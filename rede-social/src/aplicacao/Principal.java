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
		
		System.out.println("Bem vindo à nossa Rede Social!\n");

		do {
			System.out.print("1 - Cadastrar Usuário\n" + "2 - Cadastrar novo álbum\n" + "3 - Cadastrar nova foto\n"
					+ "4 - Fazer uma postagem\n" + "5 - Comentar uma postagem\n"
					+ "6 - Enviar mensagem à outro usuário\n" + "7 - Seguir/Deixar de seguir um usuário\n"
					+ "8 - Curtir/descurtir uma postagem\n" + "0 - Sair\n\n" + "Digite uma opção: ");

			op = Integer.parseInt(s.nextLine());
			System.out.println();

			switch (op) {
			
			case 0:
				System.out.println("Sistema encerrado.");
				break;
				
			case 1:
				
				System.out.print("Digite as informações do usuário:\n" + "Nome: ");
				nomeusuario = s.nextLine();
				System.out.print("Email: ");
				emailusuario = s.nextLine();
				Usuario usuario = new Usuario(null, nomeusuario, null, "", emailusuario, "", "", "");
				usuarioServico = new UsuarioServicoImpl();
				usuarioServico.inserirAtualizar(usuario);
				System.out.println("Usuário inserido com sucesso. ID do usuário: " + usuario.getIdUsuario());

				break;

			case 2:
				
				System.out.print("Digite o ID do usuário que será dono desse álbum: ");
				idusuario = Integer.parseInt(s.nextLine());
				if (idusuario == 0) {
					System.out.println("Usuário inexistente.");
					break;
				}
				usuario = usuarioServico.buscar(idusuario);
				System.out.print("Digite o nome do álbum:");
				nomealbum = s.nextLine();
				Album album = new Album(null, nomealbum, new Date(), usuario);
				albumServico = new AlbumServicoImpl();
				try {
					albumServico.inserirAlbum(album);
				} catch (ServicoException e) {
					System.out.println("Ocorreu um erro ao tentar inserir álbum. Erro: " + e.getMessage());
				}
				break;

			case 3:
				System.out.print("Digite as informações da nova foto:\n" + "ID do usuário: ");
				idusuario = Integer.parseInt(s.nextLine());
				if (idusuario == 0) {
					System.out.println("Usuário inexistente.");
					break;
				}
				usuario = usuarioServico.buscar(idusuario);
				System.out.println("Álbuns deste usuário: ");
				for (Album x : usuario.getAlbuns()) {
					System.out.println("ID: " + x.getIdAlbum() + "Nome: " + x.getNomeAlbum());
				}
				System.out.print("\nDigite o ID do álbum que a foto será inserida: ");
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
				System.out.print("Digite o ID do usuário que fará o post (0 para sair): ");
				idusuario = Integer.parseInt(s.nextLine());
				if (idusuario == 0) {
					System.out.println();
					break;
				}
				usuario = usuarioServico.buscar(idusuario);

				System.out.println("Digite o conteúdo do post: ");
				conteudo = s.nextLine();
				Post post = new Post(null, conteudo, new Date(), usuario);
				postServico = new PostServicoImpl();
				postServico.inserirAtualizar(post);
				System.out.println("Post inserido com sucesso. ID do post: " + post.getIdPost());
				break;

			case 5:
				System.out.print("Digite o ID do usuário que fará o comentário (0 para sair): ");
				idusuario = Integer.parseInt(s.nextLine());
				if (idusuario == 0) {
					System.out.println();
					break;
				}
				usuario = usuarioServico.buscar(idusuario);
				
				System.out.print("Digite o ID do post que receberá o comentário: ");
				idpost = Integer.parseInt(s.nextLine());
				post = postServico.buscar(idpost);
				
				System.out.println("Digite o conteúdo do comentário: ");
				conteudo = s.nextLine();
				Comentario comentario = new Comentario(null, conteudo, new Date(), usuario, post);
				comentarioServico = new ComentarioServicoImpl();
				comentarioServico.inserirAtualizar(comentario);
				System.out.println("Comentário inserido com sucesso. ID do comentário: " + comentario.getIdComentario());
				break;
				
			case 6:
				System.out.print("Digite o ID do usuário remetente: ");
				idremetente = Integer.parseInt(s.nextLine());
				if (idremetente == 0) {
					System.out.println("Usuário inexistente.");
					break;
				}
				Usuario remetente = usuarioServico.buscar(idremetente);

				System.out.print("Digite o ID do usuário destinatário: ");
				iddestinatario = Integer.parseInt(s.nextLine());
				
				if (iddestinatario == 0) {
					System.out.println("Usuário inexistente.");
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
				System.out.print("Digite o ID do usuário a ser seguido: ");
				idseguido = Integer.parseInt(s.nextLine());

				if (idseguido == 0) {
					System.out.println("Usuário inexistente.");
					break;
				}
				
				Usuario seguido = usuarioServico.buscar(idseguido);

				System.out.print("Digite o ID do usuário seguidor: ");
				idseguidor = Integer.parseInt(s.nextLine());
				
				if (idseguidor == 0) {
					System.out.println("Usuário inexistente.");
				}
				
				Usuario seguidor = usuarioServico.buscar(idseguidor);
				
				Amizade amizade = new Amizade(null, new Date(), seguido, seguidor);
				
				amizadeServico = new AmizadeServicoImpl();
				
				if (amizadeServico.inserirAtualizar(amizade)) {
					System.out.println(seguido.getNome() + " está seguindo " + seguidor.getNome() + ". ");
				} else {
					System.out.println("Amizade desfeita.");
				}
				break;

			case 8:
				
				System.out.print("Digite o ID do usuário que irá curtir o post: ");
				idusuario = Integer.parseInt(s.nextLine());
				if (idusuario == 0) {
					System.out.println("Usuário inexistente.");
					break;
				}
				usuario = usuarioServico.buscar(idusuario);

				System.out.print("Digite o ID do post que será curtido: ");
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
				System.out.println("\nOpção inválida. Tente novamente.\n");
			}

		} while (op != 0);

		s.close();
	}

}
