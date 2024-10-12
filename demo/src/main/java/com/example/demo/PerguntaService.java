package com.example.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PerguntaService {

    private List<Pergunta> perguntas = new ArrayList<>();
    private int proxId = 1;

    public PerguntaService() {
        importarPerguntas();
    }

    private void importarPerguntas() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File("src/main/resources/perguntas.json");
            List<Pergunta> perguntasImportadas = objectMapper.readValue(file, new TypeReference<List<Pergunta>>() {});
            perguntas.addAll(perguntasImportadas);
            proxId = perguntas.size() + 1; // Atualiza o próximo ID
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Pergunta> listarTodas() {
        return perguntas;
    }

    public Pergunta buscarPorId(int id) {
        return perguntas.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public Pergunta aleatorio() {
        int numeroAleatorio = ThreadLocalRandom.current().nextInt(proxId);
        return perguntas.stream().filter(p -> p.getId() == numeroAleatorio).findFirst().orElse(null);
    }

    public Pergunta adicionarPergunta(Pergunta novaPergunta) {
        novaPergunta.setId(proxId++);
        perguntas.add(novaPergunta);
        salvarPerguntas();
        return novaPergunta;
    }

    private void salvarPerguntas() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("src/main/resources/perguntas.json"), perguntas);
        } catch (IOException e) {
            System.err.println("Erro ao salvar perguntas: " + e.getMessage());
        }
    }

    public void deletarPergunta(int id) {
        Pergunta perguntaParaRemover = perguntas.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        if (perguntaParaRemover != null) {
            perguntas.remove(perguntaParaRemover);
            salvarPerguntas();
        }
    }
}
