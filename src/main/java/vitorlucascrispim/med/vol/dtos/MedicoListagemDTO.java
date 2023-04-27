package vitorlucascrispim.med.vol.dtos;

import vitorlucascrispim.med.vol.models.Medico;

public record MedicoListagemDTO (String nome, String email, String crm, Especialidade especialidade ) {

    public MedicoListagemDTO (Medico medico){
        this(medico.getNome(),medico.getEmail(),medico.getCrm(),medico.getEspecialidade());
    }

}
