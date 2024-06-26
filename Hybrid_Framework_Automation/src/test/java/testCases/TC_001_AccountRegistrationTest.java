package testCases;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

    @Test(groups = {"sanity", "master"})
    public void verify_account_registration()
    {
        logger = (Logger) LogManager.getLogger(TC_001_AccountRegistrationTest.class); // Initialize logger

        logger.info("**** starting TC_001_AccountRegistrationTest  *****");
        logger.debug("application logs started......");

        try
        {
            HomePage hp=new HomePage(driver);
            hp.clickMyAccount();
            logger.info("Clicked on MyAccount link");

            hp.clickRegister();
            logger.info("Clicked on registration link");

            logger.info("Entering customer details.. ");
            AccountRegistrationPage regpage=new AccountRegistrationPage(driver);

            regpage.setFirstName(randomeString().toUpperCase());
            regpage.setLastName(randomeString().toUpperCase());
            regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email

            String password=randomAlphaNumeric();

            regpage.setPassword(password);

            regpage.setPrivacyPolicy();
            regpage.clickContinue();
            logger.info("clicked on continue..");

            String confmsg=regpage.getConfirmationMsg();

            logger.info("Validating expected message..");

            Assert.assertEquals(confmsg, "Your Account Has Been Created!","Account creation failed");

        }
        catch(Exception e)
        {
            logger.error("test failed..");
            logger.debug("debug logs....");
            Assert.fail();
        }

        logger.debug("application logs end.......");
        logger.info("**** finished TC_001_AccountRegistrationTest  *****");

    }





}






