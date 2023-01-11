package practise_Ders03;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.security.Key;

public class P04_BuyukKucukHarf extends TestBase {

    @Test
    public void test01() {


            //google sayfasına gidelim
            driver.get("https://google.com");
            //Büyük küçük harf olucak şekilde HeLlO yazdıralım
            WebElement searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
            searchBox.sendKeys(Keys.SHIFT,"h",Keys.SHIFT,"e",Keys.SHIFT,"l",Keys.SHIFT,"l",Keys.SHIFT,"o",Keys.SHIFT);


        }
}
