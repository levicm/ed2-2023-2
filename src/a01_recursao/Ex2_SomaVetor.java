package a01_recursao;

public class Ex2_SomaVetor {

	public static void main(String[] args) {
		double[] vet1 = new double[] { 2.5, 3.5, 4.4, 6, 6 };
		System.out.println(soma(vet1, vet1.length - 1));
		System.out.println(soma2(vet1, vet1.length));

	}
	
	public static double soma(double[] vetor, int posicao) {
		if (posicao < 0) {
			return 0;
		} else {
			return vetor[posicao] + soma(vetor, posicao - 1);
		}
	}

	public static double soma2(double[] vetor, int tamanho) {
		if (tamanho <= 0) {
			return 0;
		} else {
			return vetor[tamanho - 1] + soma2(vetor, tamanho - 1);
		}
	}

}
