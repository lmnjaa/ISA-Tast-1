package app.spring.dto;

import java.sql.Date;
import java.time.LocalDate;

import app.spring.model.Zvanje;

public class ZvanjeDTO {

	private Long id;
	private LocalDate datumIzbora;
	private LocalDate datumPrestanka;

	private Long nastavnikId;

	public ZvanjeDTO() {
		super();
	}

	public ZvanjeDTO(Long id, LocalDate datumIzbora, LocalDate datumPrestanka, Long nastavnikId) {
		super();
		this.id = id;
		this.datumIzbora = datumIzbora;
		this.datumPrestanka = datumPrestanka;
		this.nastavnikId = nastavnikId;
	}

	public ZvanjeDTO(Zvanje zvanje) {
		super();
		this.id = zvanje.getId();
		this.datumIzbora = zvanje.getDatumIzbora();
		this.datumPrestanka = zvanje.getDatumPrestanka();

		this.nastavnikId = zvanje.getNastavnik().getId();
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

	public Long getNastavnikId() {
		return nastavnikId;
	}

	public void setNastavnikId(Long nastavnikId) {
		this.nastavnikId = nastavnikId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datumIzbora == null) ? 0 : datumIzbora.hashCode());
		result = prime * result + ((datumPrestanka == null) ? 0 : datumPrestanka.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nastavnikId == null) ? 0 : nastavnikId.hashCode());
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
		ZvanjeDTO other = (ZvanjeDTO) obj;
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
		if (nastavnikId == null) {
			if (other.nastavnikId != null)
				return false;
		} else if (!nastavnikId.equals(other.nastavnikId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ZvanjeDTO [id=" + id + ", datumIzbora=" + datumIzbora + ", datumPrestanka=" + datumPrestanka
				+ ", nastavnikId=" + nastavnikId + "]";
	}

}
