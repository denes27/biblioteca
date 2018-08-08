package aplicacao;

import entitys.Item;
import entitys.DVD;
import entitys.Livro;


public class Main {

	public static void main(String[] args){		
		GerenciaItem.InicializaItens(); //salva itens na dao;

		Sistema.Inicializacao();
		
	}
}
