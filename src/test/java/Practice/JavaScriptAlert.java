package Practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptAlert extends GenericTest{


    @Test(priority = 1)
    public void handleJsPopupAlertTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://demo.automationtesting.in/Alerts.html",20);

        WebElement alertWithOK = driver.findElement(By.xpath("//a[text()=\"Alert with OK \"]"));
        alertWithOK.click();

        driver.findElement(By.xpath("//button[@class=\"btn btn-danger\"]")).click();


        //To get the text from the alert
        Alert alertWindow = driver.switchTo().alert();
        String text = alertWindow.getText();

        System.out.println("Text is:" +text);

        //click on OK button
        Thread.sleep(6000);
        driver.switchTo().alert().accept();

        driver.quit();
    }

    @Test(priority = 2)
    public void handleJsOkAndCancelAlertTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://demo.automationtesting.in/Alerts.html",20);

        WebElement alertWithOK = driver.findElement(By.xpath("//a[text()=\"Alert with OK & Cancel \"]"));
        alertWithOK.click();

        driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();


        //To get the text from the alert
        Alert alertWindow = driver.switchTo().alert();
        String text = alertWindow.getText();

        System.out.println("Text is:" +text);

        //click on OK button
        Thread.sleep(6000);
        //driver.switchTo().alert().accept();

        //This is for cancel
        driver.switchTo().alert().dismiss();
        Thread.sleep(6000);

        driver.quit();
    }

    @Test(priority = 3)
    public void handleJsAcceptValueAlertTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://demo.automationtesting.in/Alerts.html",20);

        WebElement alertWithOK = driver.findElement(By.xpath("//a[text()=\"Alert with Textbox \"]"));
        alertWithOK.click();

        driver.findElement(By.xpath("//button[@class=\"btn btn-info\"]")).click();
        Thread.sleep(6000);

        //To get the text from the alert
        Alert alertWindow = driver.switchTo().alert();
        String text = alertWindow.getText();

        System.out.println("Text is:" +text);

        alertWindow.sendKeys("Welcome Automation");
        alertWindow.accept();
        Thread.sleep(6000);
        driver.quit();
    }
}
