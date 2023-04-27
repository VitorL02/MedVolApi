package vitorlucascrispim.med.vol.models;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vitorlucascrispim.med.vol.dtos.MedicoDTO;

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
}
