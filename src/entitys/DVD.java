package entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="DVD")

public class DVD extends Item{
	
	@Column (name="ano")
	private String _ano;
	@Column (name="diretor")
	private String _diretor;
	
	public DVD() {
		
	}
	
	public DVD(String tipo, String id, String nome, String diretor, String genero,
			   String ano, int numExemplares, int exemplaresDisponiveis) {
		super(tipo, id, nome, genero, numExemplares, exemplaresDisponiveis);
		this._diretor=diretor;
		this._ano=ano;
	}
	
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
