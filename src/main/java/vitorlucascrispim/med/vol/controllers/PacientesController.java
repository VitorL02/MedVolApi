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
import vitorlucascrispim.med.vol.dtos.medico.*;
import vitorlucascrispim.med.vol.models.medico.Medico;
import vitorlucascrispim.med.vol.models.paciente.Paciente;
import vitorlucascrispim.med.vol.services.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastroPacientes(@RequestBody @Valid PacienteDTO pacienteDTO, UriComponentsBuilder uriBuilder){
        Paciente paciente = pacienteService.cadastrarPacientes(pacienteDTO);
        var uri = uriBuilder.path("/paciente/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(pacienteDTO);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String>deletaPaciente(@PathVariable Long id){
        pacienteService.desativaPaciente(id);
        return ResponseEntity.status(HttpStatus.OK).body("Paciente Inativado com sucesso");
    }


    @GetMapping("/{id}")
    public ResponseEntity<PacienteEspecificoDTO>detalhaMedicoEspecifico(@PathVariable Long id){
        PacienteEspecificoDTO pacienteEspecificoDTO = pacienteService.detalhaPacienteEspecifico(id);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteEspecificoDTO);
    }
}
