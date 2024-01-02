package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class JavaScriptExecutorExample extends GenericTest{


    //Refresh page Using JS
    @Test(priority = 1)
    public void refreshPageUsingJSTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://www.ironspider.ca/forms/checkradio.htm",10);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(5000);
        js.executeScript("location.reload()");

        Thread.sleep(3000);
        driver.quit();
    }

    //Get page title Using JS
    @Test(priority = 2)
    public void getPageTitleUsingJSTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",10);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println(js.executeScript("return document.title"));
        driver.quit();
    }

    //Get the website URL using JS
    @Test(priority = 3)
    public void getPageURLUsingJSTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",10);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println(js.executeScript("return document.URL"));
        driver.quit();
    }


    //Execute Java Script using selenium command
    @Test(priority = 4)
    public void getAlertUsingJSTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",10);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('Amit')");
        try {
            Thread.sleep(6000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        driver.quit();
    }


    //Execute Java Script using selenium command
    @Test(priority = 5)
    public void getPromptUsingJSTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",10);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("prompt('Hello Amit')");
        try {
            Thread.sleep(6000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        driver.quit();
    }

    //Enter text into text box using JS
    @Test(priority = 6)
    public void inputBoxUsingJSTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",10);

        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='Admin'",userName);
        try {
            Thread.sleep(6000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        driver.quit();
    }


    @Test(priority = 7)
    public void inputBoxDOMUsingJSTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",10);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByName('username')[0].value='Admin'");
        try {
            Thread.sleep(6000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        driver.quit();
    }

    @Test(priority = 8)
    public void changeButtonBackgroundColorUsingJSTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",10);


        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("document.getElementsByClassName('oxd-button oxd-button--medium oxd-button--main orangehrm-login-button')[0].style.background='green'");
        js.executeScript("arguments[0].style.background='green'",loginButton);
        try {
            Thread.sleep(6000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        driver.quit();
    }

    @Test(priority = 9)
    public void findTotalCheckboxesUsingJsTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://www.ironspider.ca/forms/checkradio.htm",10);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> totalCheckBoxes = (List<WebElement>) js.executeScript("return document.getElementsByName('color')");

        for(int i=0; i<totalCheckBoxes.size(); i++)
        {
            WebElement checkBox = totalCheckBoxes.get(i);
            System.out.println("Attribute Value:" +checkBox.getAttribute("value"));
        }

        try {
            Thread.sleep(6000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        driver.quit();
    }

    @Test(priority = 10)
    public void selectFirstCheckboxesUsingJsTest() {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://www.ironspider.ca/forms/checkradio.htm",10);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> totalCheckBoxes = (List<WebElement>) js.executeScript("return document.getElementsByName('color')");

        for(int i=0; i<totalCheckBoxes.size(); i++)
        {
            WebElement checkBox = totalCheckBoxes.get(i);
            if(checkBox.getAttribute("value").equalsIgnoreCase("red"))
            {
                js.executeScript("arguments[0].click()",checkBox);
                break;
            }
        }

        try {
            Thread.sleep(6000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        driver.quit();
    }

    @Test(priority = 11)
    public void selectMiddleCheckboxesUsingJsTest() {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://www.ironspider.ca/forms/checkradio.htm",10);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> totalCheckBoxes = (List<WebElement>) js.executeScript("return document.getElementsByName('color')");

        for(int i=0; i<totalCheckBoxes.size(); i++)
        {
            WebElement checkBox = totalCheckBoxes.get(i);
            if(checkBox.getAttribute("value").equalsIgnoreCase("orange"))
            {
                js.executeScript("arguments[0].click()",checkBox);
                break;
            }
        }

        try {
            Thread.sleep(6000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        driver.quit();
    }

    @Test(priority = 12)
    public void findTotalRadioButtonUsingJsTest() {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://www.ironspider.ca/forms/checkradio.htm",10);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> totalRadioButton = (List<WebElement>) js.executeScript("return document.getElementsByName('browser')");

        for(int i=0; i<totalRadioButton.size(); i++)
        {
            WebElement radioButton = totalRadioButton.get(i);
            System.out.println("Value is:" +radioButton.getAttribute("name"));
        }

        try {
            Thread.sleep(6000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        driver.quit();
    }

    @Test(priority = 13)
    public void selectRadioButtonUsingJsTest() {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://artoftesting.com/samplesiteforselenium",10);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> totalRadioButton = (List<WebElement>) js.executeScript("return document.getElementsByName('gender')");

        for(int i=0; i<totalRadioButton.size(); i++)
        {
            WebElement radioButton = totalRadioButton.get(i);
            if(radioButton.getAttribute("value").equalsIgnoreCase("female"))
            {
                js.executeScript("arguments[0].click()",radioButton);
                break;
            }
        }
        try {
            Thread.sleep(6000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        driver.quit();
    }

    @Test(priority = 14)
    public void dropDownUsingJsTest() {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://artoftesting.com/samplesiteforselenium",10);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> automationDropValue = (List<WebElement>) js.executeScript("return document.getElementById('testingDropdown')");

        for(int i=0; i<automationDropValue.size(); i++)
        {
            WebElement dropVal = automationDropValue.get(i);
            System.out.println("Inner Text is:" +dropVal.getText());
        }
        try {
            Thread.sleep(6000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        driver.quit();
    }
}
