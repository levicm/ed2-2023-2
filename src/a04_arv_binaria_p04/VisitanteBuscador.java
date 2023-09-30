package a04_arv_binaria_p04;

public class VisitanteBuscador implements Visitante {

	private Object infoBusca;
	private NodoAB resultado;

	public VisitanteBuscador(Object infoBusca) {
		this.infoBusca = infoBusca;
	}

	public void visita(NodoAB nodo) {
		if (infoBusca.equals(nodo.getInfo())) {
			resultado = nodo;
		}
	}

	public NodoAB getResultado() {
		return resultado;
	}
}
