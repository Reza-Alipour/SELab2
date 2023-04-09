package calculator;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class MyStepdefs {
    private Calculator calculator;
    private int value1;
    private int value2;
    private int result;
    private double doubleResult;
    private String opt;

    @Before
    public void before() {
        calculator = new Calculator();
    }

    @Given("^Two input values, (-?\\d+) and (-?\\d+)$")
    public void twoInputValuesAnd(int arg0, int arg1) {
        value1 = arg0;
        value2 = arg1;
    }


    @When("^I add the two values$")
    public void iAddTheTwoValues() {
        result = calculator.add(value1, value2);
        System.out.print(result);
    }

    @Then("^I expect the result (-?\\d+)$")
    public void iExpectTheResult(int arg0) {
        Assert.assertEquals(arg0, result);
    }

    @Then("^I expect the result to be (.+)$")
    public void iExpectTheResultToBeResult(String result) {
        if (result.equalsIgnoreCase("nan"))
            Assert.assertEquals(Double.NaN, doubleResult, 0.0001);
        else {
            double num = Double.parseDouble(result);
            Assert.assertEquals(num, doubleResult, 0.0001);
        }
    }

    @When("^I evaluate$")
    public void iEvaluate() {
        if (opt.equals("rvs"))
            doubleResult = calculator.reverse(value1);
        else
            doubleResult = calculator.sqrt(value1);
    }

    @Given("^One input value and opt, ([-+]?\\d+) (rvs|sqr)$")
    public void oneInputValueAndOptNumberOpt(int arg0, String arg1) {
        value1 = arg0;
        opt = arg1;
    }
}