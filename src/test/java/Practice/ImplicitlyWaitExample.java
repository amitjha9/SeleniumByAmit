package Practice;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitlyWaitExample extends GenericTest{

    @Test
    public void implicitWaitTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",5);

        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[text()=' Login ']")).click();
        driver.quit();
    }
}
