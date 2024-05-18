package healthcalc;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcTest {

	private final HealthCalc healthcalc = HealthCalcImpl.getInstance();

	// Tests para la clase idealWeight

	@Test
	@DisplayName("Comprobar si height es menor que 84 para hombre")
	public void heightMenor84(){
		assertThrows(IllegalArgumentException.class, () -> healthcalc.idealWeight(83, 'm'));
		assertThrows(IllegalArgumentException.class, () -> healthcalc.idealWeight(-10, 'm'));
	}

	@Test
	@DisplayName("Comprobar si height es menor que 84 para hombre")
	public void heightMenor67(){
		assertThrows(IllegalArgumentException.class, () -> healthcalc.idealWeight(66, 'w'));
		assertThrows(IllegalArgumentException.class, () -> healthcalc.idealWeight(-10, 'w'));
	}

	@Test
	@DisplayName("Comprobar si height es mayor que 250")
	public void heightMayor250(){
		assertThrows(IllegalArgumentException.class, () -> healthcalc.idealWeight(251, 'm'));
		assertThrows(IllegalArgumentException.class, () -> healthcalc.idealWeight(251, 'w'));
	}

	@Test
	@DisplayName("Comprobar si el output es correcto para hombre")
	public void heightHombre() throws Exception{
		float res = 84 - 100 - (84 - 150) / 4f;
		assertEquals(res, healthcalc.idealWeight(84, 'm'));

		res = 180 - 100 - (180 - 150) / 4f;
		assertEquals(res, healthcalc.idealWeight(180, 'm'));

		res = 250 - 100 - (250 - 150) / 4f;
		assertEquals(res, healthcalc.idealWeight(250, 'm'));
	}

	@Test
	@DisplayName("Comprobar si el output es correcto para mujer")
	public void heightMujer() throws Exception{
		float res = 67 - 100 - (67 - 150) / 2.5f;
		assertEquals(res, healthcalc.idealWeight(67, 'w'));

		res = 180 - 100 - (180 - 150) / 2.5f;
		assertEquals(res, healthcalc.idealWeight(180, 'w'));

		res = 250 - 100 - (250 - 150) / 2.5f;
		assertEquals(res, healthcalc.idealWeight(250, 'w'));
	}

	@Test
	@DisplayName("Comprobar si no se lanza una excepción para los valores posibles de gender")
	public void genderNoException(){
		assertDoesNotThrow(() -> healthcalc.idealWeight(180, 'm'));
		assertDoesNotThrow(() -> healthcalc.idealWeight(180, 'M'));
		assertDoesNotThrow(() -> healthcalc.idealWeight(180, 'w'));
		assertDoesNotThrow(() -> healthcalc.idealWeight(180, 'W'));
	}

	@Test
	@DisplayName("Comprobar si se lanza una excepción cuando se inserta un char erróneo")
	public void genderException(){
		assertThrows(RuntimeException.class, () -> healthcalc.idealWeight(180, 'j'));
	}

	// Tests para la clase basalMetabolicRate

	@Test
	@DisplayName("Comprobar si weight lanza excepción fuera del rango (0, 500]")
	public void weightFueraRango(){
		assertThrows(IllegalArgumentException.class, () -> healthcalc.basalMetabolicRate(0, 180, 'm', 50));
		assertThrows(IllegalArgumentException.class, () -> healthcalc.basalMetabolicRate(500.1f, 180, 'm', 50));
		assertThrows(IllegalArgumentException.class, () -> healthcalc.basalMetabolicRate(-10, 180, 'm', 50));
	}

	@Test
	@DisplayName("Comprobar si height lanza excepción fuera del rango (0, 250]")
	public void heightFueraRango(){
		assertThrows(IllegalArgumentException.class, () -> healthcalc.basalMetabolicRate(50, 0, 'm', 50));
		assertThrows(IllegalArgumentException.class, () -> healthcalc.basalMetabolicRate(50, 251, 'm', 50));
		assertThrows(IllegalArgumentException.class, () -> healthcalc.basalMetabolicRate(50, -10, 'm', 50));
	}

	@Test
	@DisplayName("Comprobar si no se lanza una excepción para los valores posibles de gender")
	public void genderNoExceptionBasal(){
		assertDoesNotThrow(() -> healthcalc.basalMetabolicRate(50, 180, 'm', 50));
		assertDoesNotThrow(() -> healthcalc.basalMetabolicRate(50, 180, 'M', 50));
		assertDoesNotThrow(() -> healthcalc.basalMetabolicRate(50, 180, 'w', 50));
		assertDoesNotThrow(() -> healthcalc.basalMetabolicRate(50, 180, 'W', 50));
	}

	@Test
	@DisplayName("Comprobar si se lanza una excepción cuando se inserta un char erróneo")
	public void genderExceptionBasal(){
		assertThrows(RuntimeException.class, () -> healthcalc.basalMetabolicRate(50, 180, 'j', 50));
	}

	@Test
	@DisplayName("Comprobar si age lanza excepción fuera del rango (0, 150]")
	public void ageFueraRango(){
		assertThrows(IllegalArgumentException.class, () -> healthcalc.basalMetabolicRate(50, 180, 'm', 0));
		assertThrows(IllegalArgumentException.class, () -> healthcalc.basalMetabolicRate(50, 180, 'm', 151));
		assertThrows(IllegalArgumentException.class, () -> healthcalc.basalMetabolicRate(50, 180, 'm', -10));
	}

	@Test
	@DisplayName("Comprobar si se lanza una excepción cuando el resultado de la función es negativo")
	public void resultadoNegativo(){
		assertThrows(RuntimeException.class, () -> healthcalc.basalMetabolicRate(10, 10, 'm', 100));
		assertThrows(RuntimeException.class, () -> healthcalc.basalMetabolicRate(10, 10, 'w', 100));
	}

	@Test
	@DisplayName("Comprobar si el resultado es correcto cuando los argumentos están en rango")
	public void resultadoEnRango() throws Exception{
		// Hombre
		// BW = 0
		float res = 10 * 20.125f + 6.25f * 47 - 5 * 100 + 5;
		assertEquals(res, healthcalc.basalMetabolicRate(20.125f, 47, 'm', 100));
		// BW != 0
		res = 10 * 50 + 6.25f * 180 - 5 * 50 + 5;
		assertEquals(res, healthcalc.basalMetabolicRate(50, 180, 'm', 50));
		

		// Mujer
		// BW = 0
		res = 10 * 36.725f + 6.25f * 47 - 5 * 100 - 161;
		assertEquals(res, healthcalc.basalMetabolicRate(36.725f, 47, 'w', 100));
		// BW != 0
		res = 10 * 50 + 6.25f * 180 - 5 * 50 -161;
		assertEquals(res, healthcalc.basalMetabolicRate(50, 180, 'w', 50));
	}
}
