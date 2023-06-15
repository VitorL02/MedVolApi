package vitorlucascrispim.med.vol.dtos.medico;

import jakarta.validation.constraints.NotNull;

public record AtualizaMedicoDTO(@NotNull Long id, String nome, String telefone, EnderecoAtualizacaoDTO enderecoDTO) {
}
