package vitorlucascrispim.med.vol.models;

import jakarta.persistence.*;
import lombok.*;
import vitorlucascrispim.med.vol.dtos.AtualizaMedicoDTO;
import vitorlucascrispim.med.vol.dtos.Especialidade;
import vitorlucascrispim.med.vol.dtos.MedicoDTO;


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

    private String telefone;
    private String crm;

    private  boolean ativo;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;


    public Medico(MedicoDTO medicoDTO) {
        this.ativo = true;
        this.nome = medicoDTO.nome();
        this.email = medicoDTO.email();
        this.telefone = medicoDTO.telefone();
        this.crm = medicoDTO.crm();
        this.especialidade = medicoDTO.especialidade();
        this.endereco = new Endereco(medicoDTO);
    }

    public void atualizaInformacoes(AtualizaMedicoDTO medicoDTO) {

        if(medicoDTO.nome() != null){
            this.nome = medicoDTO.nome();
        }
        if(medicoDTO.telefone() != null){
            this.telefone = medicoDTO.telefone();
        }
        if(medicoDTO.enderecoDTO() != null){
            this.endereco.atualizarInformacoes(medicoDTO.enderecoDTO());
        }


    }

    public void excluir() {
        this.ativo = false;
    }
}
