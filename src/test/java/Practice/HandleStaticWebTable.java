package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;

public class HandleStaticWebTable extends GenericTest{

    /*
    Requirement
    1. How many table headers
    2. Print the header name
    3. How many rows in a table
    4. Print specific row details from a table
    5. print all the row details from a table
    6. Print all column data from a table
    7. Print specific row/column data from a table
    8. Print all the data from the table
     */

    @Test(priority = 1)
    public void numberOfHeadersInWebTableTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://practice.expandtesting.com/tables",20);

        List<WebElement> totalHeaders = driver.findElements(By.xpath("//table[@id='table1']//thead//th"));

        System.out.println("Total Size is:" +totalHeaders.size());

        driver.quit();
    }

    @Test(priority = 2)
    public void printHeadersInWebTableTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://practice.expandtesting.com/tables",20);

        List<WebElement> totalHeaders = driver.findElements(By.xpath("//table[@id='table1']//thead//th"));

        System.out.println("Total Size is:" +totalHeaders.size());

        //Now get the header and print them

        for(int i=0; i<totalHeaders.size(); i++)
        {
            String headerName = totalHeaders.get(i).getText();
            System.out.println("Header are:" +headerName);
        }
        driver.quit();
    }

    @Test(priority = 3)
    public void getTotalRowsInWebTableTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://practice.expandtesting.com/tables",20);

        List<WebElement> totalRows = driver.findElements(By.xpath("//table[@id=\"table1\"]//tbody//tr"));

        System.out.println("Total Size is:" +totalRows.size());

        driver.quit();
    }

    @Test(priority = 4)
    public void printSpecificRowInWebTableTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://practice.expandtesting.com/tables",20);

        int rowNum = 2;

        List<WebElement> totalRows = driver.findElements(By.xpath("//table[@id=\"table1\"]//tbody//tr"));
        System.out.println("Total Size is:" +totalRows.size());

        for(int i=0; i<totalRows.size(); i++)
        {
            if(i==rowNum)
            {
                String rowValue=totalRows.get(i).getText();
                System.out.println("Row Detail:" +rowValue);
            }
        }
        driver.quit();
    }

    @Test(priority = 5)
    public void printAllRowInWebTableTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://practice.expandtesting.com/tables",20);


        List<WebElement> totalRows = driver.findElements(By.xpath("//table[@id=\"table1\"]//tbody//tr"));
        System.out.println("Total Size is:" +totalRows.size());

        for(int i=0; i<totalRows.size(); i++)
        {
            String rowValue=totalRows.get(i).getText();
            System.out.println(" ");
            System.out.println("Row Detail:" +rowValue);
        }
        driver.quit();
    }

    @Test(priority = 6)
    public void printAllColumnInWebTableTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://practice.expandtesting.com/tables",20);


        List<WebElement> totalRows = driver.findElements(By.xpath("//table[@id=\"table1\"]//tbody//tr"));
        System.out.println("Total Size is:" +totalRows.size());

        for(int i=0; i<totalRows.size(); i++)
        {
            String rowValue=totalRows.get(i).getText();
            System.out.println(" ");
            System.out.println("Row Detail:" +rowValue);
        }
        driver.quit();
    }

    @Test(priority = 7)
    public void printSpecificValueWebTableTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://practice.expandtesting.com/tables",20);


        WebElement emailData = driver.findElement(By.xpath("//table[@id=\"table1\"]//tbody//tr[1]//td[3]"));
        String email = emailData.getText();
        System.out.println("Email :" +email);
        driver.quit();
    }

    @Test(priority = 8)
    public void getValueDynamicallyWebTableTest()
    {
        GenericTest genericTest = new GenericTest();
        genericTest.launchApplication("https://practice.expandtesting.com/tables",20);

        //First find total number of rows in a table
        List<WebElement> totalRows = driver.findElements(By.xpath("//table[@id=\"table1\"]//tbody//tr"));
        System.out.println("Number of Rows:" +totalRows.size());

        List<WebElement> totalColumn = driver.findElements(By.xpath("//table[@id=\"table1\"]//thead//th"));
        System.out.println("Number of Headers:" +totalColumn.size());

        for(int i=1; i<totalRows.size(); i++)
        {
            for(int j=1; j<totalColumn.size();j++)
            {
                WebElement dataValue = driver.findElement(By.xpath("//table[@id=\"table1\"]//tbody//tr["+i+"]//td["+j+"]"));
                String value = dataValue.getText();
                System.out.println("Data Value:" +value);
            }
        }
        driver.quit();
    }
}
