import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumActions {
    WebDriver driver;

    By rightClick = By.id("hot-spot");
    By avatar = By.cssSelector("[alt= 'User Avatar']");  // 3 --> selenium chooses the first element
    By doubleClickBtn = By.id("double-click");
    By drag = By.id("draggable");
    By drop = By.id("droppable");
    By clickAndHold = By.id("click-box");


    @Test
    public void contextClick() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions action = new Actions(driver);
        action.contextClick(driver.findElement(rightClick)).perform();
    }

    @Test
    public void hover() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(avatar)).perform();
    }

    @Test
    public void doubleClick() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://webdriveruniversity.com/Actions/index.html#");
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(doubleClickBtn)).perform();
    }

    @Test
    public void dragAndDrop() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://webdriveruniversity.com/Actions/index.html#");
        Actions action = new Actions(driver);
        action.dragAndDrop(driver.findElement(drag), driver.findElement(drop)).perform();
    }

    @Test
    public void clickAndHold() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://webdriveruniversity.com/Actions/index.html#");
        Actions action = new Actions(driver);
        action.clickAndHold(driver.findElement(clickAndHold))
                .moveToElement(driver.findElement(clickAndHold))
                .pause(Duration.ofSeconds(5))  //I added it to hold the btn for 5 sec
                .release()
                .perform();
    }

    @Test
    public void keys() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/key_presses");
        Actions action = new Actions(driver);
        action.keyDown(Keys.SHIFT)
                .sendKeys(driver.findElement(By.id("target")), "merna")
                .perform();
        reset();  //without that line, the above action will still be valid
        driver.findElement(By.id("target")).sendKeys("merna");
    }

    public void reset() {
        ((RemoteWebDriver) driver).resetInputState();
    }

}
