package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.HashMap;

public class DownloadFileInSelenium {


    @Test(priority = 1)
    public void downloadFileToProjectPathLocationTest() throws InterruptedException {
        String locationPath = System.getProperty("user.dir")+"/DownloadFile/";
        HashMap<String,String> prefrences = new HashMap<>();
        prefrences.put("download.default_directory",locationPath);

        //Broser level setting
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs",prefrences);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        WebElement sampleDocFile = driver.findElement(By.xpath("//table[@class=\"table table-hover table-responsive dataTable no-footer\"]//tbody//tr[2]//td[5]"));
        Thread.sleep(3000);
        sampleDocFile.click();

        driver.quit();
    }
}
