package br.edu.ufape.editais.model;

import br.edu.ufape.editais.model.dto.DadosAtualizarVaga;
import br.edu.ufape.editais.model.dto.VagaDTO;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantidade;
    private boolean ativa;

    public Vaga(VagaDTO dados) {
    	this.quantidade = dados.quantidade();
    	this.ativa = true;
    }
    
    /*
    // Método para verificar se a quantidade de pessoas concorrendo está dentro do intervalo permitido
    public boolean vagaValida() {
    	if(this.quantidade > 50) {
    		ativar();
    		return this.ativa;
    	}
    	inativar();
    	return this.ativa;
    }
    */

	public void atualizarInformacoes(DadosAtualizarVaga dados) {
		if (dados.quantidade() != 0) {
			this.quantidade = dados.quantidade();
		}
	}

	public void inativar() {
		this.ativa = false;
	}

	public void ativar() {
	    this.ativa = true;
	}

}