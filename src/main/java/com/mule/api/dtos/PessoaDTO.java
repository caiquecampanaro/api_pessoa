package com.mule.api.dtos;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class PessoaDTO {
	
	private List<ContatoDTO> contatos;

	private EnderecoDTO endereco;

	private String nome;

	private String sobrenome;
	

}



