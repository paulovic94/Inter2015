package dominio.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.PostDao;
//import dao.Conexao;
import dominio.Post;

public class PostDaoImpl implements PostDao {
	
	private EntityManager em;
	
	public PostDaoImpl(/*Conexao con*/) {
		//ConexaoImpl aux = (ConexaoImpl) con;
		this.em = EM.getLocalEm();//aux.getEm();
	}

	@Override
	public void inserirAtualizar(Post u) {
		if (u.getIdPost() != null) {
			u = em.merge(u);
		}
		em.persist(u);

	}

	@Override
	public void excluir(Post u) {
		u = em.merge(u);
		em.remove(u);

	}

	@Override
	public Post buscar(int codigo) {
		return em.find(Post.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> buscarTodos() {
		String jpql = "SELECT a FROM Post a";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

}
