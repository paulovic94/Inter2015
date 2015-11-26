package servico;

import java.util.List;

import dominio.Foto;
import dominio.Usuario;

public interface UsuarioServico {

	public void inserirAtualizar(Usuario u);
	public void excluir(Usuario u);
	public Usuario buscar(int codigo);
	public List<Usuario> buscarTodos();
	
	public void definirFotoPerfil(Usuario u, Foto x);
}
