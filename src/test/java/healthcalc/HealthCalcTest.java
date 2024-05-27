package healthcalc;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcTest {

	private final HealthCalcImpl calc = HealthCalcImpl.getInstance();

	// Tests para la clase idealWeight

	@Test
	@DisplayName("Comprobar si height es menor que 84 para hombre")
	public void heightMenor84(){
		Persona p1 = new Persona(83, Gender.MALE);
		Persona p2 = new Persona(-10, Gender.MALE);
		assertThrows(IllegalArgumentException.class, () -> calc.getIdealBodyWeight(p1));
		assertThrows(IllegalArgumentException.class, () -> calc.getIdealBodyWeight(p2));
	}

	@Test
	@DisplayName("Comprobar si height es menor que 67 para mujer")
	public void heightMenor67(){
		Persona p1 = new Persona(66, Gender.FEMALE);
		Persona p2 = new Persona(-10, Gender.FEMALE);
		assertThrows(IllegalArgumentException.class, () -> calc.getIdealBodyWeight(p1));
		assertThrows(IllegalArgumentException.class, () -> calc.getIdealBodyWeight(p2));
	}

	@Test
	@DisplayName("Comprobar si height es mayor que 250")
	public void heightMayor250(){
		Persona p1 = new Persona(251, Gender.MALE);
		Persona p2 = new Persona(251, Gender.FEMALE);
		assertThrows(IllegalArgumentException.class, () -> calc.getIdealBodyWeight(p1));
		assertThrows(IllegalArgumentException.class, () -> calc.getIdealBodyWeight(p2));
	}

	@Test
	@DisplayName("Comprobar si el output es correcto para hombre")
	public void heightHombre() throws Exception{
		Persona p1 = new Persona(84, Gender.MALE);
		double res = 84 - 100 - (84 - 150) / 4f;
		assertEquals(res, calc.getIdealBodyWeight(p1));

		Persona p2 = new Persona(180, Gender.MALE);
		res = 180 - 100 - (180 - 150) / 4f;
		assertEquals(res, calc.getIdealBodyWeight(p2));

		Persona p3 = new Persona(250, Gender.MALE);
		res = 250 - 100 - (250 - 150) / 4f;
		assertEquals(res, calc.getIdealBodyWeight(p3));
	}

	@Test
	@DisplayName("Comprobar si el output es correcto para mujer")
	public void heightMujer() throws Exception{
		Persona p1 = new Persona(67, Gender.FEMALE);
		double res = 67 - 100 - (67 - 150) / 2.5f;
		assertEquals(res, calc.getIdealBodyWeight(p1));

		Persona p2 = new Persona(180, Gender.FEMALE);
		res = 180 - 100 - (180 - 150) / 2.5f;
		assertEquals(res, calc.getIdealBodyWeight(p2));

		Persona p3 = new Persona(250, Gender.FEMALE);
		res = 250 - 100 - (250 - 150) / 2.5f;
		assertEquals(res, calc.getIdealBodyWeight(p3));
	}

	@Test
	@DisplayName("Comprobar si no se lanza una excepción para los valores posibles de gender")
	public void genderNoException(){
		Persona p1 = new Persona(180, Gender.FEMALE);
		Persona p2 = new Persona(180, Gender.MALE);
		assertDoesNotThrow(() -> calc.getIdealBodyWeight(p1));
		assertDoesNotThrow(() -> calc.getIdealBodyWeight(p2));
	}

	/* 
	@Test
	@DisplayName("Comprobar si se lanza una excepción cuando se inserta un char erróneo")
	public void genderException(){
		assertThrows(RuntimeException.class, () -> healthcalc.idealWeight(180, 'j'));
	}
	*/

	// Tests para la clase basalMetabolicRate

	@Test
	@DisplayName("Comprobar si weight lanza excepción fuera del rango (0, 500]")
	public void weightFueraRango(){
		Persona p1 = new Persona(0, 180, Gender.MALE, 50);
		Persona p2 = new Persona(500.1f, 180, Gender.MALE, 50);
		Persona p3 = new Persona(-10, 180, Gender.MALE, 50);
		assertThrows(IllegalArgumentException.class, () -> calc.basalMetabolicRate(p1));
		assertThrows(IllegalArgumentException.class, () -> calc.basalMetabolicRate(p2));
		assertThrows(IllegalArgumentException.class, () -> calc.basalMetabolicRate(p3));
	}

	@Test
	@DisplayName("Comprobar si height lanza excepción fuera del rango (0, 250]")
	public void heightFueraRango(){
		Persona p1 = new Persona(50, 0, Gender.MALE, 50);
		Persona p2 = new Persona(50, 251, Gender.MALE, 50);
		Persona p3 = new Persona(50, -10, Gender.MALE, 50);
		assertThrows(IllegalArgumentException.class, () -> calc.basalMetabolicRate(p1));
		assertThrows(IllegalArgumentException.class, () -> calc.basalMetabolicRate(p2));
		assertThrows(IllegalArgumentException.class, () -> calc.basalMetabolicRate(p3));
	}

	@Test
	@DisplayName("Comprobar si no se lanza una excepción para los valores posibles de gender")
	public void genderNoExceptionBasal(){
		Persona p1 = new Persona(50, 180, Gender.MALE, 50);
		Persona p2 = new Persona(50, 181, Gender.FEMALE, 50);
		assertDoesNotThrow(() -> calc.basalMetabolicRate(p1));
		assertDoesNotThrow(() -> calc.basalMetabolicRate(p2));
	}

	/* 
	@Test
	@DisplayName("Comprobar si se lanza una excepción cuando se inserta un char erróneo")
	public void genderExceptionBasal(){
		assertThrows(RuntimeException.class, () -> healthcalc.basalMetabolicRate(50, 180, 'j', 50));
	}
	*/

	@Test
	@DisplayName("Comprobar si age lanza excepción fuera del rango (0, 150]")
	public void ageFueraRango(){
		Persona p1 = new Persona(50, 180, Gender.MALE, 0);
		Persona p2 = new Persona(50, 180, Gender.MALE, 151);
		Persona p3 = new Persona(50, 180, Gender.MALE, -10);
		assertThrows(IllegalArgumentException.class, () -> calc.basalMetabolicRate(p1));
		assertThrows(IllegalArgumentException.class, () -> calc.basalMetabolicRate(p2));
		assertThrows(IllegalArgumentException.class, () -> calc.basalMetabolicRate(p3));
	}

	@Test
	@DisplayName("Comprobar si se lanza una excepción cuando el resultado de la función es negativo")
	public void resultadoNegativo(){
		Persona p1 = new Persona(10, 10, Gender.MALE, 100);
		Persona p2 = new Persona(10, 10, Gender.FEMALE, 100);
		assertThrows(IllegalArgumentException.class, () -> calc.basalMetabolicRate(p1));
		assertThrows(IllegalArgumentException.class, () -> calc.basalMetabolicRate(p2));
	}

	@Test
	@DisplayName("Comprobar si el resultado es correcto cuando los argumentos están en rango")
	public void resultadoEnRango() throws Exception{
		// Hombre
		// BW = 0
		Persona p1 = new Persona(20.125f, 47, Gender.MALE, 100);
		double res = 10 * 20.125f + 6.25f * 47 - 5 * 100 + 5;
		assertEquals(res, calc.basalMetabolicRate(p1));
		// BW != 0
		Persona p2 = new Persona(50, 180, Gender.MALE, 50);
		res = 10 * 50 + 6.25f * 180 - 5 * 50 + 5;
		assertEquals(res, calc.basalMetabolicRate(p2));
		

		// Mujer
		// BW = 0
		Persona p3 = new Persona(36.725f, 47, Gender.FEMALE, 100);
		res = 10 * 36.725f + 6.25f * 47 - 5 * 100 - 161;
		assertEquals(res, calc.basalMetabolicRate(p3));
		// BW != 0
		Persona p4 = new Persona(50, 180, Gender.FEMALE, 50);
		res = 10 * 50 + 6.25f * 180 - 5 * 50 -161;
		assertEquals(res, calc.basalMetabolicRate(p4));
	}
}
