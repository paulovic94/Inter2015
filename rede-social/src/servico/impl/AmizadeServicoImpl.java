package servico.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import dao.AmizadeDao;
import dao.DaoFactory;
import dominio.Amizade;
import dominio.jpa.EM;
import servico.AmizadeServico;
//import servico.ServicoException;

public class AmizadeServicoImpl implements AmizadeServico {
	
	private AmizadeDao dao;
	
	public AmizadeServicoImpl() {
		dao = DaoFactory.criarAmizadeDao();
	}

	@Override
	public boolean inserirAtualizar(Amizade u) {
		EM.getLocalEm().getTransaction().begin();
		TypedQuery<Amizade> queryamz = EM.getLocalEm()
				.createQuery("SELECT a FROM Amizade a WHERE seguido = :do AND seguidor = :dor", Amizade.class);
		queryamz.setParameter("do", u.getSeguido());
		queryamz.setParameter("dor", u.getSeguidor());
		List<Amizade> amzdb = queryamz.getResultList();
		if (amzdb.isEmpty()) {
			Amizade novaamz = new Amizade(null, new Date(), u.getSeguido(), u.getSeguidor());
			dao.inserirAtualizar(novaamz);
			EM.getLocalEm().getTransaction().commit();
			return true;
		
		} else {
			dao.inserirAtualizar(u);
			dao.excluir(u);
			EM.getLocalEm().getTransaction().commit();
			return false;
		}
	}

	@Override
	public void excluir(Amizade u) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(u);
		EM.getLocalEm().getTransaction().commit();

	}

	@Override
	public Amizade buscar(int codigo) {
		return dao.buscar(codigo);	
	}

	@Override
	public List<Amizade> buscarTodos() {
		return dao.buscarTodos();
	}

}
