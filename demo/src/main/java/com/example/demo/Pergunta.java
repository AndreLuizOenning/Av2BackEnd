package com.example.demo;
public class Pergunta {
    private int id;
    private String texto;
    private String alternativaA;
    private String alternativaB;
    private String alternativaC;
    private String alternativaD;
    private String respostaCorreta;

    // Construtores, getters e setters
    public Pergunta(int id, String texto, String alternativaA, String alternativaB, String alternativaC, String alternativaD, String respostaCorreta) {
        this.id = id;
        this.texto = texto;
        this.alternativaA = alternativaA;
        this.alternativaB = alternativaB;
        this.alternativaC = alternativaC;
        this.alternativaD = alternativaD;
        this.respostaCorreta = respostaCorreta;
    }

    public int getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public String getAlternativaA() {
        return alternativaA;
    }

    public String getAlternativaB() {
        return alternativaB;
    }

    public String getAlternativaC() {
        return alternativaC;
    }

    public String getAlternativaD() {
        return alternativaD;
    }

    public String getRespostaCorreta() {
        return respostaCorreta;
    }
}
