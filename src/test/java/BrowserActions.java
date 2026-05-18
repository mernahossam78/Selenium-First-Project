import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class BrowserActions {
    WebDriver driver;

    //Test runner
    @Test
    public void testCase() {
        driver = new EdgeDriver();
        navigateTo("http://google.com");
        navigateTo("http://bing.com");
        navigateBack();
        navigateForward();
        refresh();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateForward() {
        driver.navigate().forward();
    }

    public void refresh() {
        driver.navigate().refresh();
    }


}
