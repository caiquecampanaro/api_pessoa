package com.mule.api.dtos;

import java.util.List;

import com.mule.api.models.Contato;
import com.mule.api.models.Endereco;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class PessoaDTO {

	private List<Contato> contatos;

	private Endereco endereco;

	private String nome;

	private String sobrenome;
	

}



