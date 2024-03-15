package br.edu.ufape.vinculos.application.dto.Participacoes;

import java.util.Date;


import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import br.edu.ufape.vinculos.application.annotations.NotFutureDate;
import br.edu.ufape.vinculos.application.annotations.ValidDateRange;
import br.edu.ufape.vinculos.application.validations.DateRange;
import br.edu.ufape.vinculos.business.models.Participacao;
import br.edu.ufape.vinculos.config.SpringApplicationContext;

@Getter @Setter @NoArgsConstructor @ValidDateRange(message = "A data de início deve ser anterior à data de fim")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ParticipacoesUpdateRequest implements DateRange{

    @Override
    public Date getStartDate() {
        return dataInicio;
    }

    @Override
    public Date getEndDate() {
        return dataFim;
    }

    
    @NotFutureDate(message = "A data de início não pode ser futura")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataInicio;


    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataFim;

    private Long estudanteId;
    
    public Participacao convertToEntity() {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        Participacao obj = modelMapper.map(this, Participacao.class);
        return obj;
    }
}
