package servico.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import dao.CurtidaDao;
import dao.DaoFactory;
import dominio.Curtida;
import dominio.jpa.EM;
import servico.CurtidaServico;
//import servico.ServicoException;

public class CurtidaServicoImpl implements CurtidaServico {
	
	private CurtidaDao dao;
	
	public CurtidaServicoImpl() {
		dao = DaoFactory.criarCurtidaDao();
	}

	@Override
	public boolean inserirAtualizar(Curtida u) {
		EM.getLocalEm().getTransaction().begin();
		Query querycurt = EM.getLocalEm().createQuery("SELECT c FROM Curtida c WHERE usuario = :usu AND post = :post");
		querycurt.setParameter("usu", u.getUsuario());
		querycurt.setParameter("post", u.getPost());
		@SuppressWarnings("unchecked")
		ArrayList<Curtida> curtdb = (ArrayList<Curtida>) querycurt.getResultList();
		if (curtdb.isEmpty()) {
			Curtida novacurtida = new Curtida(null, new Date(), u.getUsuario(), u.getPost());
			dao.inserirAtualizar(novacurtida);
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
	public void excluir(Curtida u) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(u);
		EM.getLocalEm().getTransaction().commit();

	}

	@Override
	public Curtida buscar(int codigo) {
		return dao.buscar(codigo);	
	}

	@Override
	public List<Curtida> buscarTodos() {
		return dao.buscarTodos();
	}

}
