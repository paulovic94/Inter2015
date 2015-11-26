package dominio.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.FotoDao;
//import dao.Conexao;
import dominio.Foto;

public class FotoDaoImpl implements FotoDao {
	
	private EntityManager em;
	
	public FotoDaoImpl(/*Conexao con*/) {
		//ConexaoImpl aux = (ConexaoImpl) con;
		this.em = EM.getLocalEm();//aux.getEm();
	}

	@Override
	public void inserirAtualizar(Foto u) {
		if (u.getIdFoto() != null) {
			u = em.merge(u);
		}
		em.persist(u);

	}

	@Override
	public void excluir(Foto u) {
		u = em.merge(u);
		em.remove(u);

	}

	@Override
	public Foto buscar(int codigo) {
		return em.find(Foto.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Foto> buscarTodos() {
		String jpql = "SELECT a FROM Foto a";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

}
