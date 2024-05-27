package healthcalc;

public class HospitalAdapter implements HealthHospital {

	private HealthCalcImpl calculadora = HealthCalcImpl.getInstance();

	// Altura en metros y peso en gramos

	@Override
	public double bmr(char genero, int edad, float altura, int peso) throws Exception {
		float weight = Float.valueOf(peso / 1000);
		int height = Math.round(altura * 100);

		Character genero_unificado = Character.toLowerCase(genero);
		Gender gender = null;
		if(genero_unificado == 'm'){
			gender = Gender.MALE;
		} else if(genero_unificado == 'w'){
			gender = Gender.FEMALE;
		}
		Persona persona = new Persona(weight, height, gender, edad);

		return Double.valueOf(calculadora.basalMetabolicRate(persona));
	}

	@Override
	public int pesoIdeal(char genero, float altura) throws Exception {
		int height = Math.round(altura * 100);

		Character genero_unificado = Character.toLowerCase(genero);
		Gender gender = null;
		if(genero_unificado == 'm'){
			gender = Gender.MALE;
		} else if(genero_unificado == 'w'){
			gender = Gender.FEMALE;
		}
		Persona persona = new Persona(height, gender);

		return (int) Math.round(calculadora.getIdealBodyWeight(persona));
	}

}
