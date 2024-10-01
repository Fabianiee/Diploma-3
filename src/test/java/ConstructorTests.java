import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConstructorTests {
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
    public void testBunsTab() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToProfile();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.goToConstructor();

        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.selectBuns();

        // Проверяем, что мы на вкладке "Булки"
        String bunsTitle = driver.getTitle();
        assertThat(bunsTitle, equalTo("Булки"));
    }

    @Test
    public void testSaucesTab() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToProfile();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.goToConstructor();

        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.selectSauces();

        // Проверяем, что мы на вкладке "Соусы"
        String saucesTitle = driver.getTitle();
        assertThat(saucesTitle, equalTo("Соусы"));
    }

    @Test
    public void testFillingsTab() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToProfile();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.goToConstructor();

        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.selectFillings();

        // Проверяем, что мы на вкладке "Начинки"
        String fillingsTitle = driver.getTitle();
        assertThat(fillingsTitle, equalTo("Начинки"));
    }
}
