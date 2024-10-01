import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConstructorPage {
    private WebDriver driver;

    @FindBy(xpath = "//tab[contains(text(), 'Булки')]")
    private WebElement bunsTab;

    @FindBy(xpath = "//tab[contains(text(), 'Соусы')]")
    private WebElement saucesTab;

    @FindBy(xpath = "//tab[contains(text(), 'Начинки')]")
    private WebElement fillingsTab;

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectBuns() {
        bunsTab.click();
    }

    public void selectSauces() {
        saucesTab.click();
    }

    public void selectFillings() {
        fillingsTab.click();
    }
}
