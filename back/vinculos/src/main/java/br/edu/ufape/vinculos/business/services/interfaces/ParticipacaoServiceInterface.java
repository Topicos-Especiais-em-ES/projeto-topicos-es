package br.edu.ufape.vinculos.business.services.interfaces;

import java.util.List;

import br.edu.ufape.vinculos.business.models.Participacao;
import br.edu.ufape.vinculos.business.models.Projeto;

public interface ParticipacaoServiceInterface {

    Participacao registerParticipacao(Participacao entity);

    String deleteParticipacao(Long id);

    Participacao findParticipacao(Long id);

    List<Participacao> findParticipacoesByEstudanteId(Long estudanteId);

    List<Participacao> findAllParticipacoes();

    List<Participacao> findParticipacaoByProjeto(Projeto projeto);

}