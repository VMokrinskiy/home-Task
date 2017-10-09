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
        mainPage.marketButton.click();

        MarketPage marketPage = new MarketPage(driver);
        marketPage.electronicButton.click();
        marketPage.tvButton.click();

        TVPage tvPage = new TVPage(driver);
        tvPage.priceFromInput.sendKeys("20000");
        tvPage.scrollTo(tvPage.samsungCheckBox);
        tvPage.samsungCheckBox.click();
        tvPage.lgCheckBox.click();
        tvPage.scrollTo(tvPage.applyButton);
        tvPage.applyButton.click();

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        assertEquals(12, searchResultPage.list.size());
        WebElement firstTV = searchResultPage.list.get(0);
        String name = firstTV.getText();
        searchResultPage.searchInput.sendKeys(name);
        searchResultPage.searchInput.submit();
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.tvHeader));
        assertEquals(name, searchResultPage.tvHeader.getText());

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
