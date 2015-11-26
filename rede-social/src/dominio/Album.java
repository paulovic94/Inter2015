package dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="tb_albuns")
public class Album implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idAlbum;
	private String nomeAlbum;
	private Date dataCriacao;
	
	@ManyToOne
	@JoinColumn(name="usuario")	
	private Usuario usuario;
	
	@OneToMany(mappedBy="album")
	private List<Foto> fotos;
	
	public Album(){
		this.fotos = new ArrayList<Foto>();
	}

	public Album(Integer idAlbum, String nomeAlbum, Date dataCriacao, Usuario usuario) {
		this.idAlbum = idAlbum;
		this.nomeAlbum = nomeAlbum;
		this.dataCriacao = dataCriacao;
		this.usuario = usuario;
		this.fotos = new ArrayList<Foto>();
	}

	public Integer getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(Integer idAlbum) {
		this.idAlbum = idAlbum;
	}

	public String getNomeAlbum() {
		return nomeAlbum;
	}

	public void setNomeAlbum(String nomeAlbum) {
		this.nomeAlbum = nomeAlbum;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAlbum == null) ? 0 : idAlbum.hashCode());
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
		Album other = (Album) obj;
		if (idAlbum == null) {
			if (other.idAlbum != null)
				return false;
		} else if (!idAlbum.equals(other.idAlbum))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Album [idAlbum=" + idAlbum + ", nomeAlbum=" + nomeAlbum + ", dataCriacao=" + dataCriacao + "]";
	}	

}
