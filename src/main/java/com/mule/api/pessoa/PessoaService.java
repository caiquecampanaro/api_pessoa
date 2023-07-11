package com.mule.api.pessoa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mule.api.core.models.Pessoa;
import com.mule.api.core.services.ContatoService;
import com.mule.api.core.services.EnderecoService;
import com.mule.api.pessoa.repository.PessoaRepository;

import jakarta.transaction.Transactional;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ContatoService contatoService;

	@Autowired
	private EnderecoService enderecoService;

	@Transactional
	public Pessoa save(Pessoa pessoa) {
		pessoa.getEndereco().setPessoa(pessoa);
		pessoa.getContatos().stream().forEach(contato -> contato.setPessoa(pessoa));
		pessoaRepository.save(pessoa);
		return pessoa;
	}

	@Transactional
	public Pessoa update(Pessoa pessoa) {
//		Pessoa pessoaTeste = pessoaRepository.findById(9L).get();
//		Pessoa pessoaTeste = new Pessoa();
//		pessoaTeste.setNome("BLIBLIBLBILBILBI");
		
//		Pessoa pessoaBD = pessoaRepository.findById(pessoa.getId()).orElse(null);
//		if (Objects.isNull(pessoaBD)) {
//			// Jogar uma exceção de notFound!!!
//		}
//		contatoRepository.deleteAll(pessoaBD.getContatos());
//		contatoRepository.flush();
//		enderecoRepository.deleteById(pessoaBD.getEndereco().getId());
//		enderecoRepository.flush();
//		pessoaBD.setEndereco(null);
//		pessoaBD.setContatos(null);
//		pessoaRepository.save(pessoaBD);
		
//		Pessoa testePessoa = pessoaRepository.findById(pessoa.getId()).get();
//		contatoService.deletar(testePessoa.getContatos());
//		enderecoService.deletar(testePessoa.getEndereco());
		return save(pessoa);
	}

	public Pessoa buscarId(Long id) {
		return pessoaRepository.findById(id).orElse(null);
	}

	public List<Pessoa> buscarPessoas() {
		return pessoaRepository.findAll();
	}

	@Transactional
	public void deletar(Long id) {
		pessoaRepository.deleteById(id);
	}

}
