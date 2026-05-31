import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

public class ElementActions {

    WebDriver driver;

    //we change here the way we get to the our locator and any changes are reflected on the below code
    //what we did here saved the locator using By instead of WebElement, this way we can reuse the locator and avoid Stale Element Reference Exception
    By username = By.id("user-name");  //Traditional Locator
    //By username = new ByChained(By.id("login_button_container"), By.id("user-name"));
    By password = By.cssSelector("[type = 'password']");
    By loginBtn = RelativeLocator.with(By.tagName("input")).below(password);  //Relative Locator

    //Test Runner
    @Test
    public void testCase() {
        driver = new EdgeDriver();
        maximize();
        navigateTo("https://www.saucedemo.com/");
        /* Stale Element Reference Exception happens when we do the below line
        WebElement username = driver.findElement(By.id(""));
        username.sendKeys("");
         */

        // driver.findElement(username).sendKeys("Merna");

        // driver.findElement(username).sendKeys("admin"); //reallocate the element

        findElement(username).sendKeys("admin");
        findElement(username).clear();
        findElement(username).sendKeys("standard_user");
        findElement(password).sendKeys("secret_sauce");
        findElement(loginBtn).click();
    }

    //we can use this function instead
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }
}
