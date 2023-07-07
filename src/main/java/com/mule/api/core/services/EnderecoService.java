package com.mule.api.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mule.api.core.models.Contato;
import com.mule.api.core.models.Endereco;
import com.mule.api.core.repository.EnderecoRepository;

import jakarta.transaction.Transactional;

@Service
public class EnderecoService {
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Transactional
	public void deletar(Endereco endereco ) {
//		endereco.setPessoa(null);
		enderecoRepository.delete(endereco);
	}

}
