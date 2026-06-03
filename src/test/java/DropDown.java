import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropDown {
    WebDriver driver;

    /*
    DropDowns are used to select one or more options from a list of options. There are two types of dropdowns:
    1- Single Select Dropdown: It allows the user to select only one option from the list. It is represented by the <select> HTML tag.
    2- Multi Select Dropdown: It allows the user to select multiple options from the list. It is also represented by the <select> HTML tag but with the "multiple" attribute.

    To interact with dropdowns in Selenium, we can use the Select class provided by Selenium WebDriver. The Select class provides methods to select options from a dropdown, such as selectByVisibleText(), selectByValue(), and selectByIndex().

    */
    @Test
    public void testDropDown() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/dropdown");
        By dropdown = By.id("dropdown");
        /*i can't pass it directly as it needs it as a webelement so i will
        use .findElement and that function will pass it as a webElemetn
         */
        new Select(driver.findElement(dropdown)).selectByIndex(2);
    }
}
