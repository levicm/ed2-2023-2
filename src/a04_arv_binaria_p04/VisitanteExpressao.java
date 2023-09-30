package a04_arv_binaria_p04;

import java.util.Stack;

public class VisitanteExpressao implements Visitante {

	private Stack<Float> pilha = new Stack<Float>();

	public void visita(NodoAB nodo) {
		if (nodo != null) {
			Float valor = null;
			if (nodo.getInfo() instanceof Float) {
				valor = (Float) nodo.getInfo();
				pilha.push(valor);
			} else {
				Float direita = pilha.pop();
				Float esquerda = pilha.pop();
				if ("+".equals(nodo.getInfo())) {
					valor = esquerda + direita;
				} else if ("-".equals(nodo.getInfo())) {
					valor = esquerda - direita;
				} else if ("*".equals(nodo.getInfo())) {
					valor = esquerda * direita;
				} else if ("/".equals(nodo.getInfo())) {
					valor = esquerda / direita;
				}
				pilha.push(valor);
			}
		}
	}

	public Float getResultado() {
		return pilha.peek();
	}
}
