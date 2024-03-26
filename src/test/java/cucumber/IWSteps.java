package cucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import healthcalc.HealthCalc;
import healthcalc.HealthCalcImpl;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IWSteps {

    private final HealthCalc healthcalc = new HealthCalcImpl();
    private float res;
    private int height;
    private char gender;

    @Given("the height as {int} is correct")
    public void givenHeightIsCorrect(int height) {
        this.height = height;
    }

    @Given("the gender as {string} is correct")
    public void givenGenderIsCorrect(char gender) {
        this.gender = gender;
    }

    @Given("the gender as {string} is not correct")
    public void givenGenderIsNotCorrect(char gender) {
        this.gender = gender;
    }

    @Given("the height as {int} is not correct")
    public void givenHeightIsNotCorrect(int height) {
        this.height = height;
    }

    @When("i press the calculate button")
    public void whenPressCalculateButton() throws Exception {
        res = healthcalc.idealWeight(height, gender);
    }

    @Then("the result as {float} is returned")
    public void thenResultIsReturned(float result) {
        assertEquals(result, res);
    }

    @Then("an error message indicates the gender is not correct")
    public void thenErrorMessageGenderNotCorrect() {
        assertThrows(IllegalArgumentException.class, () -> healthcalc.idealWeight(height, gender));
    }

    @Then("an error message indicates the height is not correct")
    public void thenErrorMessageHeightNotCorrect() {
        assertThrows(IllegalArgumentException.class, () -> healthcalc.idealWeight(height, gender));
    }
    
}
