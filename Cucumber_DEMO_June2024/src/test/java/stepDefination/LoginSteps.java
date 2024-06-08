package stepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginSteps {

    WebDriver driver;

    @Given("the user is on the login page")
    public void the_user_is_on_the_nop_commerce_login_page() {

        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


    }
    @When("the user enters valid credentials \\(username: {string}, password: {string})")
    public void the_user_enters_valid_credentials_username_password(String username, String password) {

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

    }
    @When("the user clicks on the Login button")
    public void the_user_clicks_on_the_login_button() {

       driver.findElement(By.xpath("//button[@id='submit']")).click();

    }
    @Then("the user should be redirected to the My Account page")
    public void the_user_should_be_redirected_to_the_my_account_page() {

        String msg = driver.findElement(By.xpath("//h1[@class='post-title']")).getText();
        Assert.assertEquals(msg, "Logged In Successfully");
    }
    @Then("the user should see a welcome message")
    public void the_user_should_see_a_welcome_message() {

        boolean welcomemsg = driver.findElement(By.xpath("//strong[contains(text(),'Congratulations student. You successfully logged i')]")).isDisplayed();
        Assert.assertEquals(welcomemsg,true);
        driver.quit();
    }

}
