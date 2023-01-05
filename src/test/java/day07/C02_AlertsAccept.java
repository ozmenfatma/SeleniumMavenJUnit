package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static day07.TestBase.driver;

public class C02_AlertsAccept {
    @Test
    public void acceptAlertTest() throws InterruptedException {
//        1. butona tıklayın,
//        uyarıdaki OK butonuna tıklayın
//        ve result mesajının
//       “You successfully clicked an alert” oldugunu test edin.
        // switchto()--> alert'e gecmek için kullanıyoruz.dedigimiz zaman driver alertin oraya goder ve accept dedigimiz zaman driver tiklar


            driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
//        1. butona tıklayın,
            driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
//        uyarıdaki OK butonuna tıklayın
            Thread.sleep(5000);
            driver
                    .switchTo()//degistir
                    .alert()//alerte degistir
                    .accept();//OK secenegine tiklanir
            Thread.sleep(5000);
//        ve result mesajının “You successfully clicked an alert” oldugunu test edin.
            String actualResult = driver.findElement(By.id("result")).getText();
            String expectedResult = "You successfully clicked an alert";
            Assert.assertEquals(expectedResult,actualResult);
        }
    /*
    *Alertleri nasil automate edersin? How to handle alerts in selenium?
    -Alertler javascript ile olusur. Inspect edilemezler. Oncelikle alerte switch etmemiz gerekir.
     */
    }
