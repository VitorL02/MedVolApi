package vitorlucascrispim.med.vol.models;

import jakarta.persistence.*;
import lombok.*;
import vitorlucascrispim.med.vol.dtos.Especialidade;


@Table(name="tb_medicos")
@Entity(name="Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;
}
