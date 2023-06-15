package vitorlucascrispim.med.vol.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vitorlucascrispim.med.vol.dtos.AtualizaMedicoDTO;
import vitorlucascrispim.med.vol.dtos.MedicoDTO;
import vitorlucascrispim.med.vol.dtos.MedicoEspecificoDTO;
import vitorlucascrispim.med.vol.dtos.MedicoListagemDTO;
import vitorlucascrispim.med.vol.models.Medico;
import vitorlucascrispim.med.vol.repositories.MedicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicosService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico cadastraMedicos(MedicoDTO medicoDTO){
        Medico medico = new Medico(medicoDTO);
        try{
            if(medico != null){
                medicoRepository.save(medico);
            }
        }catch (Exception e){
            throw new RuntimeException("Erro ao salvar cadastro do medico");
        }
        return medico;
    }

    public MedicoEspecificoDTO atualizaMedicoDTO(AtualizaMedicoDTO medicoDTO){
        Medico medicoAtualizado = medicoRepository.findById(medicoDTO.id()).get();
        if(medicoAtualizado != null){
            medicoAtualizado.atualizaInformacoes(medicoDTO);
            try{
                medicoRepository.save(medicoAtualizado);
            }catch (RuntimeException e){
                throw new RuntimeException("Erro ao atualizar o medico");
            }
        }
        MedicoEspecificoDTO medicoEspecificoDTO = new MedicoEspecificoDTO(medicoAtualizado);
        return  medicoEspecificoDTO;
    }

    public void desativaMedico(Long id){
        var medico = medicoRepository.findById(id).get();
        if(medico != null){
            medico.excluir();
            medicoRepository.save(medico);
        }


    }

    public MedicoEspecificoDTO detalhaMedicoEspecifico(Long id){
        MedicoEspecificoDTO medicoEspecificoDTO = null;
        var medico = medicoRepository.findById(id).get();
        if(medico != null){
            medicoEspecificoDTO = new MedicoEspecificoDTO(medico);
        }else{
            throw new RuntimeException("Erro ao buscar medico especifico");
        }

        return medicoEspecificoDTO;
    }


}
