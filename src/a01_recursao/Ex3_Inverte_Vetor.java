package a01_recursao;

public class Ex3_Inverte_Vetor {

	public static void main(String[] args) {
		double[] vet1 = new double[] { 2.5, 3.5, 4.4, 6, 7.8, 9.2 };
		imprime(vet1);

		inverte(vet1, 0, vet1.length - 1);
		imprime(vet1);

		inverte2(vet1, vet1.length - 1);
		imprime(vet1);
	}

	private static void inverte(double[] vetor, int esquerda, int direita) {
		if (esquerda > direita) {
			return;
		} else {
			double temp = vetor[esquerda];
			vetor[esquerda] = vetor[direita];
			vetor[direita] = temp;
			inverte(vetor, esquerda + 1, direita - 1);
		}
	}

	private static void inverte2(double[] vetor, int direita) {
		int esquerda = vetor.length - direita - 1;
		if (esquerda > direita) {
			return;
		} else {
			double temp = vetor[esquerda];
			vetor[esquerda] = vetor[direita];
			vetor[direita] = temp;
			inverte2(vetor, direita - 1);
		}
	}

	private static void imprime(double[] vetor) {
		System.out.print("[");
		for (int i = 0; i < vetor.length; i++) {
			if (i > 0) {
				System.out.print(", ");
			}
			System.out.print(vetor[i]);
		}
		System.out.println("]");
	}

}
