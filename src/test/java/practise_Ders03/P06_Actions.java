package practise_Ders03;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class P06_Actions extends TestBase {

    //https://demoqa.com/ url'ine gidin.
    //Alerts, Frame & Windows Butonuna click yap
    //clickWithText("div.card-body>h5","Alerts, Frame & Windows");
    //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
    //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
    //New Tab butonunun görünür olduğunu doğrula
    //New Tab butonuna click yap
    //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
    //İlk Tab'a geri dön
    ////New Tab butonunun görünür olduğunu doğrula

    @Test
    public void test01() {


            //https://demoqa.com/ url'ine gidin.
            driver.get("https://demoqa.com/");
            //Alerts, Frame & Windows Butonuna click yap
            WebElement kutu = driver.findElement(By.xpath("(//*[@class='card-up'])[6]"));
            //clickWithText("div.card-body>h5","Alerts, Frame & Windows");
            Actions actions = new Actions(driver);
            //actions.moveToElement(kutu).perform();
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            driver.findElement(By.xpath("(//*[@class='card mt-4 top-card'])[3]")).click();


        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula

        WebElement text = driver.findElement(By.xpath("//*[text()='Please select an item from left to start practice.']"));
        Assert.assertTrue(text.isDisplayed());

        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("//*[text()='Browser Windows']")).click();

        //New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='New Tab']")).isDisplayed());

        //New Tab butonuna click yap
        driver.findElement(By.xpath("//*[text()='New Tab']")).click();

        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        //yeni bir pencere aclidiginda handler i yeni bir liste atariz. calistiginda acilan browserlerin hepsi listin icine atilir

        List<String> allWindow = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allWindow.get(1));

        //İlk Tab'a geri dön
        waitFor(3);
        driver.switchTo().window(allWindow.get(0));

        ////New Tab butonunun görünür olduğunu doğrula

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='New Tab']")).isDisplayed());
    }
}
