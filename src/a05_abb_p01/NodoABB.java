package a05_abb_p01;

public class NodoABB {
	private Comparable info;
	private NodoABB pai;
	private NodoABB esquerdo;
	private NodoABB direito;

	public NodoABB(Comparable info) {
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
	
	public int nivel()  {
		int result = 1;
		NodoABB pai = getPai();
		while (pai != null) {
			result++;
			pai = pai.getPai();
		}
		return result;
	}
	
	public int altura() {
		return medeAltura(this, 1);
	}
	
	private static int medeAltura(NodoABB nodo, int altura) {
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

	public NodoABB getPai() {
		return pai;
	}

	public void setPai(NodoABB pai) {
		this.pai = pai;
	}

	public NodoABB getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(NodoABB esquerdo) {
		this.esquerdo = esquerdo;
	}

	public NodoABB getDireito() {
		return direito;
	}

	public void setDireito(NodoABB direito) {
		this.direito = direito;
	}
	
	@Override
	public String toString() {
		return String.valueOf(info);
	}
	
}
