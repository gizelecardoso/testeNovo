package com.example.vaga.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.vaga.model.Pessoa;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Integer> {

}
