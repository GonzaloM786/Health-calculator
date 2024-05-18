package healthcalc;

public class CardiovascularMetrics {

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
