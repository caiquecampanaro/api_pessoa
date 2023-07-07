package com.mule.api.core.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mule.api.core.enums.ContatoEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "CONTATO")
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contato_sequence")
	@SequenceGenerator(allocationSize = 1, name = "contato_sequence", sequenceName = "contato_sequence")
	private Long id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "pessoa_id", nullable = false )
	@JsonBackReference
	private Pessoa pessoa;
	
	@Enumerated(EnumType.STRING)
	private ContatoEnum tipo;
		
	private String valor;

}
