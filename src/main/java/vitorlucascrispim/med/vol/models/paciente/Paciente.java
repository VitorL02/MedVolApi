package vitorlucascrispim.med.vol.models.paciente;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vitorlucascrispim.med.vol.dtos.medico.Especialidade;
import vitorlucascrispim.med.vol.dtos.medico.MedicoDTO;
import vitorlucascrispim.med.vol.dtos.medico.PacienteDTO;
import vitorlucascrispim.med.vol.models.medico.Endereco;

@Table(name="tb_pacientes")
@Entity(name="Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Paciente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    private String telefone;

    private  boolean ativo;

    @Embedded
    private Endereco endereco;




    public Paciente(PacienteDTO pacienteDTO) {
        this.ativo = true;
        this.nome = pacienteDTO.nome();
        this.email = pacienteDTO.email();
        this.telefone = pacienteDTO.telefone();
        this.endereco = new Endereco(pacienteDTO);
    }


    public void excluir() {
        this.ativo = false;
    }
}
