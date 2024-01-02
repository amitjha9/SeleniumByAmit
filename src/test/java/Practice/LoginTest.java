package Practice;


import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends GenericTest{

    //Verify the title of the page
    GenericTest genericTest;
    LoginPage loginPage;

    String appUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    long time = 20;

    String user = "Admin";
    String pass = "admin123";


    @BeforeMethod
    public void setUP()
    {
       genericTest = new GenericTest();
       genericTest.launchApplication(appUrl,time);
       loginPage = new LoginPage();
    }



    @Test(priority = 1)
    public void verifyLoginTitleTest()
    {
        String loginTitle = loginPage.getLoginTitlePage();
        Assert.assertEquals(loginTitle,"OrangeHRM");
    }

    @Test(priority = 2)
    public void verifyLoginLogoTest()
    {
        boolean flag =loginPage.loginPageLogo();
        Assert.assertEquals(flag,true);
    }

    @Test(priority = 3)
    public void verifyLoginTest() throws InterruptedException {
        Thread.sleep(2000);
        loginPage.loginIntoApplication(user,pass);
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown()
    {
        genericTest.Quit(driver);
    }

}
