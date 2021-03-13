package com.acme.tarefas.repository;

import com.acme.tarefas.model.Autor;
import com.acme.tarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findAllByAutorId(Long autorId);
}
