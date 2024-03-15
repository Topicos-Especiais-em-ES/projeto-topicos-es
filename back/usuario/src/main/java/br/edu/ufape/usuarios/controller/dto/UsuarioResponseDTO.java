package br.edu.ufape.usuarios.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioResponseDTO {
    private Long id;
    // id do keycloak
    private String keycloak;
    private String login;
    private String nome;
    private boolean gestao;
    private boolean admin;
    private String curso;
    private String celular;
    private String rg;
    private String orgaoExpedidorRg;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate emissaoRg;
    private String cpf;
    private String assinaturaPath;
    private String estadoCivil;
    private String nacionalidade;
    private String naturalidade;
    private EnderecoRequestDTO endereco;
}
