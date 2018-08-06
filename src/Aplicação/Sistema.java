package Aplicação;

import java.io.IOException;
import java.util.Scanner;

public class Sistema {

		public static void Inicializacao(){
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Bem-vindo(a) ao sistema da Biblioteca!");
			System.out.println("Você deseja: 1-Consultar, 2-Reservar, 3-Devolver, 4-Sair?");
			//System.out.println("Fazer login como 'Usuário'(1) ou 'Funcionário'(2)?");
			int opcao= sc.nextInt();
			
			filtarOpcao(opcao);
		}
		
		public static void filtarOpcao(int opcao) {
			
			Item item = new Item();
			
			switch(opcao) {
			case 1:
				Item.Consultar();
				break;
			case 2:
				try {
				Item.Reservar(item);
				} catch (Exception e){
					Scanner sc = new Scanner(System.in);
					System.out.println("Reserva mal sucedida!");
					System.out.println("Deseja: 1-Consultar, 2-Reservar, 3-Devolver outro livro, ou 4-Sair");
					int opcao2= sc.nextInt();
					sc.close();
					filtarOpcao(opcao2);
				}
				break;
			case 3:
				Item.Devolver(item);
				break;
			case 4:
				System.out.println("Agradecemos a preferência! Tenha um bom dia!");
				return;
			default: 
				System.out.println("Opção Inválida! Por favor, insira uma opção válida: ");
				Scanner sc = new Scanner(System.in);
				filtarOpcao(sc.nextInt());
				break;
			}
		}

		private void opcoesFuncionário() { }

		private void opcoesUsuario() {
			System.out.println("Usuário já possui cadastro? S/N");
			Scanner sc = new Scanner(System.in);
			String resposta= sc.nextLine();
			if(resposta=="S"){
				Usuario usuario = new Usuario();
				//try{
				System.out.println("Insira Usuário:");
				String login=sc.nextLine();
				System.out.println("Insira a Senha:");
				String senha=sc.nextLine();
				//Usuario.validacao(login, senha);
				//} catch(IOException e) {
					//System.out.println("Usuário inexistente ou inválido!");
					//opcoesUsuario();
				//}
				
			}
			if (resposta=="N") {
					System.out.println("É necessário cadastrar-se para realizar Reservas.");
					//Usuario.casdastrar();					
			}
			sc.close();
			
		}
}
