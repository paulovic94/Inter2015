package dao;

import java.util.List;

import dominio.Amizade;

public interface AmizadeDao {
	
	public void inserirAtualizar(Amizade u);
	public void excluir(Amizade u);
	public Amizade buscar(int codigo);
	public List<Amizade> buscarTodos();

}
