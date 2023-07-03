package vitorlucascrispim.med.vol.dtos.medico;

import vitorlucascrispim.med.vol.models.medico.Medico;
import vitorlucascrispim.med.vol.models.paciente.Paciente;

public record PacienteEspecificoDTO(Long id , String nome, String email,  String telefone) {


    public PacienteEspecificoDTO(Paciente paciente){
        this(paciente.getId(),paciente.getNome(),paciente.getEmail(),paciente.getTelefone());
    }

    public PacienteEspecificoDTO {
    }
}
