package servico;

import java.util.List;

import dominio.Foto;

public interface FotoServico {

	public void inserirAtualizar(Foto u);
	public void excluir(Foto u);
	public Foto buscar(int codigo);
	public List<Foto> buscarTodos();
}
