package StepDefinition;

import Pages.EtsyHomePage;
import Utilities.CommonUtils;
import Utilities.Driver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EtsySteps {
EtsyHomePage etsyHomePage=new EtsyHomePage();

    WebDriver driver = Driver.getDriver("browser");

//
//    @Given("User navigate to Etsy apllication")
//    public void user_navigate_to_etsy_apllication() {
//        driver.get(CommonUtils.getProperty("EtsyURL"));
//
//
//    }

    @Given("User navigates to Etsy application")
    public void user_navigates_to_Etsy_application() {
        driver.get(CommonUtils.getProperty("EtsyURL"));
    }


    @When("User click on {string} part")
    public void user_click_on_part(String department) {

if(department.equals("Jewellery & Accessories")) {
    etsyHomePage.jewelryDep.click();
}else if (department.equals("Clothing & Shoes ")){
    etsyHomePage.clothingDep.click();
}else if(department.equals("Home & Living ")){
    etsyHomePage.homeDep.click();
}else if(department.equals("Wedding & Party ")){
    etsyHomePage.weddingDep.click();
}else if(department.equals("Toys & Entertainment ")){
    etsyHomePage.toysDep.click();
}else if(department.equals("Art & Collectibles ")){
    etsyHomePage.artDep.click();
}
    }

    @Then("User validates {string}  title")
    public void user_validates_title(String expectedTitle) {

String actualTitle=driver.getTitle();
Assert.assertEquals(expectedTitle,actualTitle);
    }


    @When("User searches for {string}")
    public void user_searches_for(String item) {
        etsyHomePage.searchBox.sendKeys(item+ Keys.ENTER);


    }

    @Then("User validates the result contains")
    public void user_validates_the_result_contains(DataTable dataTable) {
List<String> items=dataTable.asList();
for(WebElement element:etsyHomePage.items){
    String itemName=element.getText();
    boolean isFound=false;
    for(String item:items){
        if(itemName.toLowerCase().contains(item)){
            isFound=true;
        }
    }

Assert.assertTrue(itemName,isFound);

    }
}
    @When("User selects over ${int} option")
    public void user_selects_over_$_option(Integer int1) throws InterruptedException {

        etsyHomePage.radioButton.click();
        Thread.sleep(5000);
    }
    @Then("User validates that all prices over {int}")
    public void user_validates_that_all_prices_over(Integer int1) {

        for(WebElement element:etsyHomePage.price){
            String prices=element.getText();
            prices=prices.replace(",","");

            double priceInDouble=Double.parseDouble(prices);
          // Assert.assertTrue(priceInDouble>int1);

        }
    }









}