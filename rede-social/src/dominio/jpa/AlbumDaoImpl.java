package dominio.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.AlbumDao;
//import dao.Conexao;
import dominio.Album;

public class AlbumDaoImpl implements AlbumDao {
	
	private EntityManager em;
	
	public AlbumDaoImpl(/*Conexao con*/) {
		//ConexaoImpl aux = (ConexaoImpl) con;
		this.em = EM.getLocalEm();
	}

	@Override
	public void inserirAtualizar(Album u) {
		if (u.getIdAlbum() != null) {
			u = em.merge(u);
		}
		em.persist(u);

	}

	@Override
	public void excluir(Album u) {
		u = em.merge(u);
		em.remove(u);

	}

	@Override
	public Album buscar(int codigo) {
		return em.find(Album.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Album> buscarTodos() {
		String jpql = "SELECT a FROM Album a";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

}
