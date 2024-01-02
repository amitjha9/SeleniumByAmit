package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;

public class JqueryDropDown extends GenericTest{

    @Test(priority = 1)
    public void multiSelectionDropDownTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/",10);

        WebElement select = driver.findElement(By.xpath("//input[@id='justAnInputBox']"));
        select.click();

        //selectValueFromDropDownList(driver,"choice 1");
        selectValueFromDropDownList(driver,"choice 2","choice 2 1","choice 2 2","choice 2 3","choice 6 2 1");
        //selectValueFromDropDownList(driver, "all");
        driver.quit();
    }


    public void selectValueFromDropDownList(WebDriver driver, String... value) throws InterruptedException {
        List<WebElement> choiceList = driver.findElements(By.xpath("//ul//li//span[@class='comboTreeItemTitle']"));
        int actualSize = choiceList.size()-30;
        if(!value[0].equalsIgnoreCase("all"))
        {
            for(int j=0; j<actualSize; j++)
            {
                WebElement choice = choiceList.get(j);
                String text = choice.getText();
                for(int k=0; k<value.length; k++)
                {
                    if(text.equalsIgnoreCase(value[k]))
                    {
                        choice.click();
                        Thread.sleep(2000);
                    }
                }
            }
        }
        else
        {
            for(int i=0; i<actualSize;i++)
            {
                WebElement choice = choiceList.get(i);
                choice.click();
                Thread.sleep(2000);
            }
        }
    }
}
