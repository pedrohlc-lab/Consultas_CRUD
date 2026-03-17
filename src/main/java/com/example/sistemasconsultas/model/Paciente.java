package com.example.sistemasconsultas.model;


import jakarta.persistence.*;
import lombok.Data;
import java.time.*;
import java.util.Date;

@Entity
@Table(name = "paciente")
@Data
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private LocalDate nascimento;


}
