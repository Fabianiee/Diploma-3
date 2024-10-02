import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
    public static WebDriver getDriver(String browserType) {
        WebDriver driver;

        switch (browserType.toLowerCase()) {
            case "chrome":
              System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

                driver = new ChromeDriver();
                break;

            case "yandex":

                throw new UnsupportedOperationException("Yandex Browser support is not implemented yet.");

            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }

        return driver;
    }
}