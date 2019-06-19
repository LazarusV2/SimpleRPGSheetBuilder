package Didier;

public class RepositorioAtributosLista implements RepositorioAtributos{
	private AtributoBasico atributo;
	private RepositorioAtributosLista proximo;
	public RepositorioAtributosLista() {
		this.atributo = null;
		this.proximo = null;
	}
	public void inserir(AtributoBasico atributo){
		if(this.atributo == null) {
			this.atributo = atributo;
			this.proximo = new RepositorioAtributosLista();
		}else {
			this.proximo.inserir(atributo);
		}
	}
	public void digaClasseRaca(String classe, String raca) throws ClasseRacaNaoEncontradaException, AtributoNaoEncontradoException{
		switch (raca) {
		//cada raca possui uma serie de caracteristicas particulares, que alteram os atributos ja inseridos
		case "Elfo":
			this.inserir(new Atributo2("Velocidade", 9));
			this.atualizar(new Atributo("Destreza", this.procurar("Destreza").getValor()+2));
			this.atualizar(new Atributo("Inteligencia", this.procurar("Inteligencia").getValor()+1));
			break;
		case "Humano":
			this.inserir(new Atributo2("Velocidade", 9));
			this.atualizar(new Atributo("Forca", this.procurar("Forca").getValor()+1));
			this.atualizar(new Atributo("Destreza", this.procurar("Destreza").getValor()+1));
			this.atualizar(new Atributo("Constituicao", this.procurar("Constituicao").getValor()+1));
			this.atualizar(new Atributo("Inteligencia", this.procurar("Inteligencia").getValor()+1));
			this.atualizar(new Atributo("Sabedoria", this.procurar("Sabedoria").getValor()+1));
			this.atualizar(new Atributo("Carisma", this.procurar("Carisma").getValor()+1));
			break;
		case "Anao":
			this.inserir(new Atributo2("Velocidade", 6));
			this.atualizar(new Atributo("Constituicao", this.procurar("Constituicao").getValor()+2));
			this.atualizar(new Atributo("Forca", this.procurar("Forca").getValor()+1));
			break;
		default:
			throw new ClasseRacaNaoEncontradaException(raca);
		}
		this.inserir(new Atributo2("Iniciativa", this.procurar("Destreza").getMod()));
		this.inserir(new Atributo2("Proficiencia", 2));
		this.inserir(new Atributo2("Percepcao Passiva", 10+this.procurar("Sabedoria").getMod()));
		switch (classe) {
		//a classe, assim como a raca, tambem altera alguns valores
		case "Mago":
			this.inserir(new Atributo2("PV", 6+this.procurar("Constituicao").getMod()));
			break;
		case "Guerreiro":
			this.inserir(new Atributo2("PV", 10+this.procurar("Constituicao").getMod()));
			break;
		case "Clerigo":
			this.inserir(new Atributo2("PV", 8+this.procurar("Constituicao").getMod()));
			break;
		default:
			throw new ClasseRacaNaoEncontradaException(classe);
		}
	}
	public void atualizar(AtributoBasico atributo) throws AtributoNaoEncontradoException{
		if(this.atributo != null && this.atributo.getNome().equals(atributo.getNome())) {
			this.atributo.setNome(atributo.getNome());
			this.atributo.setValor(atributo.getValor());
			this.atributo.setMod();
		}else if (this.proximo == null) {
			throw new AtributoNaoEncontradoException(atributo.getNome());
		}else {
			this.proximo.atualizar(atributo);
		}
	}
	public void remover(String atributo) throws AtributoNaoEncontradoException{
		if (this.atributo == null) {
			throw new AtributoNaoEncontradoException(atributo);
		}
		else if(this.atributo.getNome().equals(atributo)) {
			this.atributo = this.proximo.atributo;
			this.proximo = this.proximo.proximo;
		}else {
			this.proximo.remover(atributo);
		}
	}
	public AtributoBasico procurar(String atributo) throws AtributoNaoEncontradoException {
		AtributoBasico aux = null;
		if(this.atributo == null) {
			throw new AtributoNaoEncontradoException(atributo);
		}else if(this.atributo.getNome().equals(atributo)) {
			switch(atributo) {
			case "Forca":
			case "Inteligencia":
			case "Destreza":
			case "Sabedoria":
			case "Constituicao":
			case "Carisma":
				aux = new Atributo("", 0);
				break;
			default:
				aux = new Atributo2("", 0);
			}
			aux.setNome(this.atributo.getNome());
			aux.setValor(this.atributo.getValor());
			aux.setMod();
			return aux;
		}else {
			return this.proximo.procurar(atributo);
		}
	}
	public boolean existe(String atributo){
		if(this.atributo == null) {
			return false;
		}else if (this.atributo.getNome().equals(atributo)) {
			return true;
		}else {
			return this.proximo.existe(atributo);
		}
	}
	public String saida(String inicial) {
		if (this.atributo != null) {
			inicial += this.atributo.getNome()+": "+this.atributo.getValor();
			switch (this.atributo.getNome()) {
			case "Forca":
			case "Inteligencia":
			case "Destreza":
			case "Sabedoria":
			case "Constituicao":
			case "Carisma":
				inicial += ", Modificador: "+this.atributo.getMod();
			default:
				inicial += "\n";
			}return this.proximo.saida(inicial);
		}else {
			return inicial;
		}
	}
}