package app.spring.dto;

import java.util.ArrayList;
import java.util.List;

import app.spring.model.Nastavnik;
import app.spring.model.Zvanje;

public class NastavnikDTO {

	private Long id;
	private String ime, biografija, jmbg;
	private List<ZvanjeDTO> zvanja = new ArrayList<>();

	public NastavnikDTO() {
		super();
	}

	public NastavnikDTO(Long id, String ime, String biografija, String jmbg, List<ZvanjeDTO> zvanja) {
		super();
		this.id = id;
		this.ime = ime;
		this.biografija = biografija;
		this.jmbg = jmbg;
		this.zvanja = zvanja;
	}

	public NastavnikDTO(Nastavnik nastavnik) {
		super();
		this.id = nastavnik.getId();
		this.ime = nastavnik.getIme();
		this.biografija = nastavnik.getBiografija();
		this.jmbg = nastavnik.getJmbg();
		for(Zvanje z : nastavnik.getZvanja()) {
			this.zvanja.add(new ZvanjeDTO(z.getId(), z.getDatumIzbora(), z.getDatumPrestanka(), z.getId()));
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getBiografija() {
		return biografija;
	}

	public void setBiografija(String biografija) {
		this.biografija = biografija;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public List<ZvanjeDTO> getZvanja() {
		return zvanja;
	}

	public void setZvanja(List<ZvanjeDTO> zvanja) {
		this.zvanja = zvanja;
	}

}
