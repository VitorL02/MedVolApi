package vitorlucascrispim.med.vol.models.medico;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vitorlucascrispim.med.vol.dtos.medico.AtualizaMedicoDTO;
import vitorlucascrispim.med.vol.dtos.medico.EnderecoAtualizacaoDTO;
import vitorlucascrispim.med.vol.dtos.medico.MedicoDTO;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;


    public Endereco(MedicoDTO medicoDTO) {
        this.logradouro = medicoDTO.endereco().logradouro();
        this.bairro = medicoDTO.endereco().bairro();
        this.cep = medicoDTO.endereco().cep();
        this.cidade = medicoDTO.endereco().cidade();
        this.uf = medicoDTO.endereco().uf();
        this.complemento = medicoDTO.endereco().complemento();
        this.numero = medicoDTO.endereco().numero();
    }

    public Endereco(AtualizaMedicoDTO medicoDTO) {
        this.logradouro = medicoDTO.enderecoDTO().logradouro();
        this.bairro = medicoDTO.enderecoDTO().bairro();
        this.cep = medicoDTO.enderecoDTO().cep();
        this.cidade = medicoDTO.enderecoDTO().cidade();
        this.uf = medicoDTO.enderecoDTO().uf();
        this.complemento = medicoDTO.enderecoDTO().complemento();
        this.numero = medicoDTO.enderecoDTO().numero();
    }

    public void atualizarInformacoes(EnderecoAtualizacaoDTO enderecoDTO) {
        if(enderecoDTO.logradouro() != null){
            this.logradouro = enderecoDTO.logradouro();
        }
        if(enderecoDTO.bairro() != null){
            this.bairro = enderecoDTO.bairro();
        }
        if(enderecoDTO.cep() != null){
            this.cep = enderecoDTO.cep();
        }
        if(enderecoDTO.cidade() != null){
            this.cidade = enderecoDTO.cidade();
        }
        if(enderecoDTO.uf() != null){
            this.uf = enderecoDTO.uf();
        }
        if(enderecoDTO.numero() != null){
            this.numero = enderecoDTO.numero();
        }
        if(enderecoDTO.complemento() != null){
            this.complemento = enderecoDTO.complemento();
        }


    }
}
