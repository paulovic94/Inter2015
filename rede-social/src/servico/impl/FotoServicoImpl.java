package servico.impl;

import java.util.List;

import dao.FotoDao;
import dao.DaoFactory;
import dominio.Foto;
import dominio.jpa.EM;
import servico.FotoServico;
//import servico.ServicoException;

public class FotoServicoImpl implements FotoServico {
	
	private FotoDao dao;
	
	public FotoServicoImpl() {
		dao = DaoFactory.criarFotoDao();
	}

	@Override
	public void inserirAtualizar(Foto u) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(u);
		EM.getLocalEm().getTransaction().commit();

	}

	@Override
	public void excluir(Foto u) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(u);
		EM.getLocalEm().getTransaction().commit();

	}

	@Override
	public Foto buscar(int codigo) {
		return dao.buscar(codigo);	
	}

	@Override
	public List<Foto> buscarTodos() {
		return dao.buscarTodos();
	}

}
