package healthcalc.GUI;

import java.awt.EventQueue;
import healthcalc.HealthCalcImpl;

public class MainCalculadora {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthCalcImpl healthCalc = HealthCalcImpl.getInstance();
					CalculatorVista vista = new CalculatorVista();
					Controlador controlador = new Controlador(healthCalc, vista);
					vista.registerController(controlador);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
