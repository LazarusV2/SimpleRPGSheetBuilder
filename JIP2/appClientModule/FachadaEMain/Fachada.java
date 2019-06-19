package FachadaEMain;
import Bruno.*;
import Didier.*;
import Lazarus.*;
import Nilo.*;
import PedroTenorio.*;

public class Fachada {
	
	private CadastroTracos tracos;
	private CadastroPericias pericias;
	private CadastroAtributos atributos;
	private CadastroItens itens;
	private CadastroMagias magias;
	
	public Fachada(boolean tipo, int tam) {
		if(tipo) { //Array
			this.tracos = new CadastroTracos(new RepositorioTracosArray(tam));
			this.pericias = new CadastroPericias( new RepositorioPericiaArray());
			this.itens = new CadastroItens(new RepositorioItensArray());
			this.atributos = new CadastroAtributos(new RepositorioAtributosArray());
			this.magias = new CadastroMagias(new RepositorioMagiaArray(tam));
			}
		else { //Lista
			this.tracos = new CadastroTracos(new RepositorioTracosLista());
			this.pericias = new CadastroPericias(new RepositorioPericiaLista());
			this.itens = new CadastroItens(new RepositorioItensLista());
			this.atributos = new CadastroAtributos(new RepositorioAtributosLista());
			this.magias = new CadastroMagias(new RepositorioMagiaLista());
		}	
	}
	
	public void cadastrarTraco(Traco traco) throws TracoJaCadastradoException{
		if(!this.tracos.existe(traco.getNome())) {
			this.tracos.cadastrar(traco);
		}
		else {
			throw new TracoJaCadastradoException(traco.getNome());
		}
	}
	public String imprimirTracos() {
		return this.tracos.imprimirTracos();
	}
	public void removerTraco(String nome) throws TracoNaoEncontradoException {
		this.tracos.remover(nome);
	}
	
	public void atualizarTraco(Traco traco) throws TracoNaoEncontradoException{
		this.tracos.atualizar(traco);
	}
	
	public boolean existeTraco(String nome) {
		return this.tracos.existe(nome);
	}
	
	public Traco procurarTraco(String nome) throws TracoNaoEncontradoException{
		return this.tracos.procurar(nome);
	}
	
	public void cadastrarPericia(Pericia pericia) throws PericiaJaCadastradaException {
		this.pericias.cadastrar(pericia);
	}
	
	public void removerPericia(String nome) throws NaoExistePericiaException {
		this.pericias.remove(nome);
	}
	
	public boolean existePericia(String nome) {
		return this.pericias.existe(nome);
	}
	
	public void atualizarPericia(Pericia pericia) throws NaoExistePericiaException, PericiaJaCadastradaException{
		this.pericias.atualizar(pericia);
	}
	
	public Pericia procurarPericia(String nome) throws NaoExistePericiaException {
		return this.pericias.procurar(nome);
	}
	
	public String imprimirPericia() {
		return this.pericias.imprimir();
	}
	
	public void cadastrarAtributo(Atributo atributo) throws AtributoJaCadastradoException{
		if(!this.atributos.existe(atributo.getNome())) {
			this.atributos.cadastrar(atributo);
		}else {
			throw new AtributoJaCadastradoException(atributo);
		}
	}
	
	public void atributo_dizerClasseERaca(String classe, String raca) throws ClasseRacaNaoEncontradaException, AtributoNaoEncontradoException, TracoNaoEncontradoException{
		raca = this.procurarTraco("Raca").getDescricao();
		classe = this.procurarTraco("Classe").getDescricao();
		this.atributos.dizerClasseERaca(classe, raca);
	}
	
	public void atualizarAtributo(Atributo atributo) throws AtributoNaoEncontradoException{
		this.atributos.atualizar(atributo);
	}
	
	public void removerAtributo(String atributo) throws AtributoNaoEncontradoException{
		this.atributos.remover(atributo);
	}
	
	public AtributoBasico procurarAtributo(String atributo) throws AtributoNaoEncontradoException{
		return this.atributos.procurar(atributo);
	}
	
	public boolean existeAtributo(String nome) {
		return this.atributos.existe(nome);
	}
	
	public String saidaAtributo(String inicial) {
		return this.atributos.saida(inicial);
	}
	
	public void cadastrarItem(Item item) throws ItemJaCadastradoException{
		if(!this.itens.existe(item.getNome())) {
			this.itens.cadastrar(item);
		} else {
			throw new ItemJaCadastradoException();
		}
	}
	
	public void atualizarItem(Item item) throws ItemNaoEncontradoException{
		this.itens.atualizar(item);
	}
	
	public void removerItem(String nome) throws ItemNaoEncontradoException{
		this.itens.remover(nome);
	}
	
	public Item procurarItem(String nome) throws ItemNaoEncontradoException{
		return this.itens.procurar(nome);
	}
	
	public boolean existeItem(String nome) {
		return this.itens.existe(nome);
	}
	
	public String imprimirItem() {
		return this.itens.imprimir();
	}
	
	public void cadastrarMagia(Magia magia) throws MagiaJaCadastradaException {
		if (this.magias.existe(magia.getNome())) {
			throw new MagiaJaCadastradaException(magia.getNome());
		}	
		this.magias.cadastrar(magia);
	}
	
	public Magia procurarMagia(String nome) throws MagiaNaoEncontradaException {
		return this.magias.procurar(nome);
	}
	
	public void removerMagia(String nome) throws MagiaNaoEncontradaException {
		this.magias.remover(nome);
	}
	
	public boolean existeMagia(String nome){
		return this.magias.existe(nome);
	}
	
	public void atualizarMagia(Magia magianova) throws MagiaNaoEncontradaException {
		this.magias.atualizar(magianova);
	}
	
	public String imprimirMagias() {
		return this.magias.imprimirMagias();
	}
}
