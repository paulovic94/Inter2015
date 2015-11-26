package servico.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import dao.DaoFactory;
import dao.MensagemDao;
import dominio.Mensagem;
import dominio.jpa.EM;
import servico.MensagemServico;
//import servico.ServicoException;

public class MensagemServicoImpl implements MensagemServico {
	
	private MensagemDao dao;
	
	public MensagemServicoImpl() {
		dao = DaoFactory.criarMensagemDao();
	}

	@Override
	public void inserirAtualizar(Mensagem mensagem) {
		EM.getLocalEm().getTransaction().begin();
		
		TypedQuery<Mensagem> query = EM.getLocalEm().createQuery(
				"SELECT msg FROM Mensagem msg WHERE remetente = :idrem AND destinatario = :iddest",
				Mensagem.class);
		query.setParameter("idrem", mensagem.getEnviadas().getIdUsuario());
		query.setParameter("iddest", mensagem.getRecebidas().getIdUsuario());
		ArrayList<Mensagem> msgdb = (ArrayList<Mensagem>) query.getResultList();
		if (msgdb.isEmpty()) {
			Mensagem novamensagem = new Mensagem(null, mensagem.getConversa(), mensagem.getData(), mensagem.getEnviadas(), mensagem.getRecebidas());
			dao.inserirAtualizar(novamensagem);
			//EM.getLocalEm().persist(novamensagem);
		
		} else {
			String conversadb = msgdb.get(0).getConversa();
			conversadb += ";" + mensagem.getConversa();
			msgdb.get(0).setConversa(conversadb);
			dao.inserirAtualizar(msgdb.get(0));
			//EM.getLocalEm().merge(msgdb.get(0));
		}
		EM.getLocalEm().getTransaction().commit();

	}

	@Override
	public void excluir(Mensagem u) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(u);
		EM.getLocalEm().getTransaction().commit();

	}

	@Override
	public Mensagem buscar(int codigo) {
		return dao.buscar(codigo);	
	}

	@Override
	public List<Mensagem> buscarTodos() {
		return dao.buscarTodos();
	}

}
