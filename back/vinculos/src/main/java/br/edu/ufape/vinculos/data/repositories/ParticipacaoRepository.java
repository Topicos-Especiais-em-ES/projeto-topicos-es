package br.edu.ufape.vinculos.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.vinculos.business.models.Participacao;
import br.edu.ufape.vinculos.business.models.Projeto;

@Repository
public interface ParticipacaoRepository extends JpaRepository<Participacao, Long>{
    List<Participacao> findByProjeto(Projeto projeto);
    List<Participacao> findByEstudanteId(Long estudanteId);
}
