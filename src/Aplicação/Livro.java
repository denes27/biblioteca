package Aplicação;

public class Livro extends Item {
	
	private String _autor, _editora;
	
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
