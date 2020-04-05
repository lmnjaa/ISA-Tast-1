package app.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "nastavnici")
public class Nastavnik {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@Type(type = "text")
	private String ime;

	@Column
	@Type(type = "text")
	private String biografija;

	@Column(nullable = false, unique = true, length = 100)
	@Type(type = "text")
	private String jmbg;

	@Column
	@OneToMany(targetEntity=Zvanje.class, mappedBy="nastavnik", fetch=FetchType.LAZY)
	private List<Zvanje> zvanja;

	public Nastavnik() {
		super();
	}

	public Nastavnik(Long id, String ime, String biografija, String jmbg, List<Zvanje> zvanja) {
		super();
		this.id = id;
		this.ime = ime;
		this.biografija = biografija;
		this.jmbg = jmbg;
		this.zvanja = zvanja;
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

	public List<Zvanje> getZvanja() {
		return zvanja;
	}

	public void setZvanja(List<Zvanje> zvanja) {
		this.zvanja = zvanja;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((biografija == null) ? 0 : biografija.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ime == null) ? 0 : ime.hashCode());
		result = prime * result + ((jmbg == null) ? 0 : jmbg.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nastavnik other = (Nastavnik) obj;
		if (biografija == null) {
			if (other.biografija != null)
				return false;
		} else if (!biografija.equals(other.biografija))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (!ime.equals(other.ime))
			return false;
		if (jmbg == null) {
			if (other.jmbg != null)
				return false;
		} else if (!jmbg.equals(other.jmbg))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nastavni [id=" + id + ", ime=" + ime + ", biografija=" + biografija + ", jmbg=" + jmbg + "]";
	}
	
	

	
	
}
