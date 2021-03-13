package com.acme.tarefas.controller;

import com.acme.tarefas.exceptions.AutorNotFoundException;
import com.acme.tarefas.model.Autor;
import com.acme.tarefas.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository repo;

    @GetMapping
    public List<Autor> obterTodos() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Autor> obterAutor(@PathVariable Long id) {
        return repo.findById(id);
    }

    @PostMapping
    public Autor inserirAutor(@RequestBody Autor autor) {
        return repo.save(autor);
    }

    @PutMapping("/{id}")
    public Autor alterarAutor(@PathVariable Long id, @RequestBody Autor autor) {
        Optional<Autor> opt = repo.findById(id);
        if (opt.isPresent()) {
            Autor autorBanco = opt.get();
            if (autor.getNome() != null) autorBanco.setNome(autor.getNome());
            repo.save(autorBanco);
            return autorBanco;
        }
        else {
            throw new AutorNotFoundException(id);
        }
    }

    @DeleteMapping("/{id}")
    public void excluirAutor(@PathVariable Long id) {
        Optional<Autor> opt = repo.findById(id);
        if (opt.isPresent()) {
            repo.deleteById(id);
        }
        else {
            throw new AutorNotFoundException(id);
        }
    }


}
