package vitorlucascrispim.med.vol.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vitorlucascrispim.med.vol.dtos.consulta.ConsultaDTO;
import vitorlucascrispim.med.vol.dtos.consulta.DadosAgendamentoDTO;
import vitorlucascrispim.med.vol.services.ConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultasController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoDTO dadosAgendamentoDTO){

        consultaService.agendarConsulta(dadosAgendamentoDTO);
        return ResponseEntity.ok(new ConsultaDTO(null,null,null))

    }


}
