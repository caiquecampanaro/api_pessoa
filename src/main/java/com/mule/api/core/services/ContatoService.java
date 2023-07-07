package com.mule.api.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mule.api.core.models.Contato;
import com.mule.api.core.repository.ContatoRepository;

import jakarta.transaction.Transactional;

@Service
public class ContatoService {
	
	@Autowired
	ContatoRepository contatoRepository;
	
	@Transactional
	public void deletar(List<Contato> contatos ) {
//		contatos.stream().forEach(contato -> contato.setPessoa(null));
		contatoRepository.deleteAll(contatos);
	}

}
