package Practice;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class TakeScreenshotInSelenium extends GenericTest{

    /*
    Requirement: Take a screenshot of a web page at any test failure
    1. Take a full web page screenshot
    2. Take a section/portion of web page screenshot
    3. Take a screenshot of a particular web element
     */

    @Test(priority = 1)
    public void takeFullPageScreenshotTest() throws IOException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://demo.nopcommerce.com/",10);

        int randomInt = generateRandomInt();

        String fileName = "Test1"+randomInt+".jpg";

        String destinationPath = System.getProperty("user.dir");
        String destPath = destinationPath+"/screenshots/";

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        //Take screenshot and store it in a file format
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File target = new File(destPath+fileName);
        FileUtils.copyFile(source,target);
        driver.quit();
    }

    @Test(priority = 2)
    public void takeSpecificWebElementScreenshotTest() throws IOException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://demo.nopcommerce.com/",10);

        WebElement element = driver.findElement(By.xpath("//div[@class=\"product-grid home-page-product-grid\"]"));

        int randomInt = generateRandomInt();

        String fileName = "WebElement"+randomInt+".jpg";

        String destinationPath = System.getProperty("user.dir");
        String destPath = destinationPath+"/screenshots/";

        //For a specific web element screenshot we don't need to use TakesScreenshot , simply we can get screenshot on web element
        File source = element.getScreenshotAs(OutputType.FILE);
        File target = new File(destPath+fileName);
        FileUtils.copyFile(source,target);
        driver.quit();
    }


    public int generateRandomInt()
    {
        Random random = new Random();
        int num=random.nextInt(1000);
        return num;
    }
}
