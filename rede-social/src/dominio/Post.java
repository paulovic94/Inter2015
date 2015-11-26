package dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="tb_posts")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idPost;
	private String post;
	private Date dataPostagem;
	
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuario;
	
	@OneToMany(mappedBy="post")
	private List<Curtida> curtidas;
	
	@OneToMany(mappedBy="post")
	private List<Comentario> postComentario;
	
	public Post(){
		this.curtidas = new ArrayList<Curtida>();
		this.postComentario = new ArrayList<Comentario>();
	}

	public Post(Integer idPost, String post, Date dataPostagem, Usuario usuario) {
		this.idPost = idPost;
		this.post = post;
		this.dataPostagem = dataPostagem;
		this.usuario = usuario;
		this.curtidas = new ArrayList<Curtida>();
		this.postComentario = new ArrayList<Comentario>();
	}

	public Integer getIdPost() {
		return idPost;
	}

	public void setIdPost(Integer idPost) {
		this.idPost = idPost;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Date getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(Date dataPostagem) {
		this.dataPostagem = dataPostagem;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Curtida> getCurtidas() {
		return curtidas;
	}

	public void setCurtidas(List<Curtida> curtidas) {
		this.curtidas = curtidas;
	}

	public List<Comentario> getComentarios() {
		return postComentario;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.postComentario = comentarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPost == null) ? 0 : idPost.hashCode());
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
		Post other = (Post) obj;
		if (idPost == null) {
			if (other.idPost != null)
				return false;
		} else if (!idPost.equals(other.idPost))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Post [idPost=" + idPost + ", post=" + post + ", dataPostagem=" + dataPostagem + "]";
	}
	
		

}
