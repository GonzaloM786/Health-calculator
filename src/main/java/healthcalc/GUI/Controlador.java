package healthcalc.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import healthcalc.CalculadoraEuropea;
import healthcalc.CardiovascularMetrics;
import healthcalc.Gender;
import healthcalc.MetabolicMetrics;
import healthcalc.Persona;

public class Controlador implements ActionListener {

	private MetabolicMetrics calculadora_metabolica;
	private CardiovascularMetrics calculadora_cardiovascular;

	private CalculatorVista vista;

	private Gender gender;
	private float height;
	private int weight;
	private int age;
	private double resultado_bmr;
	private double resultado_imc;

	public Controlador(CardiovascularMetrics calc_card, MetabolicMetrics calc_metab, CalculatorVista vista) {
		this.calculadora_metabolica = calc_metab;
		this.calculadora_cardiovascular = calc_card;
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
				resultado_imc = calculadora_cardiovascular.getIdealBodyWeight(persona);
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
				resultado_bmr = calculadora_metabolica.basalMetabolicRate(persona);
				vista.setTextField_BMR(resultado_bmr);
			} catch (Exception ex) {
				vista.errorBMR();
			}
		}

	}

}
