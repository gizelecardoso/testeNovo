package com.example.vaga.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vaga.model.Vaga;
import com.example.vaga.modelTO.VagaTO;
import com.example.vaga.repository.VagaRepository;

@Service
public class VagaService {


	@Autowired
	private VagaRepository repository;


	public VagaTO createVaga (VagaTO vagaTO) {

		Vaga newVaga = new Vaga();

		BeanUtils.copyProperties(vagaTO, newVaga);

		repository.save(newVaga);
		
		vagaTO.setId(newVaga.getId());

		return vagaTO;

	}

}
