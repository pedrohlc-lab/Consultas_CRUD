package com.example.sistemasconsultas.repository;

import com.example.sistemasconsultas.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
