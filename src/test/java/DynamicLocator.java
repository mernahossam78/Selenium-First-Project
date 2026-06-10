import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DynamicLocator {

    WebDriver driver;

    @Test
    public void dynamicLocator() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/");
        new Actions(driver).moveToElement(driver.findElement(By.xpath("(//li [@class = 'dropdown'] /a ) [4]")))
                .perform();
        chooseOption("Join");


    }

    public void chooseOption(String option) {
        driver.findElement(By.xpath("//a[.='" + option + "']")).click();
    }

}
