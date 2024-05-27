package healthcalc;

public class HealthCalcImpl implements CardiovascularMetrics, MetabolicMetrics {
	
	// Patron SingleTone
	private static HealthCalcImpl instance;
	
	private HealthCalcImpl() {
		
	}
	
	public static HealthCalcImpl getInstance() {
		if(instance == null) {
			instance = new HealthCalcImpl();
		}
		return instance;
	}

    @Override
    public double basalMetabolicRate(Persona persona) {
        float peso = persona.weight();
        float altura = persona.height();
        int edad = persona.age();

        if (peso <= 0 || peso > 500 || altura <= 0 || altura > 250 || edad <= 0 || edad > 150) {
            throw new IllegalArgumentException("Argumentos no válidos");
        } else {
            float resultado;
            if (persona.gender() == Gender.MALE) {
                resultado = 10 * peso + 6.25f * altura - 5 * edad + 5;
            } else {
                resultado = 10 * peso + 6.25f * altura - 5 * edad - 161;
            }
            if (resultado < 0) {
                throw new IllegalArgumentException("El resultado de la operación es negativo");
            } else {
                return resultado;
            }
        }
    }

    @Override
    public double getIdealBodyWeight(Person persona) {
        float altura = persona.height();
        if (altura > 250) {
            throw new IllegalArgumentException("La altura es demasiado grande");
        }
        if (persona.gender() == Gender.MALE) {
            if (altura < 84) {
                throw new IllegalArgumentException("La altura es demasiado pequeña");
            } else {
                return altura - 100 - (altura - 150) / 4f;
            }
        } else {
            if (altura < 67) {
                throw new IllegalArgumentException("La altura es demasiado pequeña");
            } else {
                return altura - 100 - (altura - 150) / 2.5f;
            }
        }
    }
    
}