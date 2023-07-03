package vitorlucascrispim.med.vol.dtos.consulta;

import java.time.LocalDateTime;

public record ConsultaDTO(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
}
