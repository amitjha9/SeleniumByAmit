package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class AutoCompleteGooglePlacesDropDown extends GenericTest{

    @Test(priority = 1)
    public void test()
    {
        int i=1;
        do {
            System.out.println("Value:" +i);
            i++;
        }
        while (i<10);
    }

    @Test(priority = 2)
    public void googleAutoPlacesDropDownTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://twoplugs.com/",10);

        WebElement livePost = driver.findElement(By.xpath("//a[text()='Live Posting']"));
        livePost.click();

        WebElement searchText = driver.findElement(By.xpath("//input[@id='autocomplete']"));
        searchText.clear();

        searchText.sendKeys("Toronto");
        String text;

        do {
            searchText.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(6000);
            text = searchText.getAttribute("value");
            if(text.equalsIgnoreCase("Toronto, OH, USA"))
            {
                searchText.sendKeys(Keys.ENTER);
                Thread.sleep(6000);
                break;
            }
        }
        while (!text.isEmpty());
        driver.quit();
    }

    @Test(priority = 3)
    public void makeMyTripAutoPlacesDropDownTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://www.makemytrip.com/",10);

        WebElement fromCity = driver.findElement(By.xpath("//input[@id='fromCity']"));

        fromCity.sendKeys("Mumbai");

        WebElement filedSearch = driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']"));

        List<WebElement> cities = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
        for(int i=0; i<cities.size(); i++)
        {
            WebElement cityName = cities.get(i);
            String name = cityName.getText();
            if(name.contains("Pune, India"))
            {
                filedSearch.clear();
                filedSearch.sendKeys("Pune");
                break;
            }
        }
        driver.quit();
    }
}
