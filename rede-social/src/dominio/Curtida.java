package dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="tb_curtidas")
public class Curtida implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCurtida;
	private Date dataCurtida;
	
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="post")
	private Post post;
	
	public Curtida(){
		
	}

	public Curtida(Integer idCurtida, Date dataCurtida, Usuario usuario, Post post) {
		this.idCurtida = idCurtida;
		this.dataCurtida = dataCurtida;
		this.usuario = usuario;
		this.post = post;
	}

	public Integer getIdCurtida() {
		return idCurtida;
	}

	public void setIdCurtida(Integer idCurtida) {
		this.idCurtida = idCurtida;
	}

	public Date getDataCurtida() {
		return dataCurtida;
	}

	public void setDataCurtida(Date dataCurtida) {
		this.dataCurtida = dataCurtida;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCurtida == null) ? 0 : idCurtida.hashCode());
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
		Curtida other = (Curtida) obj;
		if (idCurtida == null) {
			if (other.idCurtida != null)
				return false;
		} else if (!idCurtida.equals(other.idCurtida))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Curtida [idCurtida=" + idCurtida + ", dataCurtida=" + dataCurtida + "]";
	}	

}
