package com.acme.tarefas.exceptions;

public class AutorNotFoundException extends RuntimeException {

    public AutorNotFoundException(Long id) {
        super("Autor " + id + " não encontrador.");
    }

}
