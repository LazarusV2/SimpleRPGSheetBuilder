package PedroTenorio;

public class ItemJaCadastradoException extends Exception{
	
	public ItemJaCadastradoException() {
		super("Item j� cadastrado!");    //Exception que printa uma mensagem caso o Item j� esteja no reposit�rio ao tentar ser cadastrado
	}

}
