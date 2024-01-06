package Practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.util.List;

public class SeleniumActions extends GenericTest{


    @Test(priority = 1)
    public void performSendKeysUsingActionClassTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",10);

        Actions actions = new Actions(driver);

        WebElement userName = driver.findElement(By.xpath("//input[@name=\"username\"]"));
        actions.sendKeys(userName,"Admin").perform();
        Thread.sleep(6000);
        driver.quit();
    }

    @Test(priority = 2)
    public void performSendClickUsingActionClassTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",10);

        Actions actions = new Actions(driver);

        WebElement userName = driver.findElement(By.xpath("//input[@name=\"username\"]"));
        actions.sendKeys(userName,"Admin").perform();

        WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        actions.sendKeys(password,"admin123").perform();

        WebElement login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        //Perform click using Actions class
        actions.click(login).perform();
        Thread.sleep(6000);
        driver.quit();
    }

    @Test(priority = 3)
    public void performRightClickUsingActionClassTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://demo.guru99.com/test/simple_context_menu.html",10);

        WebElement rightClickMe = driver.findElement(By.xpath("//span[text()=\"right click me\"]"));

        Actions actions = new Actions(driver);
        actions.contextClick(rightClickMe).perform();


        List<WebElement> totalRightClickAction = driver.findElements(By.xpath("//ul[@class=\"context-menu-list context-menu-root\"]//li//span"));
        System.out.println("Total Right click Action is:" +totalRightClickAction.size());

        for(int i=0; i<totalRightClickAction.size(); i++)
        {
            String rightClickText = totalRightClickAction.get(i).getText();
            System.out.println("Action Text is:" +rightClickText);
            if(rightClickText.equalsIgnoreCase("Edit"))
            {
                totalRightClickAction.get(i).click();
                break;
            }
        }
        Thread.sleep(6000);

        Alert popup = driver.switchTo().alert();
        String text = popup.getText();
        System.out.println("Pop up text:" +text);
        popup.accept();
        driver.quit();
    }

    @Test(priority = 4)
    public void performDoubleClickUsingAlertClassTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://demo.guru99.com/test/simple_context_menu.html",10);

        WebElement doubleClickMe = driver.findElement(By.xpath("//button[text()=\"Double-Click Me To See Alert\"]"));

        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickMe).perform();

        Thread.sleep(6000);
        Alert popup = driver.switchTo().alert();
        String text = popup.getText();
        System.out.println("Pop up text:" +text);
        popup.accept();
        driver.quit();
    }

    @Test(priority = 5)
    public void performDragDropUsingActionClassTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-1.html",10);

        WebElement sourceElement = driver.findElement(By.xpath("//div[@id=\"box1\" and text()=\"CAT\"]"));
        WebElement destination = driver.findElement(By.xpath("//div[@id=\"dropBox\"]"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(sourceElement).release(destination).release().perform();

        Thread.sleep(6000);
        driver.quit();
    }

    @Test(priority = 6)
    public void performImageDragDropUsingActionClassTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://www.globalsqa.com/demo-site/draganddrop/",10);

        Actions actions = new Actions(driver);

        //Switch to iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class=\"demo-frame lazyloaded\"]")));
        WebElement destination = driver.findElement(By.xpath("//span[text()=\"Trash\"]"));

        List<WebElement> images = driver.findElements(By.xpath("//ul[@id=\"gallery\"]//li"));
        for(int i=0; i<images.size(); i++)
        {
            WebElement sourceElement = images.get(i);
            actions.dragAndDrop(sourceElement,destination).perform();
            Thread.sleep(3000);
        }

        System.out.println("All the images moved to trash box successfully");
        Thread.sleep(6000);
        driver.quit();
    }

    @Test(priority = 7)
    public void mouseHoverActionUsingActionClassTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://demo.opencart.com/",10);

        Actions actions = new Actions(driver);

        WebElement sourceElementDesktop = driver.findElement(By.xpath("//ul[@class=\"nav navbar-nav\"]//li//a[text()=\"Desktops\"]"));
        WebElement destinationElementMac = driver.findElement(By.xpath("//ul[@class=\"list-unstyled\"]//li//a[text()=\"Mac (1)\"]"));


        actions.moveToElement(sourceElementDesktop).moveToElement(destinationElementMac).click().perform();
        Thread.sleep(3000);
        System.out.println("Element clicked successfully");
        Thread.sleep(3000);
        driver.quit();
    }

    @Test(priority = 8)
    public void verifyActionVsActionsTest() throws InterruptedException {
        /*
        Actions is class in selenium
        Action is just an action - when we perform build operation from that operation we got the return type as "Action"
         */

        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://demo.opencart.com/",10);

        Actions actions = new Actions(driver);

        WebElement sourceElementDesktop = driver.findElement(By.xpath("//ul[@class=\"nav navbar-nav\"]//li//a[text()=\"Desktops\"]"));
        WebElement destinationElementMac = driver.findElement(By.xpath("//ul[@class=\"list-unstyled\"]//li//a[text()=\"Mac (1)\"]"));

        //Action is just an action - when we perform build operation from that operation we got the return type as "Action"
        Action clicked = actions.moveToElement(sourceElementDesktop).moveToElement(destinationElementMac).click().build();
        clicked.perform();
        Thread.sleep(3000);
        System.out.println("Element clicked successfully");
        Thread.sleep(3000);
        driver.quit();
    }
}
