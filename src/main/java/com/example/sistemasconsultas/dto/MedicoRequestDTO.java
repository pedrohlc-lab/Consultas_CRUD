package com.example.sistemasconsultas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;


public record MedicoRequestDTO(
    @NotBlank String nome,
    @NotBlank String crm,
    @NotNull Long especialidadeId
){}
