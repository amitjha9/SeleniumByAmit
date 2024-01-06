package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ToolTip extends GenericTest{

    /*
    Requirement
    1. How to capture tooltip of a web element
    2. How to open a link in new tab window
    3. How to open URL's in a multiple tab or Windows
    4. How to capture size and location of a web element
     */

    @Test(priority = 1)
    public void captureToolTipInputBoxTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://jqueryui.com/tooltip/",10);


        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class=\"demo-frame\"]")));

        WebElement inputBox = driver.findElement(By.xpath("//input[@id=\"age\"]"));
        String toolTipText = inputBox.getAttribute("title");
        System.out.println("ToolTip Text:" +toolTipText);

        driver.quit();
    }

    @Test(priority = 2)
    public void captureToolTipLinkTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://jqueryui.com/tooltip/",10);


        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class=\"demo-frame\"]")));

        WebElement link = driver.findElement(By.xpath("//a[text()=\"ThemeRoller\"]"));
        String toolTipText = link.getAttribute("title");
        System.out.println("ToolTip Text:" +toolTipText);

        driver.quit();
    }


    @Test(priority = 3)
    public void openLinkInNewTabTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://demo.nopcommerce.com/",10);

        WebElement element = driver.findElement(By.linkText("Register"));

        //This statement is used for opening any link in new tab
        String tab = Keys.chord(Keys.CONTROL,Keys.RETURN);
        element.sendKeys(tab);

        Thread.sleep(6000);
        driver.quit();
    }

    @Test(priority = 4)
    public void openMultipleURLInMultipleTabTest()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");

        //This is the command to switch and open new URL in new tab without effecting the first URL.
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.quit();
    }

    @Test(priority = 5)
    public void openMultipleURLInMultipleWindowTest()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");

        //This is the command to switch and open new URL in new window.
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.quit();
    }

    @Test(priority = 6)
    public void locationAndSizeofWebElementTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",10);

        WebElement logo = driver.findElement(By.xpath("//img[@alt=\"company-branding\"]"));

        //Get the location of the web element
        System.out.println("Location of(x,y):" +logo.getLocation());
        System.out.println("Location of(x):" +logo.getLocation().getX());
        System.out.println("Location of(y):" +logo.getLocation().getY());

        //Get the size of the web element
        System.out.println("Size of(x,y):" +logo.getSize());
        System.out.println("Width:" +logo.getSize().getWidth());
        System.out.println("Height:" +logo.getSize().getHeight());

        driver.quit();
    }
}
