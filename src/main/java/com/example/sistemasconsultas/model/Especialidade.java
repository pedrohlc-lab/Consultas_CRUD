package com.example.sistemasconsultas.model;


import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "especialidade")
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String nome;

    //Relacionamento inverso para saber quais medicos estao atrelados a essa especialidade
    @OneToMany(mappedBy = "especialidade")
    private List<Medico> medicos;

}
