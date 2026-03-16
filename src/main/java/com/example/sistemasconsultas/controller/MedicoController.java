package com.example.sistemasconsultas.controller;

import com.example.sistemasconsultas.dto.MedicoRequestDTO;
import com.example.sistemasconsultas.dto.MedicoResponseDTO;
import com.example.sistemasconsultas.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<MedicoResponseDTO> cadastrar(@RequestBody MedicoRequestDTO dados) {
        var resposta = medicoService.salvar(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);

    }

    @GetMapping
    public ResponseEntity<List<MedicoResponseDTO>> findAll() {
        var lista = medicoService.listarTodosMedicos();
        return ResponseEntity.ok().body(lista);

    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoResponseDTO> atualizar(@PathVariable Long id, @RequestBody MedicoRequestDTO dados) {
        var resposta = medicoService.editarMedico(id, dados);
        return ResponseEntity.ok().body(resposta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Deletar(@PathVariable Long id) {
        medicoService.DeletarMedico(id);
        return ResponseEntity.noContent().build();
    }
}
