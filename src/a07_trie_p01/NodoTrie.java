package a07_trie_p01;

public class NodoTrie {

	public static final int QTD_LETRAS = 255;
	private NodoTrie[] filhos = new NodoTrie[255];
	private Object valor;
	private int tamanho = 0;
	
	public Object getValor() {
		return valor;
	}
	
	public void setValor(Object valor) {
		this.valor = valor;
	}
	
	public NodoTrie getFilho(char letra) {
		int posicao = (int) letra;
		return filhos[posicao];
	}

	public void setFilho(char letra, NodoTrie nodo) {
		int posicao = (int) letra;
		filhos[posicao] = nodo;
		tamanho++;
	}
	
	public void remove(char letra) {
		int posicao = (int) letra;
		filhos[posicao] = null;
		tamanho--;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	@Override
	public String toString() {
		return String.valueOf(valor);
	}
}
