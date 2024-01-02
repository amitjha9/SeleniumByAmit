package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Navigations {


    @Test
    public void navigatioTest() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("115");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.get("https://www.myntra.com/");
        driver.manage().window().maximize();

        driver.navigate().back(); //Myntra
        driver.navigate().forward(); //Amazon

        driver.navigate().to("https://www.google.com/");

        Thread.sleep(2000);
        driver.navigate().refresh();

        driver.quit();
    }
}

//Functionality wise there is no difference between get() and to() method.
//to() - method internally calls get() only , but it get() - accepts only string as a parameter , but to() accept string as
//as a parameter and URL instance as a parameter
