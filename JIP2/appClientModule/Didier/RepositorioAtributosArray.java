package Didier;

public class RepositorioAtributosArray implements RepositorioAtributos {
	// parte bruta do codigo
	private AtributoBasico[] atributos;
	private int indice;

	public RepositorioAtributosArray() {
		this.atributos = new AtributoBasico[11];
	}

	public void inserir(AtributoBasico atributo) {
		this.atributos[this.indice++] = atributo;
	}

	public void digaClasseRaca(String classe, String raca) throws ClasseRacaNaoEncontradaException, AtributoNaoEncontradoException {
		switch (raca) {
		//cada raca possui uma serie de caracteristicas particulares, que alteram os atributos ja inseridos
		case "Elfo":
			this.inserir(new Atributo2("Velocidade", 9));
			this.atualizar(new Atributo("Destreza", this.procurar("Destreza").getValor() + 2));
			this.atualizar(new Atributo("Inteligencia", this.procurar("Inteligencia").getValor() + 1));
			break;
		case "Humano":
			this.inserir(new Atributo2("Velocidade", 9));
			this.atualizar(new Atributo("Forca", this.procurar("Forca").getValor() + 1));
			this.atualizar(new Atributo("Destreza", this.procurar("Destreza").getValor() + 1));
			this.atualizar(new Atributo("Constituicao", this.procurar("Constituicao").getValor() + 1));
			this.atualizar(new Atributo("Inteligencia", this.procurar("Inteligencia").getValor() + 1));
			this.atualizar(new Atributo("Sabedoria", this.procurar("Sabedoria").getValor() + 1));
			this.atualizar(new Atributo("Carisma", this.procurar("Carisma").getValor() + 1));
			break;
		case "Anao":
			this.inserir(new Atributo2("Velocidade", 6));
			this.atualizar(new Atributo("Constituicao", this.procurar("Constituicao").getValor() + 2));
			this.atualizar(new Atributo("Forca", this.procurar("Forca").getValor() + 1));
			break;
		default:
			throw new ClasseRacaNaoEncontradaException(raca);
		}
		this.inserir(new Atributo2("Iniciativa", this.procurar("Destreza").getMod()));
		this.inserir(new Atributo2("Proficiencia", 2));
		this.inserir(new Atributo2("Percepcao Passiva", 10 + this.procurar("Sabedoria").getMod()));
		switch (classe) {
		//a classe, assim como a raca, tambem altera alguns valores
		case "Mago":
			this.inserir(new Atributo2("PV", 6 + this.procurar("Constituicao").getMod()));
			break;
		case "Guerreiro":
			this.inserir(new Atributo2("PV", 10 + this.procurar("Constituicao").getMod()));
			break;
		case "Clerigo":
			this.inserir(new Atributo2("PV", 8 + this.procurar("Constituicao").getMod()));
			break;
		default:
			throw new ClasseRacaNaoEncontradaException(classe);
		}
	}

	public void atualizar(AtributoBasico atributo) throws AtributoNaoEncontradoException {
		boolean checar_atualizar = false;
		for (int i = 0; i < this.atributos.length && !checar_atualizar; i++) {
			if (this.atributos[i].getNome().equals(atributo.getNome())) {
				this.atributos[i].setNome(atributo.getNome());
				this.atributos[i].setValor(atributo.getValor());
				this.atributos[i].setMod();
				checar_atualizar = true;
			}
			if (i == this.atributos.length - 1 && !(checar_atualizar)) {
				throw new AtributoNaoEncontradoException(atributo.getNome());
			}
		}
	}

	public void remover(String atributo) throws AtributoNaoEncontradoException {
		boolean checar_remocao = false;
		for (int i = 0; i < this.indice && !checar_remocao; i++) {
			if (this.atributos[i].getNome().equals(atributo)) {
				this.indice--;

				for (int j = i; j < this.indice; j++)
					this.atributos[j] = this.atributos[j + 1];

				this.atributos[this.indice] = null;
				checar_remocao = true;
			}
		}
		if (!checar_remocao)
			throw new AtributoNaoEncontradoException(atributo);
	}

	public AtributoBasico procurar(String atributo) throws AtributoNaoEncontradoException {
		boolean checar_existe = false;
		AtributoBasico aux = null;
		for (int i = 0; i < this.atributos.length && !checar_existe; i++) {
			if (this.atributos[i] != null && this.atributos[i].getNome().equals(atributo)) {
				switch (atributo) {
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
				aux.setNome(this.atributos[i].getNome());
				aux.setValor(this.atributos[i].getValor());
				aux.setMod();
				checar_existe = true;
			}
			if (i == this.atributos.length - 1 && !(checar_existe)) {
				throw new AtributoNaoEncontradoException(atributo);
			}
		}
		return aux;
	}

	public boolean existe(String atributo) {
		for (int i = 0; i < this.atributos.length; i++) {
			if (this.atributos[i] != null && this.atributos[i].getNome().equals(atributo))
				return true;
		}
		return false;
	}

	public String saida(String inicial) {
		for (int i = 0; i < this.atributos.length && this.atributos[i] != null; i++) {
			inicial += this.atributos[i].getNome() + ": " + this.atributos[i].getValor();
			switch (this.atributos[i].getNome()) {
			case "Forca":
			case "Inteligencia":
			case "Destreza":
			case "Sabedoria":
			case "Constituicao":
			case "Carisma":
				inicial += ", Modificador: " + this.atributos[i].getMod();
			default:
				inicial += "\n";
			}
		}
		return inicial;
	}
}
