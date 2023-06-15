package vitorlucascrispim.med.vol.controllers;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import vitorlucascrispim.med.vol.dtos.AtualizaMedicoDTO;
import vitorlucascrispim.med.vol.dtos.MedicoDTO;
import vitorlucascrispim.med.vol.dtos.MedicoEspecificoDTO;
import vitorlucascrispim.med.vol.dtos.MedicoListagemDTO;
import vitorlucascrispim.med.vol.models.Medico;
import vitorlucascrispim.med.vol.repositories.MedicoRepository;
import vitorlucascrispim.med.vol.services.MedicosService;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicosController {

    @Autowired
    private MedicosService medicosService;

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastroDeMedicos(@RequestBody @Valid MedicoDTO medicoDTO, UriComponentsBuilder uriBuilder){
        Medico medico = medicosService.cadastraMedicos(medicoDTO);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(medicoDTO);

    }

    @GetMapping("/findMedicos")

    public ResponseEntity<Page<MedicoListagemDTO>> listarMedicos(@PageableDefault(size = 10,sort = {"nome"}) Pageable pageable) {
        Page<MedicoListagemDTO> todosOsMedicos = medicoRepository.findAllByAtivoTrue(pageable).map(MedicoListagemDTO::new);
        return ResponseEntity.status(HttpStatus.OK).body(todosOsMedicos);
    }

    @PutMapping("/atualizaMedico")
    @Transactional
    public ResponseEntity<MedicoEspecificoDTO> atualizaMedico(@RequestBody @Valid AtualizaMedicoDTO medicoDTO) {
        MedicoEspecificoDTO medicoEspecificoDTO = medicosService.atualizaMedicoDTO(medicoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(medicoEspecificoDTO);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String>deletaMedico(@PathVariable Long id){
        medicosService.desativaMedico(id);
        return ResponseEntity.status(HttpStatus.OK).body("Medico Inativado com sucesso");
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoEspecificoDTO>detalhaMedicoEspecifico(@PathVariable Long id){
        MedicoEspecificoDTO medicoEspecificoDTO = medicosService.detalhaMedicoEspecifico(id);
        return ResponseEntity.status(HttpStatus.OK).body(medicoEspecificoDTO);
    }

}
