package day10;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C02_Actions extends TestBase {

    /*
MANUAL:
1. Amazon home sayfasina git
2. Account & list e uzerinde bekle --mouseover yada hoverover
3.Acilan pencerede Account linkine tokla
4.Acilan sayfanin Title inin, your Account oldugunu dogrula
 */

    @Test
    public void hoverOverTest() {
        driver.get("https://amazon.com");
        //1. Adim : Actions objesi olustur
        Actions actions=new Actions(driver);

        //        2. ELEMANI BUL
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        waitFor(1);

//        2. UYGUN ACTIONS METHODUNU KULLAN. EN SONRA PERFORM KULLANAMAYI UNUTMA
        actions.moveToElement(accountList).perform();
        waitFor(3);
//        Acilan pencerede Account linkine tikla
        driver.findElement(By.linkText("Account")).click();

//        Acilan sayfanin title inin Your Account icerdigini dogrula
        Assert.assertTrue(driver.getTitle().contains("Your Account"));





    }
}
