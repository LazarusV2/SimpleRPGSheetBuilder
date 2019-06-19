package Didier;

public interface RepositorioAtributos {
	//funcoes basicas para inicalizacao de atributos
	public void inserir(AtributoBasico atributo); //insere o atributo
	public void digaClasseRaca(String classe, String raca) throws ClasseRacaNaoEncontradaException, AtributoNaoEncontradoException; //altera atributos
	//baseado em classe e raca
	public void atualizar(AtributoBasico atributo) throws AtributoNaoEncontradoException; //atualizacao de dados
	public void remover(String atributo) throws AtributoNaoEncontradoException; //remove atributo
	public AtributoBasico procurar(String atributo) throws AtributoNaoEncontradoException; //procura e retorna atributo
	public boolean existe(String atributo); //verifica a existencia do objeto
	public String saida(String inicial); //retorna string de saida
}
