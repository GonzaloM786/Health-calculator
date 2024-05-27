package healthcalc.GUI;

import java.awt.EventQueue;
import healthcalc.HealthCalcImpl;

public class MainCalculadora {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthCalcImpl calculadora = HealthCalcImpl.getInstance();
					CalculatorVista vista = new CalculatorVista();
					Controlador controlador = new Controlador(calculadora, vista);
					vista.registerController(controlador);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
