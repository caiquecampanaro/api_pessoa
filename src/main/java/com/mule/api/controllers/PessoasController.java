package com.mule.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mule.api.components.PessoaService;
import com.mule.api.models.Pessoa;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {

	@Autowired
	private PessoaService pessoasService;
	
	

	@GetMapping
	public ResponseEntity<List<Pessoa>> getPessoas() {
		return new ResponseEntity<List<Pessoa>>(pessoasService.buscarPessoas(), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> getPessoa(@PathVariable Long id) {
		return new ResponseEntity<Pessoa>(pessoasService.buscarId(id), HttpStatus.OK) {
		};
	}

	@PostMapping
	@Transactional
	public ResponseEntity<Pessoa> createPessoa(@RequestBody Pessoa pessoa) {
		pessoasService.saveOrUpdate(pessoa);
		return new ResponseEntity<Pessoa>(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Pessoa> updatePessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		pessoasService.saveOrUpdate(pessoa);
		return new ResponseEntity<Pessoa>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}") 
	public ResponseEntity<Pessoa> deletePessoa(@PathVariable Long id) {
		pessoasService.deletar(id);
		return new ResponseEntity<Pessoa>(HttpStatus.NO_CONTENT); 
	}
	
	

}
