package aplicacao;

public class DVD extends Item {
	
	private String _diretor, _ano;
	
	public String get_ano() {
		return _ano;
	}
	
	public void set_ano(String _ano) {
		this._ano = _ano;
	}
	
	public String get_diretor() {
		return _diretor;
	}
	
	public void set_diretor(String _diretor) {
		this._diretor = _diretor;
	}
}
