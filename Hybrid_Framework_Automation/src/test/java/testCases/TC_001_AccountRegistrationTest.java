package testCases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

     HomePage hp;

    @Test
    public void verify_account_registration() throws InterruptedException {

        System.out.println("driver ==> " + driver);

        hp = new HomePage(driver);
        hp.clickMyAccount();
        Thread.sleep(2000);
        hp.clickRegister();
        Thread.sleep(5000);


        AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
        regpage.setFirstName(randomeString().toUpperCase());
        regpage.setLastName(randomeString().toUpperCase());
        regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email



        String password=randomAlphaNumeric();  //store the password into a varible first
        regpage.setPassword(password);


        regpage.setPrivacyPolicy();
        regpage.clickContinue();

        String confmsg=regpage.getConfirmationMsg();
        Assert.assertEquals(confmsg, "Your Account Has Been Created!");
    }




}
