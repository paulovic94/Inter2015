package dao;

import java.util.List;

import dominio.Foto;

public interface FotoDao {
	
	public void inserirAtualizar(Foto u);
	public void excluir(Foto u);
	public Foto buscar(int codigo);
	public List<Foto> buscarTodos();

}
