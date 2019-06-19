package Didier;

public class AtributoNaoEncontradoException extends Exception{
	//caso o atributo inserido nao exista a excecao sera exposta
	private String atributoerrado;
	public AtributoNaoEncontradoException (String atributoerrado) {
		super ("O atributo nao existe.");
		this.atributoerrado = atributoerrado;
	}
	public String getAE(){
		return atributoerrado;
	}
}