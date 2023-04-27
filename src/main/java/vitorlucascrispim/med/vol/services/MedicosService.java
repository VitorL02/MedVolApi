package vitorlucascrispim.med.vol.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vitorlucascrispim.med.vol.dtos.MedicoDTO;
import vitorlucascrispim.med.vol.models.Medico;
import vitorlucascrispim.med.vol.repositories.MedicoRepository;

@Service
public class MedicosService {

    @Autowired
    private MedicoRepository medicoRepository;

    public void cadastraMedicos(MedicoDTO medicoDTO){
        Medico medico = new Medico(medicoDTO);
        try{
            if(medico != null){
                medicoRepository.save(medico);
            }
        }catch (Exception e){
            throw new RuntimeException("Erro ao salvar cadastro do medico");
        }
    }
}
