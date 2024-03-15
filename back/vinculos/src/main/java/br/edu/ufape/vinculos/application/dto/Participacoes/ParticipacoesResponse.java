package br.edu.ufape.vinculos.application.dto.Participacoes;

import java.util.Date;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import br.edu.ufape.vinculos.business.models.Participacao;
import br.edu.ufape.vinculos.config.SpringApplicationContext;

@Getter @Setter @NoArgsConstructor
public class ParticipacoesResponse {
    private Long id;
    private Long projetoId;
    private Long estudanteId;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataInicio;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataFim;

    public ParticipacoesResponse(Participacao obj){
        if(obj == null) throw new IllegalArgumentException("O objeto não pode ser nulo");
        else{
            ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
            modelMapper.map(obj, this);
        }
    }
}
