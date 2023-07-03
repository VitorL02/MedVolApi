package vitorlucascrispim.med.vol.models.consulta;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vitorlucascrispim.med.vol.models.medico.Medico;
import vitorlucascrispim.med.vol.models.paciente.Paciente;

import java.time.LocalDateTime;

@Table(name="tb_consultas")
@Entity(name="Consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="paciente_id")
    private Paciente paciente;

    private LocalDateTime data;



}
