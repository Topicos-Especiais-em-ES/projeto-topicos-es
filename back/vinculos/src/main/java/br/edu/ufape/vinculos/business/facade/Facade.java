package br.edu.ufape.vinculos.business.facade;

import java.util.List;


import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import br.edu.ufape.vinculos.business.models.Participacao;
import br.edu.ufape.vinculos.business.models.Projeto;
import br.edu.ufape.vinculos.business.models.Vinculo;
import br.edu.ufape.vinculos.business.services.interfaces.ParticipacaoServiceInterface;
import br.edu.ufape.vinculos.business.services.interfaces.ProjetoServiceInterface;
import br.edu.ufape.vinculos.business.services.interfaces.VinculoServiceInterface;

@Component
@RequiredArgsConstructor
public class Facade {
    private final VinculoServiceInterface vinculoService;
    private final ProjetoServiceInterface projetoService;
    private final ParticipacaoServiceInterface participacaoService;

    //===== Vinculos ===== //
    
    public Vinculo registerVinculo(Vinculo entity) {
        return vinculoService.registerVinculo(entity);
    }

    public String deleteVinculo(Long id) {
       return vinculoService.deleteVinculo(id);
    }

    public Vinculo findVinculo(Long id) {
        return vinculoService.findVinculo(id);
    }

    public List<Vinculo> findAllVinculos() {
        return vinculoService.findAllVinculos();
    }

    public List<Vinculo> findVinculoByProjeto(Projeto projeto) {
        return vinculoService.findByProjeto(projeto);
    }

    //===== Projetos ===== //

    public Projeto registerProjeto(Projeto entity) {
        return projetoService.registerProjeto(entity);
    }

    public String deleteProjeto(Long id) {
       return projetoService.deleteProjeto(id);
    }

    public Projeto findProjeto(Long id) {
        return projetoService.findProjeto(id);
    }

    public List<Projeto> findAllProjetos() {
        return projetoService.findAllProjetos();
    }

    //===== Participacoes ===== //

    public Participacao registerParticipacao(Participacao entity) {
        return participacaoService.registerParticipacao(entity);
    }

    public String deleteParticipacao(Long id) {
       return participacaoService.deleteParticipacao(id);
    }

    public Participacao findParticipacao(Long id) {
        return participacaoService.findParticipacao(id);
    }

    public List<Participacao> findParticipacoesByEstudanteId(Long estudanteId) {
        return participacaoService.findParticipacoesByEstudanteId(estudanteId);
    }

    public List<Participacao> findAllParticipacoes() {
        return participacaoService.findAllParticipacoes();
    }

    public List<Participacao> findParticipacaoByProjeto(Projeto projeto) {
        return participacaoService.findParticipacaoByProjeto(projeto);
    }



}
