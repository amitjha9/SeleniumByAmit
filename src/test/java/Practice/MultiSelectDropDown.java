package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.util.List;

public class MultiSelectDropDown extends GenericTest{

    @Test(priority = 1)
    public void multipleSelectDropDownValueTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://admirhodzic.github.io/multiselect-dropdown/demo.html",10);

        WebElement drpDown = driver.findElement(By.xpath("//select[@name='field1']"));

        Select select = new Select(drpDown);
        List<WebElement> allOptions = select.getOptions();

        for (WebElement optionVal:allOptions) {
            String textName = optionVal.getAttribute("innerHTML");
            System.out.println("Text Name:" +textName);
        }
        System.out.println("Total Size is:" +allOptions.size());
        driver.quit();
    }
}
