package com.example.sistemasconsultas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ConsultaRequestDTO(
        @NotBlank String nome,
        @NotBlank String cpf,
        @NotBlank String email,
       @NotNull LocalDate dataNascimento

) {}
