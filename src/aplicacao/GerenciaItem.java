package aplicacao;

import java.util.Scanner;

import dao.LivroDao;
import dao.DVDDao;
import entitys.Item;
import entitys.DVD;
import entitys.Livro;

public class GerenciaItem {

	public static void Consultar() {
		filtrarOpcoesDeConsulta();
		return;
	}
	
	private static void filtrarOpcoesDeConsulta() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Deseja buscar por qual tipo de item?");
		System.out.println("1- procurar por Livro;");
		System.out.println("2- procurar por DVD;");
		int tipoItem = sc.nextInt();
		
		switch(tipoItem){
		case 1:
			filtrarOpcoesConsultaLivro();
			break;
		case 2:
			filtrarOpcoesConsultaDVD();
			break;
		}
		return;
	}
	
	private static void filtrarOpcoesConsultaLivro() {
		
		Scanner sc = new Scanner(System.in);
		LivroDao lDAO = new LivroDao();
		
		System.out.println("Selecione o filtro com que deseja fazer a busca: ");
		System.out.println("1- procurar por nome;");
		System.out.println("2- procurar por gênero;");
		System.out.println("3- procurar por Número de Identificação;");
		System.out.println("4- procurar pelo nome do autor;");
		System.out.println("5- procurar pelo nome da editora;");
				
		int filtro = sc.nextInt();
		Livro itemConsultado = new Livro();
		
		switch(filtro){
			case 1:
				Scanner n = new Scanner(System.in);
				System.out.println("Insira o título do livro pelo qual deseja buscar: ");
				String titulo = n.nextLine();
				itemConsultado=lDAO.findByNome(titulo);
				validaConsultaLivro(itemConsultado);
				break;
			case 2:
				System.out.println("Insira o genero do livro pelo qual deseja buscar: ");
				String genero = sc.nextLine();
				//itemConsultado=lDAO.findByGenero(titulo);
				validaConsultaLivro(itemConsultado);
				break;
			case 3:
				System.out.println("Insira o ID do livro pelo qual deseja buscar: ");
				String id = sc.nextLine();
				itemConsultado=lDAO.findByID(id);
				validaConsultaLivro(itemConsultado);
				break;
			case 4:
				System.out.println("Insira o nome do autor do livro pelo qual deseja buscar: ");
				String autor = sc.nextLine();
				//itemConsutado=PostgreDAO.consulta("Livro", "Nome do Autor", autor);
				//validaConsultaLivro(item);
				break;
			case 5:
				System.out.println("Insira o nome da editora do livro pelo qual deseja buscar: ");
				String editora = sc.nextLine();
				//itemConsutado=PostgreDAO.consulta("Livro", "Nome da Editora", editora);
				//validaConsultaLivro(item);
				break;
			default: 
				System.out.println("Por favor, insira uma uma opção válida");
				filtrarOpcoesConsultaLivro();
		}
	
	}
	
	private static void filtrarOpcoesConsultaDVD() {
		
		Scanner sc = new Scanner(System.in);
		DVDDao dDAO = new DVDDao();
		
		System.out.println("Selecione o filtro com que deseja fazer a busca: ");
		System.out.println("1- procurar por nome;");
		System.out.println("2- procurar por gênero;");
		System.out.println("3- procurar por Número de Identificação;");
		System.out.println("4- procurar pelo ano;");
		System.out.println("5- procurar pelo nome do diretor;");
		
		int filtro = sc.nextInt();
		DVD itemConsultado = new DVD();
		switch(filtro){
			case 1:
				System.out.println("Insira o título do DVD pelo qual deseja buscar: ");
				String titulo = sc.nextLine();
				itemConsultado = dDAO.findByNome(titulo);
				validaConsultaDVD(itemConsultado);
				break;
			case 2:
				System.out.println("Insira o genero do DVD pelo qual deseja buscar: ");
				String genero = sc.nextLine();
				//itemConsutado=PostgreDAO.consulta("DVD", "Gênero", genero);
				//validaConsultaDVD(item);
				break;
			case 3:
				System.out.println("Insira o ID do DVD pelo qual deseja buscar: ");
				String id = sc.nextLine();
				itemConsultado = dDAO.findByID(id);
				validaConsultaDVD(itemConsultado);
				break;
			case 4:
				System.out.println("Insira o ano do DVD pelo qual deseja buscar: ");
				String ano = sc.nextLine();
				//itemConsutado=PostgreDAO.consulta("DVD", "Ano", ano);
				//validaConsultaDVD(item);
				break;
			case 5:
				System.out.println("Insira o nome do diretor do DVD pelo qual deseja buscar: ");
				String diretor = sc.nextLine();
				//itemConsutado=PostgreDAO.consulta("DVD", "Nome do Diretor", diretor);
				//validaConsultaDVD(item);
				break;
			default: 
				System.out.println("Por favor, insira uma uma opção válida");
				filtrarOpcoesConsultaDVD();
		}
		return;
	}
	
	private static void validaConsultaLivro(Livro itemAReservar) {
		System.out.println("Confira os dados do item: ");
		System.out.println("Título: "+itemAReservar.get_nome());
		System.out.println("Autor: "+itemAReservar.get_autor());
		System.out.println("Gênero: "+itemAReservar.get_genero());
		System.out.println("Editora: "+itemAReservar.get_editora());
		System.out.println("Número de Identificação: "+itemAReservar.get_id());
		System.out.println("Número de Exemplares: "+itemAReservar.get_numExemplares());
		System.out.println("Número de Exemplares disponíveis: "+itemAReservar.get_exemplaresDisponiveis());
		System.out.println("Deseja reservar? S/N");
		Scanner sc = new Scanner(System.in);
		String resposta=sc.nextLine();
		if (resposta=="S"){
			try{
				Reservar(itemAReservar);
			} catch (Exception e) {
				System.out.println("Reserva mal sucedida!");
				System.out.println("Deseja: 1-Consultar, 2-Reservar, 3-Devolver outro livro, ou 4-Sair");
				int opcao= sc.nextInt();
				
				Sistema.filtarOpcao(opcao);
			}
		} else {
			Consultar();
		}
	}
	
	private static void validaConsultaDVD(DVD itemAReservar) {
		System.out.println("Confira os dados do item:");
		System.out.println("Título: "+itemAReservar.get_nome());
		System.out.println("Diretor: "+itemAReservar.get_diretor());
		System.out.println("Ano: "+itemAReservar.get_ano());
		System.out.println("Gênero: "+itemAReservar.get_genero());
		System.out.println("Número de Identificação: "+itemAReservar.get_id());
		System.out.println("Número de Exemplares: "+itemAReservar.get_numExemplares());
		System.out.println("Número de Exemplares disponíveis: "+itemAReservar.get_exemplaresDisponiveis());
		System.out.println("Deseja reservar? S/N");
		Scanner sc = new Scanner(System.in);
		String resposta=sc.nextLine();
		if (resposta=="S"){
			try{
				Reservar(itemAReservar);
			} catch (Exception e) {
				System.out.println("Reserva mal sucedida!");
				System.out.println("Deseja: 1-Consultar, 2-Reservar, 3-Devolver outro livro, ou 4-Sair");
				int opcao= sc.nextInt();
				
				Sistema.filtarOpcao(opcao);
			}
		} else {
			Consultar();
		}
	}
	
	public static void Reservar(Item e) throws Exception {
		int exemplaresDisponiveis = e.get_exemplaresDisponiveis();
		if (exemplaresDisponiveis > 0) {
			exemplaresDisponiveis--;
			e.set_exemplaresDisponiveis(exemplaresDisponiveis);
			System.out.println("O item está reservado! Deseja consultar ou reservar outro item? S/N");
			Scanner sc = new Scanner(System.in);
			String resposta= sc.nextLine();
			
			if(resposta=="S"){
				Consultar();
				return;
			}
			if (resposta=="N") {
				System.out.println("Dirija-se ao balcão para validar e retirar o item.");
				return;
			}
		} else throw new indisponibilidadeException("O item não tem exemplares disponíveis.");
		
	}
	
	public static void Devolver(Item e) {
		System.out.println("Processo de Devolução iniciado.");
		int exemplaresDisponiveis = e.get_exemplaresDisponiveis();
		exemplaresDisponiveis++;
		e.set_exemplaresDisponiveis(exemplaresDisponiveis);
		System.out.println("Dirija-se ao balcão para entregar o item e validar sua devolução.");
	}
	
	public static void InicializaItens() {
		
		Livro l1 = new Livro("Livro", "id", "Fortaleza Digital", "Dan Brown", "Ficção", "Sextante", 5, 3);
		Livro l2 = new Livro("Livro", "id", "Anjos e Demônios", "Dan Brown", "Ficção", "Sextante", 5, 5);
		Livro l3 = new Livro("Livro", "id", "O Código Da Vinci", "Dan Brown", "Ficção", "Sextante", 5, 1);	
		Livro l4 = new Livro("Livro", "id", "O Guia do Mochileiro das Galáxias", "Douglas  Adams", "Comédia", "Arqueiro", 5, 2);
		Livro l5 = new Livro("Livro", "id", "O Senhor dos Anéis", "J.R.R. Tolkien", "Fantasia", "Martins Fontes", 5, 3);
		
		DVD d1 = new DVD("DVD", "id", "O Todo Poderoso", "Tom Shadyac", "Comédia", "2003", 5, 5);
		DVD d2 = new DVD("DVD", "id", "Kill Bill", "Quentin Tarantino", "Ação", "2003", 5, 1);
		DVD d3 = new DVD("DVD", "id", "Inferno", "Ron Howard", "Mistério", "2016", 5, 4);
		DVD d4 = new DVD("DVD", "id", "2001: Uma Odisséia no espaço", "Stanley Kubric", "Ficção", "1968", 5, 2);
		DVD d5 = new DVD("DVD", "id", "Click", "Frank Coraci", "Comédia", "2006", 5, 0);
		
	}
}