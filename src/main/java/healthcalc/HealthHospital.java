package healthcalc;

public interface HealthHospital {

	public double bmr(char genero, int edad, float altura, int peso) throws Exception;

	public int pesoIdeal(char genero, float altura) throws Exception;
}
