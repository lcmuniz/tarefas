package com.acme.tarefas.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String texto;

    @ManyToOne
    @JoinColumn(name="autor_id")
    private Autor autor;

    private Date dataInicio;
    private Date dataFim;

}
