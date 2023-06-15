package vitorlucascrispim.med.vol.dtos.medico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EnderecoAtualizacaoDTO(String logradouro, String bairro, @Pattern(regexp = "\\d{8}") String cep, String cidade, String uf, String complemento, String numero) {
}
