package servico;

import servico.impl.*;

public class ServicoFactory {

//	public static Conexao criarConexao() {
//		return new ConexaoImpl();
//	}
	
	public static AlbumServico criarAlbumServico(/*Conexao c*/) {
		return new AlbumServicoImpl(/*c*/);
	}
	
	public static AmizadeServico criarAmizadeServico(/*Conexao c*/) {
		return new AmizadeServicoImpl(/*c*/);
	}
	
	public static ComentarioServico criarComentarioServico(/*Conexao c*/) {
		return new ComentarioServicoImpl(/*c*/);
	}
	
	public static CurtidaServico criarCurtidaServico(/*Conexao c*/) {
		return new CurtidaServicoImpl(/*c*/);
	}
	
	public static FotoServico criarFotoServico(/*Conexao c*/) {
		return new FotoServicoImpl(/*c*/);
	}
	
	public static MensagemServico criarMensagemServico(/*Conexao c*/) {
		return new MensagemServicoImpl(/*c*/);
	}
	
	public static PostServico criarPostServico(/*Conexao c*/) {
		return new PostServicoImpl(/*c*/);
	}
	
	public static UsuarioServico criarUsuarioServico(/*Conexao c*/) {
		return new UsuarioServicoImpl(/*c*/);
	}
}
