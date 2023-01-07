package challenges;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;

import java.util.Set;

public class day11_marketTest extends TestBase {


    @Test
    public <Cookies> void test01() {

        //Go to https://www.amazon.com.tr/
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.id("sp-cc-accept")).click();

        //Search iPhone13 512
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone13 512", Keys.ENTER);

        //Check that the results are listed
        driver.findElement(By.xpath(" //span[@class='a-color-state a-text-bold']")).isDisplayed();
        //Click iPhone13 at the top of the list

        //Log the following values for each size .Size information .Price .Color .Stock status
        //Isim - Renk - Stok - Boyut - Fiyat
    }
}
