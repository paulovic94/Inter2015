package dao;

import java.util.List;

import dominio.Curtida;

public interface CurtidaDao {
	
	public void inserirAtualizar(Curtida u);
	public void excluir(Curtida u);
	public Curtida buscar(int codigo);
	public List<Curtida> buscarTodos();

}
