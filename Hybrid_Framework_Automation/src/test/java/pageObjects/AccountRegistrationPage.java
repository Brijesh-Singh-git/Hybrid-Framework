package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountRegistrationPage extends  BasePage {

    WebDriver driver;

    public AccountRegistrationPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath="//input[@id='input-firstname']")
    WebElement txtFirstname;

    @FindBy(xpath="//input[@id='input-lastname']")
    WebElement txtLasttname;

    @FindBy(xpath="//input[@id='input-email']")
    WebElement txtEmail;

    @FindBy(xpath="//input[@id='input-password']")
    WebElement txtPassword;

    @FindBy(xpath="//input[@name='agree']")
    WebElement chkdPolicy;

    @FindBy(xpath="//input[@value='Continue']")
    WebElement btnContinue;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;


    public void setFirstName(String fname) {
        txtFirstname.sendKeys(fname);

    }

    public void setLastName(String lname) {
        txtLasttname.sendKeys(lname);

    }

    public void setEmail(String email) {
        txtEmail.sendKeys(email);

    }

    public void setPassword(String pwd) {
        txtPassword.sendKeys(pwd);

    }

    public void setPrivacyPolicy() {
        chkdPolicy.click();


    }

    public void clickContinue() {  //sometimes it shows Element not found exception
        //sol1
        //btnContinue.click();

        //sol2
        //btnContinue.submit();

        //sol3
        //Actions act=new Actions(driver);
        //act.moveToElement(btnContinue).click().perform();

        //sol4
        //JavascriptExecutor js=(JavascriptExecutor)driver;
        //js.executeScript("arguments[0].click();", btnContinue);

        //Sol 5
        //btnContinue.sendKeys(Keys.RETURN);

        //Sol6
        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
        mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();

    }

    public String getConfirmationMsg() {   //Page objects class we dont do any validations
        try {
            return (msgConfirmation.getText());
        } catch (Exception e) {
            return (e.getMessage());

        }

    }
}


