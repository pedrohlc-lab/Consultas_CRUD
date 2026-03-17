package com.example.sistemasconsultas.service;

import com.example.sistemasconsultas.dto.ConsultaRequestDTO;
import com.example.sistemasconsultas.dto.ConsultaResponseDTO;
import com.example.sistemasconsultas.model.Consulta;
import com.example.sistemasconsultas.model.Medico;
import com.example.sistemasconsultas.model.Paciente;
import com.example.sistemasconsultas.repository.MedicoRepository;
import com.example.sistemasconsultas.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sistemasconsultas.repository.ConsultaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaService {

    @Autowired private ConsultaRepository consultaRepository;
    @Autowired private PacienteRepository pacienteRepository;
    @Autowired private MedicoRepository medicoRepository;


    //CREATE
    @Transactional
    public ConsultaResponseDTO agendarConsulta(ConsultaRequestDTO dadosConsulta) {
        //Quero salvar a consulta com os dados do paciente e os dados do medico
        Consulta consulta = new Consulta();

        Medico medico = medicoRepository.findById(dadosConsulta.medicoId())
                .orElseThrow(() -> new RuntimeException("Médico não encontrado com ID: " + dadosConsulta.medicoId()));

        Paciente paciente = pacienteRepository.findById(dadosConsulta.pacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado com ID: " + dadosConsulta.pacienteId()));

        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
        consulta.setDataHora(dadosConsulta.dataHora());
        consulta.setStatus(dadosConsulta.status());

        consultaRepository.save(consulta);

        return new ConsultaResponseDTO(
                consulta.getId(),
                medico.getId(),
                paciente.getId(),
                consulta.getDataHora());
    }


    //READ
    @Transactional
    public List<ConsultaResponseDTO> listarConsultas() {
        List<Consulta> consultas = consultaRepository.findAll();
        List<ConsultaResponseDTO> listaConsultas = new ArrayList<>();

        for (Consulta consulta : consultas) {
            listaConsultas.add(new ConsultaResponseDTO(
                    consulta.getId(),
                    consulta.getMedico().getId(),
                    consulta.getPaciente().getId(),
                    consulta.getDataHora()
                    )
            );
        }
        return listaConsultas;
    }


    //UPDATE
    @Transactional
    public ConsultaResponseDTO editarConsulta(ConsultaRequestDTO dadosConsulta, Long id) {

        if (!consultaRepository.existsById(id)) {
            throw new RuntimeException("ID da Consulta não existe!");
        }
        if (!medicoRepository.existsById(dadosConsulta.medicoId())) {
            throw new RuntimeException("ID do Médico não existe!");
        }
        if (!pacienteRepository.existsById(dadosConsulta.pacienteId())) {
            throw new RuntimeException("ID do Paciente não existe!");
        }

        Consulta consulta = consultaRepository.getReferenceById(id);
        Medico medico = medicoRepository.findById(dadosConsulta.medicoId()).get();
        Paciente paciente = pacienteRepository.findById(dadosConsulta.pacienteId()).get();


        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
        consulta.setDataHora(dadosConsulta.dataHora());

        return new ConsultaResponseDTO(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getDataHora());


    }

    //DELETE
    @Transactional
    public void deletarConsulta(Long id) {
        if (!consultaRepository.existsById(id)) {
            consultaRepository.deleteById(id);
        }else {throw new RuntimeException("Consulta não encontrada para deleção");}
    }



}
