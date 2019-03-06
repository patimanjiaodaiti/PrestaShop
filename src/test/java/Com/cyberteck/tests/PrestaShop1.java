package Com.cyberteck.tests;

import Com.cyberteck.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PrestaShop1 extends TestBase {
    @Test
    public void test1(){
        driver.get(" http://automationpractice.com/index.php");
        WebElement dressName = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[4]/div/div[2]/h5/a"));
        String beforeNameText = dressName.getText();

        WebElement dressPrice = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[4]/div/div[2]/div[1]/span"));
        String beforePriceText = dressPrice.getText();

        driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[4]/div/div[2]/h5/a")).click();

        WebElement afterName = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/h1"));
        String afterNameText = afterName.getText();

        WebElement afterPrice = driver.findElement(By.id("our_price_display"));
        String afterPriceText= afterPrice.getText();

        Assert.assertEquals(beforeNameText,afterNameText);
        Assert.assertEquals(beforePriceText,afterPriceText);
    }
        @Test
        public void test2(){
        driver.get("http://automationpractice.com/index.php?id_product=4&controller=product");
        WebElement defaultOne = driver.findElement(By.id("quantity_wanted"));
        String qty = defaultOne.getAttribute("value");
        Assert.assertEquals("1",qty);

        WebElement defaultSize = driver.findElement(By.id("group_1"));
        Select select = new Select(defaultSize);
        select.selectByValue("1");
            System.out.println(select.getOptions().get(0).getAttribute("title"));
        Assert.assertEquals(select.getOptions().get(0).getAttribute("title"),"S");


    }
}
