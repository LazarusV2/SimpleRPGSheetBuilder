package Didier;

//Classe feita para cadastrar os atributos no sistema, ela serve para simplificar a visualizacao das funcoes
//presentes nos repositorios, ou seja, e uma camada de negocios.

public class CadastroAtributos {
	private RepositorioAtributos atributos;
	public CadastroAtributos(RepositorioAtributos rep) {
		atributos = rep;
	}
	public void cadastrar(Atributo atributo) throws AtributoJaCadastradoException{
		if(!atributos.existe(atributo.getNome())) {
			this.atributos.inserir(atributo);
		}else {
			throw new AtributoJaCadastradoException(atributo);
		}
	}
	public void dizerClasseERaca(String classe, String raca) throws ClasseRacaNaoEncontradaException, AtributoNaoEncontradoException{
		this.atributos.digaClasseRaca(classe, raca);
	}
	public void atualizar(Atributo atributo) throws AtributoNaoEncontradoException{
		this.atributos.atualizar(atributo);
	}
	public void remover(String atributo) throws AtributoNaoEncontradoException{
		this.atributos.remover(atributo);
	}
	public AtributoBasico procurar(String atributo) throws AtributoNaoEncontradoException{
		return this.atributos.procurar(atributo);
	}
	public boolean existe(String nome) {
		return this.atributos.existe(nome);
	}
	public String saida(String inicial) {
		return this.atributos.saida(inicial);
	}
}
