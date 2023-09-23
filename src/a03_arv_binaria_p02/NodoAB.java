package a03_arv_binaria_p02;

public class NodoAB {

	private Object info;
	private NodoAB pai;
	private NodoAB esquerdo;
	private NodoAB direito;
	
	public NodoAB(Object info) {
		this.info = info;
	}

	public Object getInfo() {
		return info;
	}

	public void setInfo(Object info) {
		this.info = info;
	}

	public NodoAB getPai() {
		return pai;
	}

	public void setPai(NodoAB pai) {
		this.pai = pai;
	}

	public NodoAB getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(NodoAB esquerdo) {
		this.esquerdo = esquerdo;
	}

	public NodoAB getDireito() {
		return direito;
	}

	public void setDireito(NodoAB direito) {
		this.direito = direito;
	}
}
