package com.example.demo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class PerguntaService {

    private List<Pergunta> perguntas = new ArrayList<>();
    private int proxId = 1;


    public PerguntaService(){
        perguntas.add(new Pergunta(proxId++,"Qual a Capital do Brasil?","Brasilia","Rio de Janeiro", "São Paulo", "Salvador","A"));
        perguntas.add(new Pergunta(proxId++,"Qual a cor do céu?", "Verde", "Azul", "Amarelo", "Vermelho", "B"));

    }

    public List<Pergunta> listarTodas() {
        return perguntas;
    }

    public Pergunta buscarPorId(int id) {
        return perguntas.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public Pergunta salvar(Pergunta pergunta) {
        pergunta = new Pergunta(proxId++, pergunta.getTexto(), pergunta.getAlternativaA(), pergunta.getAlternativaB(), pergunta.getAlternativaC(), pergunta.getAlternativaD(), pergunta.getRespostaCorreta());
        perguntas.add(pergunta);
        return pergunta;
    }
    public void deletar(int id) {
        perguntas.removeIf(p -> p.getId() == id);
    }

}
