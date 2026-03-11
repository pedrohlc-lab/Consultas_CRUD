package com.example.sistemasconsultas.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "consultas")
@Data
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    Paciente Medico;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false)
    private String status;




}
