package servico;

import java.util.List;

import dominio.Mensagem;

public interface MensagemServico {

	public void inserirAtualizar(Mensagem u);
	public void excluir(Mensagem u);
	public Mensagem buscar(int codigo);
	public List<Mensagem> buscarTodos();
}
