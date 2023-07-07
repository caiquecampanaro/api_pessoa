package com.mule.api.pessoa;

import java.net.URI;
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

import com.mule.api.core.models.Pessoa;
import com.mule.api.pessoa.dto.PessoaDTO;
import com.mule.api.pessoa.repository.PessoaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

	@Autowired
	PessoaService service;

	@Autowired
	PessoaRepository repository;

	@GetMapping("{id}")
	public ResponseEntity<Pessoa> buscarId(@PathVariable Long id) {
		Pessoa pessoaBanco = service.buscarId(id);
		return new ResponseEntity<Pessoa>(pessoaBanco, HttpStatus.OK);
	}

	@GetMapping
	public List<Pessoa> buscarPessoas(Pessoa pessoas) {
		return repository.findAll();
	}

	@PostMapping()
	public ResponseEntity<Pessoa> criarPessoa(@Valid @RequestBody PessoaDTO pessoaDTO) {

		// Convertendo o DTO para a ENTIDADE do BANCO!!
//		Pessoa pessoaConvertidaNaEntidade = pessoaDTO.convert();

		// Chamando o SERVICE para salvar a ENTIDADE
//		service.savepessoaConvertidaNaEntidade);

		// feito em uma linha:

		service.save(pessoaDTO.convert());

		// RETORNANDO A ENTIDADE SALVA!
		return ResponseEntity.created(URI.create("/pessoa")).build();

	}

	// Fazer o UPDATE!!!! Kaike e Caio
	@PutMapping("{id}")
	public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) {

		Pessoa pessoaParaAtualizar = pessoaDTO.convert();
		pessoaParaAtualizar.setId(id);
		service.update(pessoaParaAtualizar);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Pessoa> deletar(@PathVariable("id") Long id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
