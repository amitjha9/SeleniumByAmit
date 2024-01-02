package Pages;

import Practice.GenericTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends GenericTest {

    GenericTest genericTest;

    long time = 40;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement login;

    @FindBy(xpath = "//img[@alt='company-branding']")
    public WebElement loginLogo;

    public LoginPage()
    {
        PageFactory.initElements(driver,this);
    }

    //Get the title of this page
    public String getLoginTitlePage()
    {
        return driver.getTitle();
    }

    public boolean loginPageLogo()
    {
        boolean flag = false;
        if(loginLogo.isDisplayed())
        {
            flag = true;
        }
        return  flag;
    }

    public void loginIntoApplication(String userName, String passWord)
    {
        if(!username.isDisplayed() && password.isDisplayed())
        {
            impliclitlyWait(driver,time);
        }
        else {
            username.sendKeys(userName);
            password.sendKeys(passWord);
            login.click();
        }
    }
}
