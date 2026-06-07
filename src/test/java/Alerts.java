import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Alerts {
    WebDriver driver;

    By jsAlert = By.cssSelector("[onclick=\"jsAlert()\"]");
    By jsConfirm = By.cssSelector("[onclick=\"jsConfirm()\"]");
    By jsPrompt = By.cssSelector("[onclick=\"jsPrompt()\"]");
    By result = By.id("result");

    @Test
    public void JSconfirm() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(jsAlert).click(); //Alert appears
        driver.switchTo().alert().accept();  //we click on ok or accept
        System.out.println(driver.findElement(result).getText());
    }


    @Test
    public void JSdismiss() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(jsConfirm).click(); //Alert appears
        driver.switchTo().alert().dismiss();
        System.out.println(driver.findElement(result).getText());
    }


    @Test
    public void JSprompt() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(jsPrompt).click(); //Alert appears
        driver.switchTo().alert().sendKeys("Merna"); //we send text to the alert
        driver.switchTo().alert().accept();  //we click on ok or accept
        System.out.println(driver.findElement(result).getText());


    }


    @Test
    public void JStext() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(jsAlert).click();
        String alertText = driver.switchTo().alert().getText(); //we get the text of the alert
        System.out.println(alertText);


    }


}
