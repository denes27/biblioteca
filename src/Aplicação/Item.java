package Aplicação;

import java.util.Scanner;

public class Item {

	private String _nome, _genero;
	private int _id, _numExemplares, _exemplaresDisponiveis;
	
	public void Consultar() {
		Scanner sc = new Scanner(System.in);
		//filtro
		//função()
		System.out.println("Deseja buscar por qual tipo de item?");
		System.out.println("1- procurar por Livro;");
		System.out.println("2- procurar por DVD;");
		int item=sc.nextInt();
		
		System.out.println("Selecione o filtro com que deseja fazer a busca: ");
		System.out.println("1- procurar por nome;");
		System.out.println("2- procurar por gênero;");
		System.out.println("3- procurar por Número de Identificação;");
//		if (item==1){
//			System.out.println("4- procurar pelo nome do autor;");
//			System.out.println("5- procurar pelo nome da editora;");
//		} else if (item==2){
//			System.out.println("4- procurar pelo ano;");
//			System.out.println("5- procurar pelo tipo (filme ou música);");
//			System.out.println("6- procurar pelo nome do diretor;");
//		}
				
		int filtro = sc.nextInt();
		
		switch(filtro){
			case 1:
				System.out.println("Insira o título pelo qual deseja buscar: ");
				String titulo = sc.nextLine();
				//PostgreDAO.consulta(item, filtro, titulo);
				break;
			case 2:
				System.out.println("Insira o genero pelo qual deseja buscar: ");
				String genero = sc.nextLine();
				//PostgreDAO.consulta(item, filtro, genero);
				break;
			case 3:
				System.out.println("Insira o ID pelo qual deseja buscar: ");
				int id = sc.nextInt();
				//PostgreDAO.consulta(item, filtro, id);
				break;
			default: 
				System.out.println("Por favor, insira uma uma opção válida");
				filtro=sc.nextInt();
		}
		
		sc.close();
		
	}
	
	public void Reservar(Item e) throws Exception {
		if (e._exemplaresDisponiveis > 0) {
			_exemplaresDisponiveis--;
			System.out.println("O item está reservado! Deseja consultar ou reservar outro item? S/N");
			Scanner sc = new Scanner(System.in);
			String r= sc.nextLine();
			if(r=="S"){
				Consultar();
				return;
			}
			if (r=="N") {
					System.out.println("Dirija-se ao balcão para validar e retirar o item.");
			}
			sc.close();
		} else throw new indisponibilidadeException("O item não tem exemplares disponíveis.");
		
	}
	
	public void Devolver() {
		
	}
}