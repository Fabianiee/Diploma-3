import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class LogOutTests {
    private WebDriver driver;
    private final String baseUrl = "https://stellarburgers.nomoreparties.site";

    @Before
    public void setup() {
        driver = Browser.getDriver("chrome"); // Или "yandex" для запуска в Яндекс.Браузере
        driver.get(baseUrl);
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
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
    public void testLogout() {
        testLoginWithExistingUser();

        LogOutPage logOutPage = new LogOutPage(driver);
        logOutPage.clickLogOutButton();


        MainPage mainPage = new MainPage(driver);


        String loginButton = driver.getPageSource();
        assertThat(loginButton, containsString("Войти в аккаунт"));

        String profileLink = driver.getPageSource();
        assertThat(profileLink, not(containsString("Личный кабинет")));
    }

    private void testLoginWithExistingUser() {
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
}

