import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Waits {
    WebDriver driver;

    /*
    Implicit Wait: It is a global wait that applies to all elements in the test. It tells the WebDriver to wait for a certain amount of time before throwing a NoSuchElementException if an element is not found. The implicit wait is set once and applies to all subsequent element searches.

    Explicit Wait: It is a more specific wait that allows you to wait for a certain condition to be met before proceeding with the test. You can specify the condition you want to wait for, such as an element being visible or clickable. Explicit waits are used when you need to wait for a specific element or condition before continuing with the test.

    Fluent Wait: It is similar to explicit wait but provides more flexibility in terms of polling frequency and exception handling. With fluent wait, you can specify how often the WebDriver should check for the condition and which exceptions to ignore while waiting.

     */
    By startBtn = By.tagName("button");
    By msg = By.cssSelector("#finish > h4");

    /*we are here trying to find the text hello world that is printed after
    clicking on the start button without using any wait
     */
    @Test
    public void implicitWait() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        /*I will add here an implicit wait --> it will wait until the element appears
        in the DOM, not necessarily to be visible to me
         */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        /*i changed the page from 2 to 1 to see the case where the element
        is displayed in the DOM but not loaded yet to be seen visibly
        */
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(startBtn).click();
        String message = driver.findElement(msg).getText();
        System.out.println(message);
    }

    @Test
    public void explicitWaitUsingExpectedConditions() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(startBtn).click();

        // Here we will use explicit wait to wait until the message is visible
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(msg));
        String message = driver.findElement(msg).getText();
        System.out.println(message);
    }

    @Test
    public void explicitWaitUsingLambda() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(startBtn).click();

        // Here we will use explicit wait to wait until the message is visible
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(d -> driver.findElement(msg).isDisplayed());
        String message = driver.findElement(msg).getText();
        System.out.println(message);
    }
}