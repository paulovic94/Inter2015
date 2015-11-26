package servico;

import java.util.List;

import dominio.Amizade;

public interface AmizadeServico {

	public boolean inserirAtualizar(Amizade u);
	public void excluir(Amizade u);
	public Amizade buscar(int codigo);
	public List<Amizade> buscarTodos();
}
