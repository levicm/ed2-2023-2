package a03_arv_binaria_p02;

public class ImpressaoVisitante implements Visitante {

	@Override
	public void visita(NodoAB nodo) {
		System.out.println(nodo.getInfo());
	}

}
