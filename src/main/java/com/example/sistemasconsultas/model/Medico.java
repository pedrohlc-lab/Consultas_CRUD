package com.example.sistemasconsultas.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "medicos")
@Data
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String nome;

    @Column
    private String crm;

    // Relação: Muitos médicos para uma especialidade
    @ManyToOne
    @JoinColumn(name = "especialidades_id")
    private Especialidade especialidade;

}
