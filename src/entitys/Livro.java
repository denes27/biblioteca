package entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Livro")

public class Livro extends Item {
	
	@Column (name="editora")
	private String _editora;
	@Column (name="autor")
	private String _autor;

	public Livro() {
		
	}
	
	public Livro(String tipo, String id, String nome, String autor, String genero,
					String editora, int numExemplares, int exemplaresDisponiveis) {
		super(tipo, id, nome, genero, numExemplares, exemplaresDisponiveis);
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
}
