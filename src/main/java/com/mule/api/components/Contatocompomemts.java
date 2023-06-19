package com.mule.api.components;

import org.springframework.stereotype.Component;

import com.mule.api.enums.ContatoEnum;
import com.mule.api.models.Contato;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter @Setter
public class Contatocompomemts implements ConvertEntity<Contato>  {

	private Long id;
	
	private PessoaService pessoa;
	
	private ContatoEnum tipo;
		
	private String valor;

	@Override
	public Contato convert() {
		Contato contato = new Contato();
		contato.setId(id);
		contato.setPessoa(null);
		contato.setTipo(tipo);
		contato.setValor(valor);
		
		return contato;
	}

}
