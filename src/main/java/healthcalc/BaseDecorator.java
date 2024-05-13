package healthcalc;

public abstract class BaseDecorator implements HealthHospital{
	
	private HealthHospital calculadora;
	
	public BaseDecorator() {
		calculadora = new HospitalAdapter();
	}
	
	
	@Override
	public double bmr(char genero, int edad, float altura, int peso) throws Exception {
		return calculadora.bmr(genero, edad, altura, peso);
	}

	@Override
	public int pesoIdeal(char genero, float altura) throws Exception {
		return calculadora.pesoIdeal(genero, altura);
	}
	
}
