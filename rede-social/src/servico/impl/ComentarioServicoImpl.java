package servico.impl;

import java.util.List;

import dao.ComentarioDao;
import dao.DaoFactory;
import dominio.Comentario;
import dominio.jpa.EM;
import servico.ComentarioServico;
//import servico.ServicoException;

public class ComentarioServicoImpl implements ComentarioServico {
	
	private ComentarioDao dao;
	
	public ComentarioServicoImpl() {
		dao = DaoFactory.criarComentarioDao();
	}

	@Override
	public void inserirAtualizar(Comentario u) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(u);
		EM.getLocalEm().getTransaction().commit();

	}

	@Override
	public void excluir(Comentario u) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(u);
		EM.getLocalEm().getTransaction().commit();

	}

	@Override
	public Comentario buscar(int codigo) {
		return dao.buscar(codigo);	
	}

	@Override
	public List<Comentario> buscarTodos() {
		return dao.buscarTodos();
	}

}
