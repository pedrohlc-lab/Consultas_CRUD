package com.example.sistemasconsultas.repository;

import com.example.sistemasconsultas.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
