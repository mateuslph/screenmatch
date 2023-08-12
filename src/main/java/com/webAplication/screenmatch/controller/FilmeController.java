package com.webAplication.screenmatch.controller;

import com.webAplication.screenmatch.domain.filme.DadosCadastroFilme;
import com.webAplication.screenmatch.domain.filme.Filme;
import com.webAplication.screenmatch.domain.filme.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    //private List<Filme> filmes = new ArrayList<>();
    @Autowired
    private FilmeRepository repository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario() {
        return "filmes/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        //model.addAttribute("lista", filmes);
        model.addAttribute("lista", repository.findAll());
        return "filmes/listagem";
    }

    @PostMapping
    public String cadastraFilmes(DadosCadastroFilme dados) {
        var filme = new Filme(dados);
        //filmes.add(filme);
        repository.save(filme);
        return "redirect:/filmes";  //por padrao este modo chama pelo metodo get
    }

    @DeleteMapping
    public String removeFilme(Long id) {
        repository.deleteById(id);
        return "redirect:/filmes";
    }

}
