package com.mule.api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "PESSOA")
@NoArgsConstructor
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.AUTO, generator = "pessoa_sequence")
	@SequenceGenerator(allocationSize = 1, name = "pessoa_sequence", sequenceName = "pessoa_sequence")
	@Getter @Setter
	private Long id;

	@OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER)
	@JsonManagedReference
	@Getter @Setter
	private List<Contato> contatos;

	@OneToOne(mappedBy = "pessoa", fetch = FetchType.EAGER)
	@JsonManagedReference
	@Getter @Setter
	private Endereco endereco;

	@NonNull
	@Getter @Setter
	private String nome;

	@NonNull
	@Getter @Setter
	private String sobrenome;
	
	
	public Pessoa(Long id, String nome, String sobrenome  ) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}
	
	public Pessoa(Long id,List<Contato> contatos , Endereco endereco,  String nome, String sobrenome  ) {
		this.id = id;
		this.contatos = contatos;
		this.endereco = endereco;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}
	
	public Pessoa (List<Contato> contatos, Endereco endereco, String nome, String sobrenome) {
		this.contatos = contatos;
		this.endereco = endereco;
		this.nome = nome; 
		this.sobrenome = sobrenome;
		
	}
	
}
