package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class InputBox extends GenericTest{

    @Test(priority = 1)
    public void inputBoxTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F",10);

        WebElement emailID =driver.findElement(By.xpath("//input[@type='email']"));

        emailID.clear();
        Thread.sleep(2000);
        emailID.sendKeys("amitjhatest@gmail.com");
        driver.quit();
    }

    @Test(priority = 2)
    public void inputBoxAttributeTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F",10);

        WebElement emailID =driver.findElement(By.xpath("//input[@type='email']"));
        String emailAttributeText = emailID.getAttribute("value");
        System.out.println("Email Text:" +emailAttributeText);

        driver.quit();
    }

    @Test(priority = 3)
    public void getTextInnerTextTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F",10);

        WebElement login =driver.findElement(By.xpath("//button[@type='submit']"));
        String loginInnerText=login.getText();

        String classText=login.getAttribute("class");
        System.out.println("Login Inner Text:" +loginInnerText);
        System.out.println("Clas attribute value :" +classText);

        String headingText=driver.findElement(By.xpath("//h1[text()='Admin area demo']")).getText();
        System.out.println("Heading Text is:" +headingText);

        driver.quit();
    }
}
