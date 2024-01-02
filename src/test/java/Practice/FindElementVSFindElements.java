package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementVSFindElements extends GenericTest{


    @Test(priority = 1)
    public void findElementTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",10);

        //findElement() --> This return always a single web element
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[text()=' Login ']")).click();

        By adminLocName = By.xpath("//span[text()=\"Admin\"]");
        WebElement admin=waitForElement(driver,20,adminLocName);
        admin.click();
        driver.quit();
    }

    @Test(priority = 2)
    public void findElementsTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://demo.nopcommerce.com/",10);

        List<WebElement> link = driver.findElements(By.xpath("//div[@class='footer-block information']/ul/li"));
        System.out.println("Size of the list is:" +link.size());

        for(int i=0; i<link.size(); i++)
        {
            String text = link.get(i).getText();
            System.out.println("Text is:" +text);
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
