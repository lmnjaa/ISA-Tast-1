package app.spring.dto;

import app.spring.model.TipZvanja;

public class TipZvanjaDTO {

	private Long id;
	private Long zvanjeId;
	private String naziv;

	public TipZvanjaDTO() {
		super();
	}

	public TipZvanjaDTO(Long id, Long zvanjeId, String naziv) {
		super();
		this.id = id;
		this.zvanjeId = zvanjeId;
		this.naziv = naziv;
	}

	public TipZvanjaDTO(TipZvanja tipZvanja) {
		super();
		this.id = tipZvanja.getId();
		this.zvanjeId = tipZvanja.getZvanje().getId();
		this.naziv = tipZvanja.getNaziv();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getZvanjeId() {
		return zvanjeId;
	}

	public void setZvanjeId(Long zvanjeId) {
		this.zvanjeId = zvanjeId;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		result = prime * result + ((zvanjeId == null) ? 0 : zvanjeId.hashCode());
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
		TipZvanjaDTO other = (TipZvanjaDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		if (zvanjeId == null) {
			if (other.zvanjeId != null)
				return false;
		} else if (!zvanjeId.equals(other.zvanjeId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipZvanjaDTO [id=" + id + ", zvanjeId=" + zvanjeId + ", naziv=" + naziv + "]";
	}

}
