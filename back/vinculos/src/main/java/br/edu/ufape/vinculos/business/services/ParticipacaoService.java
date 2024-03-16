package br.edu.ufape.vinculos.business.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import br.edu.ufape.vinculos.business.models.Participacao;
import br.edu.ufape.vinculos.business.models.Projeto;
import br.edu.ufape.vinculos.business.services.interfaces.ParticipacaoServiceInterface;
import br.edu.ufape.vinculos.data.repositories.ParticipacaoRepository;
import org.springframework.web.client.HttpClientErrorException;

@Service @RequiredArgsConstructor
public class ParticipacaoService implements ParticipacaoServiceInterface {
    private final ParticipacaoRepository repository;
    private final RestTemplate restTemplate;


   
    @Override
    public Participacao registerParticipacao(Participacao entity) {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/estudantes/" + entity.getEstudanteId(), String.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                return repository.save(entity);
            } else {
                throw new RuntimeException("Estudante não encontrado");
            }
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new RuntimeException("Estudante não encontrado", e);
            } else {
                throw new RuntimeException("Error occurred while calling the API", e);
            }
        }
    }

    @Override
    public String deleteParticipacao(Long id) {
        Participacao entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Participacao não encontrado"));
        repository.delete(entity);
        return "Participacao deletado com sucesso";
    }

    @Override
    public Participacao findParticipacao(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Participacao não encontrada"));
    }

    @Override
    public List<Participacao> findParticipacoesByEstudanteId(Long estudanteId) {
        return repository.findByEstudanteId(estudanteId);
    }

    @Override
    public List<Participacao> findAllParticipacoes() {
        return repository.findAll();
    }

    @Override
    public List<Participacao> findParticipacaoByProjeto(Projeto projeto) {
        return repository.findByProjeto(projeto);
    }

    
}
