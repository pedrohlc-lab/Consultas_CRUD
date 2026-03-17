package com.example.sistemasconsultas.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ConsultaResponseDTO(
        Long id,
        Long medicoId,
        Long pacienteId,
        LocalDateTime dataHora
) {}


