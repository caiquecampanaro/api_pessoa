package com.mule.api.pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mule.api.core.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}