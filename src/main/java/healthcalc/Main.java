package healthcalc;
import healthcalc.HealthCalcImpl;

public class Main {
	public static void main(String[] args) throws Exception{
		HealthCalcImpl calculadora = HealthCalcImpl.getInstance();
		
		System.out.println(calculadora.idealWeight(180, 'm'));
	}
}
