package com.example.vaga.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vaga.model.Vaga;
import com.example.vaga.modelTO.VagaTO;
import com.example.vaga.repository.VagaRepository;

import javassist.NotFoundException;

@Service
public class VagaService {


	@Autowired
	private VagaRepository repository;

	/**
	 * Find all vagas into of the database.
	 */
	public List<VagaTO> findVaga () {

		Iterable<Vaga> listVaga = repository.findAll();

		VagaTO vagaTO = new VagaTO();
		List<VagaTO> listVagaTO = new ArrayList<>();

		for (Vaga vaga : listVaga) {
			BeanUtils.copyProperties(vaga, vagaTO);
			listVagaTO.add(vagaTO);
		}

		return listVagaTO;

	}


	/**
	 * Find vagas by id.
	 * @throws NotFoundException 
	 */
	public VagaTO findVagaById (Integer id) throws NotFoundException {

		Optional<Vaga> vaga = repository.findById(id);

		if(vaga.isPresent()) {
			VagaTO vagaTO = new VagaTO();
			BeanUtils.copyProperties(vaga, vagaTO);

			return vagaTO;
		} else {
			throw new NotFoundException("Vaga não encontrada no banco!");
		}

	}



	/**
	 * Create or update vaga
	 */

	public VagaTO updateOrCreateVaga (VagaTO vagaTO) {

		if(vagaTO.getId() != null) {

			Optional<Vaga> vaga = repository.findById(vagaTO.getId());

			Vaga oldVaga = new Vaga();
			BeanUtils.copyProperties(vaga, oldVaga);

			Vaga newVaga = new Vaga();
			BeanUtils.copyProperties(vagaTO, newVaga);

			repository.delete(oldVaga);

			repository.save(newVaga);


		} else {

			Vaga newVaga = new Vaga();

			BeanUtils.copyProperties(vagaTO, newVaga);

			repository.save(newVaga);

		}

		return vagaTO;

	}

	/**
	 * 
	 * Delete vagas
	 */
	public void deleteVaga(Integer id) {
		Optional<Vaga> vaga = repository.findById(id);

		if(vaga.isPresent()) {

			Vaga oldVaga = new Vaga();
			BeanUtils.copyProperties(vaga, oldVaga);

			repository.delete(oldVaga);

		}
	}

}
