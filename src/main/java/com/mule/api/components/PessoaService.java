package com.mule.api.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mule.api.models.Pessoa;
import com.mule.api.repositories.ContatoRepository;
import com.mule.api.repositories.EnderecoRepository;
import com.mule.api.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private ContatoRepository contatoRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

//	private Long id;
//
//	private List<Contatocompomemts> contatos;
//
//
//	private Enderecocomponents endereco;
//
//	private String nome;
//
//	private String sobrenome;

	public void saveOrUpdate(Pessoa pessoa) {
//		Pessoa pessoa = this.convert();
		pessoa.getEndereco().setPessoa(pessoa);

		enderecoRepository.save(pessoa.getEndereco());

		pessoa.getContatos().stream().forEach(contato -> contato.setPessoa(pessoa));

		contatoRepository.saveAll(pessoa.getContatos());
	}

	public Pessoa buscarId(Long id) {
		return pessoaRepository.findById(id).orElseGet(null);
	}

	public List<Pessoa> buscarPessoas() {
		return pessoaRepository.findAll();
	}

	public void deletar(Long id) {
		pessoaRepository.deleteById(id);
	}

//	@Override
//	public Pessoa convert() {
//		Pessoa pessoa = new Pessoa();
//		pessoa.setNome(nome);
//		pessoa.setSobrenome(sobrenome);
//		pessoa.setId(id);
//		pessoa.setEndereco(this.endereco.convert());
//		pessoa.setContatos(this.contatos.stream().map(t -> t.convert()).toList());
//		return pessoa;
//	}
//
//	public Pessoacomponets setPessoa(Pessoa pessoa) {
//		this.id = pessoa.getId();
//		this.nome = pessoa.getNome();
//		this.sobrenome = pessoa.getSobrenome();
//		this.contatos = pessoa.getContatos().stream().map(t -> {
//			Contatocompomemts contatoComponent = new Contatocompomemts();
//			contatoComponent.setId(t.getId());
//			contatoComponent.setPessoa(null);
//			contatoComponent.setTipo(t.getTipo());
//			contatoComponent.setValor(t.getValor());
//			return contatoComponent;
//		}).toList();
//		Enderecocomponents enderecoComponent = new Enderecocomponents();
//		if (this.endereco != null) {
//			enderecoComponent.setId(pessoa.getEndereco().getId());
//			enderecoComponent.setCidade(pessoa.getEndereco().getCidade());
//			enderecoComponent.setEstado(pessoa.getEndereco().getEstado());
//			enderecoComponent.setBairro(pessoa.getEndereco().getBairro());
//			enderecoComponent.setRua(pessoa.getEndereco().getRua());
//			enderecoComponent.setNumero(pessoa.getEndereco().getNumero());
//
//		}
//		this.endereco = enderecoComponent;
//		return this;
//	}
//	
//	public Pessoacomponets setId(Long id) {
//		this.id = id;
//		return this;
//	}
	
//	public Pessoacomponets(Long id) {
//		this.id = id;
//	}

}
