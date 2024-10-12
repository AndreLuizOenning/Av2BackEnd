package com.example.demo;

public class perguntaVerifier {
    private String mensagem;
    private boolean correta;

    public perguntaVerifier(String mensagem, boolean correta) {
        this.mensagem = mensagem;
        this.correta = correta;
    }

    public String getMensagem() {
        return mensagem;
    }

    public boolean isCorrect() {
        return correta;
    }
}