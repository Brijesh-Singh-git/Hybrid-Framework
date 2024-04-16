package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseClass {

   public  WebDriver driver;
   public Logger logger;


    @BeforeSuite
    public void setup() throws InterruptedException {

        //loading log4j file
        LogManager.getLogger(this.getClass());

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://demo.opencart.com/index.php?route=common/home&language=en-gb");
        driver.manage().window().maximize();

    }

    @AfterSuite
    public void tearDown()
    {
        driver.close();
    }

    public String randomeString()
    {
        String generatedString= RandomStringUtils.randomAlphabetic(5);
        return generatedString;
    }

    public String randomeNumber()
    {
        String generatedString=RandomStringUtils.randomNumeric(10);
        return generatedString;
    }

    public String randomAlphaNumeric()
    {
        String str=RandomStringUtils.randomAlphabetic(3);
        String num=RandomStringUtils.randomNumeric(3);

        return (str+"@"+num);
    }
}
