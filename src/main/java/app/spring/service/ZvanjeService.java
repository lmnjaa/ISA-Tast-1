package app.spring.service;

import org.springframework.stereotype.Service;

import app.spring.model.Zvanje;
import app.spring.repository.ZvanjeRepository;

@Service
public class ZvanjeService {

	private ZvanjeRepository zvanjeRepository;

	public Iterable<Zvanje> findAll() {
		return zvanjeRepository.findAll();
	}

	public Zvanje findById(Long id) {
		return zvanjeRepository.findById(id).orElse(null);
	}

	public void save(Zvanje zvanje) {
		zvanjeRepository.save(zvanje);
	}

	public void delete(Long id) {
		zvanjeRepository.deleteById(id);
	}

}
