package day13;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C04_StaleElementReferenceException  extends TestBase { //ayni web elementi tekrar tekrar kullanmaya calisirsak ve iyi dizayn edilmediyse bu excception alinabilir


    @Test
    public void test01() {
        /*
    StateElementReferenceException
StateElementReferenceException = eski kullanılamaz durumda olan, kullanıma artık elverişli olmayan durumlarda alınan hatadır.
Sayfayı yenilediğimizde,
sayfada ileri geri gittiğimizde meydana gelen exception'dır. yada sayfayi yeniledikten sonra

    Çözüm
Elemanı tekrar bulmak.

 */
        driver.get("https://www.techproeducation.com");
        waitFor(5);
//        LMS LOGIN linkine tikla ve o sayfanin URL inin lms icerdigini test et
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(7);
        lmsLoginLink.click();//LMS e git
        Assert.assertTrue(driver.getCurrentUrl().contains("lms"));//URl in lms kelimesini icerdigini test et
        waitFor(7);
//        Tekrar ana sayfaya gel ve LMS LOGIN sayfasina tekrar
        driver.navigate().back();//tekrar ana sayfaya gittik
        waitFor(7);
        lmsLoginLink.click();//LMS e git

        driver.navigate().back();
        waitFor(5);
        lmsLoginLink.click();
            }
    /*
           lmsLoginLink linkini sayfa yenilendikden(back()) sonra kullandigim icin StaleElementReferenceException aldim
            */

    @Test
    public void staleElementReferenceExceptionTest2(){
        driver.get("https://www.techproeducation.com");
        waitFor(5);
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(5);
        driver.navigate().refresh();
        waitFor(5);
        lmsLoginLink.click();

        //        SAYFA YENILENMEDEN ONCE BULDUGUM ELEMENTI, SAYFA YENILENDIKDEN SONRA KULLANMAK ISTEDIM
        lmsLoginLink.click();// org.openqa.selenium.StaleElementReferenceException
//        COZUM ESKI(SLATE ELEMENT) ELEMENTI TEKRAR LOCATE ET
//        driver.findElement(By.linkText("LMS LOGIN")).click();


    }
        }

