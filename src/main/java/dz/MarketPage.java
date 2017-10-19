package dz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketPage extends BasePage {

    @FindBy(xpath = "//a[text()='�����������'][@class=\"link topmenu__link\"]")
    public WebElement electronicButton;

    @FindBy(xpath = "//a[text()=\"����������\"][contains(@class, \"link catalog-menu\")]")
    public WebElement tvButton;

    public MarketPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
