package app.spring.service;

import org.springframework.stereotype.Service;

import app.spring.model.NaucnaOblast;
import app.spring.repository.NaucnaOblastRepository;

@Service
public class NaucnaOblastService {
	
	private NaucnaOblastRepository naucnaOblastRepository;
	
	public Iterable<NaucnaOblast> findAll(){
		return naucnaOblastRepository.findAll();
	}
	
	public NaucnaOblast findById(Long id) {
		return naucnaOblastRepository.findById(id).orElse(null);
	}
	
	public void save(NaucnaOblast naucnaOblast) {
		naucnaOblastRepository.save(naucnaOblast);
	}
	
	public void delete(Long id) {
		naucnaOblastRepository.deleteById(id);
	}

}
