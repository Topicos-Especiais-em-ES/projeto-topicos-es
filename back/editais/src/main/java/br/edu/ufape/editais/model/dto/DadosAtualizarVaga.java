package br.edu.ufape.editais.model.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarVaga(
		
		@NotNull
		Long id,
		
		@NotNull
		int quantidade) {

}
