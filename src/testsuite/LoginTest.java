package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    static String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter “standard_user” username
        sendTextToElement(By.id("user-name"), "standard_user");
        //Enter "secret_sauce" password
        sendTextToElement(By.id("password"), "secret_sauce");
        //Click on 'LOGIN' button
        clickOnElement(By.id("login-button"));
        //Verify the text "PRODUCTS"
        verifyText("Invalid Text", "Products", getTextFromElement(By.xpath("//span[text()='Products']")));
    }


    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter “standard_user” username
        sendTextToElement(By.id("user-name"), "standard_user");
        // Enter “secret_sauce” password
        sendTextToElement(By.id("password"), "secret_sauce");
        // Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
        // Verify that six products are displayed on page
        List<WebElement> actualElements = driver.findElements(By.className("inventory_item"));
        int actualNumbers = actualElements.size();
        Assert.assertEquals("Doesn't match",6,actualNumbers);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}



