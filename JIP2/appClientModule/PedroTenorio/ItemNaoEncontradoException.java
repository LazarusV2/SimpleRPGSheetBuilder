package PedroTenorio;

public class ItemNaoEncontradoException extends Exception {
	
	public ItemNaoEncontradoException() {
		super("Item nao encontrado!");  //Exception que printa uma mensagem caso o Item n�o seja encontrado ao ser procurado.
	}

}
