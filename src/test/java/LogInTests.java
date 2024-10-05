import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class LogInTests {
    private WebDriver driver;
    private final String baseUrl = "https://stellarburgers.nomoreparties.site";

    @Before
    public void setup() {
              WebDriverManager.chromedriver().setup();

              ChromeOptions options = new ChromeOptions();
             driver = new ChromeDriver(options);

        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginWithExistingUser() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToProfile();

        LogInPage logInPage = new LogInPage(driver);
        logInPage.enterEmail("I.am.only.Mary@gmail.com");
        logInPage.enterPassword("798465132StInG");
        logInPage.clickLogin();

        // Проверка успешного входа
        String welcomeMessage = driver.getPageSource();
        assertThat(welcomeMessage, containsString("Добро пожаловать"));
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToProfile();

        LogInPage logInPage = new LogInPage(driver);
        logInPage.enterEmail("wrong.email@example.com");
        logInPage.enterPassword("wrongpassword");
        logInPage.clickLogin();

        // Проверка ошибки входа
        String errorMessage = driver.getPageSource();
        assertThat(errorMessage, containsString("Неверный логин или пароль"));
    }
}
