package dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="tb_fotos")
public class Foto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idFoto;
	private String legenda;
	private Date dataFoto;
	
	@ManyToOne
	@JoinColumn(name="album")
	private Album album;
	
	public Foto(){
		
	}

	public Foto(Integer idFoto, String legenda, Date dataFoto, Album album) {
		this.idFoto = idFoto;
		this.legenda = legenda;
		this.dataFoto = dataFoto;
		this.album = album;
	}

	public Integer getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(Integer idFoto) {
		this.idFoto = idFoto;
	}

	public String getNomeFoto() {
		return legenda;
	}

	public void setNomeFoto(String legenda) {
		this.legenda = legenda;
	}

	public Date getDataFoto() {
		return dataFoto;
	}

	public void setDataFoto(Date dataFoto) {
		this.dataFoto = dataFoto;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFoto == null) ? 0 : idFoto.hashCode());
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
		Foto other = (Foto) obj;
		if (idFoto == null) {
			if (other.idFoto != null)
				return false;
		} else if (!idFoto.equals(other.idFoto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Foto [idFoto=" + idFoto + ", legenda=" + legenda + ", dataFoto=" + dataFoto + "]";
	}		
}
