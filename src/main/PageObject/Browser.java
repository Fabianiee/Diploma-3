import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
    public static WebDriver getDriver(String browserType) {
        WebDriver driver;

        switch (browserType.toLowerCase()) {
            case "chrome":
                String chromeDriverPath = System.getenv("CHROME_DRIVER_PATH");
                if (chromeDriverPath != null) {
                    System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                } else {
                    throw new IllegalStateException("CHROME_DRIVER_PATH environment variable is not set.");
                }
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