import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Windows {
    WebDriver driver;

    By newWindow = By.tagName("h3");

    @Test
    public void switchToNewWindow() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
        String parent = driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();
        String child = driver.getWindowHandles().toArray()[1].toString();
        driver.switchTo().window(child);  //without that line the driver is still seeing the handle of the parent window and not the child window
        System.out.println(driver.findElement(newWindow).getText());

    }

}
