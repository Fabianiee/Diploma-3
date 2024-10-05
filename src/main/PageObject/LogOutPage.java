import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogOutPage {
    private WebDriver driver;

    // Локатор кнопки "Выйти"
    private final By LOG_OUT_BUTTON = By.xpath("//button[text()='Выход']");

    public LogOutPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Выход из аккаунта")
    public void clickLogOutButton() {
        WebElement logoutButton = driver.findElement(LOG_OUT_BUTTON);
        logoutButton.click();
    }
}
