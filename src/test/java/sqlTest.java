import cucumber.api.Delimiter;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Random;
import static org.junit.Assert.assertEquals;
import cucumber.deps.com.thoughtworks.xstream.annotations.XStreamConverter;
import java.util.List;

public class sqlTest {

    private static List<String> arg;

    @When("^i put new book in base (.+)$")
    public void newBook(@Delimiter(",") List<String> arg) {
        this.arg=arg;
        sql.write(arg);
    }

    @Then("^this book appears in base$")
    public void check() {
        assertEquals(sql.check(arg), true);
    }

}
