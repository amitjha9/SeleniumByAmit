package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class HandleDynamicWebTable extends GenericTest{


    /*
    Definition of dynamic web table is: A table with pagination concept is called as dynamic web table on web pages.
    Requirements
    1.Find the total number of pages in the table
    2.Find the active pages
    2.Find how many rows exist in each pages
    3.Print the total rows value
     */


    @Test(priority = 1)
    public void getTotalPageTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://demo.opencart.com/admin/index.php",20);

        WebElement userName = driver.findElement(By.xpath("//input[@id=\"input-username\"]"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id=\"input-password\"]"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        login.click();

        WebElement close = driver.findElement(By.xpath("//button[@class=\"btn-close\"]"));
        close.click();

        driver.findElement(By.xpath("//a[text()=\" Sales\"]")).click();
        driver.findElement(By.xpath("//ul[@id=\"collapse-4\"]/li//a[text()=\"Returns\"]")).click();

        WebElement getTotalPage = driver.findElement(By.xpath("//div[text()=\"Showing 1 to 10 of 271 (28 Pages)\"]"));
        String totalTotalPageText = getTotalPage.getText();

        System.out.println("Total Page text:" +totalTotalPageText);

        String val = totalTotalPageText.substring(19,22);
        System.out.println("Value:" +val);

        try {
            int totalPage = Integer.parseInt(val);
            System.out.println("Total page is:" +totalPage);
        }
        catch (NumberFormatException ex)
        {
            System.out.println("Exception:" +ex.getMessage());
        }
        Thread.sleep(3000);
        driver.quit();
    }

    @Test(priority = 2)
    public void getActivePageTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://demo.opencart.com/admin/index.php",20);

        WebElement userName = driver.findElement(By.xpath("//input[@id=\"input-username\"]"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id=\"input-password\"]"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        login.click();

        WebElement close = driver.findElement(By.xpath("//button[@class=\"btn-close\"]"));
        close.click();

        driver.findElement(By.xpath("//a[text()=\" Sales\"]")).click();
        driver.findElement(By.xpath("//ul[@id=\"collapse-4\"]/li//a[text()=\"Returns\"]")).click();

        WebElement getTotalPage = driver.findElement(By.xpath("//div[text()=\"Showing 1 to 10 of 271 (28 Pages)\"]"));
        String totalTotalPageText = getTotalPage.getText();

        System.out.println("Total Page text:" +totalTotalPageText);

        String val = totalTotalPageText.substring(19,22);
        System.out.println("Value:" +val);

        try {
            int totalPage = Integer.parseInt(val);
            System.out.println("Total page is:" +totalPage);

            for(int i=1; i<10; i++)
            {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollTo(0,800)");
                Thread.sleep(4000);
                WebElement activePage=driver.findElement(By.xpath("//ul[@class=\"pagination\"]//li//span"));
                if(activePage.isDisplayed())
                {
                    System.out.println("Active Page is:" +activePage.getText());
                    activePage.click();
                }
                List<WebElement> totalRows = driver.findElements(By.xpath("//table[@class=\"table table-bordered table-hover\"]//tbody//tr"));
                System.out.println("Total Rows on Active Page:" +activePage.getText()+ " is:" +totalRows.size());

                String nextIndex = Integer.toString(i+1);
                WebElement nextPage = driver.findElement(By.xpath("//ul[@class=\"pagination\"]//li//a[text()="+nextIndex+"]"));
                nextPage.click();
            }
        }
        catch (NumberFormatException ex)
        {
            System.out.println("Exception:" +ex.getMessage());
        }
        Thread.sleep(3000);
        driver.quit();
    }

    @Test(priority = 3)
    public void getTableDataForActivePageTest() throws InterruptedException {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://demo.opencart.com/admin/index.php",20);

        WebElement userName = driver.findElement(By.xpath("//input[@id=\"input-username\"]"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id=\"input-password\"]"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        login.click();

        WebElement close = driver.findElement(By.xpath("//button[@class=\"btn-close\"]"));
        close.click();

        driver.findElement(By.xpath("//a[text()=\" Sales\"]")).click();
        driver.findElement(By.xpath("//ul[@id=\"collapse-4\"]/li//a[text()=\"Returns\"]")).click();

        WebElement getTotalPage = driver.findElement(By.xpath("//div[text()=\"Showing 1 to 10 of 271 (28 Pages)\"]"));
        String totalTotalPageText = getTotalPage.getText();

        System.out.println("Total Page text:" +totalTotalPageText);

        String val = totalTotalPageText.substring(19,22);
        System.out.println("Value:" +val);

        try {
            int totalPage = Integer.parseInt(val);
            System.out.println("Total page is:" +totalPage);

            for(int i=1; i<3; i++)
            {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollTo(0,800)");
                Thread.sleep(4000);
                WebElement activePage=driver.findElement(By.xpath("//ul[@class=\"pagination\"]//li//span"));
                if(activePage.isDisplayed())
                {
                    System.out.println("Active Page is:" +activePage.getText());
                    activePage.click();
                }

                //Getting Table Data Here
                js.executeScript("window.scrollTo(0,100)");
                Thread.sleep(6000);
                List<WebElement> totalColumn = driver.findElements(By.xpath("//table[@class=\"table table-bordered table-hover\"]//thead//tr//td"));
                int totalColumnSize = totalColumn.size();

                List<WebElement> totalRows = driver.findElements(By.xpath("//table[@class=\"table table-bordered table-hover\"]//tbody//tr"));
                int totalRowSize = totalRows.size();

                for(int p=1; p<totalRowSize; p++)
                {
                    for(int q=1; q<totalColumnSize; q++)
                    {
                        WebElement tableData = driver.findElement(By.xpath("//table[@class=\"table table-bordered table-hover\"]//tbody//tr["+p+"]//td["+q+"]"));
                        String tableText = tableData.getText();
                        System.out.println("Table Data is:" +tableText);
                    }
                }

                js.executeScript("window.scrollTo(0,0)");
                js.executeScript("window.scrollTo(0,800)");
                Thread.sleep(4000);
                //Clicking on next page
                String nextIndex = Integer.toString(i+1);
                WebElement nextPage = driver.findElement(By.xpath("//ul[@class=\"pagination\"]//li//a[text()="+nextIndex+"]"));
                nextPage.click();
            }
        }
        catch (NumberFormatException ex)
        {
            System.out.println("Exception:" +ex.getMessage());
        }
        Thread.sleep(3000);
        driver.quit();
    }
}
