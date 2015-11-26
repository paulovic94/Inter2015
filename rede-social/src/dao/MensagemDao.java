package dao;

import java.util.List;
import dominio.Mensagem;

public interface MensagemDao {
	
	public void inserirAtualizar(Mensagem u);
	public void excluir(Mensagem u);
	public Mensagem buscar(int codigo);
	public List<Mensagem> buscarTodos();

}
