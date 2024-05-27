package healthcalc.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import healthcalc.Gender;
import healthcalc.HealthCalcImpl;
import healthcalc.Persona;

public class Controlador implements ActionListener {

	private HealthCalcImpl calculadora;

	private CalculatorVista vista;

	private Gender gender;
	private float height;
	private int weight;
	private int age;
	private double resultado_bmr;
	private double resultado_imc;

	public Controlador(HealthCalcImpl calc, CalculatorVista vista) {
		this.calculadora = calc;
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();
		if (command.equalsIgnoreCase("Male")) {
			gender = Gender.MALE;
			vista.getbMale().setBackground(Color.ORANGE);
			vista.getbFemale().setBackground(Color.WHITE);

		} else if (command.equalsIgnoreCase("Female")) {
			gender = Gender.FEMALE;
			vista.getbFemale().setBackground(Color.ORANGE);
			vista.getbMale().setBackground(Color.WHITE);
		} else if (command.equalsIgnoreCase("IMC")) {
			try {
				height = Float.parseFloat(String.valueOf(vista.getSpinner_Height().getValue()));
				Persona persona = new Persona(height, gender);
				resultado_imc = calculadora.getIdealBodyWeight(persona);
				vista.setTextField_IMC(resultado_imc);
			} catch (Exception ex) {
				vista.errorIMC();
			}

		} else if (command.equalsIgnoreCase("BMR")) {
			try {
				height = Float.parseFloat(String.valueOf(vista.getSpinner_Height().getValue()));
				weight = Integer.parseInt(vista.getTextField_Weight().getText());
				age = (Integer) vista.getSpinner_Age().getValue();
				Persona persona = new Persona(weight, height, gender, age);
				resultado_bmr = calculadora.basalMetabolicRate(persona);
				vista.setTextField_BMR(resultado_bmr);
			} catch (Exception ex) {
				vista.errorBMR();
			}
		}

	}

}
