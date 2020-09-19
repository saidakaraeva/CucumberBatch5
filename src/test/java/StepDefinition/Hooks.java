package StepDefinition;

import Utilities.CommonUtils;
import Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hooks {

    WebDriver driver = Driver.getDriver(CommonUtils.getProperty("browser"));

    @Before
    public void setup() {


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Before each scenario");

    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
         CommonUtils.takeScreenshot(driver, "Test Scenario");

//byte []screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//scenario.attach(screenshot,"image/png","Failed part");
        }
      //  driver.quit();


    }


}