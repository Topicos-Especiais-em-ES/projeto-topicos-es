package br.edu.ufape.editais.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

import br.edu.ufape.editais.model.Vaga;
import br.edu.ufape.editais.model.dto.DadosAtualizarVaga;
import br.edu.ufape.editais.model.dto.DadosDetalhamentoVaga;
import br.edu.ufape.editais.model.dto.DadosListagemVaga;
import br.edu.ufape.editais.model.dto.VagaDTO;
import br.edu.ufape.editais.repository.VagaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    private VagaRepository repository;
    
    @PostMapping
    public ResponseEntity<DadosDetalhamentoVaga> cadastrarVaga(@RequestBody @Valid VagaDTO dados, UriComponentsBuilder uriBuilder) {
    	var vaga = new Vaga(dados);
    	repository.save(new Vaga(dados));
    	
    	var uri = uriBuilder.path("/vagas/{id}").buildAndExpand(vaga.getId()).toUri();
    	
    	return ResponseEntity.created(uri).body(new DadosDetalhamentoVaga(vaga));
    }
    
    @GetMapping
    public ResponseEntity<List<DadosListagemVaga>> listarVagas(){
    	var lista = repository.findAllByAtivaTrue().stream().map(DadosListagemVaga :: new).toList();
    	
    	return ResponseEntity.ok(lista);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoVaga> buscarVagaPorId(@PathVariable Long id) {
    	var vaga = repository.getReferenceById(id);
    	
    	return ResponseEntity.ok(new DadosDetalhamentoVaga(vaga));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoVaga> atualizarVaga(@RequestBody @Valid DadosAtualizarVaga dados) {
    	var vaga = repository.getReferenceById(dados.id());
        vaga.atualizarInformacoes(dados);
        
        return ResponseEntity.ok(new DadosDetalhamentoVaga(vaga));
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirVaga(@PathVariable Long id) {
    	repository.deleteById(id);
    	
    	return ResponseEntity.noContent().build();
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativarVaga(@PathVariable Long id) {
    	var vaga = repository.getReferenceById(id);
    	vaga.inativar();
    	
    	return ResponseEntity.noContent().build();
    }
    
    @PutMapping("reativar/{id}")
    @Transactional
    public ResponseEntity<Void> reativarVaga(@PathVariable Long id) {
        var vaga = repository.getReferenceById(id);
        if (vaga.vagaValida() == true) {
            vaga.ativar();
       }
        
        return ResponseEntity.noContent().build();
    }
}