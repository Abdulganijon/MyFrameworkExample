package com.Project.step_definitions;

import com.Project.pages.SearchPage;
import com.Project.utilities.ConfigurationReader;
import com.Project.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import static io.restassured.RestAssured.*;

public class SearchStepDef {
    SearchPage searchPage = new SearchPage();
    Actions actions = new Actions(Driver.get());

    @Given("User go to home page")
    public void user_go_to_home_page() {
        Driver.get().get(ConfigurationReader.getProperty("Url"));
        Driver.get().manage().window().maximize();

    }

    @When("user search PS5")
    public void user_search_ps5() {
   searchPage.searchBar.sendKeys("PS5 console bundle god of war"+ Keys.ENTER);
   //searchPage.submitButton.click();

    }
    @And("user sorts to High to low")
    public void userSortsToHighToLow() {
    searchPage.sortButton.click();
    searchPage.highToLow.click();


    }

    @When("user scrolls down to first")
    public void user_scrolls_down_to_first() {
        actions.moveToElement(searchPage.selectedBundle).click().perform();



    }


    @Then("user validates the correct price")
    public void userValidatesTheCorrectPrice() {
        String actualPrice = searchPage.priceValidation.getText();

       String expectedPrice = "$559.99";

       Assert.assertEquals(expectedPrice,actualPrice);







    }

    @Then("api status code should be {int}")
    public void apiStatusCodeShouldBe(int arg0) {
       String url = "https://www.amazon.com/nav/ajax/hMenuDesktopFirstLayer?ajaxTemplate=hMenuDesktopFirstLayer&pageType=Detail&hmDataAjaxHint=1&isFreshRegion=false&isFreshCustomer=false&isPrimeMember=false&isPrimeDay=false&isSmile=false&regionalStores%5B%5D=VUZHIFdob2xlIEZvb2Rz&regionalStores%5B%5D=VUZHIFdob2xlIEZvb2Rz&regionalStores%5B%5D=VUZHIFdob2xlIEZvb2Rz&regionalStores%5B%5D=VUZHIFdob2xlIEZvb2Rz&regionalStores%5B%5D=VUZHIFdob2xlIEZvb2Rz&regionalStores%5B%5D=VUZHIFdob2xlIEZvb2Rz&regionalStores%5B%5D=VUZHIFdob2xlIEZvb2Rz&isBackup=false&firstName=false&navDeviceType=desktop&hashCustomerAndSessionId=c964265bf95507a33ac557aa2f0a914676eabd71&environmentVFI=AmazonNavigationCards%2Fdevelopment%40B6106048915-AL2_x86_64&languageCode=en_US&isExportMode=false";
       given().when().get(url).
               then().assertThat().statusCode(200);


    }
}
