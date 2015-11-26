package dao;

import java.util.List;

import dominio.Post;

public interface PostDao {
	
	public void inserirAtualizar(Post u);
	public void excluir(Post u);
	public Post buscar(int codigo);
	public List<Post> buscarTodos();

}
