package servico.impl;

import java.util.List;

import dao.AlbumDao;
import dao.DaoFactory;
import dao.UsuarioDao;
import dominio.Album;
import dominio.Usuario;
import dominio.jpa.EM;
import servico.AlbumServico;
import servico.ServicoException;

public class AlbumServicoImpl implements AlbumServico {
	
	private AlbumDao dao;
	
	public AlbumServicoImpl() {
		dao = DaoFactory.criarAlbumDao();
	}

	@Override
	public void inserirAlbum(Album u) throws ServicoException {
		
		//AlbumDao albDao = DaoFactory.criarAlbumDao();
		UsuarioDao usuDao = DaoFactory.criarUsuarioDao();
		
		Usuario usuario = usuDao.buscar(u.getUsuario().getIdUsuario());
		
		for (Album alb : usuario.getAlbuns()) {
			if (alb.getNomeAlbum().equals(u.getNomeAlbum())) {
				throw new ServicoException("Este usuário já possui um álbum com esse nome!", 1);
			}
		}
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(u);
		EM.getLocalEm().getTransaction().commit();

	}

	@Override
	public void excluir(Album u) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(u);
		EM.getLocalEm().getTransaction().commit();

	}

	@Override
	public Album buscar(int codigo) {
		return dao.buscar(codigo);	
	}

	@Override
	public List<Album> buscarTodos() {
		return dao.buscarTodos();
	}

}
