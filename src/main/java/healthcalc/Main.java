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
	}
}
