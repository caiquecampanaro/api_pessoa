package com.mule.api.dtos;

import com.mule.api.enums.ContatoEnum;
import com.mule.api.models.Pessoa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class ContatoDTO {

	
	private Pessoa pessoa;
	
	private ContatoEnum tipo;
	
	private String valor;

}
