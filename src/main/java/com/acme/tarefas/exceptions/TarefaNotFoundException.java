package com.acme.tarefas.exceptions;

public class TarefaNotFoundException extends RuntimeException{

    public TarefaNotFoundException(Long id) {
        super("Tarefa " + id + " não encontrada.");
    }

}
