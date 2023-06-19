package com.mule.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mule.api.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
