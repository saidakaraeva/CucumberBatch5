package StepDefinition;

import Pages.OrderPage;
import Pages.WebOrderHomePage;
import Pages.WebOrdersLoginPage;
import Utilities.CommonUtils;
import Utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class WebOrdersAppSteps {

    WebDriver driver = Driver.getDriver("chrome");

    WebOrdersLoginPage webOrdersLoginPage = new WebOrdersLoginPage();

    WebOrderHomePage webOrderHomePage = new WebOrderHomePage();

    OrderPage orderPage = new OrderPage();


    @Given("User navigates to WebOrders application")
    public void user_navigates_to_web_orders_application() {
        driver.get(CommonUtils.getProperty("WebOrdersURL"));
    }


    @When("User provides username {string} and password {string}")
    public void user_provides_username_and_password(String username, String password) {

        webOrdersLoginPage.login(username, password);


    }

    @Then("User validates that application {string} logged in")
    public void user_validates_that_application_logged_in(String condition) {
        if (condition.equalsIgnoreCase("is")) {
            String expectedTitle = "Web Orders";
            String actualTitle = driver.getTitle();
            Assert.assertEquals("Actual Title: " + actualTitle + ""
                    + "Didn't match with expected " + expectedTitle, expectedTitle, actualTitle);
        } else if (condition.equalsIgnoreCase("is not")) {
            String expectedErrorMessage = "Invalid Login or Password.";
            String actualErrorMessage = webOrdersLoginPage.errorMessage.getText();
            Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        }

    }

    @When("User click on Order part")
    public void user_click_on_order_part() {

        webOrderHomePage.orderPart.click();

    }

    @When("User adds new order with data")
    public void user_adds_new_order_with_data(DataTable dataTable) {

        List<Map<String, Object>> data = dataTable.asMaps(String.class, Object.class);
        orderPage.quantityBox.clear();
        orderPage.quantityBox.sendKeys(data.get(0).get("Quantity").toString());
        orderPage.customerNameBox.sendKeys(data.get(0).get("Customer name").toString());
        orderPage.stateBox.sendKeys(data.get(0).get("State").toString());
        orderPage.streetBox.sendKeys(data.get(0).get("Street").toString());
        orderPage.zipBox.sendKeys(data.get(0).get("Zip").toString());
        orderPage.VisaCardBox.click();
        orderPage.cardNumBox.sendKeys(data.get(0).get("Card Nr").toString());
        orderPage.expireDate.sendKeys(data.get(0).get("Expire Date").toString());
        orderPage.cityBox.sendKeys(data.get(0).get("City").toString());


    }

    @Then("User click on Process button and validates {string} message")
    public void user_click_on_process_button_and_validates_message(String success) {

        orderPage.processButton.click();
        String actualMessage = orderPage.verifyOrderCreated.getText();
        Assert.assertEquals(success, actualMessage);

    }

    @When("User click View All Orders part")
    public void user_click_view_all_orders_part() {
        webOrderHomePage.viewAllOrder.click();


    }

    @Then("User created order is added to list with data")
    public void user_created_order_is_added_to_list_with_data(DataTable dataTable) {
List<Map<String,Object>>data=dataTable.asMaps(String.class,Object.class);

webOrderHomePage.firsRowData.get(1).getText();
Assert.assertEquals(data.get(0).get("Customer name"),webOrderHomePage.firsRowData.get(1).getText());

Assert.assertEquals(data.get(0).get("Quantity"),webOrderHomePage.firsRowData.get(3).getText());
Assert.assertEquals(data.get(0).get("Street"),webOrderHomePage.firsRowData.get(5).getText());
Assert.assertEquals(data.get(0).get("City"),webOrderHomePage.firsRowData.get(6).getText());
Assert.assertEquals(data.get(0).get("State"),webOrderHomePage.firsRowData.get(7).getText());
Assert.assertEquals(data.get(0).get("Zip"),webOrderHomePage.firsRowData.get(8).getText());
Assert.assertEquals(data.get(0).get("Card Nr"),webOrderHomePage.firsRowData.get(10).getText());
Assert.assertEquals(data.get(0).get("Expire Date"),webOrderHomePage.firsRowData.get(11).getText());


    }
}