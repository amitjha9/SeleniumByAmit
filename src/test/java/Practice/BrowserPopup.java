package Practice;

import org.testng.annotations.Test;

public class BrowserPopup extends GenericTest{


    /*
    for browser pop up use setting at the browser level
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-notifications");
     */

    @Test(priority = 1)
    public void handlePermissionPopupTest() throws InterruptedException {

        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://www.redbus.in/",20);
        Thread.sleep(3000);
        driver.quit();
    }
}
