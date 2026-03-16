package com.example.sistemasconsultas.dto;

public record MedicoResponseDTO(
        String nome,
        String crm,
        Long especialidadeId
){}