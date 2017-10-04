import cucumber.api.Delimiter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.deps.com.thoughtworks.xstream.annotations.XStreamConverter;
import org.junit.Before;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class soapTest {

    private List<String> result;

    @When("^i send string \\\"([^\\\"]*)\\\"$")
    public void newBook(String arg) {
        result=soap.checkString(arg);
    }

    @Then("^the result is (.+)$")
    public void the_result_should_be(@Delimiter(",") List<String> arg) {
        assertEquals(arg, result);
    }

}