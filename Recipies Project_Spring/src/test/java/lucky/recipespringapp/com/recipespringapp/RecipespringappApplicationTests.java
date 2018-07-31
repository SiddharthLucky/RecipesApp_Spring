package lucky.recipespringapp.com.recipespringapp;

import com.google.common.base.Verify;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipespringappApplicationTests {

    public WebDriver contextLoads()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\siddh\\Desktop\\MSS Workspace\\Recipies Project\\Recipies Project_Spring\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    @Test
    public void checkView()
    {
        List<String> name  = new ArrayList<>();
        name.add("sid");
        name.add("sam");
        WebDriver driver = contextLoads();
        for(String names : name)
        {
            driver.get("https://www.facebook.com/login");
            driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(names);
            driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(names);
            driver.findElement(By.xpath("//*[@id=\"loginbutton\"]")).click();
        }
        // Go to using Xpath if all other fail. 2 types of paths - Absolute XPath, relative Xpath.
        //Synchronization - The waiting has to be synchronized, can be achieved using implicit or explicit waitpoints.
        //Good practise is to wait for an object to load and than passing time in the implicit wait.
        //Apache POI - Feeding the data using external source. Check it out.
        String val = driver.getCurrentUrl();
        String expUrl = "http://localhost:8080/recipe/2/show/";

        if(val.equals("http://localhost:8080/recipe/2/show/"))
        {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void searchEngine()
    {
        //initializations;
        WebDriver driver = contextLoads();
        //Navigating to page.
        driver.get("http://newtours.demoaut.com/");

        //Variables to hold paths;
        String strRegXPath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[10]/td/table/tbody/tr/td[2]/font/a";

        //Collecting all the elements.
        WebElement registerLink = driver.findElement(By.xpath(strRegXPath));
        registerLink.click();

        /*WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));*/
    }

}
