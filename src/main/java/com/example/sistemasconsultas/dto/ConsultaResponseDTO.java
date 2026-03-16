package com.example.sistemasconsultas.dto;

import java.time.LocalDate;

public record ConsultaResponseDTO(
        String nome,
        String cpf,
        String email,
        LocalDate dataNascimento
) {}


