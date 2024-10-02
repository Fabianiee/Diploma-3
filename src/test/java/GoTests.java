import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GoTests {
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
    public void testGoToProfileFromMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToProfile();

        String profileTitle = driver.getTitle();
        assertThat(profileTitle, equalTo("Личный кабинет"));
    }

    @Test
    public void testGoToConstructorFromProfile() {
        testLoginWithExistingUser();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.goToConstructor();

        // Проверка, что мы на странице конструктора
        String constructorTitle = driver.getTitle();
        assertThat(constructorTitle, equalTo("Конструктор"));
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

    @Test
    public void testGoToConstructorFromLogo() {
        testLoginWithExistingUser();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickLogo();

        // Проверка, что мы на странице конструктора
        String constructorTitle = driver.getTitle();
        assertThat(constructorTitle, equalTo("Конструктор"));
    }
}
