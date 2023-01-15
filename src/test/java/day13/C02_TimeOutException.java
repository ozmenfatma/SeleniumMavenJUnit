package day13;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {

    @Test
    public void test01() {// explicit wait kullanildiignda ve eleman bulunmadignda


//        TimeOutException:
//        Explicit wait kullanildiginda, ve element bulunamadiginda alinir.
//                Explicit wait & yanlis locator-> timeout
//        Explicit wait & doğru locator & sure yeterli degil -> timeout
//        Explicit wait & dogru locator & sure yeterli & iframe var ->  time out
//        Solution:
//        -Sureyi arttirmak
//                -Farkli explicit kullanmak: wait visibilityOfElementLocated YERINE presenceOfElementLocated. Yada javascript executor da ki waiter sayfa geçişlerini beklemek icin kullanabilirim
//                -Locatori tekrar kontrol etmek
//                -Frameworkunde hazir reusable method lar var Bu durumda timeoutexception aldigimda hızlıca o metotlar yardımıyla problemi cozebiliyoruz


        /*
TimeOutException explicit wait kullandimda ve locator bulunamadiginda alirim
 */

        driver.get("https://www.techproeducation.com");
//        Explit wait icin olusturdugumuz methodlardan birini kullanalim
//        Parametre 1: beklemek istedigim element, Parametre 2: Max sure
       // waitForVisibility(driver.findElement(By.xpath("//input[@type='searchh']")),15).
        //        sendKeys("QA" + Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("yanlis")));
    }
}
