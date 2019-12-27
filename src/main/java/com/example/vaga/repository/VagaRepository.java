package com.example.vaga.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.vaga.model.Vaga;

@Repository
public interface VagaRepository extends CrudRepository<Vaga, Integer> {

}
