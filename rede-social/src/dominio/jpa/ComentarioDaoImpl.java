package dominio.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ComentarioDao;
//import dao.Conexao;
import dominio.Comentario;

public class ComentarioDaoImpl implements ComentarioDao {
	
	private EntityManager em;
	
	public ComentarioDaoImpl(/*Conexao con*/) {
		//ConexaoImpl aux = (ConexaoImpl) con;
		this.em = EM.getLocalEm();//aux.getEm();
	}

	@Override
	public void inserirAtualizar(Comentario u) {
		if (u.getIdComentario() != null) {
			u = em.merge(u);
		}
		em.persist(u);

	}

	@Override
	public void excluir(Comentario u) {
		u = em.merge(u);
		em.remove(u);

	}

	@Override
	public Comentario buscar(int codigo) {
		return em.find(Comentario.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comentario> buscarTodos() {
		String jpql = "SELECT a FROM Comentario a";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

}
