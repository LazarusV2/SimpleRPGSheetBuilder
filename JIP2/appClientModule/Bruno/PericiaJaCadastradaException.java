package Bruno;

public class PericiaJaCadastradaException extends Exception {
	public PericiaJaCadastradaException(String nome) {
		super("Pericia ja Cadastrada: " + nome);//Exception que printa uma mensagem caso a pericia j� esteja no reposit�rio ao tentar ser cadastrado
	}
}
