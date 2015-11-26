package dao;

import java.util.List;

import dominio.Comentario;

public interface ComentarioDao {
	
	public void inserirAtualizar(Comentario u);
	public void excluir(Comentario u);
	public Comentario buscar(int codigo);
	public List<Comentario> buscarTodos();

}
