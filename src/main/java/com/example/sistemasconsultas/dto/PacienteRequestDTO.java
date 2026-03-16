package com.example.sistemasconsultas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PacienteRequestDTO(
       @NotBlank String nome,
       @NotBlank String cpf,
       @NotBlank String email,
       @NotBlank String telefone,
       @NotNull LocalDate nascimento
){}
