package vitorlucascrispim.med.vol.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizaMedicoDTO(@NotNull Long id, String nome, String telefone, EnderecoAtualizacaoDTO enderecoDTO) {
}
