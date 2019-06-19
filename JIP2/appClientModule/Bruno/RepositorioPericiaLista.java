package Bruno;

public class RepositorioPericiaLista implements RepositorioPericia {
	private Pericia pericia;//atributo da classe que serve como armanezamento de pericia
	private RepositorioPericiaLista proximo;//sequenciamento de repositorios de lista
	
	public Pericia procurar(String nome) throws NaoExistePericiaException {//procura-se a pericia com o nome dado
		if (this.pericia == null)
			throw new NaoExistePericiaException(nome);//se nao encontrar uma pericia com o mesmo nome;
		else if (nome.equals(this.pericia.getNome()))
			return new Pericia(this.pericia);//retorna um clone da pericia, quando encontra-a
		else
			return this.proximo.procurar(nome);//se nao encontra nessa classe, procura-se na proxima
	}

	public boolean existe(String info) {//verifica se a pericia existe
		if (this.pericia == null)
			return false;//se nao existe pericia, significa que esta no final da lista, portanto, nao foi encontrado
		else if (info.equals(this.pericia.getNome()))//se achar a pericia com o mesmo nome, retorna true
			return true;
		else
			return this.proximo.existe(info);//se a pericia nao se encontra nesse, procura-se no proximo
	}

	public void inserir(Pericia pericia) {//adiciona-se a pericia no repositorio
		if (this.pericia == null) {//adiciona-se somente no final
			this.pericia = new Pericia(pericia);
			this.proximo = new RepositorioPericiaLista();
		}
		else
			this.proximo.inserir(pericia);//so adiciona-se num lugar vazio
	}

	public void remover(String info) throws NaoExistePericiaException {//remover a pericia com o nome dado
		if (this.pericia == null)//se pericia == null e, quer dizer que, dentre de todos os valores inseridos, nao existe uma pericia com o nome dado
			throw new NaoExistePericiaException(info);
		else if (info.equals(this.pericia.getNome())) {//armazena os atributos dessa classe com a da proxima, o que da o efeito de "apagar"
			this.pericia = this.proximo.pericia;
			this.proximo = this.proximo.proximo;
		} else
			this.proximo.remover(info);//se a pericia nao se encontra nesse, procura-se no proximo
	}
	
	public void atualizar(Pericia pericia) throws NaoExistePericiaException {//atualiza a pericia de acordo com a chave inserida
		if (this.pericia == null)//se pericia == null e, quer dizer que, dentre de todos os valores inseridos, nao existe uma pericia com o nome dado
			throw new NaoExistePericiaException(pericia.getNome());
		else if (pericia.getKey() == this.pericia.getKey())//procura-se pericia com a mesma chave
			this.pericia.trocarNome(pericia.getNome());
		else
			this.proximo.atualizar(pericia);//se a pericia nao se encontra nesse, procura-se no proximo
	}

	public String imprimir() {//pega todos os nomes das pericias e coloca-as em um formato que podera ser usado para impressao
		if (this.pericia == null)
			return "";
		else
			return this.pericia.getNome() + "\n" + this.proximo.imprimir();
	}
}
