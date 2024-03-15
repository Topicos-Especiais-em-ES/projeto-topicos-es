package br.edu.ufape.editais.model.dto;

import jakarta.validation.constraints.NotNull;

public record VagaDTO(
		
		@NotNull
		int quantidade,
		boolean ativa) {

}
