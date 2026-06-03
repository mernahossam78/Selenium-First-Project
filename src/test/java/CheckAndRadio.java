import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class CheckAndRadio {
    WebDriver driver;

    By Option1 = By.cssSelector("[value = 'option-1']");
    By Option3 = By.cssSelector("[value = 'option-3']");

    By Green = By.cssSelector("[value = 'green']");
    By Blue = By.cssSelector("[value = 'blue']");
    By Purple = By.cssSelector("[value = 'purple']");

    @Test
    public void checkBox() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        System.out.println("Is checked: " + driver.findElement(Option3).isSelected());
        driver.findElement(Option1).click();
    }

    @Test
    public void radio() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        System.out.println("Is checked: " + driver.findElement(Purple).isEnabled());  //We use with radio buttons isEnabled()
        driver.findElement(Green).click();
    }

}
