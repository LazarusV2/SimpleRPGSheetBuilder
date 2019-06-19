package PedroTenorio;

public class ItemJaCadastradoException extends Exception{
	
	public ItemJaCadastradoException() {
		super("Item jï¿½ cadastrado!");    //Exception que printa uma mensagem caso o Item já esteja no repositório ao tentar ser cadastrado
	}

}
