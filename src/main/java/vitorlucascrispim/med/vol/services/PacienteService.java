package vitorlucascrispim.med.vol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vitorlucascrispim.med.vol.dtos.medico.*;
import vitorlucascrispim.med.vol.models.medico.Medico;
import vitorlucascrispim.med.vol.models.paciente.Paciente;
import vitorlucascrispim.med.vol.repositories.MedicoRepository;
import vitorlucascrispim.med.vol.repositories.PacienteRepository;

import java.util.Optional;

@Service
public class PacienteService {



    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente cadastrarPacientes(PacienteDTO pacienteDTO){
        Paciente paciente = new Paciente(pacienteDTO);
        try{
            if(paciente != null){
                pacienteRepository.save(paciente);
            }
        }catch (Exception e){
            throw new RuntimeException("Erro ao salvar cadastro do paciente");
        }
        return paciente;
    }

    public void desativaPaciente(Long id){
        var paciente = pacienteRepository.findById(id).get();
        if(paciente != null){
            paciente.excluir();
            pacienteRepository.save(paciente);
        }


    }

    public PacienteEspecificoDTO detalhaPacienteEspecifico(Long id){
        PacienteEspecificoDTO pacienteEspecificoDTO = null;
        var paciente = pacienteRepository.findById(id).get();
        pacienteEspecificoDTO = new PacienteEspecificoDTO(paciente);
        return pacienteEspecificoDTO;
    }



}
