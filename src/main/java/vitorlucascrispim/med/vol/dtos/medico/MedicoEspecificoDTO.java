package vitorlucascrispim.med.vol.dtos.medico;

import vitorlucascrispim.med.vol.models.medico.Medico;

public record MedicoEspecificoDTO(Long id , String nome, String email, String crm, String telefone, Especialidade especialidade) {


    public MedicoEspecificoDTO (Medico medico){
        this(medico.getId(),medico.getNome(),medico.getEmail(),medico.getCrm(),medico.getTelefone(),medico.getEspecialidade());
    }

    public MedicoEspecificoDTO {
    }
}
