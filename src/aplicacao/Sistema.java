package aplicacao;

import java.io.IOException;
import java.util.Scanner;

import dao.LivroDao;
import entitys.Item;
import dao.DVDDao;


public class Sistema {

		public static void Inicializacao(){
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Bem-vindo(a) ao sistema da Biblioteca!");
			System.out.println("Você deseja: 1-Consultar, 2-Reservar, 3-Devolver, 4-Sair?");
			
			int opcao= sc.nextInt();
			
			filtarOpcao(opcao);
		}
		
		public static void filtarOpcao(int opcao) {
			
			Scanner sc = new Scanner(System.in);
			Item item = new Item();
			LivroDao lDAO = new LivroDao();
			DVDDao dDAO = new DVDDao();
			
			switch(opcao) {
			case 1:
				GerenciaItem.Consultar();
				break;
			case 2:
				System.out.println("Deseja Reservar 1-Livro, ou 2-DVD?");
				int resposta1= sc.nextInt();
				
				System.out.println("Insira o ID do Item que vocẽ deseja reservar: ");
				String id = sc.nextLine();
				
				switch(resposta1) {
				case 1:
					item = lDAO.findByID(id);
					break;
				case 2:
					item = dDAO.findByID(id);
					break;
				}
				
				try {
				GerenciaItem.Reservar(item);
				} catch (Exception e){
					
					System.out.println("Reserva mal sucedida!");
					System.out.println("Deseja: 1-Consultar, 2-Reservar, 3-Devolver outro livro, ou 4-Sair");
					int opcao2= sc.nextInt();
					sc.close();
					filtarOpcao(opcao2);
				}
				break;
			case 3:
				System.out.println("Deseja Devolver um 1-Livro, ou 2-DVD?");
				int resposta2= sc.nextInt();
				
				System.out.println("Insira o ID do Item que você deseja devolver: ");
				String id2 = sc.nextLine();
				
				switch(resposta2) {
				case 1:
					item = lDAO.findByID(id2);
					break;
				case 2:
					item = dDAO.findByID(id2);
					break;
				}
				GerenciaItem.Devolver(item);
				break;
			case 4:
				System.out.println("Agradecemos a preferência! Tenha um bom dia!");
				sc.close();
				return;
			default: 
				System.out.println("Opção Inválida! Por favor, insira uma opção válida: ");
				filtarOpcao(sc.nextInt());
				break;
			}
		}

}
