package br.edu.ufape.vinculos.application.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import br.edu.ufape.vinculos.application.dto.Participacoes.ParticipacoesRequest;
import br.edu.ufape.vinculos.application.dto.Participacoes.ParticipacoesResponse;
import br.edu.ufape.vinculos.application.dto.Participacoes.ParticipacoesUpdateRequest;
import br.edu.ufape.vinculos.business.facade.Facade;
import br.edu.ufape.vinculos.business.models.Participacao;



@RestController @RequiredArgsConstructor @RequestMapping("/participacoes")
public class ParticipacaoController {
    private final ModelMapper modelMapper;
    private final Facade participacoes;


    @PostMapping
    public ResponseEntity<ParticipacoesResponse> registerParticipacao(@Valid @RequestBody ParticipacoesRequest entity) {
        Participacao response = participacoes.registerParticipacao(entity.convertToEntity());
        return new ResponseEntity<ParticipacoesResponse>(new ParticipacoesResponse(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ParticipacoesResponse> updateParticipacao(@PathVariable Long id, @Valid @RequestBody ParticipacoesUpdateRequest entity) {
       try{
        Participacao participacao = participacoes.findParticipacao(id);
        modelMapper.map(entity, participacao);
        ParticipacoesResponse response = new ParticipacoesResponse(participacoes.registerParticipacao(participacao));
        return new ResponseEntity<ParticipacoesResponse>(response, HttpStatus.OK);
       }catch(RuntimeException e){
           System.err.println(e.getMessage());
           return new ResponseEntity<ParticipacoesResponse>(HttpStatus.NOT_FOUND);
       }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipacoesResponse> findParticipacao(@PathVariable Long id) {
        try{
            ParticipacoesResponse response = new ParticipacoesResponse(participacoes.findParticipacao(id));
            return new ResponseEntity<ParticipacoesResponse>(response, HttpStatus.OK);
        }catch(RuntimeException e){
            System.err.println(e.getMessage());
            return new ResponseEntity<ParticipacoesResponse>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/estudante/{id}")
    public List<ParticipacoesResponse> findParticipacoesByEstudanteId(@PathVariable Long id) {
        return participacoes.findParticipacoesByEstudanteId(id).stream().map(ParticipacoesResponse::new).toList();
    }

    @GetMapping
    public List<ParticipacoesResponse> findAllParticipacoes() {
        return participacoes.findAllParticipacoes().stream().map(ParticipacoesResponse::new).toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteParticipacao(@PathVariable Long id) {
        try{
            String response = participacoes.deleteParticipacao(id);
            return new ResponseEntity<String>(response, HttpStatus.OK);
        }catch(RuntimeException e){
            System.err.println(e.getMessage());
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }
    
}
