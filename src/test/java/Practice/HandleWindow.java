package Practice;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HandleWindow extends GenericTest{


    @Test(priority = 1)
    public void handleWindowTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",10);

        WebElement link = driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']"));
        link.click();

        Set<String> windowsIDs=driver.getWindowHandles();
        Iterator<String> itr = windowsIDs.iterator();

        System.out.println("Size of the set is:" +windowsIDs.size());

        while (itr.hasNext())
        {
            System.out.println("Parent Window ID:" +itr.next());
            System.out.println("Child Window ID:" +itr.next());
        }

        //Convert set to list collection
        List<String> windowID = new ArrayList<>(windowsIDs);
        String parentWindowID = windowID.get(0);
        String childWindowID = windowID.get(1);

        System.out.println("List Parent Window ID:" +parentWindowID);
        System.out.println("List Child Window ID:" +childWindowID);


        //Switch to window now

        driver.switchTo().window(parentWindowID);
        System.out.println("Title of the parent window page:" +driver.getTitle());

        driver.switchTo().window(childWindowID);
        System.out.println("Title of the child page is:" +driver.getTitle());

        driver.quit();
    }

    @Test(priority = 2)
    public void handleWindowActionTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",10);

        WebElement link = driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']"));
        link.click();

        Set<String> windowsIDs=driver.getWindowHandles();
        //Convert set to list collection
        List<String> windowID = new ArrayList<>(windowsIDs);
        String parentWindowID = windowID.get(0);
        String childWindowID = windowID.get(1);

        System.out.println("List Parent Window ID:" +parentWindowID);
        System.out.println("List Child Window ID:" +childWindowID);

        driver.switchTo().window(childWindowID);
        System.out.println("Title of the child page is:" +driver.getTitle());

        System.out.println("Print using for loop");
        for (String winID:windowID
             ) {
            String title = driver.switchTo().window(winID).getTitle();
            System.out.println("Page Title is:"+title);
        }


        List<WebElement> contactSales = driver.findElements(By.xpath("//button[text()='Contact Sales']"));
        WebElement contactSale = contactSales.get(1);
        Thread.sleep(6000);
        contactSale.click();

        driver.findElement(By.xpath("//input[@id='Form_getForm_FullName']")).sendKeys("admin09090");
        driver.findElement(By.xpath("//input[@id='Form_getForm_Contact']")).sendKeys("9876543210");
        driver.findElement(By.xpath("//input[@id='Form_getForm_Email']")).sendKeys("admin09090@gmail.com");

        WebElement drpCountry = driver.findElement(By.xpath("//select[@name='Country']"));
        Select countryList = new Select(drpCountry);

        List<WebElement> countryChoice = countryList.getOptions();
        countryChoice.get(2).click();

        WebElement drpEmployee = driver.findElement(By.xpath("//select[@name='NoOfEmployees']"));
        Select employeeList = new Select(drpEmployee);

        List<WebElement> empChoice = employeeList.getOptions();
        empChoice.get(2).click();


        driver.findElement(By.xpath("//input[@name='JobTitle']")).sendKeys("TestDesign");
        driver.findElement(By.xpath("//textarea[@name='Comment']")).sendKeys("Test");

        driver.findElement(By.xpath("//textarea[@name='Comment']")).sendKeys(Keys.TAB);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,400)");

        driver.close();

        driver.switchTo().window(parentWindowID);
        System.out.println("I am in Parent Window Title page:" +driver.getTitle());

        Thread.sleep(6000);
        driver.quit();
    }

    public static WebElement waitForElement(WebDriver driver, long timeout, By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }
}
