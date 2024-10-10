package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    @GetMapping("/sobre")
    public Sobre getSobre() {
        Sobre sobre = new Sobre();
        sobre.setNome("André Luiz Oenning");
        sobre.setProjeto("Quiz");
        return sobre;
    }
}
@RequestMapping("/quiz")
public class PerguntaController {

    private PerguntaService perguntaService = new PerguntaService();

    @GetMapping
    public List<Pergunta> listar() {
        return perguntaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Pergunta buscar(@PathVariable int id) {
        return perguntaService.buscarPorId(id);
    }

    @PostMapping
    public Pergunta criar(@RequestBody Pergunta pergunta) {
        return perguntaService.salvar(pergunta);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        perguntaService.deletar(id);
    }
}
