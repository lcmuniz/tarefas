package com.acme.tarefas.controller;

import com.acme.tarefas.exceptions.TarefaNotFoundException;
import com.acme.tarefas.model.Tarefa;
import com.acme.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository repo;

    @GetMapping
    public List<Tarefa> obterTodas() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Tarefa> obterTarefa(@PathVariable Long id) {
        return repo.findById(id);
    }

    @PostMapping
    public Tarefa inserir(@RequestBody Tarefa tarefa) {
        return repo.save(tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa alterar(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        Optional<Tarefa> opt = repo.findById(id);

        if (opt.isPresent()) {
            Tarefa tarefaBanco = opt.get();
            if (tarefa.getTitulo() != null) tarefaBanco.setTitulo(tarefa.getTitulo());
            if (tarefa.getTexto() != null) tarefaBanco.setTexto(tarefa.getTexto());
            if (tarefa.getDataInicio() != null) tarefaBanco.setDataInicio(tarefa.getDataInicio());
            if (tarefa.getDataFim() != null) tarefaBanco.setDataFim(tarefa.getDataFim());
            if (tarefa.getAutor() != null) tarefaBanco.setAutor(tarefa.getAutor());
            repo.save(tarefaBanco);
            return tarefaBanco;
        }
        else {
            throw new TarefaNotFoundException(id);
        }

    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        Optional<Tarefa> opt = repo.findById(id);
        if (opt.isPresent()) {
            repo.deleteById(id);
        }
        else {
            throw new TarefaNotFoundException(id);
        }
    }

    @GetMapping("/autor/{id}")
    public List<Tarefa> obterTarefasAutor(@PathVariable Long id) {
        return repo.findAllByAutorId(id);
    }

}
