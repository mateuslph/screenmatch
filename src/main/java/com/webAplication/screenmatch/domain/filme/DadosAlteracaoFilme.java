package com.webAplication.screenmatch.domain.filme;

// se tiver dados que nao podem ser editados, nesses paramentros nao deve conter
public record DadosAlteracaoFilme(Long id, String nome, Integer duracao, Integer ano, String genero) {
}
