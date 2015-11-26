package dominio.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.MensagemDao;
//import dao.Conexao;
import dominio.Mensagem;

public class MensagemDaoImpl implements MensagemDao {
	
	private EntityManager em;
	
	public MensagemDaoImpl(/*Conexao con*/) {
		//ConexaoImpl aux = (ConexaoImpl) con;
		this.em = EM.getLocalEm();//aux.getEm();
	}

	@Override
	public void inserirAtualizar(Mensagem u) {
		if (u.getIdConversa() != null) {
			u = em.merge(u);
		}
		em.persist(u);

	}

	@Override
	public void excluir(Mensagem u) {
		u = em.merge(u);
		em.remove(u);

	}

	@Override
	public Mensagem buscar(int codigo) {
		return em.find(Mensagem.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mensagem> buscarTodos() {
		String jpql = "SELECT a FROM Mensagem a";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

}
