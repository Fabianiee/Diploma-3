import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    // Локатор профиля
    private By profileLink = By.xpath("//a[text()='Личный кабинет']");

    // Локатор кнопки входа в аккаунт
    private final By LOG_IN_BUTTON = By.xpath("//button[text()='Войти в аккаунт']");

    // Локатор кнопки оформления заказа
    private final By ORDER_BUTTON = By.xpath("//button[text()='Оформить заказ']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Переход на страницу профиля")
    public void goToProfile() {
        WebElement profileElement = driver.findElement(profileLink);
        profileElement.click(); // Кликаем по элементу
    }

    @Step("Переход на страницу логина через кнопку 'Войти в аккаунт'")
    public void clickLogInButton() {
        WebElement loginButton = driver.findElement(LOG_IN_BUTTON);
        loginButton.click(); // Кликаем по кнопке
    }

    public boolean checkIsCheckOutButtonEnabled() {
        WebElement orderButton = driver.findElement(ORDER_BUTTON);
        return orderButton.isEnabled(); // Проверяем, доступна ли кнопка
    }

    public boolean checkIsLogInButtonEnabled() {
        WebElement loginButton = driver.findElement(LOG_IN_BUTTON);
        return loginButton.isEnabled(); // Проверяем, доступна ли кнопка
    }
}
