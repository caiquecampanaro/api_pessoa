package com.mule.api.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mule.api.repositories.ContatoRepository;
import com.mule.api.repositories.EnderecoRepository;
import com.mule.api.repositories.PessoaRepository;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "PESSOA")
@NoArgsConstructor
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_sequence")
	@SequenceGenerator(allocationSize = 1, name = "pessoa_sequence")
	@Getter @Setter
	private Long id;

	@OneToMany(mappedBy = "pessoa")
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
	

}
