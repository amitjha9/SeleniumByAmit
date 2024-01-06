package Practice;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;

public class HandleCookiesInSelenium extends GenericTest{

    /*
    Requirement
    1. How to capture cookies from browser
    2. How to print cookies from browser
    3. How to add cookies to the browser
    4. How to delete specific cookies from the browser
    5. How to delete all the cookies from the browser

    Few methods are provided by the selenium web driver
    driver.manage.getCookies(); - This returns the list of all the cookies
    driver.manage.addCookie(arg0); - Create and add the cookie
    driver.manage.deleteCookie(arg0); - Delete Specific Cookie
    driver.manage.deleteCookieNamed(arg0); - Delete specific cookie by name
    driver.manage.deleteAllCookies(); - Delete all cookies
     */

    @Test(priority = 1)
    public void handleCookieTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://demo.nopcommerce.com/",10);

        Set<Cookie> cookies = driver.manage().getCookies();

        //Get the total size of the cookie
        System.out.println("Total cookie size:" +cookies.size());

        //Print all the cookies
        Iterator<Cookie> itr = cookies.iterator();
        while (itr.hasNext())
        {
            Cookie cookie = itr.next();
            System.out.println("Cookie Name:" +cookie.getName()+ " Cookie Value:" +cookie.getValue());
        }

        //Adding new cookie
        Cookie cookieAddNewCookie = new Cookie("MyNewCookie","1234567");
        driver.manage().addCookie(cookieAddNewCookie);

        //After adding new cookie , let's get the size and print the cookie
        cookies = driver.manage().getCookies();
        System.out.println("Added new cookie to the browser:" +cookies.size());

        System.out.println("Print cookie after adding new one");
        Iterator<Cookie> itr1 = cookies.iterator();
        while (itr1.hasNext())
        {
            Cookie cookie = itr1.next();
            System.out.println("Cookie Name:" +cookie.getName()+ " Cookie Value:" +cookie.getValue());
        }

        //Now delete specific cookie
        driver.manage().deleteCookie(cookieAddNewCookie);
        cookies = driver.manage().getCookies();
        System.out.println("Total cookies after deleting one:" +cookies.size());

        //Delete cookie by name
        System.out.println("Deleting cookie by name");
        driver.manage().deleteCookieNamed(".Nop.Customer");
        cookies = driver.manage().getCookies();
        System.out.println("Total cookies after deleting cookie by name:" +cookies.size());

        System.out.println("Print cookie after deleting by name");
        Iterator<Cookie> itr2 = cookies.iterator();
        while (itr2.hasNext())
        {
            Cookie cookie = itr2.next();
            System.out.println("Cookie Name:" +cookie.getName()+ " Cookie Value:" +cookie.getValue());
        }

        //Delete all the cookies now
        System.out.println("Deleting all the cookies from the browser here");
        driver.manage().deleteAllCookies();
        System.out.println("Size after deleting all the cookies:" +driver.manage().getCookies().size());
        driver.quit();
    }
}
