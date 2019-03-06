package Com.cyberteck.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;

    @BeforeMethod
    public void beforeEachTest(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//it waits until all the element is find
        //explicityWait    waits until it finds specific element
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);//until the page is loaded

    }
    @AfterMethod
    public void afterEachTest(){
       try{
           Thread.sleep(4000);
       }catch (InterruptedException e){

       }
        if(driver!= null){
            driver.quit();
        }

    }
}
