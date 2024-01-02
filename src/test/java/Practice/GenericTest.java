package Practice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class GenericTest {


    public static  WebDriver driver = null;


    public void launchApplication(String url, long timeout)
    {
        try {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setBrowserVersion("115");
            chromeOptions.addArguments("--disable-notifications");
            driver = new ChromeDriver(chromeOptions);
            driver.get(url);
            driver.manage().window().maximize();
            impliclitlyWait(driver,timeout);
        }
        catch (WebDriverException e)
        {
            String error = e.getMessage();
            System.out.println("Error while opening url is:" +error);
        }
    }

    public void clickElement(WebDriver driver, WebElement element)
    {
        try
        {
            element.click();
        }
        catch (WebDriverException e)
        {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();",element);
        }
    }

    public void clickElementWithoutJS(WebElement element)
    {
        element.click();
    }

    public void clickElementWithXpath(WebDriver driver, String xpath)
    {
        try
        {
            WebElement element=driver.findElement(By.xpath(xpath));
            element.click();
        }
        catch (WebDriverException e)
        {

        }
    }

    public void impliclitlyWait(WebDriver driver,long timeout)
    {
        try
        {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
        }
        catch (WebDriverException e)
        {
            e.printStackTrace();
        }
    }

    public  void clearAndType(String text, WebElement element)
    {
        try {
            element.clear();
            element.sendKeys(text);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void sendKeys(WebElement element, String text)
    {
        element.sendKeys(text);
    }

    public String getTitle(WebDriver driver)
    {
        String title = "";
        title=driver.getTitle();
        return  title;
    }

    public void Quit(WebDriver driver)
    {
        driver.quit();
    }
}
