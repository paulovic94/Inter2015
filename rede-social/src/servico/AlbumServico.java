package servico;

import java.util.List;

import dominio.Album;

public interface AlbumServico {

	public void inserirAlbum(Album u) throws ServicoException;
	public void excluir(Album u);
	public Album buscar(int codigo);
	public List<Album> buscarTodos();
}
