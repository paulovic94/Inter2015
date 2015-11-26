package dao;

import java.util.List;

import dominio.Foto;
import dominio.Usuario;

public interface UsuarioDao {
	
	public void inserirAtualizar(Usuario u);
	public void excluir(Usuario u);
	public Usuario buscar(int codigo);
	public List<Usuario> buscarTodos();
	
	public void definirFotoPerfil(Usuario u, Foto f);

}
