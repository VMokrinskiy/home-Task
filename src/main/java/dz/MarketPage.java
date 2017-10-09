package dz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketPage extends BasePage {

    @FindBy(xpath = "//ul[@class=\"topmenu__list\"]/li[1]/a")
    public WebElement electronicButton;

    @FindBy(xpath = "//div[@class=\"catalog-menu__item\"][3]/div/a[1]")
    public WebElement tvButton;

    public MarketPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
