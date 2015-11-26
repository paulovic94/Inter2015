package dominio.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.AmizadeDao;
//import dao.Conexao;
import dominio.Amizade;

public class AmizadeDaoImpl implements AmizadeDao {
	
	private EntityManager em;
	
	public AmizadeDaoImpl(/*Conexao con*/) {
		//ConexaoImpl aux = (ConexaoImpl) con;
		this.em = EM.getLocalEm();
	}

	@Override
	public void inserirAtualizar(Amizade u) {
		if (u.getIdAmizade() != null) {
			u = em.merge(u);
		}
		em.persist(u);

	}

	@Override
	public void excluir(Amizade u) {
		u = em.merge(u);
		em.remove(u);

	}

	@Override
	public Amizade buscar(int codigo) {
		return em.find(Amizade.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Amizade> buscarTodos() {
		String jpql = "SELECT a FROM Amizade a";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

}
