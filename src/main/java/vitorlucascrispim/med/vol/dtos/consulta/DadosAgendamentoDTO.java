package vitorlucascrispim.med.vol.dtos.consulta;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoDTO(Long idMedio, @NotNull Long idPaciente, @NotNull @Future @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
LocalDateTime data) {
}
