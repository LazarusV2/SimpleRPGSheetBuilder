package Bruno;

public class PericiaJaCadastradaException extends Exception {
	public PericiaJaCadastradaException(String nome) {
		super("Pericia ja Cadastrada: " + nome);//Exception que printa uma mensagem caso a pericia já esteja no repositório ao tentar ser cadastrado
	}
}
