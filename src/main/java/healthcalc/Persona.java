package healthcalc;

public class Persona implements Person {

    private float peso;
    private float altura;
    private Gender genero;
    private int edad;

    public Persona(float peso, float altura, Gender genero, int edad) {
        this.peso = peso;
        this.altura = altura;
        this.genero = genero;
        this.edad = edad;
    }

    public Persona(float altura, Gender genero) {
        this.altura = altura;
        this.genero = genero;
    }

    @Override
    public float weight() {
        return this.peso;
    }

    @Override
    public float height() {
        return this.altura;
    }

    @Override
    public Gender gender() {
        return this.genero;
    }

    @Override
    public int age() {
        return this.edad;
    }

}
