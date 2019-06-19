package PedroTenorio;

public class ItemNaoEncontradoException extends Exception {
	
	public ItemNaoEncontradoException() {
		super("Item nao encontrado!");  //Exception que printa uma mensagem caso o Item não seja encontrado ao ser procurado.
	}

}
