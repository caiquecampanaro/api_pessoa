package com.mule.api.dtos;

import com.mule.api.models.Pessoa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class EnderecoDTO {

	private Pessoa pessoa;
	
	private String cidade;
	
	private String estado;
	
	private String bairro;
	
	private String rua;
	
	private String numero;
	
	
	
}
