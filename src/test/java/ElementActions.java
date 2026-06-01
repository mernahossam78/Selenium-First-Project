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

    By uploadFiles = By.id("myFile");
    By submitBtn = By.cssSelector("[onclick = 'fileSubmitted()']");

    By p = By.className("traversal-marked-text");

    /*
    The following lines were code before being polished
     Stale Element Reference Exception happens when we do the below line
        WebElement username = driver.findElement(By.id(""));
        username.sendKeys("");
         */

    // driver.findElement(username).sendKeys("Merna");

    // driver.findElement(username).sendKeys("admin"); //reallocate the element
/*
    findElement(username).sendKeys("admin");
    findElement(username).clear();
    findElement(username).sendKeys("standard_user");
    findElement(password).sendKeys("secret_sauce");
    findElement(loginBtn).click();

     */

    //Test Runner
    @Test
    public void testCase() {
        driver = new EdgeDriver();
        maximize();
        navigateTo("https://www.saucedemo.com/");
        type(username, "standard_user");
        type(password, "secret_sauce");
        clicking(loginBtn);

    }

    @Test
    public void uploadFilesTC() {
        driver = new EdgeDriver();
        maximize();
        navigateTo("https://webdriveruniversity.com/File-Upload/index.html");
        uploadFiles(uploadFiles, "/src/test/resources/test.txt");

    }

    @Test
    public void getText() {
        driver = new EdgeDriver();
        maximize();
        navigateTo("https://webdriveruniversity.com/Data-Table/index.html");
        getText(p);

    }

    //we can use this function instead
    public String getText(By by) {
        String text = findElement(by).getText();
        System.out.println(text);
        return text;
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void clicking(By by) {
        driver.findElement(by).click();
    }

    public void clear(By by) {
        driver.findElement(by).clear();
    }

    public void type(By by, String text) {
        clear(by);
        driver.findElement(by).sendKeys(text);
    }

    public void submit(By by) {
        driver.findElement(by).submit();
    }

    public void uploadFiles(By by, String filePath) {
        clear(by);
        String userHome = System.getProperty("user.dir");
        System.out.println(userHome);
        findElement(by).sendKeys(userHome + filePath);

    }
}
