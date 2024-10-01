import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage {
    private WebDriver driver;

    @FindBy(xpath = "//button[text()='Выйти']")
    private WebElement logoutButton;

    @FindBy(xpath = "//a[text()='Конструктор']")
    private WebElement constructorLink;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogout() {
        logoutButton.click();
    }

    public void goToConstructor() {
        constructorLink.click();
    }

    public void clickLogo() {
    }
}
