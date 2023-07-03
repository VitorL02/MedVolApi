package vitorlucascrispim.med.vol.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vitorlucascrispim.med.vol.dtos.consulta.DadosAgendamentoDTO;
import vitorlucascrispim.med.vol.models.consulta.Consulta;
import vitorlucascrispim.med.vol.repositories.ConsultaRepository;
import vitorlucascrispim.med.vol.repositories.MedicoRepository;
import vitorlucascrispim.med.vol.repositories.PacienteRepository;

@Service
public class ConsultaService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;
    
    @Autowired
    private ConsultaRepository consultaRepository;


    public void agendarConsulta(DadosAgendamentoDTO dadosAgendamentoDTO){
        var medico = medicoRepository.findById(dadosAgendamentoDTO.idMedio()).get();
        var paciente = pacienteRepository.findById(dadosAgendamentoDTO.idPaciente()).get();
        var consulta = new Consulta(null,medico,paciente, dadosAgendamentoDTO.data());


        consultaRepository.save(consulta);
    }

}
