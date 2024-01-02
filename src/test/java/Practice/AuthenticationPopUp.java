package Practice;

import org.testng.annotations.Test;

public class AuthenticationPopUp extends GenericTest{


    @Test(priority = 1)
    public void handleAuthPopupTest()
    {
        GenericTest genericTest = new GenericTest();

        //Syntax
        //https://user:password@Url

        //user = admin
        //Password = admin

        genericTest.launchApplication("https://admin:admin@the-internet.herokuapp.com/basic_auth",20);

        driver.quit();
    }
}
