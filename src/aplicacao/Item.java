package aplicacao;

import java.util.Scanner;

public class Item {

	private String _nome, _genero, _id, _tipo;
	private int  _numExemplares;
	private static int _exemplaresDisponiveis;
	
	public String get_tipo() {
		return _tipo;
	}

	public void set_tipo(String _tipo) {
		this._tipo = _tipo;
	}
	
	public String get_nome() {
		return _nome;
	}
	

	public void set_nome(String _nome) {
		this._nome = _nome;
	}

	public String get_genero() {
		return _genero;
	}

	public void set_genero(String _genero) {
		this._genero = _genero;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public int get_numExemplares() {
		return _numExemplares;
	}

	public void set_numExemplares(int _numExemplares) {
		this._numExemplares = _numExemplares;
	}

	public static int get_exemplaresDisponiveis() {
		return _exemplaresDisponiveis;
	}

	public static void set_exemplaresDisponiveis(int _exemplaresDisponiveis) {
		Item._exemplaresDisponiveis = _exemplaresDisponiveis;
	}

	public static void Consultar() {
		filtrarOpcoesDeConsulta();
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
		Item itemConsultado=new Item();
		
		switch(filtro){
			case 1:
				System.out.println("Insira o título do livro pelo qual deseja buscar: ");
				String titulo = sc.nextLine();
				//itemConsutado=PostgreDAO.consulta("Livro", "Título", titulo);
				//validaConsultaLivro(item);
				break;
			case 2:
				System.out.println("Insira o genero do livro pelo qual deseja buscar: ");
				String genero = sc.nextLine();
				//itemConsutado=PostgreDAO.consulta("Livro", "Gênero", genero);
				//validaConsultaLivro(item);
				break;
			case 3:
				System.out.println("Insira o ID do livro pelo qual deseja buscar: ");
				String id = sc.nextLine();
				//itemConsutado=PostgreDAO.consulta("Livro", "ID", id);
				//validaConsultaLivro(item);
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
		
		System.out.println("Selecione o filtro com que deseja fazer a busca: ");
		System.out.println("1- procurar por nome;");
		System.out.println("2- procurar por gênero;");
		System.out.println("3- procurar por Número de Identificação;");
		System.out.println("4- procurar pelo ano;");
		System.out.println("5- procurar pelo nome do diretor;");
		
		int filtro = sc.nextInt();
		
		switch(filtro){
			case 1:
				System.out.println("Insira o título do DVD pelo qual deseja buscar: ");
				String titulo = sc.nextLine();
				//try{
				//itemConsutado=PostgreDAO.consulta("DVD", "Titulo", titulo);
				//} catch (itemInexistenteException) {
				//		System.out.println("O item que você tentou consultar não existe no sistema!");
				//		Consulta();
				//}
				//validaConsultaDVD(item);
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
				//itemConsutado=PostgreDAO.consulta("DVD", "ID", id);
				//validaConsultaDVD(item);
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
		
	}
	
	private void validaConsultaLivro(Livro itemAReservar) {
		System.out.println("Confira os dados do item que você está prestes a reservar:");
		System.out.println("Título: "+itemAReservar.get_nome());
		System.out.println("Autor: "+itemAReservar.get_autor());
		System.out.println("Gênero: "+itemAReservar.get_genero());
		System.out.println("Editora: "+itemAReservar.get_editora());
		System.out.println("Número de Identificação: "+itemAReservar.get_id());
		System.out.println("Número de Exemplares: "+itemAReservar.get_numExemplares());
		System.out.println("Número de Exemplares disponíveis: "+itemAReservar.get_exemplaresDisponiveis());
		System.out.println("Deseja prosseguir? S/N");
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
			
		}
	}
	
	private void validaConsultaDVD(DVD itemAReservar) {
		System.out.println("Confira os dados do item que você está prestes a reservar:");
		System.out.println("Título: "+itemAReservar.get_nome());
		System.out.println("Diretor: "+itemAReservar.get_diretor());
		System.out.println("Ano: "+itemAReservar.get_ano());
		System.out.println("Tipo: "+itemAReservar.get_tipo());
		System.out.println("Gênero: "+itemAReservar.get_genero());
		System.out.println("Número de Identificação: "+itemAReservar.get_id());
		System.out.println("Número de Exemplares: "+itemAReservar.get_numExemplares());
		System.out.println("Número de Exemplares disponíveis: "+itemAReservar.get_exemplaresDisponiveis());
	}
	
	public static void Reservar(Item e) throws Exception {
		if (e._exemplaresDisponiveis > 0) {
			_exemplaresDisponiveis--;
			System.out.println("O item está reservado! Deseja consultar ou reservar outro item? S/N");
			Scanner sc = new Scanner(System.in);
			String resposta= sc.nextLine();
			
			if(resposta=="S"){
				Consultar();
				return;
			}
			if (resposta=="N") {
					System.out.println("Dirija-se ao balcão para validar e retirar o item.");
			}
		} else throw new indisponibilidadeException("O item não tem exemplares disponíveis.");
		
	}
	
	public static void Devolver(Item e) {
		System.out.println("Processo de Devolução iniciado.");
		e._exemplaresDisponiveis++;
		System.out.println("Dirija-se ao balcão para entregar o item e validar sua devolução.");
	}
}