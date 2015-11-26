package dominio.jpa;

import javax.persistence.EntityManager;

//import dao.Conexao;

public class ConexaoImpl_old /*implements Conexao*/ {
	
	//Extra
	public EntityManager getEm() {
		return EM.getLocalEm();
	}

	//@Override
	public void fecharConexao() {
		EM.closeLocalEm();

	}

	//@Override
	public void iniciarTransacao() {
		EM.getLocalEm().getTransaction().begin();

	}

	//@Override
	public void commit() {
		EM.getLocalEm().getTransaction().commit();

	}

	//@Override
	public void rollback() {
		EM.getLocalEm().getTransaction().rollback();

	}

	//@Override
	public boolean transacaoAtiva() {
		return EM.getLocalEm().getTransaction().isActive();
	}

}
