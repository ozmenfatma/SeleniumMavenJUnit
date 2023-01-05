package practise_Ders02;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P02 extends TestBase {

    @Test
    public void test() {


            // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
            driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

            // ikinci emojiye tıklayın
            WebElement iframe = driver.findElement(By.xpath("//*[@id='emoojis']"));
            driver.switchTo().frame(iframe);
            driver.findElement(By.xpath("(//*[@data-upgraded=',MaterialRipple'])[2]")).click();

            // tüm ikinci emoji öğelerini tıklayın
            List<WebElement> emojiler = driver.findElements(By.xpath("//*[@id='nature']//div/img"));
            //1.yol // emojiler.stream().forEach(t-> t.click());
            for (WebElement t : emojiler) {
                t.click();
            }

            // parent iframe e geri donun

            driver.switchTo().defaultContent();
            //driver.switchTo().parentFrame();  2.yol
            //driver.navigate.refresh();  --> sayfayi ilk haline dondurur 3.yol -> direk anaayfaya doner


            // formu doldurun,(Formu istediğiniz metinlerle doldurun)


             //driver.findElement(By.xpath("//*[@id='text']")).sendKeys("Erol");
             List<WebElement> list = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
             List<String> veriler = new ArrayList<>(Arrays.asList(
                 "Erol","Evren","selenium","lambda","java","sql","gitgithub","fsd","dfasf","lkjl","asdasd","asd","sda"));
            for (int i = 0; i < list.size(); i++) {
             list.get(i).sendKeys(veriler.get(i));
        }

        //  apply button a basin
        driver.findElement(By.xpath("//*[text()='Apply']")).click();


        }

    }

