package healthcalc;

public class StatsProxy implements HealthStats, HealthHospital{

	private float[] alturas;
	private int[] pesos;
	private int[] edades;
	
	@Override
	public float alturaMedia() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float pesoMedio() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float edadMedia() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float bmrMedio() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numSexoH() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numSexoM() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numTotalPacientes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double bmr(char genero, int edad, float altura, int peso) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int pesoIdeal(char genero, float altura) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
