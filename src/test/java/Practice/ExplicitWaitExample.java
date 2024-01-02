package Practice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

public class ExplicitWaitExample extends GenericTest{


    @Test
    public void explicitWaitTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",10);
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[text()=' Login ']")).click();

        By adminLocName = By.xpath("//span[text()=\"Admin\"]");
        WebElement admin=waitForElement(driver,20,adminLocName);
        admin.click();
        driver.quit();
    }

    public static WebElement waitForElement(WebDriver driver, long timeout, By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }
}
