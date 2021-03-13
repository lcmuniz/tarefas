package com.acme.tarefas.exceptions;

import com.acme.tarefas.exceptions.TarefaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TarefaNotFoundAdvice {
    
    @ResponseBody
    @ExceptionHandler(TarefaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String tarefaNaoEncontrada(TarefaNotFoundException ex) {
        return ex.getMessage();
    }
    
}
