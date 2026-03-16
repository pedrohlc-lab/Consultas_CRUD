package com.example.sistemasconsultas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicoRequestDTO(
    @NotBlank String nome,
    @NotBlank String crm,
    @NotNull Long especialidadeId
){}
