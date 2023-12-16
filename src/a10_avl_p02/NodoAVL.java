package a10_avl_p02;

public class NodoAVL {
	private Comparable info;
	private NodoAVL pai;
	private NodoAVL esquerdo;
	private NodoAVL direito;
	private int altura;

	public NodoAVL(Comparable info) {
		this.info = info;
	}

	public int grau() {
		int result = 0;
		if (getEsquerdo() != null) {
			result++;
		}
		if (getDireito() != null) {
			result++;
		}
		return result;
	}

	public int nivel() {
		int result = 1;
		NodoAVL pai = getPai();
		while (pai != null) {
			result++;
			pai = pai.getPai();
		}
		return result;
	}

	public int altura() {
		return medeAltura(this, 1);
	}

	private static int medeAltura(NodoAVL nodo, int altura) {
		int result = altura;
		if (nodo.getDireito() != null) {
			result = Math.max(altura, medeAltura(nodo.getDireito(), altura + 1));
		}
		if (nodo.getEsquerdo() != null) {
			result = Math.max(altura, medeAltura(nodo.getEsquerdo(), altura + 1));
		}
		return result;
	}

	public Comparable getInfo() {
		return info;
	}

	public NodoAVL getPai() {
		return pai;
	}

	public void setPai(NodoAVL pai) {
		this.pai = pai;
	}

	public NodoAVL getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(NodoAVL esquerdo) {
		this.esquerdo = esquerdo;
	}

	public NodoAVL getDireito() {
		return direito;
	}

	public void setDireito(NodoAVL direito) {
		this.direito = direito;
	}

	public boolean isFolha() {
		return getEsquerdo() == null && getDireito() == null;
	}

	public NodoAVL getMaior() {
		NodoAVL nodo = this;
		while (nodo.getDireito() != null) {
			nodo = nodo.getDireito();
		}
		return nodo;
	}

	public NodoAVL getMenor() {
		NodoAVL nodo = this;
		while (nodo.getEsquerdo() != null) {
			nodo = nodo.getEsquerdo();
		}
		return nodo;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getFator() {
		return getAltura(direito) - getAltura(esquerdo);
	}

	private int getAltura(NodoAVL nodo) {
		if (nodo != null) {
			return nodo.getAltura();
		} else {
			return 0;
		}
	}
	
	public void atualizaAltura() {
		this.altura = Math.max(getAltura(direito), getAltura(esquerdo)) + 1; 
	}

	@Override
	public String toString() {
		return String.valueOf(info);
	}

}






