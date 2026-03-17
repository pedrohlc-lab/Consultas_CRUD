package com.example.sistemasconsultas.controller;


import com.example.sistemasconsultas.dto.ConsultaRequestDTO;
import com.example.sistemasconsultas.dto.ConsultaResponseDTO;
import com.example.sistemasconsultas.dto.MedicoResponseDTO;
import com.example.sistemasconsultas.model.Consulta;
import com.example.sistemasconsultas.service.ConsultaService;
import com.example.sistemasconsultas.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<ConsultaResponseDTO> cadastrarConsulta(@RequestBody ConsultaRequestDTO consulta) {
        var resposta = consultaService.agendarConsulta(consulta);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @GetMapping
    public ResponseEntity<List<ConsultaResponseDTO>> listarConsultas() {
        var lista = consultaService.listarConsultas();
        return ResponseEntity.ok().body(lista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> atualizarConsulta(@PathVariable Long id, @RequestBody ConsultaRequestDTO consulta) {
        var resposta = consultaService.editarConsulta(consulta, id);
        return ResponseEntity.ok().body(resposta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> deletarConsulta(@PathVariable Long id) {
        consultaService.deletarConsulta(id);
        return ResponseEntity.noContent().build();
    }

}
