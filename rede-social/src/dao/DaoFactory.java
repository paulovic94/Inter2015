package dao;

import dominio.jpa.AlbumDaoImpl;
import dominio.jpa.AmizadeDaoImpl;
import dominio.jpa.ComentarioDaoImpl;
//import dominio.jpa.ConexaoImpl;
import dominio.jpa.CurtidaDaoImpl;
import dominio.jpa.FotoDaoImpl;
import dominio.jpa.MensagemDaoImpl;
import dominio.jpa.PostDaoImpl;
import dominio.jpa.UsuarioDaoImpl;

public class DaoFactory {

//	public static Conexao criarConexao() {
//		return new ConexaoImpl();
//	}
	
	public static AlbumDao criarAlbumDao(/*Conexao c*/) {
		return new AlbumDaoImpl(/*c*/);
	}
	
	public static AmizadeDao criarAmizadeDao(/*Conexao c*/) {
		return new AmizadeDaoImpl(/*c*/);
	}
	
	public static ComentarioDao criarComentarioDao(/*Conexao c*/) {
		return new ComentarioDaoImpl(/*c*/);
	}
	
	public static CurtidaDao criarCurtidaDao(/*Conexao c*/) {
		return new CurtidaDaoImpl(/*c*/);
	}
	
	public static FotoDao criarFotoDao(/*Conexao c*/) {
		return new FotoDaoImpl(/*c*/);
	}
	
	public static MensagemDao criarMensagemDao(/*Conexao c*/) {
		return new MensagemDaoImpl(/*c*/);
	}
	
	public static PostDao criarPostDao(/*Conexao c*/) {
		return new PostDaoImpl(/*c*/);
	}
	
	public static UsuarioDao criarUsuarioDao(/*Conexao c*/) {
		return new UsuarioDaoImpl(/*c*/);
	}
}
