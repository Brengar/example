import cucumber.api.Delimiter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.deps.com.thoughtworks.xstream.annotations.XStreamConverter;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class xmlTest {

    private static List<String> arg;

    @When("^i put new book in catalog (.+)$")
    public void newBook(@Delimiter(",") List<String> arg) {
        this.arg=arg;
        xml.write(arg);
    }

    @Then("^this book apperas in catalog$")
    public void checkBook() {
        assertEquals(xml.check(arg), true);
    }

}
