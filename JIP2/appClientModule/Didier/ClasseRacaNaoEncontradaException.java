package Didier;

public class ClasseRacaNaoEncontradaException extends Exception{
	//caso a classe/raca inserida nao exista a excecao sera exposta
	private String classeracaerrada;
	public ClasseRacaNaoEncontradaException (String classeracaerrada) {
		super ("A classe/raca nao existe.");
		this.classeracaerrada = classeracaerrada;
	}
	public String getCE(){
		return classeracaerrada;
	}
}