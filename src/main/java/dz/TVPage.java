package dz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TVPage extends BasePage {
    @FindBy(xpath = "//input[@id=\"glf-pricefrom-var\"]")
    WebElement priceFromInput;

    @FindBy(xpath = "//label[text()=\"Samsung\"]")
    WebElement samsungCheckBox;

    @FindBy(xpath = "//label[text()=\"LG\"]")
    WebElement lgCheckBox;

    @FindBy(xpath = "//button[contains(@class, \"n-filter-apply\")]")
    WebElement applyButton;

    public TVPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
