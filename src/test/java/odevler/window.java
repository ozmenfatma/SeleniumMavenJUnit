package odevler;

import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class window extends TestBase {

    @Test
    public void test01() {

        //1."http://webdriveruniversity.com/" adresine gidin

        driver.get("http://webdriveruniversity.com/");

//2."Login Portal" a kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();


//3."Login Portal" a tiklayin
        waitFor(2);
        driver.findElement(By.xpath("//a[@id='login-portal']")).click();


//4.Diger window'a gecin
     switchToWindow(1);

//5."username" ve "password" kutularina deger yazdirin

        Faker faker=new Faker();
driver.findElement(By.xpath("//input[@id='text']")).sendKeys(faker.name().firstName(),Keys.TAB,faker.internet().password(),
        Keys.TAB,Keys.ENTER);

//6."login" butonuna basin
//7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
String alert= driver.switchTo().alert().getText();
String expected="validation failed";
        Assert.assertEquals(expected,alert);

//8.Ok diyerek Popup'i kapatin
        waitFor(2);
        driver.switchTo().alert().accept();
//9.Ilk sayfaya geri donun
        waitFor(2);
        switchToWindow(0);

//10.Ilk sayfaya donuldugunu test edin
       Assert.assertTrue( driver.findElement(By.xpath("//h1[text()='My Courses & Promo Codes']")).isDisplayed());

    }
}
