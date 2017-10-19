package dz;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestName;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WebDriverTest {

    private WebDriver driver;
    private String baseURL;
    Steps steps = new Steps();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        baseURL = "https://www.yandex.ru/";

    }

    @Test
    public void webDriver() throws Exception {
        driver.get(baseURL);
        WebDriverWait wait = new WebDriverWait(driver, 5, 1000);
        MainPage mainPage = new MainPage(driver);
        steps.clickOnButton(mainPage.marketButton);

        MarketPage marketPage = new MarketPage(driver);
        steps.clickOnButton(marketPage.electronicButton);
        steps.clickOnButton(marketPage.tvButton);

        TVPage tvPage = new TVPage(driver);
        steps.inputData(tvPage.priceFromInput, "20000");
        steps.scrollTo(driver, tvPage.samsungCheckBox);
        steps.clickOnButton(tvPage.samsungCheckBox);
        steps.clickOnButton(tvPage.lgCheckBox);
        steps.scrollTo(driver, tvPage.applyButton);
        steps.clickOnButton(tvPage.applyButton);

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        assertEquals(12, searchResultPage.list.size());
        WebElement firstTV = searchResultPage.list.get(0);
        String name = firstTV.getText();
        steps.inputData(searchResultPage.searchInput, name);
        steps.submitData(searchResultPage.searchInput);
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.tvHeader));
        assertEquals(name, searchResultPage.tvHeader.getText());

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
