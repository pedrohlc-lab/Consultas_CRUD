package com.example.sistemasconsultas.service;

import com.example.sistemasconsultas.dto.MedicoResponseDTO;
import com.example.sistemasconsultas.dto.PacienteRequestDTO;
import com.example.sistemasconsultas.dto.PacienteResponseDTO;
import com.example.sistemasconsultas.model.Paciente;
import com.example.sistemasconsultas.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    //CREATE
    @Transactional
    public PacienteResponseDTO salvar(PacienteRequestDTO pacienteInfoDTO){
        Paciente pacienteSalvo = new Paciente();
        
        pacienteSalvo.setCpf(pacienteInfoDTO.cpf());
        pacienteSalvo.setNome(pacienteInfoDTO.nome());
        pacienteSalvo.setEmail(pacienteInfoDTO.email());
        pacienteSalvo.setTelefone(pacienteInfoDTO.telefone());
        pacienteSalvo.setNascimento(pacienteInfoDTO.nascimento());

        pacienteRepository.save(pacienteSalvo);

        PacienteResponseDTO dtoResponse = new PacienteResponseDTO(pacienteSalvo.getId(),
                pacienteSalvo.getNome(),
                pacienteSalvo.getCpf(),
                pacienteSalvo.getEmail(),
                pacienteSalvo.getNascimento(),
                pacienteSalvo.getTelefone()
        );
        return dtoResponse;
    }

    //READ
    @Transactional
    public List<PacienteResponseDTO> listar(){
        List<PacienteResponseDTO> listaResponse = new ArrayList<>();
        List<Paciente> pacientes = pacienteRepository.findAll();

        for (Paciente paciente : pacientes) {
            listaResponse.add(new PacienteResponseDTO(paciente.getId(),paciente.getNome(),
                    paciente.getCpf(), paciente.getEmail(),paciente.getNascimento(), paciente.getTelefone()));
        }

        return listaResponse;
    }

    //DELETE
    @Transactional
    public void deletarPaciente(Long id){
        if(pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id);

        }
        else {throw new RuntimeException("Paciente não encontrado");}
    }

    //UPDATE
    @Transactional
    public PacienteResponseDTO atualizarCadastroPaciente(PacienteRequestDTO pacienteDTO, Long id){
        Paciente pacienteUpdate = pacienteRepository.getById(id);

        pacienteUpdate.setNome(pacienteDTO.nome());
        pacienteUpdate.setEmail(pacienteDTO.email());
        pacienteUpdate.setTelefone(pacienteDTO.telefone());
        pacienteUpdate.setNascimento(pacienteDTO.nascimento());
        pacienteUpdate.setCpf(pacienteDTO.cpf());

        PacienteResponseDTO dtoResponse = new PacienteResponseDTO(
                pacienteUpdate.getId(),
                pacienteUpdate.getNome(),
                pacienteUpdate.getCpf(),
                pacienteUpdate.getEmail(),
                pacienteUpdate.getNascimento(),
                pacienteUpdate.getTelefone()
        );

        return dtoResponse;
    }

}
