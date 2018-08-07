package entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AcervoDB")

public class AcervoDB {
	
	@Id
	@GeneratedValue
	private String _id;
	@Column(name="tipo")
	private String _tipo;
	@Column(name="titulo")
	private String _nome;
	@Column(name="genero")
	private String _genero;
	@Column(name="numExempl")
	private int _numExemplares;
	@Column (name="dispExempl")
	private int _exemplaresDisponiveis;
	@Column (name="editora")
	private String _editora;
	@Column (name="ano")
	private String _ano;
	@Column (name="diretor")
	private String _diretor;
	@Column (name="autor")
	private String _autor;

	public AcervoDB() {
		
	}
	
	public AcervoDB(String tipo, String id, String nome, String diretor, String autor, String genero,
					String editora, String ano, int numExemplares, int exemplaresDisponiveis) {
		this._ano=ano;
		this._tipo=tipo;
		this._id=id;
		this._nome=nome;
		this._diretor=diretor;
		this._genero=genero;
		this._numExemplares=numExemplares;
		this._exemplaresDisponiveis= exemplaresDisponiveis;
		this._autor=autor;
		this._editora=editora;
	}

 	public String get_autor() {
		return _autor;
	}
	
	public void set_autor(String _autor) {
		this._autor = _autor;
	}
	
	
	public String get_editora() {
		return _editora;
	}
	
	public void set_editora(String _editora) {
		this._editora = _editora;
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
	
	public void set_exemplaresDisponiveis(int _exemplaresDisponiveis) {
		this._exemplaresDisponiveis = _exemplaresDisponiveis;
	}

	public int get_exemplaresDisponiveis() {
		return _exemplaresDisponiveis;
	}

	

}
