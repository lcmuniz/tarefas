package com.acme.tarefas.exceptions;


import com.acme.tarefas.exceptions.AutorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AutorNotFoundAdvice {
    
    @ResponseBody
    @ExceptionHandler(AutorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String autorNaoEncontrado(AutorNotFoundException ex) {
        return ex.getMessage();
    } 
    
}
