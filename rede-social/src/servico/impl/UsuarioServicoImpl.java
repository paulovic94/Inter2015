package servico.impl;

import java.util.List;

import dao.DaoFactory;
import dao.UsuarioDao;
import dominio.Foto;
import dominio.Usuario;
import dominio.jpa.EM;
import servico.UsuarioServico;

public class UsuarioServicoImpl implements UsuarioServico {
	
	private UsuarioDao dao;
	
	public UsuarioServicoImpl() {
		dao = DaoFactory.criarUsuarioDao();
	}

	@Override
	public void inserirAtualizar(Usuario u) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(u);
		EM.getLocalEm().getTransaction().commit();

	}

	@Override
	public void excluir(Usuario u) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(u);
		EM.getLocalEm().getTransaction().commit();

	}

	@Override
	public Usuario buscar(int codigo) {
		return dao.buscar(codigo);	
	}

	@Override
	public List<Usuario> buscarTodos() {
		return dao.buscarTodos();
	}

	@Override
	public void definirFotoPerfil(Usuario u, Foto f) {
		
	}

}
