package app.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.spring.model.Nastavnik;
import app.spring.repository.NastavnikRepository;

@Service
public class NastavnikService {

	@Autowired
	private NastavnikRepository nastavnikRepository;

	public Iterable<Nastavnik> findAll() {
		return nastavnikRepository.findAll();
	}

	public Nastavnik findById(Long id) {
		return nastavnikRepository.findById(id).orElse(null);
	}

	public Nastavnik findOne(String jmbg) {
		Iterable<Nastavnik> nastavnici = nastavnikRepository.findAll();
		for (Nastavnik nastavnik : nastavnici) {
			if (nastavnik.getJmbg().equals(jmbg)) {
				return nastavnik;
			}
		}
		return null;
	}

	public void save(Nastavnik nastavnik) {
		nastavnikRepository.save(nastavnik);
	}

	public void delete(Long id) {
		nastavnikRepository.deleteById(id);
	}

}
