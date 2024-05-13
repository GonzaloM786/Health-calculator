package healthcalc;

public class Main {
	public static void main(String[] args) throws Exception{
		// SingleTone
		HealthCalcImpl calculadora1 = HealthCalcImpl.getInstance();
		HealthCalcImpl calculadora2 = HealthCalcImpl.getInstance();
		
		System.out.println("SingleTone:" + calculadora1.idealWeight(180, 'm'));
		System.out.println("SingleTone:" + calculadora2.idealWeight(180, 'm'));
		
		// Adaptador para el hospital
		
		HealthHospital calcHospital = new HospitalAdapter();
		
		System.out.println("Hospital adapter:" + calcHospital.pesoIdeal('m', (float) 1.8));
		System.out.println("Hospital adapter:" + calcHospital.bmr('m', 25, (float) 1.8, 70000));
		
		// Proxy
		
		StatsProxy calculadoraProxy = new StatsProxy();
		
		System.out.println("Hospital proxy:" + calculadoraProxy.pesoIdeal('m', (float) 1.8));
		System.out.println("Hospital proxy:" + calculadoraProxy.bmr('m', 25, (float) 1.8, 70000));
		calculadoraProxy.bmr('w', 45, (float) 1.9, 80000);
		calculadoraProxy.bmr('w', 67, (float) 1.7, 50000);
		calculadoraProxy.bmr('m', 50, (float) 1.8, 50000);
		
		System.out.println("Altura media:" + calculadoraProxy.alturaMedia());
		System.out.println("Peso medio:" + calculadoraProxy.pesoMedio());
		System.out.println("Edad media:" + calculadoraProxy.edadMedia());
		System.out.println("BMR medio:" + calculadoraProxy.bmrMedio());
		System.out.println("Numero de hombres:" + calculadoraProxy.numSexoH());
		System.out.println("Numero de mujeres:" + calculadoraProxy.numSexoM());
		System.out.println("Numero total de pacientes:" + calculadoraProxy.numTotalPacientes());

	}
}
