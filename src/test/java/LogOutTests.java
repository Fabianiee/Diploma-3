import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


public class LogOutTests {
    private WebDriver driver;
    private final String baseUrl = "https://stellarburgers.nomoreparties.site";

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get(baseUrl);

    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLogout() {
        testLoginWithExistingUser(); // Сначала логинимся

        LogOutPage logOutPage = new LogOutPage(driver);
        logOutPage.clickLogOutButton();

        // Проверка, что мы на главной странице
        MainPage mainPage = new MainPage(driver);

        // Убедитесь, что кнопка "Войти в аккаунт" отображается
        String loginButton = driver.getPageSource();
        assertThat(loginButton, containsString("Войти в аккаунт"));

        // Дополнительно: убедитесь, что элементы профиля больше не доступны
        String profileLink = driver.getPageSource();
        assertThat(profileLink, not(containsString("Личный кабинет")));
    }

    private boolean not(Matcher<String> личныйКабинет) {
        return false;
    }

    private void testLoginWithExistingUser() {
    }


}
