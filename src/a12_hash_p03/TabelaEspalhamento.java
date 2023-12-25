package a12_hash_p03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TabelaEspalhamento {
	
	private static int TAMANHO = 26;
	
	private List<List<Object>> tabela;

	public TabelaEspalhamento() {
		this.tabela = new ArrayList<List<Object>>();
		for (int i = 0; i < TAMANHO; ++i) {
			this.tabela.add(new LinkedList<Object>());
		}
	}
	
	public void adiciona(Object info) {
		int posicao = calculaPosicao(info);
		List<Object> lista = tabela.get(posicao);
		lista.add(info);
	}
	
	public void remove(Object info) {
		int posicao = calculaPosicao(info);
		List<Object> lista = tabela.get(posicao);
		lista.remove(info);
	}
	
	public boolean contem(Object info) {
		int posicao = calculaPosicao(info);
		List<Object> lista = tabela.get(posicao);
		return lista.contains(info);
	}
	
	private int calculaPosicao(Object info) {
		int valorHash = calculaHash(info);
		return valorHash % TAMANHO;
	}

	private int calculaHash(Object info) {
		return Math.abs(info.hashCode());
	}

	@Override
	public String toString() {
		return this.tabela.toString();
	}
}
