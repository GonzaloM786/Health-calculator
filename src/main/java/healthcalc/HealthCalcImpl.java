package healthcalc;

public class HealthCalcImpl implements HealthCalc {

    @Override
    public float idealWeight(int height, char gender) throws Exception {
        Character genero = Character.toLowerCase(gender);
        if (genero != 'm' && genero != 'w') {
            throw new RuntimeException("El género no es correcto");
        } else if (height > 250) {
            throw new IllegalArgumentException("La altura es demasiado grande");
        } else {
            if (genero == 'm') {
                if (height < 84) {
                    throw new IllegalArgumentException("La altura es demasiado pequeña");
                } else {
                    return height - 100 - (height - 150) / 4f;
                }
            } else {
                if (height < 67) {
                    throw new IllegalArgumentException("La altura es demasiado pequeña");
                } else {
                    return height - 100 - (height - 150) / 2.5f;
                }
            }
        }
    }

    @Override
    public float basalMetabolicRate(float weight, int height, char gender, int age) throws Exception {
        Character genero = Character.toLowerCase(gender);
        if ((genero != 'm' && genero != 'w')
                || (weight <= 0 || weight > 500 || height <= 0 || height > 250 || age <= 0 || age > 150)) {
            throw new IllegalArgumentException("Argumentos no válidos");
        } else {
            float resultado;
            if (genero == 'm') {
                resultado = 10 * weight + 6.25f * height - 5 * age + 5;
            } else {
                resultado = 10 * weight + 6.25f * height - 5 * age - 161;
            }
            if (resultado < 0) {
                throw new RuntimeException("El resultado de la operación es negativo");
            } else {
                return resultado;
            }
        }
    }

}