package servico.impl;

import java.util.List;

import dao.PostDao;
import dao.DaoFactory;
import dominio.Post;
import dominio.jpa.EM;
import servico.PostServico;
//import servico.ServicoException;

public class PostServicoImpl implements PostServico {
	
	private PostDao dao;
	
	public PostServicoImpl() {
		dao = DaoFactory.criarPostDao();
	}

	@Override
	public void inserirAtualizar(Post u) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(u);
		EM.getLocalEm().getTransaction().commit();

	}

	@Override
	public void excluir(Post u) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(u);
		EM.getLocalEm().getTransaction().commit();

	}

	@Override
	public Post buscar(int codigo) {
		return dao.buscar(codigo);	
	}

	@Override
	public List<Post> buscarTodos() {
		return dao.buscarTodos();
	}

}
