package com.example.vaga.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.vaga.model.Candidatura;

@Repository
public interface CandidaturaRepository extends CrudRepository<Candidatura, Integer> {

}
