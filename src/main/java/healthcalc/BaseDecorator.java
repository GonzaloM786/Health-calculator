package healthcalc;

public abstract class BaseDecorator implements HealthHospital, HealthStats{
	
	private StatsProxy calculadora;
	
	public BaseDecorator() {
		calculadora = new StatsProxy();
	}
	
	
	@Override
	public double bmr(char genero, int edad, float altura, int peso) throws Exception {
		return calculadora.bmr(genero, edad, altura, peso);
	}

	@Override
	public int pesoIdeal(char genero, float altura) throws Exception {
		return calculadora.pesoIdeal(genero, altura);
	}
	
	@Override
	public float alturaMedia() {
		return calculadora.alturaMedia();
	}

	@Override
	public float pesoMedio() {
		return calculadora.pesoMedio();
	}

	@Override
	public float edadMedia() {
		return calculadora.edadMedia();
	}

	@Override
	public float bmrMedio() {
		return calculadora.bmrMedio();
	}

	@Override
	public int numSexoH() {
		return calculadora.numSexoH();
	}

	@Override
	public int numSexoM() {
		return calculadora.numSexoM();
	}

	@Override
	public int numTotalPacientes() {
		return calculadora.numTotalPacientes();
	}
	
}
