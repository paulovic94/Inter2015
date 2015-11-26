package aplicacao;

import java.util.Date;

import dominio.Album;
import dominio.Amizade;
import dominio.Comentario;
import dominio.Foto;
import dominio.Mensagem;
import dominio.Post;
import dominio.Usuario;
import servico.AlbumServico;
import servico.AmizadeServico;
import servico.ComentarioServico;
import servico.CurtidaServico;
import servico.FotoServico;
import servico.MensagemServico;
import servico.PostServico;
import servico.ServicoException;
import servico.UsuarioServico;

public class Instancias {
	
	public static void main(String[] args) throws ServicoException {
		AlbumServico albumServico = null;
		AmizadeServico amizadeServico = null;
		ComentarioServico comentarioServico = null;
		CurtidaServico curtidaServico = null;
		FotoServico fotoServico = null;
		MensagemServico mensagemServico = null;
		PostServico postServico = null;
		UsuarioServico usuarioServico = null;
		
		Usuario u1 = new Usuario(1, "Nome 1", null, "login1", "email@email.com", "senha123", "Uberlândia, MG", "07/10/1996");
		Usuario u2 = new Usuario(2, "Nome 2", null, "login2", "email@email.com", "senha123", "Uberlândia, MG", "07/10/1996");
		Usuario u3 = new Usuario(3, "Nome 3", null, "login3", "email@email.com", "senha123", "Uberlândia, MG", "07/10/1996");
		Usuario u4 = new Usuario(4, "Nome 4", null, "login4", "email@email.com", "senha123", "Uberlândia, MG", "07/10/1996");
		Usuario u5 = new Usuario(5, "Nome 5", null, "login5", "email@email.com", "senha123", "Uberlândia, MG", "07/10/1996");
		
		Album ab1 = new Album(1, "Album 1 Nome 1", new Date(), u1);
		Album ab2 = new Album(2, "Album 1 Nome 2", new Date(), u2);
		Album ab3 = new Album(3, "Album 1 Nome 3", new Date(), u3);
		Album ab4 = new Album(4, "Album 1 Nome 4", new Date(), u4);
		Album ab5 = new Album(5, "Album 1 Nome 5", new Date(), u5);
		
		Foto f1 = new Foto(1, "Legenda Foto 1", new Date(), ab1);
		Foto f2 = new Foto(2, "Legenda Foto 2", new Date(), ab2);
		Foto f3 = new Foto(3, "Legenda Foto 3", new Date(), ab3);
		Foto f4 = new Foto(4, "Legenda Foto 4", new Date(), ab4);
		Foto f5 = new Foto(5, "Legenda Foto 5", new Date(), ab5);
		
		Post p1 = new Post(1, "Post 1 Nome 1", new Date(), u1);
		Post p2 = new Post(2, "Post 1 Nome 2", new Date(), u2);
		Post p3 = new Post(3, "Post 1 Nome 3", new Date(), u3);
		Post p4 = new Post(4, "Post 1 Nome 4", new Date(), u4);
		Post p5 = new Post(5, "Post 1 Nome 5", new Date(), u5);
		
		Comentario c1 = new Comentario(1, "Comentario 1 Nome 1 Post 1", new Date(), u1, p1);
		Comentario c2 = new Comentario(2, "Comentario 1 Nome 2 Post 1", new Date(), u2, p2);
		Comentario c3 = new Comentario(3, "Comentario 1 Nome 3 Post 1", new Date(), u3, p3);
		Comentario c4 = new Comentario(4, "Comentario 1 Nome 4 Post 1", new Date(), u4, p4);
		Comentario c5 = new Comentario(5, "Comentario 1 Nome 5 Post 1", new Date(), u5, p5);
		
		Amizade az1 = new Amizade(1, new Date(), u1, u2);
		Amizade az2 = new Amizade(2, new Date(), u2, u3);
		Amizade az3 = new Amizade(3, new Date(), u3, u4);
		Amizade az4 = new Amizade(4, new Date(), u4, u5);
		Amizade az5 = new Amizade(5, new Date(), u5, u1);
		
		Mensagem m1 = new Mensagem(1, "Conversa Nome 1 Nome 2", new Date(), u1, u2);
		Mensagem m2 = new Mensagem(2, "Conversa Nome 2 Nome 3", new Date(), u2, u3);
		Mensagem m3 = new Mensagem(3, "Conversa Nome 3 Nome 4", new Date(), u3, u4);
		Mensagem m4 = new Mensagem(4, "Conversa Nome 4 Nome 5", new Date(), u4, u5);
		Mensagem m5 = new Mensagem(5, "Conversa Nome 5 Nome 1", new Date(), u5, u1);
		
		usuarioServico.inserirAtualizar(u1);
		usuarioServico.inserirAtualizar(u2);
		usuarioServico.inserirAtualizar(u3);
		usuarioServico.inserirAtualizar(u4);
		usuarioServico.inserirAtualizar(u5);
		
		albumServico.inserirAlbum(ab1);
		albumServico.inserirAlbum(ab2);
		albumServico.inserirAlbum(ab3);
		albumServico.inserirAlbum(ab4);
		albumServico.inserirAlbum(ab5);
		
		fotoServico.inserirAtualizar(f1);
		fotoServico.inserirAtualizar(f2);
		fotoServico.inserirAtualizar(f3);
		fotoServico.inserirAtualizar(f4);
		fotoServico.inserirAtualizar(f5);
		
		postServico.inserirAtualizar(p1);
		postServico.inserirAtualizar(p2);
		postServico.inserirAtualizar(p3);
		postServico.inserirAtualizar(p4);
		postServico.inserirAtualizar(p5);
		
		comentarioServico.inserirAtualizar(c1);
		comentarioServico.inserirAtualizar(c2);
		comentarioServico.inserirAtualizar(c3);
		comentarioServico.inserirAtualizar(c4);
		comentarioServico.inserirAtualizar(c5);
		
		amizadeServico.inserirAtualizar(az1);
		amizadeServico.inserirAtualizar(az2);
		amizadeServico.inserirAtualizar(az3);
		amizadeServico.inserirAtualizar(az4);
		amizadeServico.inserirAtualizar(az5);
		
		mensagemServico.inserirAtualizar(m1);
		mensagemServico.inserirAtualizar(m2);
		mensagemServico.inserirAtualizar(m3);
		mensagemServico.inserirAtualizar(m4);
		mensagemServico.inserirAtualizar(m5);
	}

}
