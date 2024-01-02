package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class DropDownSelectCondition extends GenericTest{


    @Test(priority = 1)
    public void selectDropDownTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://www.globalsqa.com/demo-site/select-dropdown-menu/",10);

        By countryDrp = By.xpath("//select");
        WebElement countryListDrp = waitForElement(driver,10,countryDrp);
        Select countryList = new Select(countryListDrp);

        List<WebElement> allOptions = countryList.getOptions();
        for (WebElement cntryList:allOptions) {
            if(cntryList.getText().equalsIgnoreCase("Belgium"))
            {
                cntryList.click();
                Thread.sleep(5000);
                break;
            }
        }
        driver.quit();
    }

    @Test(priority = 2)
    public void printDropDownTextTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://www.globalsqa.com/demo-site/select-dropdown-menu/",10);

        By countryDrp = By.xpath("//select");
        WebElement countryListDrp = waitForElement(driver,10,countryDrp);
        Select countryList = new Select(countryListDrp);

        List<WebElement> allCountry = countryList.getOptions();
        System.out.println("Size is:" +allCountry.size());
        for(int i=0; i<allCountry.size(); i++)
        {
            System.out.println(allCountry.get(i).getText());
        }
        driver.quit();
    }

    public static WebElement waitForElement(WebDriver driver, long timeout, By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }
}
