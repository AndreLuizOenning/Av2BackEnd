package com.example.demo;

public class Resposta {
    private int perguntaId;
    private String resposta;


    public Resposta(int perguntaId, String resposta) {
        this.perguntaId = perguntaId;
        this.resposta = resposta;
    }

    public int getPerguntaId() {
        return perguntaId;
    }

    public void setPerguntaId(int perguntaId) {
        this.perguntaId = perguntaId;
    }

    public String getResposta() {
        return resposta;
    }

    public void setRespostaEscolhida(String resposta) {
        this.resposta= resposta;
    }
}
