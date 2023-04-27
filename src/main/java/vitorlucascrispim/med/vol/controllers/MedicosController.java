package vitorlucascrispim.med.vol.controllers;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vitorlucascrispim.med.vol.dtos.MedicoDTO;
import vitorlucascrispim.med.vol.services.MedicosService;

@RestController
@RequestMapping("/medicos")
public class MedicosController {

    @Autowired
    private MedicosService medicosService;

    @PostMapping
    @Transactional
    public ResponseEntity<MedicoDTO>cadastroDeMedicos(@RequestBody @Valid MedicoDTO medicoDTO){
        medicosService.cadastraMedicos(medicoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoDTO);

    }
}
