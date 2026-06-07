import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Screenshots {

    WebDriver driver;

    @Test
    public void takeScreenshot() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        // code to take screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // code to save the screenshot in a specific location
        File dest = new File("src/test/resources/screenshot.png");
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            System.out.println("Error :" + e.getMessage());
        }
    }

    @Test
    public void takeScreenshotOfElement() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        // code to take screenshot
        //no need to do the takescreenshot part i just need to find the element
        File src = driver.findElement(By.className("lnXdpd")).getScreenshotAs(OutputType.FILE);
        // code to save the screenshot in a specific location
        File dest = new File("src/test/resources/Google.png");
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            System.out.println("Error :" + e.getMessage());
        }
    }
}
