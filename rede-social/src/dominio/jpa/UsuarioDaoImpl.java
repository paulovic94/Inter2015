package dominio.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.UsuarioDao;
import dominio.Foto;
//import dao.Conexao;
import dominio.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {
	
	private EntityManager em;
	
	public UsuarioDaoImpl(/*Conexao con*/) {
		//ConexaoImpl aux = (ConexaoImpl) con;
		this.em = EM.getLocalEm();//aux.getEm();
	}

	@Override
	public void inserirAtualizar(Usuario u) {
		if (u.getIdUsuario() != null) {
			u = em.merge(u);
		}
		em.persist(u);

	}

	@Override
	public void excluir(Usuario u) {
		u = em.merge(u);
		em.remove(u);

	}

	@Override
	public Usuario buscar(int codigo) {
		return em.find(Usuario.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> buscarTodos() {
		String jpql = "SELECT a FROM Usuario a";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public void definirFotoPerfil(Usuario u, Foto f) {
		u = em.merge(u);
		u.setFotoPerfil(f);
		
	}

}
