package com.example.sistemasconsultas.service;

import com.example.sistemasconsultas.dto.MedicoRequestDTO;
import com.example.sistemasconsultas.dto.MedicoResponseDTO;
import com.example.sistemasconsultas.model.Especialidade;
import com.example.sistemasconsultas.model.Medico;
import com.example.sistemasconsultas.repository.EspecialidadeRepository;
import com.example.sistemasconsultas.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    //Create
    @Transactional
    public MedicoResponseDTO salvar(MedicoRequestDTO dadosMedico){
        var especialidade = especialidadeRepository.findById(dadosMedico.especialidadeId())
                .orElseThrow(()-> new RuntimeException("Especialidade Não Encontrada."));

        Medico medico = new Medico();
        medico.setNome(dadosMedico.nome());
        medico.setCrm(dadosMedico.crm());
        medico.setEspecialidade(especialidade);

        medicoRepository.save(medico);
        MedicoResponseDTO medicoResponse  = new MedicoResponseDTO(medico.getId(),medico.getNome(),
                medico.getCrm(), medico.getEspecialidade().getNome());

        return medicoResponse;
    }

    //DELETE
    @Transactional
    public void DeletarMedico(Long id) {
        if (medicoRepository.existsById(id)) {
            medicoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Medico não encontrado.");
        }
    }
    //READ
    @Transactional
    public List<MedicoResponseDTO> listarTodosMedicos() {
        List<Medico> medicos = medicoRepository.findAll();

        List<MedicoResponseDTO> medicosResponse = new ArrayList<>();

        //salva medico por medico na lista de response
        for (Medico medico : medicos){
            MedicoResponseDTO dto = new MedicoResponseDTO(
                    medico.getId(),
                    medico.getNome(),
                    medico.getCrm(),
                    medico.getEspecialidade().getNome()
            );

            medicosResponse.add(dto);
        }

        return medicosResponse;
    }

    //UPDATE
    @Transactional
    public MedicoResponseDTO editarMedico(Long id, MedicoRequestDTO dadosMedico){
        Optional<Medico> optionalMedico = medicoRepository.findById(id);
        Optional<Especialidade> especialidade = especialidadeRepository.findById(dadosMedico.especialidadeId());

        if(optionalMedico.isEmpty()){
            throw new RuntimeException("Medico Não encontrado.");
        }
        if (especialidade.isEmpty()) {
            throw new RuntimeException("Especialidade não encontrada!");
        }

        Medico medico = optionalMedico.get();

        medico.setNome(dadosMedico.nome());
        medico.setCrm(dadosMedico.crm());
        medico.setEspecialidade(especialidade.get());

        return new  MedicoResponseDTO(
                medico.getId(),
                medico.getNome(),
                medico.getCrm(),
                medico.getEspecialidade().getNome()
        );
    }





}
