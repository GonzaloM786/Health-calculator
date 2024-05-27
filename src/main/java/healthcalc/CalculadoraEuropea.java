package healthcalc;

public class CalculadoraEuropea extends BaseDecorator {

	// Altura en metros y peso en gramos

	@Override
	public double bmr(char genero, int edad, float altura, int peso) throws Exception {
		double resultado = super.bmr(genero, edad, altura, peso);
		System.out.println("La persona con altura " + altura + " metros y " + Math.round(peso / 1000)
				+ " Kg tiene un BMR de " + resultado);
		System.out.println("The person " + altura + " meters tall and " + Math.round(peso / 1000) + " Kg has a BMR of "
				+ resultado);
		return resultado;
	}

	@Override
	public int pesoIdeal(char genero, float altura) throws Exception {
		return super.pesoIdeal(genero, altura);
	}

}