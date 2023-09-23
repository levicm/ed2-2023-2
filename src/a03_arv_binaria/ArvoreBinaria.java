package a03_arv_binaria;

public class ArvoreBinaria {

	private NodoAB raiz;

	public NodoAB criaRaiz(Object info) {
		if (raiz != null) {
			throw new RuntimeException("Raiz j� existe!");
		}
		raiz = new NodoAB(info);
		return raiz;
	}

	public NodoAB getRaiz() {
		return raiz;
	}

	public NodoAB insereEsquerda(NodoAB pai, Object info) {
		if (pai.getEsquerdo() != null) {
			throw new RuntimeException("Filho esquerdo j� existe!");
		}
		NodoAB nodo = new NodoAB(info);
		nodo.setPai(pai);
		pai.setEsquerdo(nodo);
		return nodo;
	}

	public NodoAB insereDireita(NodoAB pai, Object info) {
		if (pai.getDireito() != null) {
			throw new RuntimeException("Filho direito j� existe!");
		}
		NodoAB nodo = new NodoAB(info);
		nodo.setPai(pai);
		pai.setDireito(nodo);
		return nodo;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		montaStringCentralEsquerda(raiz, sb);
		return sb.toString();
	}

	private void montaStringCentralEsquerda(NodoAB nodo, StringBuilder sb) {
		if (nodo != null) {
			if (nodo.getEsquerdo() != null || nodo.getDireito() != null) {
				sb.append("(");
			}
			// desce para esquerda
			if (nodo.getEsquerdo() != null) {
				montaStringCentralEsquerda(nodo.getEsquerdo(), sb);
			}
			// processa nodo
			sb.append(nodo.getInfo());
			// desce para direita
			if (nodo.getDireito() != null) {
				montaStringCentralEsquerda(nodo.getDireito(), sb);
			}
			if (nodo.getEsquerdo() != null || nodo.getDireito() != null) {
				sb.append(")");
			}
		}
	}
}
