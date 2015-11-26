package dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="tb_comentarios")
public class Comentario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idComentario;
	private String comentario;
	private Date dataComentario;
	
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="postComentarios")
	private Post post;
	
	public Comentario(){
		
	}

	public Comentario(Integer idComentario, String comentario, Date dataComentario, Usuario usuario, Post post) {
		this.idComentario = idComentario;
		this.comentario = comentario;
		this.dataComentario = dataComentario;
		this.usuario = usuario;
		this.post = post;
	}

	public Integer getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(Integer idComentario) {
		this.idComentario = idComentario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getDataComentario() {
		return dataComentario;
	}

	public void setDataComentario(Date dataComentario) {
		this.dataComentario = dataComentario;
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
		result = prime * result + ((idComentario == null) ? 0 : idComentario.hashCode());
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
		Comentario other = (Comentario) obj;
		if (idComentario == null) {
			if (other.idComentario != null)
				return false;
		} else if (!idComentario.equals(other.idComentario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comentario [idComentario=" + idComentario + ", comentario=" + comentario + ", dataComentario="
				+ dataComentario + "]";
	}
	
	

}
