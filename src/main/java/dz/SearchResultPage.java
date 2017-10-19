package dz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage extends BasePage{
    @FindBy(xpath = "//div[contains(@class, \"n-snippet-card2__title\")]/a")
    List<WebElement> list;

    /*
    @FindBy(xpath = "//a[contains(@class, \"snippet-card__header-link\")]/span")
    List<WebElement> list;
*/
    @FindBy(xpath = "//input[@id=\"header-search\"]")
    WebElement searchInput;

    @FindBy(xpath = "//h1[contains(@class,'title title')]")
    WebElement tvHeader;

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
