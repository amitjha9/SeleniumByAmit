package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class HandleBrokenLinks extends GenericTest{


    //Definition of Broken link
    /*
    if any link gives the response status code > 400 , and having target page not defined , then it is considered as broken link
    if any link is null - it will not be a broken link
    if any link gives response status code < 400 - and having a target page defined then it is considered as valid link
     */


    @Test(priority = 1)
    public void handleBrokenLinkTest() throws IOException {
        int totalBrokenLink = 0;
        int totalValidLink = 0;
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("http://www.deadlinkcity.com/",20);

        List<WebElement> links = driver.findElements(By.tagName("a"));
        for(int i=0; i<links.size(); i++)
        {
            String url=links.get(i).getAttribute("href");
            if(url.isEmpty() || url==null)
            {
                System.out.println("URL is empty");
                continue;
            }
            else
            try {
                {
                    URL url1 = new URL(url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url1.openConnection();
                    httpURLConnection.connect();
                    if(httpURLConnection.getResponseCode()>=400)
                    {
                        totalBrokenLink++;
                        System.out.println("Broken link with code :" +httpURLConnection.getResponseCode()+ " and URL:" +url1);
                    }
                    else
                    {
                        totalValidLink++;
                        System.out.println("Valid link with code :" +httpURLConnection.getResponseCode()+ " and URL:" +url1);
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        System.out.println("Total Broken Link:" +totalBrokenLink);
        System.out.println("Total Valid Link:" +totalValidLink);
        driver.quit();
    }
}
