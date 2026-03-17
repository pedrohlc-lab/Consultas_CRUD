package com.example.sistemasconsultas.controller;

import com.example.sistemasconsultas.dto.PacienteRequestDTO;
import com.example.sistemasconsultas.dto.PacienteResponseDTO;
import com.example.sistemasconsultas.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> cadastrar(@RequestBody PacienteRequestDTO dados) {
        var resposta =  pacienteService.salvar(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponseDTO>> listar(){
        var lista= pacienteService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> atualizar(@PathVariable Long id, @RequestBody PacienteRequestDTO dados) {
        var resposta = pacienteService.atualizarCadastroPaciente(dados, id);
        return ResponseEntity.status(HttpStatus.OK).body(resposta);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> deletar(@PathVariable Long id){
        pacienteService.deletarPaciente(id);
        return ResponseEntity.notFound().build();
    }

}
