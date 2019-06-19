package Bruno;

public class CadastroPericias {
	private RepositorioPericia repositorio;//armazenar amarzena
	private int keynumber;//serve para administrar uma chave para cada entrada
	
	public CadastroPericias(RepositorioPericia repositorio) {//no iniciador do CadastroPericia, voce coloca, como parametro, o tipo de repositorio voce vai utilizar
		this.repositorio = repositorio;//nessa linha, voce armazena o tipo de reposito utilizado
	}

	public void cadastrar(Pericia pericia) throws PericiaJaCadastradaException {//inserir pericia
		if(this.repositorio.existe(pericia.getNome()))//verifica se a pericia ja foi inserida
			throw new PericiaJaCadastradaException(pericia.getNome());//retorna o erro de ja ter a pericia inserida
		this.repositorio.inserir(new Pericia(pericia, this.keynumber++));//armazena a pericia e atribui uma chave unica, que vai se acrescentando a cada entrada
	}

	public void remove(String nome) throws NaoExistePericiaException {//remove a pericia do repositorio
		this.repositorio.remover(nome);
	}

	public boolean existe(String nome) {//verifica se a pericia existe no repositorio
		return this.repositorio.existe(nome);
	}

	public void atualizar(Pericia pericia) throws NaoExistePericiaException, PericiaJaCadastradaException {//atualiza a pericia no repositorio
		if (this.existe(pericia.getNome()))
			throw new PericiaJaCadastradaException(pericia.getNome());
		this.repositorio.atualizar(pericia);
	}

	public Pericia procurar(String nome) throws NaoExistePericiaException {//procura o nome de uma pericia no repositorio e retorna uma copia da pericia
		return this.repositorio.procurar(nome);
	}

	public String imprimir() {//imprime na tela todas as pericias
		return this.repositorio.imprimir();
	}
}
