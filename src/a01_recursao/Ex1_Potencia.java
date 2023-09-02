package a01_recursao;

public class Ex1_Potencia {

	public static void main(String[] args) {
		calculaPot(2, 4);
		calculaPot(2, 12);
		calculaPot(3, 5);		
	}
	
	public static void calculaPot(int b, int e) {
		int resultado = potencia(b, e);
		System.out.println(b + " ^ " + e + " = " + resultado);
	}

	private static int potencia(int b, int e) {
		System.out.println("potencia de " + b + ", " + e);
		if (e == 0) {
			System.out.println("Retornando 1...");
			return 1;
		} else {
			System.out.println("Descendo para " + (e-1));
			int potInf = potencia(b, e - 1);
			System.out.println("Voltou e vai calcular " + b + " * " + potInf);
			int result = b * potInf;
			System.out.println("Retornando " + result);
			return result;
		}
	}
}







