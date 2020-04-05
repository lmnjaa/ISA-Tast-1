package app.spring.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "zvanja")
public class Zvanje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Type(type = "date")
	private LocalDate datumIzbora;
	
	@Type(type = "date")
	private LocalDate datumPrestanka;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "zvanje", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private NaucnaOblast naucnaOblast;
	
	@ManyToOne(optional = false)
	private Nastavnik nastavnik;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "zvanje", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private TipZvanja tipZvanja;

	public Zvanje() {
		super();
	}
	

	public Zvanje(LocalDate datumIzbora, LocalDate datumPrestanka, NaucnaOblast naucnaOblast, Nastavnik nastavnik,
			TipZvanja tipZvanja) {
		super();
		this.datumIzbora = datumIzbora;
		this.datumPrestanka = datumPrestanka;
		this.naucnaOblast = naucnaOblast;
		this.nastavnik = nastavnik;
		this.tipZvanja = tipZvanja;
	}


	public Zvanje(Long id, LocalDate datumIzbora, LocalDate datumPrestanka, NaucnaOblast naucnaOblast, Nastavnik nastavnik,
			TipZvanja tipZvanja) {
		super();
		this.id = id;
		this.datumIzbora = datumIzbora;
		this.datumPrestanka = datumPrestanka;
		this.naucnaOblast = naucnaOblast;
		this.nastavnik = nastavnik;
		this.tipZvanja = tipZvanja;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDatumIzbora() {
		return datumIzbora;
	}

	public void setDatumIzbora(LocalDate datumIzbora) {
		this.datumIzbora = datumIzbora;
	}

	public LocalDate getDatumPrestanka() {
		return datumPrestanka;
	}

	public void setDatumPrestanka(LocalDate datumPrestanka) {
		this.datumPrestanka = datumPrestanka;
	}

	public NaucnaOblast getNaucnaOblast() {
		return naucnaOblast;
	}

	public void setNaucnaOblast(NaucnaOblast naucnaOblast) {
		this.naucnaOblast = naucnaOblast;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public TipZvanja getTipZvanja() {
		return tipZvanja;
	}

	public void setTipZvanja(TipZvanja tipZvanja) {
		this.tipZvanja = tipZvanja;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datumIzbora == null) ? 0 : datumIzbora.hashCode());
		result = prime * result + ((datumPrestanka == null) ? 0 : datumPrestanka.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nastavnik == null) ? 0 : nastavnik.hashCode());
		result = prime * result + ((naucnaOblast == null) ? 0 : naucnaOblast.hashCode());
		result = prime * result + ((tipZvanja == null) ? 0 : tipZvanja.hashCode());
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
		Zvanje other = (Zvanje) obj;
		if (datumIzbora == null) {
			if (other.datumIzbora != null)
				return false;
		} else if (!datumIzbora.equals(other.datumIzbora))
			return false;
		if (datumPrestanka == null) {
			if (other.datumPrestanka != null)
				return false;
		} else if (!datumPrestanka.equals(other.datumPrestanka))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nastavnik == null) {
			if (other.nastavnik != null)
				return false;
		} else if (!nastavnik.equals(other.nastavnik))
			return false;
		if (naucnaOblast == null) {
			if (other.naucnaOblast != null)
				return false;
		} else if (!naucnaOblast.equals(other.naucnaOblast))
			return false;
		if (tipZvanja == null) {
			if (other.tipZvanja != null)
				return false;
		} else if (!tipZvanja.equals(other.tipZvanja))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Zvanje [id=" + id + ", datumIzbora=" + datumIzbora + ", datumPrestanka=" + datumPrestanka
				+ ", naucnaOblast=" + naucnaOblast + ", nastavnik=" + nastavnik + ", tipZvanja=" + tipZvanja + "]";
	}
	
	

}
