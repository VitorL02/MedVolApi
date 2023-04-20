package vitorlucascrispim.med.vol.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vitorlucascrispim.med.vol.dtos.MedicoDTO;

@RestController
@RequestMapping("/medicos")
public class MedicosController {

    @PostMapping
    public ResponseEntity<MedicoDTO>cadastroDeMedicos(@RequestBody MedicoDTO medicoDTO){

        return ResponseEntity.status(HttpStatus.CREATED).body(medicoDTO);

    }
}
