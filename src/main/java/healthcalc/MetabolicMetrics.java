package healthcalc;

public class MetabolicMetrics {

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
                throw new RuntimeException("El resultado de la operación es negativo");
            } else {
                return resultado;
            }
        }
    }
}
