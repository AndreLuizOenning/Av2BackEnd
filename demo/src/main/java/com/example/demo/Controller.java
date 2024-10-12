package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class Controller {

    @GetMapping("/sobre")
    public Sobre getSobre() {
        Sobre sobre = new Sobre();
        sobre.setNome("André Luiz Oenning");
        sobre.setProjeto("Quiz");
        return sobre;
    }

    @RestController
    @RequestMapping("/quiz")
    class PerguntaController {


        private final PerguntaService perguntaService;


        public PerguntaController(PerguntaService perguntaService) {
            this.perguntaService = perguntaService;
        }

        @GetMapping
        public List<Pergunta> listar() {
            return perguntaService.listarTodas();
        }

        @GetMapping("/{id}")
        public Pergunta buscar(@PathVariable int id) {
            return perguntaService.buscarPorId(id);
        }

        @GetMapping("/aleatorio")
        public Pergunta aleatorio(){
            return perguntaService.aleatorio();
        }
        @PostMapping("/salvar")
        public Pergunta criar(@RequestBody Pergunta pergunta) {
            return perguntaService.adicionarPergunta(pergunta);
        }


        @PostMapping("/responder")
        public perguntaVerifier responder(@RequestBody Resposta resposta) {
            Pergunta pergunta = perguntaService.buscarPorId(resposta.getPerguntaId());
            if (pergunta != null) {
                if (pergunta.getRespostaCorreta().equals(resposta.getResposta())) {
                    return new perguntaVerifier("Resposta correta!", true);
                } else {
                    return new perguntaVerifier("Resposta incorreta!", false);
                }
            }
            return new perguntaVerifier("Pergunta não encontrada", false);
        }


        @DeleteMapping("/{id}")
        public perguntaVerifier deletar(@PathVariable int id) {
            perguntaService.deletarPergunta(id);
            return new perguntaVerifier("Apagado",true);
        }
    }
}
