package healthcalc.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import healthcalc.CalculadoraEuropea;

public class Controlador implements ActionListener {

	private CalculadoraEuropea calculadora;
	private CalculatorVista vista;

	private char gender;
	private float height;
	private int weight;
	private int age;
	private double resultado_bmr;
	private int resultado_imc;

	public Controlador(CalculadoraEuropea calc, CalculatorVista vista) {
		this.calculadora = calc;
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();
		if (command.equalsIgnoreCase("Male")) {
			gender = 'm';
			vista.getbMale().setBackground(Color.ORANGE);
			vista.getbFemale().setBackground(Color.WHITE);

		} else if (command.equalsIgnoreCase("Female")) {
			gender = 'w';
			vista.getbFemale().setBackground(Color.ORANGE);
			vista.getbMale().setBackground(Color.WHITE);
		} else if (command.equalsIgnoreCase("IMC")) {
			try {
				height = Float.parseFloat(String.valueOf(vista.getSpinner_Height().getValue()));
				resultado_imc = calculadora.pesoIdeal(gender, height);
				vista.setTextField_IMC(resultado_imc);
			} catch (Exception ex) {
				vista.errorIMC();
			}

		} else if (command.equalsIgnoreCase("BMR")) {
			try {
				height = Float.parseFloat(String.valueOf(vista.getSpinner_Height().getValue()));
				weight = Integer.parseInt(vista.getTextField_Weight().getText());
				age = (Integer) vista.getSpinner_Age().getValue();
				resultado_bmr = calculadora.bmr(gender, age, height, weight);
				vista.setTextField_BMR(resultado_bmr);
			} catch (Exception ex) {
				vista.errorBMR();
			}
		}

	}

}
