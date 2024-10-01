import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage {
    private WebDriver driver;
// Локатор ввода email
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInput;
// Локатор ввода пароля
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;
// Локатор входа в личный кабинет
    @FindBy(xpath = "//button[text()='Войти в личный кабинет']")
    private WebElement loginButton;
// Локатор кнопки "Зарегистрироваться"
    @FindBy(xpath = "//button[text()='Зарегистрироваться']")
    private WebElement registerButton;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    public static void clickLogOutButton() {
    }

    public static void logIn(String workingEmail, String defaultPassword) {
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void clickRegister() {
        registerButton.click();
    }
}
