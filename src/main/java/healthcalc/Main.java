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
		
		System.out.println("Hospital adapter:" + calcHospital.pesoIdeal('m', 180));
		System.out.println("Hospital adapter:" + calcHospital.bmr('m', 25, 180, 70));
		
		// Proxy
		
		StatsProxy calculadoraProxy = new StatsProxy();
		
		System.out.println("Hospital proxy:" + calculadoraProxy.pesoIdeal('m', 180));
		System.out.println("Hospital proxy:" + calculadoraProxy.bmr('m', 25, 180, 70));
		calculadoraProxy.bmr('w', 45, 190, 80);
		calculadoraProxy.bmr('w', 67, 170, 50);
		calculadoraProxy.bmr('m', 50, 180, 50);
		
		System.out.println("Altura media:" + calculadoraProxy.alturaMedia());
		System.out.println("Peso medio:" + calculadoraProxy.pesoMedio());
		System.out.println("Edad media:" + calculadoraProxy.edadMedia());
		System.out.println("BMR medio:" + calculadoraProxy.bmrMedio());
		System.out.println("Numero de hombres:" + calculadoraProxy.numSexoH());
		System.out.println("Numero de mujeres:" + calculadoraProxy.numSexoM());
		System.out.println("Numero total de pacientes:" + calculadoraProxy.numTotalPacientes());

	}
}
