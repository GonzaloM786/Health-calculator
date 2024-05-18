package healthcalc.GUI;

import java.awt.EventQueue;
import healthcalc.CalculadoraEuropea;
import healthcalc.CardiovascularMetrics;
import healthcalc.MetabolicMetrics;

public class MainCalculadora {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardiovascularMetrics calc_card = new CardiovascularMetrics();
					MetabolicMetrics calc_metab = new MetabolicMetrics();
					CalculatorVista vista = new CalculatorVista();
					Controlador controlador = new Controlador(calc_card, calc_metab, vista);
					vista.registerController(controlador);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
