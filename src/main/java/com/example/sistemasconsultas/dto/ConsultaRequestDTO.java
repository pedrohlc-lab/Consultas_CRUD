package com.example.sistemasconsultas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ConsultaRequestDTO(
        @NotNull Long medicoId,
        @NotNull Long pacienteId,
        @NotNull LocalDateTime dataHora,
        @NotBlank String status
) {}
