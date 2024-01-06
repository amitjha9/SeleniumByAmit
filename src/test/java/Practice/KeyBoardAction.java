package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeyBoardAction extends GenericTest{


    @Test(priority = 1)
    public void performKeyboardUsingActionsClassTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://the-internet.herokuapp.com/key_presses",10);

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();

        Thread.sleep(2000);

        actions.sendKeys(Keys.BACK_SPACE).perform();
        Thread.sleep(2000);

        actions.sendKeys(Keys.ARROW_RIGHT).perform();
        Thread.sleep(2000);

        driver.quit();
    }

    @Test(priority = 2)
    public void performMultipleKeyboardActionTest()
    {
        /*
        Requirement is
        Do Command+A - to select the text
        Do Command+C - to copy the text
        Do TAB - to switch to next text box
        Do Command+V - to paste the text in new text box
         */

        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://text-compare.com/",10);

        WebElement firstInputBox = driver.findElement(By.xpath("//textarea[@id=\"inputText1\"]"));
        firstInputBox.sendKeys("Amit");

        WebElement secondInputBox = driver.findElement(By.xpath("//textarea[@id=\"inputText2\"]"));

        Actions actions = new Actions(driver);

        //Command+A - to select the text
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("A");
        actions.keyUp(Keys.CONTROL);
        actions.perform();

        //Command+C - to copy the text
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("C");
        actions.keyUp(Keys.CONTROL);
        actions.perform();

        //TAB - to switch to next text box
        actions.sendKeys(Keys.TAB);
        actions.perform();

        //Command+V - to paste the text in new text box
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("V");
        actions.keyUp(Keys.CONTROL);
        actions.perform();

        if(firstInputBox.getText().equalsIgnoreCase(secondInputBox.getText()))
        {
            System.out.println("Text has copied");
        }
        else
        {
            System.out.println("Text has not copied");
        }

        driver.quit();
    }
}
