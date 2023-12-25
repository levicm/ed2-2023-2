package a12_hash_p02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TabelaEspalhamento {
	
	private static int TAMANHO = 26;
	
	private List<List<String>> tabela;
	

	public TabelaEspalhamento() {
		this.tabela = new ArrayList<List<String>>();
		for (int i = 0; i < TAMANHO; ++i) {
			this.tabela.add(new LinkedList<String>());
		}
	}
	
	public void adiciona(String info) {
		int posicao = calculaPosicao(info);
		List<String> lista = tabela.get(posicao);
		lista.add(info);
	}
	
	public void remove(String info) {
		int posicao = calculaPosicao(info);
		List<String> lista = tabela.get(posicao);
		lista.remove(info);
	}
	
	public boolean contem(String info) {
		int posicao = calculaPosicao(info);
		List<String> lista = tabela.get(posicao);
		return lista.contains(info);
	}
	
	private int calculaPosicao(String info) {
		int valorHash = calculaHash(info);
		return valorHash % TAMANHO;
	}

	private int calculaHash(String info) {
		int result = 0;
		for (int i = 0; i < info.length(); ++i) {
			int posicao = info.length() - i - 1;
			char letra = info.charAt(i);
			result += letra * Math.pow(7, posicao);
		}
		return result;
	}

	@Override
	public String toString() {
		return this.tabela.toString();
	}
}
