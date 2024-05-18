package healthcalc.GUI;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;

public class CalculatorVista {

	private JFrame frame;
	private JTextField textField_Weight;
	private JSpinner spinner_Height;
	private JTextField textField_BMR;
	private JTextField textField_IMC;
	private JSpinner spinner_Age;
	private JButton bBMR;
	private JButton bIMC;
	private JButton bMale;
	private JButton bFemale;

	// /**
	// * Launch the application.
	// */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// CalculatorVista window = new CalculatorVista();
	// window.frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the application.
	 */
	public CalculatorVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 510, 635);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		bFemale = new JButton("Female");
		bFemale.setFont(new Font("Tahoma", Font.PLAIN, 19));
		bFemale.setBounds(340, 137, 95, 55);
		frame.getContentPane().add(bFemale);

		bMale = new JButton("Male");
		bMale.setFont(new Font("Tahoma", Font.PLAIN, 19));
		bMale.setBounds(186, 137, 95, 55);
		frame.getContentPane().add(bMale);

		JLabel lblNewLabel = new JLabel("HEALTH CALCULATOR");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(79, 28, 335, 37);
		frame.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		panel.setBounds(0, 0, 494, 86);
		frame.getContentPane().add(panel);

		JLabel lblNewLabel_1 = new JLabel("Gender");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(59, 149, 68, 30);
		frame.getContentPane().add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 236, 494, 2);
		frame.getContentPane().add(panel_1);

		spinner_Height = new JSpinner();
		spinner_Height.setBounds(342, 313, 100, 20);
		frame.getContentPane().add(spinner_Height);

		JLabel lblNewLabel_1_1 = new JLabel("Height (cm)");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_1.setBounds(334, 264, 108, 30);
		frame.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Weight (kg)");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_2.setBounds(50, 264, 108, 30);
		frame.getContentPane().add(lblNewLabel_1_2);

		textField_Weight = new JTextField();
		textField_Weight.setBounds(50, 313, 100, 20);
		frame.getContentPane().add(textField_Weight);
		textField_Weight.setColumns(10);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.BLACK);
		panel_1_1.setBounds(0, 363, 494, 2);
		frame.getContentPane().add(panel_1_1);

		JLabel lblNewLabel_1_2_1 = new JLabel("Calculate");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_2_1.setBounds(205, 387, 83, 30);
		frame.getContentPane().add(lblNewLabel_1_2_1);

		bIMC = new JButton("IMC");
		bIMC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bIMC.setFont(new Font("Tahoma", Font.PLAIN, 19));
		bIMC.setBounds(94, 435, 92, 55);
		frame.getContentPane().add(bIMC);

		bBMR = new JButton("BMR");
		bBMR.setFont(new Font("Tahoma", Font.PLAIN, 19));
		bBMR.setBounds(94, 516, 92, 55);
		frame.getContentPane().add(bBMR);

		textField_BMR = new JTextField();
		textField_BMR.setColumns(10);
		textField_BMR.setBounds(280, 537, 120, 20);
		frame.getContentPane().add(textField_BMR);

		textField_IMC = new JTextField();
		textField_IMC.setColumns(10);
		textField_IMC.setBounds(280, 456, 120, 20);
		frame.getContentPane().add(textField_IMC);

		JLabel lblNewLabel_1_1_1 = new JLabel("Age");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_1_1.setBounds(226, 264, 42, 30);
		frame.getContentPane().add(lblNewLabel_1_1_1);

		spinner_Age = new JSpinner();
		spinner_Age.setBounds(200, 313, 92, 20);
		frame.getContentPane().add(spinner_Age);

		// frame.pack();
		frame.setVisible(true);

	}

	public void registerController(ActionListener ctrl) {
		bIMC.addActionListener(ctrl);
		bIMC.setActionCommand("IMC");

		bBMR.addActionListener(ctrl);
		bBMR.setActionCommand("BMR");

		bMale.addActionListener(ctrl);
		bMale.setActionCommand("Male");

		bFemale.addActionListener(ctrl);
		bFemale.setActionCommand("Female");
	}

	public JTextField getTextField_Weight() {
		return textField_Weight;
	}

	public JSpinner getSpinner_Height() {
		return spinner_Height;
	}

	public JSpinner getSpinner_Age() {
		return spinner_Age;
	}

	public JButton getbBMR() {
		return bBMR;
	}

	public JButton getbIMC() {
		return bIMC;
	}

	public JButton getbMale() {
		return bMale;
	}

	public JButton getbFemale() {
		return bFemale;
	}

	public void setTextField_BMR(double res) {
		this.textField_BMR.setText(String.valueOf(res));
	}

	public void setTextField_IMC(double res) {
		this.textField_IMC.setText(String.valueOf(res));
	}

	public void errorIMC() {
		JOptionPane.showMessageDialog(frame, "Error al calcular el IMC. Altura o genero incorrectos.");
	}

	public void errorBMR() {
		JOptionPane.showMessageDialog(frame, "Error al calcular el BMR. Altura, genero, peso o edad incorrectos.");
	}

}
