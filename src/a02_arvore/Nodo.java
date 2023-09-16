package a02_arvore;

import java.util.ArrayList;
import java.util.List;

public class Nodo {

	private Object dado;
	private List<Nodo> filhos = new ArrayList<Nodo>();

	
	public Nodo(Object dado) {
		this.dado = dado;
	}
	
	public Object getDado() {
		return dado;
	}
	
	public List<Nodo> getFilhos() {
		return filhos;
	}
	
	public void adicionaFilho(Nodo filho) {
		filhos.add(filho);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		montaStringPreOrdem(this, sb, 0);
		return sb.toString();
	}
	
	private static void montaStringPreOrdem(Nodo nodo, StringBuilder sb, int nivel) {
		for (int i = 0; i < nivel; i++) {
			sb.append("  ");
		}
		sb.append(nodo.dado.toString());
		sb.append("\r\n");
		for (Nodo filho : nodo.filhos) {
			montaStringPreOrdem(filho, sb, nivel + 1);
		}
	}
}
