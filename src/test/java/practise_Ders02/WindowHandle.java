package practise_Ders02;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;

public class WindowHandle  extends TestBase {
    @Test
    public void test01() {
//        Amazon anasayfa adresine gidin.
        driver.get("https://amazon.com");

//        Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWindow=driver.getWindowHandle();  //--> hashcodu yani handle degeri aliyoruz

//        Sayfa title’nin “Amazon” icerdigini test edin
        String actualTitle = driver.getTitle();
      //  Assert.assertTrue(actualTitle.contains("Amazon"));
        String arananKelime="Amazon";
        Assert.assertTrue(actualTitle.contains(arananKelime));

//        Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB); //-->Yeni bir sekme acmis olduk
        driver.get("https://techproeducation.com");

//        Sayfa title’nin “TECHPROEDUCATION” icerip icermedigini test edin
        String actualTitleTech=driver.getTitle();
        String istenenKelime= "TECHPROEDUCATION";
        Assert.assertFalse(actualTitleTech.contains(istenenKelime));

//        Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://walmart.com");


//        Sayfa title’nin “Walmart” icerdigini test edin

        String actualWalmartTitle = driver.getTitle();
        String beklenenKelime = "Walmart";
        Assert.assertTrue(actualWalmartTitle.contains(beklenenKelime));

//        Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

        driver.switchTo().window(amazonWindow);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com/";
        Assert.assertEquals(expectedUrl,actualUrl);
    }
}
