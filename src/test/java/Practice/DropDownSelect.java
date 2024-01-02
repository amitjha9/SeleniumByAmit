package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

public class DropDownSelect extends GenericTest{


    @Test(priority = 1)
    public void selectDropDownValueTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://www.globalsqa.com/demo-site/select-dropdown-menu/",10);

        By countryDrp = By.xpath("//select");
        WebElement countryListDrp = waitForElement(driver,10,countryDrp);
        Select countryList = new Select(countryListDrp);
        countryList.selectByVisibleText("Aruba");

        Thread.sleep(5000);
        driver.quit();
    }

    @Test(priority = 2)
    public void selectDropDownByValueTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://www.globalsqa.com/demo-site/select-dropdown-menu/",10);

        By countryDrp = By.xpath("//select");
        WebElement countryListDrp = waitForElement(driver,10,countryDrp);
        Select countryList = new Select(countryListDrp);
        countryList.selectByValue("AIA");
        Thread.sleep(5000);
        driver.quit();
    }


    @Test(priority = 3)
    public void selectDropDownByIndexTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://www.globalsqa.com/demo-site/select-dropdown-menu/",10);

        By countryDrp = By.xpath("//select");
        WebElement countryListDrp = waitForElement(driver,10,countryDrp);
        Select countryList = new Select(countryListDrp);
        countryList.selectByIndex(5);
        Thread.sleep(5000);
        driver.quit();
    }

    public static WebElement waitForElement(WebDriver driver, long timeout, By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }
}
