package com.mule.api.components;

import org.springframework.stereotype.Component;

import com.mule.api.models.Endereco;

import lombok.Getter;
import lombok.Setter;

@Component
@Setter @Getter
public class Enderecocomponents implements ConvertEntity<Endereco>{

	private Long id;
	

	private PessoaService pessoa;
	
	private String cidade;
	private String estado;
	private String bairro;
	private String rua;
	private String numero;
	@Override
	public Endereco convert() {
		Endereco endereco = new Endereco();
		endereco.setId(id);
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
		endereco.setNumero(numero);
		endereco.setRua(rua);
		endereco.setPessoa(null);
		
		return endereco;
	}
	
}
