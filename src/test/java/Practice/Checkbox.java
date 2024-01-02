package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Checkbox extends GenericTest{


    @Test(priority = 1)
    public void selectSingleCheckBoxTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://www.ironspider.ca/forms/checkradio.htm",10);

        WebElement singleCheck =driver.findElement(By.xpath("//input[@type=\"checkbox\" and @value=\"red\"]"));
        if(!singleCheck.isSelected())
        {
           singleCheck.click();
           Thread.sleep(6000);
        }
        driver.quit();
    }


    @Test(priority = 2)
    public void selectAllCheckBoxTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://www.ironspider.ca/forms/checkradio.htm",10);

        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
        for(int i=0; i<checkBoxes.size(); i++)
        {
            if(!checkBoxes.get(i).isSelected())
            {
                checkBoxes.get(i).click();
                Thread.sleep(6000);
            }
        }
        System.out.println("All checkbox selected");

        driver.quit();
    }


    @Test(priority = 3)
    public void selectMiddleCheckboxTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://www.ironspider.ca/forms/checkradio.htm",10);

        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
        int middleCheckboxNum = checkBoxes.size()/2;

        checkBoxes.get(middleCheckboxNum).click();
        Thread.sleep(6000);

        System.out.println("Selected middle checkbox");
        driver.quit();
    }


    @Test(priority = 4)
    public void selectSecondLastCheckboxTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://www.ironspider.ca/forms/checkradio.htm",10);
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));

        for(int i=checkBoxes.size()-2; i>0; i--)
        {
            if(!checkBoxes.get(checkBoxes.size()-2).isSelected())
            {
                checkBoxes.get(checkBoxes.size()-2).click();
                Thread.sleep(6000);
            }
        }
        System.out.println("Selected 2nd last element from checkbox list");
        driver.quit();
    }
}
