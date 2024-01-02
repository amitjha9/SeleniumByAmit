package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckDropDownSorted extends GenericTest{


    @Test(priority = 1)
    public void checkDropDownValueSortedTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://twoplugs.com/",10);

        WebElement livePost = driver.findElement(By.xpath("//a[text()='Live Posting']"));
        livePost.click();

        WebElement drpElement = driver.findElement(By.xpath("//select[@name = 'category_id']"));
        Select drpSelect = new Select(drpElement);

        List<WebElement> drpValue = drpSelect.getOptions();

        //Create two list now
        List<String> originalList = new ArrayList<>();
        List<String> tempList = new ArrayList<>();

        for(int i=0; i<drpValue.size(); i++)
        {
            originalList.add(drpValue.get(i).getText());
            tempList.add(drpValue.get(i).getText());
        }

        //Print the list now
        System.out.println("Original List :" +originalList);
        System.out.println("Temp List:" +tempList);

        //Sort the temp list here
        Collections.sort(tempList);

        System.out.println("Temp List after sorting:" +tempList);

        if(originalList.equals(tempList))
        {
            System.out.println("Dropdown value sorted..");
        }
        else
        {
            System.out.println("Dropdown value not sorted...");
        }
        driver.quit();
    }
}
