package Bruno;

public class NaoExistePericiaException extends Exception {
	public NaoExistePericiaException(String nome) {
		super("Essa pericia nao existe: " + nome);//Exception que retorna uma mensagem caso a  pericia nao esteja no repositorio
	}
}