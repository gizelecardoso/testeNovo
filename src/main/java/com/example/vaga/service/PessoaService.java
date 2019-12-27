package com.example.vaga.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vaga.model.Pessoa;
import com.example.vaga.modelTO.PessoaTO;
import com.example.vaga.repository.PessoaRepository;

import javassist.NotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	/**
	 * Find all people into of the database.
	 */
	public List<PessoaTO> findPerson () {
		
		Iterable<Pessoa> listPerson = repository.findAll();

		PessoaTO personTO = new PessoaTO();
		List<PessoaTO> listPersonTO = new ArrayList<>();

		for (Pessoa person : listPerson) {
			BeanUtils.copyProperties(person, personTO);
			listPersonTO.add(personTO);
		}
		
		return listPersonTO;

	}

	
	/**
	 * Encontrando pessoas pelo id.
	 * @throws NotFoundException 
	 */
	public PessoaTO findPersonById (Integer id) throws NotFoundException {
		
		Optional<Pessoa> person = repository.findById(id);
		
		if(person.isPresent()) {
			PessoaTO personTO = new PessoaTO();
			BeanUtils.copyProperties(person, personTO);
			
			return personTO;
		} else {
			throw new NotFoundException("Pessoa não encontrada no banco!");
		}
			
	}
	

	
	/**
	 * Create or update person
	 */
	
	public PessoaTO updateOrCreatePerson (PessoaTO personTO) {
		
		Optional<Pessoa> person = repository.findById(personTO.getId());
		
		if(person.isPresent()) {
		
			Pessoa oldPerson = new Pessoa();
			BeanUtils.copyProperties(person, oldPerson);
			
			Pessoa newPerson = new Pessoa();
			BeanUtils.copyProperties(personTO, newPerson);
			
			repository.delete(oldPerson);
			
			repository.save(newPerson);
			

		} else {
			
			Pessoa newPerson = new Pessoa();
			
			BeanUtils.copyProperties(personTO, newPerson);
			
			repository.save(newPerson);
			
		}
		
		return personTO;
		
	}
	
	/**
	 * 
	 * Deletando pessoas
	 */
	public void deletePerson(Integer id) {
		Optional<Pessoa> person = repository.findById(id);
		
		if(person.isPresent()) {
		
			Pessoa oldPerson = new Pessoa();
			BeanUtils.copyProperties(person, oldPerson);

			repository.delete(oldPerson);

		}
	}
}
