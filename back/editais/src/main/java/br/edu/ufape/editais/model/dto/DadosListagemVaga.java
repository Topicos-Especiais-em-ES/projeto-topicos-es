package br.edu.ufape.editais.model.dto;

import br.edu.ufape.editais.model.Vaga;

public record DadosListagemVaga(
		
		Long id,
		int quantidade) {

	public DadosListagemVaga(Vaga vaga) {
		this(vaga.getId(), vaga.getQuantidade());
	}
}
