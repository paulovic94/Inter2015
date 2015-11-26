package dominio.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.CurtidaDao;
//import dao.Conexao;
import dominio.Curtida;

public class CurtidaDaoImpl implements CurtidaDao {
	
	private EntityManager em;
	
	public CurtidaDaoImpl(/*Conexao con*/) {
		//ConexaoImpl aux = (ConexaoImpl) con;
		this.em = EM.getLocalEm();//aux.getEm();
	}

	@Override
	public void inserirAtualizar(Curtida u) {
		if (u.getIdCurtida() != null) {
			u = em.merge(u);
		}
		em.persist(u);

	}

	@Override
	public void excluir(Curtida u) {
		u = em.merge(u);
		em.remove(u);

	}

	@Override
	public Curtida buscar(int codigo) {
		return em.find(Curtida.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curtida> buscarTodos() {
		String jpql = "SELECT a FROM Curtida a";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

}
