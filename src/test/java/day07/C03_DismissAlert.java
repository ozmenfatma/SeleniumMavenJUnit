package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static day07.TestBase.driver;

public class C03_DismissAlert {

    @Test
    public void dismissAlertTest() throws InterruptedException {
      //  2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “You clicked: Cancel” oldugunu test edin.


            driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
//        2. butona tıklayın,
            driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
            Thread.sleep(5000);
//        uyarıdaki Cancel butonuna tıklayın
            driver.switchTo().alert().dismiss();//CANCEL secenegine tikliyoruz
            Thread.sleep(5000);
//        ve result mesajının “You clicked: Cancel” oldugunu test edin.
            String actualResult = driver.findElement(By.id("result")).getText();//gercek deger
            String expectedResult = "You clicked: Cancel";//beklenen deger
            Assert.assertEquals(expectedResult,actualResult);
        }
    }

