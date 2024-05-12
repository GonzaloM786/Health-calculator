package healthcalc;

public class HospitalAdapter implements HealthHospital{

	private HealthCalc calculadora = HealthCalcImpl.getInstance();
	
	@Override
	public double bmr(char genero, int edad, float altura, int peso) throws Exception{
		float weight = Float.valueOf(peso);
		int height = Math.round(altura);
		
		return Double.valueOf(calculadora.basalMetabolicRate(weight, height, genero, edad));
	}

	@Override
	public int pesoIdeal(char genero, float altura) throws Exception{
		int height = Math.round(altura);
	
		return Math.round(calculadora.idealWeight(height, genero));
	}

}
