package com.mule.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mule.api.components.PessoaService;
import com.mule.api.models.Pessoa;
import com.mule.api.repositories.PessoaRepository;

@RestController
@RequestMapping("pessoa")
public class PessoaController {
	
	@Autowired
	PessoaService service;
	
	@Autowired
	PessoaRepository repository;
	
	@GetMapping("{id}")
	public ResponseEntity<Pessoa> buscarId (@PathVariable Long id) {
		Pessoa pessoaBanco = service.buscarId(id);
		return new ResponseEntity<Pessoa>(pessoaBanco, HttpStatus.OK);
	}
	
	@GetMapping
	public List<Pessoa> buscarPessoas (Pessoa pessoas) {
		return repository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Pessoa>  salvarPessoa (@RequestBody Pessoa pessoa) { 
		service.salvarPessoa( pessoa.getContatos(), pessoa.getEndereco(), pessoa.getNome(), pessoa.getSobrenome());
		return new ResponseEntity<Pessoa>(HttpStatus.CREATED);
	}

	@DeleteMapping("{id}")
	public  void deletar (@PathVariable("id") Long id ) {
		service.deletar(id);
	}
}
