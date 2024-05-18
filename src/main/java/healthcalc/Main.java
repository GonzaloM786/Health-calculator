package healthcalc;

public class Main {
	public static void main(String[] args) throws Exception {
		// Adaptador para el hospital

		HealthHospital calcHospital = new HospitalAdapter();

		System.out.println("Hospital adapter peso ideal: " + calcHospital.pesoIdeal('m', (float) 1.8));
		System.out.println("Hospital adapter bmr: " + calcHospital.bmr('m', 25, (float) 1.8, 70000));
		System.out.println("---------------------------------------");
		// Proxy

		StatsProxy calculadoraProxy = new StatsProxy();

		System.out.println("Hospital proxy peso ideal: " + calculadoraProxy.pesoIdeal('m', (float) 1.8));
		System.out.println("Hospital proxy bmr: " + calculadoraProxy.bmr('m', 25, (float) 1.8, 70000));
		calculadoraProxy.bmr('w', 45, (float) 1.9, 80000);
		calculadoraProxy.bmr('w', 67, (float) 1.7, 50000);
		calculadoraProxy.bmr('m', 50, (float) 1.8, 50000);

		System.out.println("Altura media: " + calculadoraProxy.alturaMedia());
		System.out.println("Peso medio: " + calculadoraProxy.pesoMedio());
		System.out.println("Edad media: " + calculadoraProxy.edadMedia());
		System.out.println("BMR medio: " + calculadoraProxy.bmrMedio());
		System.out.println("Numero de hombres: " + calculadoraProxy.numSexoH());
		System.out.println("Numero de mujeres: " + calculadoraProxy.numSexoM());
		System.out.println("Numero total de pacientes: " + calculadoraProxy.numTotalPacientes());
		System.out.println("---------------------------------------");
		// Decoradores

		BaseDecorator calculadora_europea = new CalculadoraEuropea();
		BaseDecorator calculadora_americana = new CalculadoraAmericana();

		calculadora_europea.bmr('m', 25, (float) 1.8, 70000);
		calculadora_americana.bmr('m', 25, (float) 5.9, 154);
		System.out.println("");

		System.out.println("Calculadora europea peso ideal: " + calculadora_europea.pesoIdeal('m', (float) 1.8));
		System.out.println("Calculadora americana peso ideal: " + calculadora_americana.pesoIdeal('m', (float) 5.9));

		System.out.println("Altura media: " + calculadora_europea.alturaMedia());
		System.out.println("Peso medio: " + calculadora_americana.pesoMedio());
		System.out.println("Edad media: " + calculadora_europea.edadMedia());
		System.out.println("BMR medio: " + calculadora_americana.bmrMedio());
		System.out.println("Numero de hombres: " + calculadora_europea.numSexoH());
		System.out.println("Numero de mujeres: " + calculadora_americana.numSexoM());
		System.out.println("Numero total de pacientes: " + calculadora_europea.numTotalPacientes());

	}
}
