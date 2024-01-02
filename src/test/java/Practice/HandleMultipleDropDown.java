package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.util.List;

public class HandleMultipleDropDown extends GenericTest{


    @Test
    public void handleMultipleDropDownTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://www.orangehrm.com/en/30-day-free-trial/",10);

        WebElement countryDrp = driver.findElement(By.xpath("//select[@id='Form_getForm_Country']"));

        Select countryDropDown = new Select(countryDrp);
        List<WebElement> countryList=countryDropDown.getOptions();

        for (int i=0; i<countryList.size(); i++)
        {
            String countryName=countryList.get(i).getText();
            if(countryName.equalsIgnoreCase("Armenia"))
            {
                String name = countryList.get(i).getText();
                System.out.println("Name:" +name);
            }
        }
        driver.quit();
    }
}
