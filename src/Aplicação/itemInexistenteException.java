package Aplicação;

public class itemInexistenteException extends Exception{
	
	public itemInexistenteException() { }
	
	public itemInexistenteException(String msg) {
		super(msg);
	}
}
