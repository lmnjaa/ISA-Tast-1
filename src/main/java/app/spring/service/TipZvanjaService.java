package app.spring.service;

import org.springframework.stereotype.Service;

import app.spring.model.TipZvanja;
import app.spring.repository.TipZvanjaRepository;

@Service
public class TipZvanjaService {
	
	private TipZvanjaRepository tipZvanjaRepository;
	
	public Iterable<TipZvanja> findAll(){
		return tipZvanjaRepository.findAll();
	}
	
	public TipZvanja findById(Long id) {
		return tipZvanjaRepository.findById(id).orElse(null);
	}
	
	public void save(TipZvanja tipZvanja) {
		tipZvanjaRepository.save(tipZvanja);
	}
	
	public void delete(Long id) {
		tipZvanjaRepository.deleteById(id);
	}

}
