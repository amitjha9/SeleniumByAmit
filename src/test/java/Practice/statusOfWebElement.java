package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class statusOfWebElement extends GenericTest{

    @Test(priority = 1)
    public void statusOfWebElementTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",10);

        WebElement userName =driver.findElement(By.xpath("//input[@name=\"username\"]"));
        System.out.println("Display Status of the element:" +userName.isDisplayed());
        System.out.println("Enable status of the element:" +userName.isEnabled());
        driver.quit();
    }


    @Test(priority = 2)
    public void statusOfWebElementSelectedTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",10);
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[text()=' Login ']")).click();

        By adminLocName = By.xpath("//span[text()=\"Admin\"]");
        WebElement admin=waitForElement(driver,20,adminLocName);
        admin.click();

        List<WebElement> elements =driver.findElements(By.xpath("//div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]"));
        System.out.println(elements.size());

        for(int i=0; i<elements.size(); i++)
        {
            if(i==1)
            {
                boolean isSelected=elements.get(i).isSelected();
                System.out.println("Selected status is:" +isSelected);
                break;
            }
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
