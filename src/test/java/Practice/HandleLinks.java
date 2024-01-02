package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;

public class HandleLinks extends GenericTest{


    @Test(priority = 1)
    public void handleLinkTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://www.amazon.com/",20);

        //Locate element using LinkText() and partialLinkText() method

        //Note: in linkText() parameter we pass inner text of the html code

        driver.navigate().refresh();

        WebElement todayDeal = driver.findElement(By.linkText("Gift Cards"));
        todayDeal.click();

        WebElement giftCard = driver.findElement(By.partialLinkText("Cards"));
        giftCard.click();


        //To get all the links present on the webpage - we have to use tag
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total link size is:" +links.size());

        //Print the total link text
        for(int i=0; i<links.size(); i++)
        {
            String text = links.get(i).getText();
            System.out.println("Link Text is:" +text);
        }

        System.out.println("===================");

        //Get href attribute from the links - means redirection link
        for(int j=0; j<links.size(); j++)
        {
            String destinationLink = links.get(j).getAttribute("href");
            System.out.println("Destination link is:" +destinationLink);
        }
        driver.quit();
    }
}
