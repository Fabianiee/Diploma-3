import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegistrationTests {
    private WebDriver driver;
    private final String baseUrl = "https://stellarburgers.nomoreparties.site";

    @Before
    public void setup() {
        // Установка ChromeDriver с использованием WebDriverManager
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Запуск в фоновом режиме, если нужно
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
    public void testSuccessfulRegistration() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToProfile();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmail("unique.email@example.com");
        registrationPage.enterPassword("ValidPass123");
        registrationPage.enterName("Test User");
        registrationPage.clickRegister();

        // Проверка успешной регистрации
        String successMessage = driver.getPageSource();
        assertThat(successMessage, containsString("Успешная регистрация"));
    }

    @Test
    public void testRegistrationWithShortPassword() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToProfile();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterEmail("short.password@test.com");
        registrationPage.enterPassword("7984");
        registrationPage.enterName("Test User");
        registrationPage.clickRegister();

        // Проверка ошибки для короткого пароля
        String errorMessage = driver.getPageSource();
        assertThat(errorMessage, containsString("Минимальная длина пароля — 6 символов"));
    }
}
