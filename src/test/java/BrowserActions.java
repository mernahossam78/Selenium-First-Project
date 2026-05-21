import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class BrowserActions {
    WebDriver driver;

    //Test runner
    @Test
    public void testCase() {
        driver = new EdgeDriver();
        maximize();
        //setPosition();
        //setSize(430, 932);
        //fullScreen();
        navigateTo("http://google.com");
        driver.switchTo().newWindow(WindowType.TAB);
        //close: closes the current window only
        //close();
        //quit, closes all the tabs
        quit();
        /*
        navigateTo("http://bing.com");
        getCurrentUrl();
        getTitle();
        getPageSource();
        navigateBack();
        navigateForward();
        //refresh();
        getWindowHandle();
        */

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

    public void maximize() {
        driver.manage().window().maximize();
    }

    public void setPosition() {

        // Point point = new Point(100 , 200);
        //ely t7t asmo anonamous object
        driver.manage().window().setPosition(new Point(100, 200));
    }

    public void setSize(int width, int height) {
        //Dimension dimension = new Dimension(width, height);
        driver.manage().window().setSize(new Dimension(width, height));
    }

    public void fullScreen() {
        driver.manage().window().fullscreen();
    }

    public void getCurrentUrl() {
        String url = driver.getCurrentUrl();
        System.out.println("Current URL: " + url);
    }

    public void getTitle() {
        String title = driver.getTitle();
        System.out.println(title);
    }

    public void getPageSource() {
        String src = driver.getPageSource();
        System.out.println("Page Source: " + src);
    }

    public void getWindowHandle() {
        String handle = driver.getWindowHandle();
        System.out.println("Window handle:" + handle);
    }

    public void close() {
        driver.close();
    }

    public void quit() {
        driver.quit();
    }

    public void scrollingUsingJS() {

    }
}
