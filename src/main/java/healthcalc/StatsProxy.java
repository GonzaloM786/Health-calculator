package healthcalc;

import java.util.ArrayList;

public class StatsProxy implements HealthStats, HealthHospital {

	private static ArrayList<Float> alturas = new ArrayList<Float>();
	private static ArrayList<Integer> pesos = new ArrayList<Integer>();
	private static ArrayList<Integer> edades = new ArrayList<Integer>();
	private static int numH = 0;
	private static int numM = 0;
	private static ArrayList<Double> lista_bmr = new ArrayList<Double>();
	private static HealthHospital calculadora = new HospitalAdapter();

	public StatsProxy() {

	}

	private static <T extends Number> float calcularMedia(ArrayList<T> lista) {
		float suma = 0;

		for (T numero : lista) {
			suma += numero.floatValue();
		}
		return suma / lista.size();
	}

	@Override
	public float alturaMedia() {
		return calcularMedia(alturas);
	}

	@Override
	public float pesoMedio() {
		return calcularMedia(pesos);
	}

	@Override
	public float edadMedia() {
		return calcularMedia(edades);
	}

	@Override
	public float bmrMedio() {
		return calcularMedia(lista_bmr);
	}

	@Override
	public int numSexoH() {
		return numH;
	}

	@Override
	public int numSexoM() {
		return numM;
	}

	@Override
	public int numTotalPacientes() {
		return numM + numH;
	}

	@Override
	public double bmr(char genero, int edad, float altura, int peso) throws Exception {
		if (genero == 'm' || genero == 'M') {
			numH += 1;
		} else {
			numM += 1;
		}
		edades.add(edad);
		alturas.add(altura);
		pesos.add(peso);

		double resultado = calculadora.bmr(genero, edad, altura, peso);

		lista_bmr.add(resultado);
		return resultado;
	}

	@Override
	public int pesoIdeal(char genero, float altura) throws Exception {
		if (genero == 'm' || genero == 'M') {
			numH += 1;
		} else {
			numM += 1;
		}
		alturas.add(altura);

		int resultado = calculadora.pesoIdeal(genero, altura);
		return resultado;
	}

}
