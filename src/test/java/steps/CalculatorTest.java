package steps;//******************************************************************************
//
// Copyright (c) 2016 Microsoft Corporation. All rights reserved.
//
// This code is licensed under the MIT License (MIT).
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.
//
//******************************************************************************

import org.junit.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import io.appium.java_client.windows.WindowsDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.PendingException;

public class CalculatorTest {

    private WindowsDriver CalculatorSession = null;
    private WebElement CalculatorResult = null;

    @Before
    public void setUp(){
        try{
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
            CalculatorSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            CalculatorSession.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

            CalculatorResult = CalculatorSession.findElementByAccessibilityId("CalculatorResults");
            Assert.assertNotNull(CalculatorResult);
        }catch(Exception e) {
            e.getMessage();
        }
    }

    @After
    public void tearDown() {
        System.out.println("Test has finished successfully");
    }

    @Given("^I am on the calculator app$")
    public void i_am_on_the_calculator_app() throws Exception {
        WebElement Calc;
        // Write code here that turns the phrase above into concrete actions
        Calc = CalculatorSession.findElementByName("Calculator");
        Assert.assertNotNull(Calc);
    }

    @When("^I add 'one' and 'seven' numbers$")
    public void i_add_one_and_seven_numbers() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        CalculatorSession.findElementByName("One").click();
        CalculatorSession.findElementByName("Plus").click();
        CalculatorSession.findElementByName("Seven").click();
        CalculatorSession.findElementByName("Equals").click();
    }

    @Then("^I should get (\\d+) displayed in screen$")
    public void i_should_get_displayed_in_screen(int arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("8", _GetCalculatorResultText());
    }

    protected String _GetCalculatorResultText()
    {
        // trim extra text and whitespace off of the display value
        return CalculatorResult.getText().replace("Display is", "").trim();
    }

//    @BeforeClass
//    public static void setup() {
//        try {
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
//            CalculatorSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
//            CalculatorSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//
//            CalculatorResult = CalculatorSession.findElementByAccessibilityId("CalculatorResults");
//            Assert.assertNotNull(CalculatorResult);
//
//        }catch(Exception e){
//            e.printStackTrace();
//        } finally {
//        }
//    }
//
//    @Before
//    public void Clear()
//    {
//        CalculatorSession.findElementByName("Clear").click();
//        Assert.assertEquals("0", _GetCalculatorResultText());
//    }
//
//    @AfterClass
//    public static void TearDown()
//    {
//        CalculatorResult = null;
//        if (CalculatorSession != null) {
//            CalculatorSession.quit();
//        }
//        CalculatorSession = null;
//    }
//
//    @Test
//    public void Addition()
//    {
//        CalculatorSession.findElementByName("One").click();
//        CalculatorSession.findElementByName("Plus").click();
//        CalculatorSession.findElementByName("Seven").click();
//        CalculatorSession.findElementByName("Equals").click();
//        Assert.assertEquals("8", _GetCalculatorResultText());
//    }
//
//    @Test
//    public void Combination()
//    {
//        CalculatorSession.findElementByName("Seven").click();
//        CalculatorSession.findElementByName("Multiply by").click();
//        CalculatorSession.findElementByName("Nine").click();
//        CalculatorSession.findElementByName("Plus").click();
//        CalculatorSession.findElementByName("One").click();
//        CalculatorSession.findElementByName("Equals").click();
//        CalculatorSession.findElementByName("Divide by").click();
//        CalculatorSession.findElementByName("Eight").click();
//        CalculatorSession.findElementByName("Equals").click();
//        Assert.assertEquals("8", _GetCalculatorResultText());
//    }
//
//    @Test
//    public void Division()
//    {
//        CalculatorSession.findElementByName("Eight").click();
//        CalculatorSession.findElementByName("Eight").click();
//        CalculatorSession.findElementByName("Divide by").click();
//        CalculatorSession.findElementByName("One").click();
//        CalculatorSession.findElementByName("One").click();
//        CalculatorSession.findElementByName("Equals").click();
//        Assert.assertEquals("8", _GetCalculatorResultText());
//    }
//
//    @Test
//    public void Multiplication()
//    {
//        CalculatorSession.findElementByName("Nine").click();
//        CalculatorSession.findElementByName("Multiply by").click();
//        CalculatorSession.findElementByName("Nine").click();
//        CalculatorSession.findElementByName("Equals").click();
//        Assert.assertEquals("81", _GetCalculatorResultText());
//    }
//
//    @Test
//    public void Subtraction()
//    {
//        CalculatorSession.findElementByName("Nine").click();
//        CalculatorSession.findElementByName("Minus").click();
//        CalculatorSession.findElementByName("One").click();
//        CalculatorSession.findElementByName("Equals").click();
//        Assert.assertEquals("8", _GetCalculatorResultText());
//    }
//
//    protected String _GetCalculatorResultText()
//    {
//        // trim extra text and whitespace off of the display value
//        return CalculatorResult.getText().replace("Display is", "").trim();
//    }
//
}