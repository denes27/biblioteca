package Aplicação;

import java.util.Scanner;

public class Item {

	private String _nome, _genero;
	private int _id, _numExemplares;
	private static int _exemplaresDisponiveis;
	
	public static void Consultar() {
		 
		filtrarOpcoesDeConsulta();
	}
	
	private static void filtrarOpcoesDeConsulta() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Deseja buscar por qual tipo de item?");
		System.out.println("1- procurar por Livro;");
		System.out.println("2- procurar por DVD;");
		int item=sc.nextInt();
		
		switch(item){
		case 1:
			filtrarOpcoesConsultaLivro();
			break;
		case 2:
			filtrarOpcoesConsultaDVD();
			break;
		}
		sc.close();
	}
	
	private static void filtrarOpcoesConsultaLivro() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Selecione o filtro com que deseja fazer a busca: ");
		System.out.println("1- procurar por nome;");
		System.out.println("2- procurar por gênero;");
		System.out.println("3- procurar por Número de Identificação;");
		System.out.println("4- procurar pelo nome do autor;");
		System.out.println("5- procurar pelo nome da editora;");
				
		int filtro = sc.nextInt();

		switch(filtro){
			case 1:
				System.out.println("Insira o título do livro pelo qual deseja buscar: ");
				String titulo = sc.nextLine();
				//PostgreDAO.consulta("Livro", "Título", titulo);
				break;
			case 2:
				System.out.println("Insira o genero do livro pelo qual deseja buscar: ");
				String genero = sc.nextLine();
				//PostgreDAO.consulta("Livro", "Gênero", genero);
				break;
			case 3:
				System.out.println("Insira o ID do livro pelo qual deseja buscar: ");
				String id = sc.nextLine();
				//PostgreDAO.consulta("Livro", "ID", id);
				break;
			case 4:
				System.out.println("Insira o nome do autor do livro pelo qual deseja buscar: ");
				String autor = sc.nextLine();
				//PostgreDAO.consulta("Livro", "Nome do Autor", autor);
				break;
			case 5:
				System.out.println("Insira o nome da editora do livro pelo qual deseja buscar: ");
				String editora = sc.nextLine();
				//PostgreDAO.consulta("Livro", "Nome da Editora", editora);
				break;
			default: 
				System.out.println("Por favor, insira uma uma opção válida");
				filtrarOpcoesConsultaLivro();
		}
	
	}
	
	public static void filtrarOpcoesConsultaDVD() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Selecione o filtro com que deseja fazer a busca: ");
		System.out.println("1- procurar por nome;");
		System.out.println("2- procurar por gênero;");
		System.out.println("3- procurar por Número de Identificação;");
		System.out.println("4- procurar pelo ano;");
		System.out.println("5- procurar pelo tipo (filme ou música);");
		System.out.println("6- procurar pelo nome do diretor;");
		
		int filtro = sc.nextInt();
		
		switch(filtro){
			case 1:
				System.out.println("Insira o título do DVD pelo qual deseja buscar: ");
				String titulo = sc.nextLine();
				//PostgreDAO.consulta("DVD", "Titulo", titulo);
				break;
			case 2:
				System.out.println("Insira o genero do DVD pelo qual deseja buscar: ");
				String genero = sc.nextLine();
				//PostgreDAO.consulta("DVD", "Gênero", genero);
				break;
			case 3:
				System.out.println("Insira o ID do DVD pelo qual deseja buscar: ");
				String id = sc.nextLine();
				//PostgreDAO.consulta("DVD", "ID", id);
				break;
			case 4:
				System.out.println("Insira o ano do DVD pelo qual deseja buscar: ");
				String ano = sc.nextLine();
				//PostgreDAO.consulta("DVD", "Ano", ano);
				break;
			case 5:
				System.out.println("Insira o tipo do DVD pelo qual deseja buscar(filme ou música): ");
				String tipo = sc.nextLine();
				//PostgreDAO.consulta("DVD", "Tipo", tipo);
				break;

			case 6:
				System.out.println("Insira o nome do diretor do DVD pelo qual deseja buscar: ");
				String diretor = sc.nextLine();
				//PostgreDAO.consulta("DVD", "Nome do Diretor", diretor);
				break;
			default: 
				System.out.println("Por favor, insira uma uma opção válida");
				filtrarOpcoesConsultaDVD();
		}
		sc.close();
	}
	
	
	public static void Reservar(Item e) throws Exception {
		if (e._exemplaresDisponiveis > 0) {
			_exemplaresDisponiveis--;
			System.out.println("O item está reservado! Deseja consultar ou reservar outro item? S/N");
			Scanner sc = new Scanner(System.in);
			String resposta= sc.nextLine();
			sc.close();
			if(resposta=="S"){
				Consultar();
				return;
			}
			if (resposta=="N") {
					System.out.println("Dirija-se ao balcão para validar e retirar o item.");
			}
		} else throw new indisponibilidadeException("O item não tem exemplares disponíveis.");
		
	}
	
	public static void Devolver() {	}
}