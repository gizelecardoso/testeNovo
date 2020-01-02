package com.example.vaga.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vaga.model.Pessoa;
import com.example.vaga.modelTO.PessoaTO;
import com.example.vaga.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	

	public PessoaTO updateOrCreatePerson (PessoaTO personTO) {
			
		Pessoa newPerson = new Pessoa();
			
		BeanUtils.copyProperties(personTO, newPerson);
			
		repository.save(newPerson);
		
		personTO.setId(newPerson.getId());
		
		return personTO;
		
	}

}
