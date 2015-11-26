package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="tb_usuarios")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUsuario;
	private String nome;
	private Foto fotoPerfil;
	private String login;
	private String email;
	private String senha;
	private String localizacao;
	private String dataNascimento;	
	
	@OneToMany(mappedBy="seguidor")
	private List<Amizade> seguidos;	
	@OneToMany(mappedBy="seguido")
	private List<Amizade> seguidores;	
	
	@OneToMany(mappedBy="recebidas")
	private List<Mensagem> destinatario;	
	@OneToMany(mappedBy="enviadas")
	private List<Mensagem> remetente;	
	
	@OneToMany(mappedBy="usuario")
	private List<Album> albuns;	
	
	@OneToMany(mappedBy="usuario")
	private List<Post> posts;
	
	@OneToMany(mappedBy="usuario")
	private List<Comentario> comentarios;
	
	@OneToMany(mappedBy="usuario")
	private List<Curtida> curtidas;
	
	public Usuario(){
		this.seguidos = new ArrayList<Amizade>();
		this.seguidores = new ArrayList<Amizade>();
		this.destinatario = new ArrayList<Mensagem>();
		this.remetente = new ArrayList<Mensagem>();
		this.albuns = new ArrayList<Album>();
		this.posts = new ArrayList<Post>();
		this.comentarios = new ArrayList<Comentario>();
		this.curtidas = new ArrayList<Curtida>();
	}

	public Usuario(Integer idUsuario, String nome, Foto fotoPerfil, String login, String email, String senha,
			String localizacao, String dataNascimento) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.fotoPerfil = fotoPerfil;
		this.login = login;
		this.email = email;
		this.senha = senha;
		this.localizacao = localizacao;
		this.dataNascimento = dataNascimento;
		this.seguidos = new ArrayList<Amizade>();
		this.seguidores = new ArrayList<Amizade>();
		this.destinatario = new ArrayList<Mensagem>();
		this.remetente = new ArrayList<Mensagem>();
		this.albuns = new ArrayList<Album>();
		this.posts = new ArrayList<Post>();
		this.comentarios = new ArrayList<Comentario>();
		this.curtidas = new ArrayList<Curtida>();
	}	

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Foto getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(Foto fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Amizade> getSeguidos() {
		return seguidos;
	}

	public void setSeguidos(List<Amizade> seguidos) {
		this.seguidos = seguidos;
	}

	public List<Amizade> getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(List<Amizade> seguidores) {
		this.seguidores = seguidores;
	}

	public List<Mensagem> getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(List<Mensagem> destinatario) {
		this.destinatario = destinatario;
	}

	public List<Mensagem> getRemetente() {
		return remetente;
	}

	public void setRemetente(List<Mensagem> remetente) {
		this.remetente = remetente;
	}

	public List<Album> getAlbuns() {
		return albuns;
	}

	public void setAlbuns(List<Album> albuns) {
		this.albuns = albuns;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public List<Curtida> getCurtidas() {
		return curtidas;
	}

	public void setCurtidas(List<Curtida> curtidas) {
		this.curtidas = curtidas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", fotoPerfil=" + fotoPerfil + ", login=" + login
				+ ", email=" + email + ", senha=" + senha + ", localizacao=" + localizacao + ", dataNascimento="
				+ dataNascimento + "]";
	}
	

}
