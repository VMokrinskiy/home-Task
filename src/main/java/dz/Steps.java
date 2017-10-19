package dz;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class Steps {
    @Step("Click on button")
    public void clickOnButton(WebElement webElement){
        webElement.click();
    }

    @Step("InputData data")
    public void inputData(WebElement webElement, String data){
        webElement.sendKeys(data);
    }

    @Step("Scroll to element")
    public void scrollTo(WebDriver webDriver, WebElement webElement){
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView(false);", webElement);
    }

    @Step("Submit data")
    public void submitData(WebElement webElement){
        webElement.submit();
    }
}
