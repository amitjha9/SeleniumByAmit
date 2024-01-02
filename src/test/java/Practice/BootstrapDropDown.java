package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;

public class BootstrapDropDown extends GenericTest{

    @Test(priority = 1)
    public void dropDownOneTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://www.icicibank.com/",10);

        driver.findElement(By.xpath("//button[@class='hed-dropdown-toggle login-toggle']")).click();

        List<WebElement> drpValue = driver.findElements(By.xpath("//div[@class='hed-dropdown-list login-list']//ul//li"));

        for(int i=0; i<drpValue.size(); i++)
        {
            WebElement value = drpValue.get(i);
            System.out.println("Text is:" +value.getText());
        }
        driver.quit();
    }

    @Test(priority = 2)
    public void dropDownTwoTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",10);


        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("Admin");

        WebElement passWord = driver.findElement(By.xpath("//input[@name='password']"));
        passWord.sendKeys("admin123");


        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();

        WebElement drpDown = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
        drpDown.click();


        List<WebElement> drpValue = driver.findElements(By.xpath(" //ul[@class='oxd-dropdown-menu']/li"));

        for(int i=0; i<drpValue.size(); i++)
        {
            WebElement value = drpValue.get(i);
            System.out.println("Text is:" +value.getText());
        }
        driver.quit();
    }


    @Test(priority = 3)
    public void autoSuggestedDropDownTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://www.google.com/",10);


        WebElement searchText = driver.findElement(By.xpath("//textarea[@name='q']"));
        searchText.sendKeys("selenium");


        List<WebElement> drpValues = driver.findElements(By.xpath("//ul[@role='listbox']//li"));

        for(int i=0; i<drpValues.size(); i++)
        {
            WebElement value = drpValues.get(i);
            System.out.println("Values are:" +value.getText());
        }
        Thread.sleep(6000);
        driver.quit();
    }

    @Test(priority = 3)
    public void autoSuggestedDropDownSelectValueTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://www.google.com/",10);


        String selectValue = "selenium rich foods";
        WebElement searchText = driver.findElement(By.xpath("//textarea[@name='q']"));
        searchText.sendKeys("selenium");


        List<WebElement> drpValues = driver.findElements(By.xpath("//ul[@role='listbox']//li"));

        for(int i=0; i<drpValues.size(); i++)
        {
            WebElement value = drpValues.get(i);
            String textValue = value.getText();
            if(textValue.equalsIgnoreCase(selectValue))
            {
                searchText.clear();
                searchText.sendKeys(textValue);
                searchText.sendKeys(Keys.ENTER);
                break;
            }
        }
        Thread.sleep(6000);
        driver.quit();
    }
}
