package com.mule.api.pessoa.dto;

import java.util.ArrayList;
import java.util.List;

import com.mule.api.core.enums.ContatoEnum;
import com.mule.api.core.interfaces.ConvertEntity;
import com.mule.api.core.models.Contato;
import com.mule.api.core.models.Endereco;
import com.mule.api.core.models.Pessoa;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PessoaDTO implements ConvertEntity<Pessoa> {
	@NotEmpty
	public List<ContatoDTO> contatos = new ArrayList<PessoaDTO.ContatoDTO>();

	@NotNull
	public EnderecoDTO endereco;

	@NotBlank
	public String nome;

	@NotBlank
	public String sobrenome;

	@NoArgsConstructor
	public static class ContatoDTO {
		public Long id;
		
		@NotBlank
		@Enumerated(EnumType.STRING)
		public ContatoEnum tipo;

		@NotBlank
		public String valor;

	}

	@NoArgsConstructor
	public static class EnderecoDTO {
		public Long id;
		
		@NotBlank
		public String cidade;

		@NotBlank
		public String estado;

		@NotBlank
		public String bairro;

		@NotBlank
		public String rua;

		@NotBlank
		public String numero;
		
		public String complemento;

	}

	@Override
	public Pessoa convert() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setSobrenome(sobrenome);
		
		this.contatos.forEach(dto -> {
			Contato contato = new Contato();
			contato.setId(dto.id);
			contato.setPessoa(pessoa);
			contato.setTipo(dto.tipo);
			contato.setValor(dto.valor);	
			
			pessoa.getContatos().add(contato);
		});
		
		Endereco endereco = new Endereco();
		endereco.setId(this.endereco.id);
		endereco.setBairro(this.endereco.bairro);
		endereco.setCidade(this.endereco.cidade);
		endereco.setEstado(this.endereco.estado);
		endereco.setNumero(this.endereco.numero);
		endereco.setRua(this.endereco.rua);
		endereco.setPessoa(pessoa);
		
		pessoa.setEndereco(endereco);

		return pessoa;
	}

}
