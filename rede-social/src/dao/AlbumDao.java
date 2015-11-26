package dao;

import java.util.List;

import dominio.Album;

public interface AlbumDao {
	
	public void inserirAtualizar(Album u);
	public void excluir(Album u);
	public Album buscar(int codigo);
	public List<Album> buscarTodos();

}
