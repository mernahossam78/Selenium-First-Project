import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Frames {
    WebDriver driver;
    By leftFrame = By.xpath("//*[contains(text(), 'LEFT')]");

    @Test
    public void frames() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        //parent > top > left > top > bottom
        driver.switchTo().frame("frame-top")
                .switchTo().frame("frame-left");
        System.out.println(driver.findElement(leftFrame).getText());
        //we can use the above method to find the content or the bottom both are correct
        driver.switchTo().defaultContent()
                .switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.tagName("body")).getText());

    }
}
