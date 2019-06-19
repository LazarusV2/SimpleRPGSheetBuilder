package Bruno;

public interface RepositorioPericia {
	public Pericia procurar(String nome) throws NaoExistePericiaException;

	public boolean existe(String nome);

	public void inserir(Pericia pericia);

	public void remover(String info) throws NaoExistePericiaException;

	public void atualizar(Pericia informacaoAtualizada) throws NaoExistePericiaException;

	public String imprimir();
}