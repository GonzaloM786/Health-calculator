package cucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import healthcalc.HealthCalc;
import healthcalc.HealthCalcImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BMRSteps {
    private final HealthCalc healthcalc = new HealthCalcImpl();
    private float res;
    private int height;
    private char gender;
    private float weight;
    private int age;

    @Given("the height as {int}, weight as {float}, age as {int} and gender as {char} are correct")
    public void givenParametersAreCorrect(int height, float weight, int age, char gender) {
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.gender = gender;
    }

    @Given("the gender is not correct")
    public void givenGenderIsNotCorrect() {
        this.height = 100;
        this.weight = 100;
        this.age = 50;
        this.gender = 'j';
    }

    @Given("the result is negative")
    public void givenResultIsNegative() {
        this.res = -1;
    }

    @When("i press the calculate button")
    public void whenPressCalculateButton() throws Exception {
        res = healthcalc.basalMetabolicRate(weight, height, gender, age);
    }

    @Then("the result as {float} is returned")
    public void thenResultIsReturned(float result) {
        assertEquals(result, res);
    }

    @Then("an error message indicates the gender is not correct")
    public void thenErrorMessageGenderNotCorrect() {
        assertThrows(IllegalArgumentException.class, () -> healthcalc.basalMetabolicRate(weight, height, gender, age));
    }

    @Then("an error message indicates the parameters are not correct")
    public void thenErrorMessageParametersNotCorrect() {
        assertThrows(IllegalArgumentException.class, () -> healthcalc.basalMetabolicRate(weight, height, gender, age));
    }
}
