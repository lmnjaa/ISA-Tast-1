package app.spring.dto;

import app.spring.model.NaucnaOblast;

public class NaucnaOblastDTO {

	private Long id;
	private String naziv;
	private Long zvanjeId;

	public NaucnaOblastDTO() {
		super();
	}

	public NaucnaOblastDTO(Long id, String naziv, Long zvanjeId) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.zvanjeId = zvanjeId;
	}

	public NaucnaOblastDTO(NaucnaOblast naucnaOblast) {
		super();
		this.id = naucnaOblast.getId();
		this.naziv = naucnaOblast.getNaziv();
		this.zvanjeId = naucnaOblast.getZvanje().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Long getZvanjeId() {
		return zvanjeId;
	}

	public void setZvanjeId(Long zvanjeId) {
		this.zvanjeId = zvanjeId;
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
		NaucnaOblastDTO other = (NaucnaOblastDTO) obj;
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
		return "NaucnaOblastDTO [id=" + id + ", naziv=" + naziv + ", zvanjeId=" + zvanjeId + "]";
	}

}
