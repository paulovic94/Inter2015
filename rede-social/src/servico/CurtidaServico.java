package servico;

import java.util.List;

import dominio.Curtida;

public interface CurtidaServico {

	public boolean inserirAtualizar(Curtida u);
	public void excluir(Curtida u);
	public Curtida buscar(int codigo);
	public List<Curtida> buscarTodos();
}
