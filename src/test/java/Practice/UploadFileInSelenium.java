package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadFileInSelenium extends GenericTest{

    /*
    Requirement
    1. Upload a file using selenium web driver in two ways
    1.1 : Using sendKeys()
    1.2 : Robot class
     */


    @Test(priority = 1)
    public void uploadFileUsingSendKeyTest() throws InterruptedException {
        /*
        In Selenium we can use sendKeys() method to upload a file if the HTML element has input type as "File" then only
        sendKeys() method will work to upload a file
         */

        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://the-internet.herokuapp.com/upload",10);

        WebElement chooseFile = driver.findElement(By.xpath("//input[@id=\"file-upload\"]"));
        chooseFile.sendKeys("/Users/amitkumarjha/Downloads/BrandAuthAdd (1).xlsx");

        System.out.println("File uploaded successfully");
        Thread.sleep(6000);
        driver.quit();

    }

    @Test(priority = 2)
    public void uploadFileUsingRobotClassTest() throws AWTException, InterruptedException {
        /*
        In Selenium we can not use sendKeys() method to upload a file if the HTML element has not input type as "File" then
        we have to use Robot class to handle window popup to upload a file
         */

        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://the-internet.herokuapp.com/upload",10);

        WebElement chooseFile = driver.findElement(By.xpath("//input[@id=\"file-upload\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",chooseFile);

        Robot robot = new Robot();
        robot.delay(3000);

        //First we have to copy the location the file location and put the file onto the clipboard
        StringSelection selection = new StringSelection("/Users/amitkumarjha/Downloads/BrandAuthAdd (1).xlsx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);

        //Now press CONTROL+V to paste the file in window popu
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        //Now release the keyword actions
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        //Now Press Enter to upload a file
        robot.keyPress(KeyEvent.VK_ENTER);

        //Now relase the key
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(6000);
        driver.quit();
    }
}
