package Didier;

public class AtributoJaCadastradoException extends Exception{
	//se o atributo ja foi cadastrado essa excecao sera exposta
	private String atributo;
	public AtributoJaCadastradoException (Atributo atributo) {
		super ("Atributo ja foi cadastrado.");
		this.atributo = atributo.getNome();
	}
	public String getAJC(){
		return atributo;
	}
}