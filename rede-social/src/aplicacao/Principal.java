package aplicacao;

import java.util.Date;
import java.util.Scanner;
import dominio.*;
import servico.*;
import servico.impl.*;

public class Principal {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int op;
		Integer idusuario = null;
		Integer idalbum = null;
		Integer idpost = null;
		Integer idremetente = null;
		Integer iddestinatario = null;
		Integer idseguido = null;
		Integer idseguidor = null;
		String nomeusuario = null;
		String emailusuario = null;
		String nomealbum = null;
		String legenda = null;
		String conteudo = null;
		AlbumServico albumServico = null;
		AmizadeServico amizadeServico = null;
		ComentarioServico comentarioServico = null;
		CurtidaServico curtidaServico = null;
		FotoServico fotoServico = null;
		MensagemServico mensagemServico = null;
		PostServico postServico = null;
		UsuarioServico usuarioServico = null;
		
		System.out.println("Bem vindo � nossa Rede Social!\n");

		do {
			System.out.print("1 - Cadastrar Usu�rio\n" + "2 - Cadastrar novo �lbum\n" + "3 - Cadastrar nova foto\n"
					+ "4 - Fazer uma postagem\n" + "5 - Comentar uma postagem\n"
					+ "6 - Enviar mensagem � outro usu�rio\n" + "7 - Seguir/Deixar de seguir um usu�rio\n"
					+ "8 - Curtir/descurtir uma postagem\n" + "0 - Sair\n\n" + "Digite uma op��o: ");

			op = Integer.parseInt(s.nextLine());
			System.out.println();

			switch (op) {
			
			case 0:
				System.out.println("Sistema encerrado.");
				break;
				
			case 1:
				
				System.out.print("Digite as informa��es do usu�rio:\n" + "Nome: ");
				nomeusuario = s.nextLine();
				System.out.print("Email: ");
				emailusuario = s.nextLine();
				Usuario usuario = new Usuario(null, nomeusuario, null, "", emailusuario, "", "", "");
				usuarioServico = new UsuarioServicoImpl();
				usuarioServico.inserirAtualizar(usuario);
				System.out.println("Usu�rio inserido com sucesso. ID do usu�rio: " + usuario.getIdUsuario());

				break;

			case 2:
				
				System.out.print("Digite o ID do usu�rio que ser� dono desse �lbum: ");
				idusuario = Integer.parseInt(s.nextLine());
				if (idusuario == 0) {
					System.out.println("Usu�rio inexistente.");
					break;
				}
				usuario = usuarioServico.buscar(idusuario);
				System.out.print("Digite o nome do �lbum:");
				nomealbum = s.nextLine();
				Album album = new Album(null, nomealbum, new Date(), usuario);
				albumServico = new AlbumServicoImpl();
				try {
					albumServico.inserirAlbum(album);
				} catch (ServicoException e) {
					System.out.println("Ocorreu um erro ao tentar inserir �lbum. Erro: " + e.getMessage());
				}
				break;

			case 3:
				System.out.print("Digite as informa��es da nova foto:\n" + "ID do usu�rio: ");
				idusuario = Integer.parseInt(s.nextLine());
				if (idusuario == 0) {
					System.out.println("Usu�rio inexistente.");
					break;
				}
				usuario = usuarioServico.buscar(idusuario);
				System.out.println("�lbuns deste usu�rio: ");
				for (Album x : usuario.getAlbuns()) {
					System.out.println("ID: " + x.getIdAlbum() + "Nome: " + x.getNomeAlbum());
				}
				System.out.print("\nDigite o ID do �lbum que a foto ser� inserida: ");
				idalbum = Integer.parseInt(s.nextLine());
				albumServico = new AlbumServicoImpl();
				album = albumServico.buscar(idalbum);
				System.out.print("\nDigite a legenda da foto: ");
				legenda = s.nextLine();
				fotoServico = new FotoServicoImpl();
				Foto foto = new Foto(null, legenda, new Date(), album);
				fotoServico.inserirAtualizar(foto);
				System.out.println("Foto inserida com sucesso. ID da foto: " + foto.getIdFoto());
				break;
				
			case 4:
				System.out.print("Digite o ID do usu�rio que far� o post (0 para sair): ");
				idusuario = Integer.parseInt(s.nextLine());
				if (idusuario == 0) {
					System.out.println();
					break;
				}
				usuario = usuarioServico.buscar(idusuario);

				System.out.println("Digite o conte�do do post: ");
				conteudo = s.nextLine();
				Post post = new Post(null, conteudo, new Date(), usuario);
				postServico = new PostServicoImpl();
				postServico.inserirAtualizar(post);
				System.out.println("Post inserido com sucesso. ID do post: " + post.getIdPost());
				break;

			case 5:
				System.out.print("Digite o ID do usu�rio que far� o coment�rio (0 para sair): ");
				idusuario = Integer.parseInt(s.nextLine());
				if (idusuario == 0) {
					System.out.println();
					break;
				}
				usuario = usuarioServico.buscar(idusuario);
				
				System.out.print("Digite o ID do post que receber� o coment�rio: ");
				idpost = Integer.parseInt(s.nextLine());
				post = postServico.buscar(idpost);
				
				System.out.println("Digite o conte�do do coment�rio: ");
				conteudo = s.nextLine();
				Comentario comentario = new Comentario(null, conteudo, new Date(), usuario, post);
				comentarioServico = new ComentarioServicoImpl();
				comentarioServico.inserirAtualizar(comentario);
				System.out.println("Coment�rio inserido com sucesso. ID do coment�rio: " + comentario.getIdComentario());
				break;
				
			case 6:
				System.out.print("Digite o ID do usu�rio remetente: ");
				idremetente = Integer.parseInt(s.nextLine());
				if (idremetente == 0) {
					System.out.println("Usu�rio inexistente.");
					break;
				}
				Usuario remetente = usuarioServico.buscar(idremetente);

				System.out.print("Digite o ID do usu�rio destinat�rio: ");
				iddestinatario = Integer.parseInt(s.nextLine());
				
				if (iddestinatario == 0) {
					System.out.println("Usu�rio inexistente.");
					break;
				}
				Usuario destinatario = usuarioServico.buscar(iddestinatario);
				
				System.out.println("Digite a mensagem: ");
				String msg = s.nextLine();
				
				Mensagem mensagem = new Mensagem(null, msg, new Date(), remetente, destinatario);
				mensagemServico = new MensagemServicoImpl();
				mensagemServico.inserirAtualizar(mensagem);
				System.out.println("Mensagem enviada com sucesso. ID da conversa: " + mensagem.getIdConversa());
				break;

			case 7:
				System.out.print("Digite o ID do usu�rio a ser seguido: ");
				idseguido = Integer.parseInt(s.nextLine());

				if (idseguido == 0) {
					System.out.println("Usu�rio inexistente.");
					break;
				}
				
				Usuario seguido = usuarioServico.buscar(idseguido);

				System.out.print("Digite o ID do usu�rio seguidor: ");
				idseguidor = Integer.parseInt(s.nextLine());
				
				if (idseguidor == 0) {
					System.out.println("Usu�rio inexistente.");
				}
				
				Usuario seguidor = usuarioServico.buscar(idseguidor);
				
				Amizade amizade = new Amizade(null, new Date(), seguido, seguidor);
				
				amizadeServico = new AmizadeServicoImpl();
				
				if (amizadeServico.inserirAtualizar(amizade)) {
					System.out.println(seguido.getNome() + " est� seguindo " + seguidor.getNome() + ". ");
				} else {
					System.out.println("Amizade desfeita.");
				}
				break;

			case 8:
				
				System.out.print("Digite o ID do usu�rio que ir� curtir o post: ");
				idusuario = Integer.parseInt(s.nextLine());
				if (idusuario == 0) {
					System.out.println("Usu�rio inexistente.");
					break;
				}
				usuario = usuarioServico.buscar(idusuario);

				System.out.print("Digite o ID do post que ser� curtido: ");
				idpost = Integer.parseInt(s.nextLine());

				if (idpost == 0) {
					System.out.println("Post inexistente.");
					break;
				}
				post = postServico.buscar(idpost);
				
				Curtida curtida = new Curtida(null, new Date(), usuario, post);
				
				curtidaServico = new CurtidaServicoImpl();
				
				if (curtidaServico.inserirAtualizar(curtida)) {
					System.out.println("Post curtido com sucesso.");
				} else {
					System.out.println("Post descurtido.");
				}
				
				break;

			default:
				System.out.println("\nOp��o inv�lida. Tente novamente.\n");
			}

		} while (op != 0);

		s.close();
	}

}
