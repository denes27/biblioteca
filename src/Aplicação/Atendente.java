package Aplicação;

public class Atendente {
	String nome;
	int balcao;
	public static int senha;
	
	public void chamaProximo() {
		System.out.println("Senha: "+ senha);
		senha++;
		System.out.println("Atendente do Balcão "+ balcao +" livre. Prossiga para retirar os itens reservados.");
	}
}
