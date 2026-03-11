package com.example.sistemasconsultas.dto;

import java.time.LocalDate;

public record PacienteDTO(

        String nome,
        String cpf,
        String email,
        LocalDate nascimento,
        String telefone

) {}
