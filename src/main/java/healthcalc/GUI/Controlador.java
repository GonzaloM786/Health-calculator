package healthcalc.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import healthcalc.HealthCalcImpl;

public class Controlador implements ActionListener{

	private HealthCalcImpl calculadora;
	private CalculatorVista vista;
	
	private char gender;
	private int height;
	private float weight;
	private int age;
	private float resultado;
	
	
	public Controlador(HealthCalcImpl calc, CalculatorVista vista) {
		this.calculadora = calc;
		this.vista = vista;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		if(command.equalsIgnoreCase("Male")) {
			gender = 'm';
			vista.getbMale().setBackground(Color.ORANGE);
			vista.getbFemale().setBackground(Color.WHITE);
			
		}else if(command.equalsIgnoreCase("Female")) {
			gender = 'w';
			vista.getbFemale().setBackground(Color.ORANGE);
			vista.getbMale().setBackground(Color.WHITE);
		}else if(command.equalsIgnoreCase("IMC")) {
			try {
				height = (Integer) vista.getSpinner_Height().getValue();
				resultado = calculadora.idealWeight(height, gender);
				vista.setTextField_IMC(resultado);
			}catch(Exception ex) {
				vista.errorIMC();
			}
			
			
		}else if(command.equalsIgnoreCase("BMR")) {
			try {
				height = (Integer) vista.getSpinner_Height().getValue();
				weight = Float.parseFloat(vista.getTextField_Weight().getText());
				age = (Integer) vista.getSpinner_Age().getValue();
				resultado = calculadora.basalMetabolicRate(weight, height, gender, age);
				vista.setTextField_BMR(resultado);
			}catch(Exception ex) {
				vista.errorBMR();
			}
		}
		
	}

	
}
