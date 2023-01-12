package practise_with_buraK;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C04_ActionsMoveToElement extends TestBase {

    @Test
    public void test01() {


        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        String sayfa1Handle=driver.getWindowHandle();

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions=new Actions(driver);
      actions.moveToElement(  driver.findElement(By.xpath("//span[@class='nav-line-2']"))).perform();

        // Change country/region butonuna basiniz

        driver.findElement(By.xpath("(//div[@class='icp-mkt-change-lnk'])[1]")).click();

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
       WebElement ddm= driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Turkey (Türkiye)");

        driver.findElement(By.xpath("//span[text()='Changing country/region website']")).click();




        // Go to website butonuna tiklayiniz

        driver.findElement(By.xpath("//span[@id='icp-save-button']")).click();

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
//       String handle= driver.getWindowHandle();
//       driver.switchTo().window(handle);
//       String title= driver.getTitle();
//        System.out.println(title);
//        Assert.assertTrue(title.contains("Elektronik"));

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
//        List<String> handles = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(handles.get(1));
//        String title2 = driver.getTitle();
//        Assert.assertTrue(title2.contains("Elektronik"));

        Set<String> windowHandleSeti=driver.getWindowHandles();

        System.out.println(sayfa1Handle);
        System.out.println(windowHandleSeti);

        String sayfa2Handle="";

        for (String each:windowHandleSeti) {

            if(!each.equals(sayfa1Handle)){

                sayfa2Handle=each;

            }

        }

        driver.switchTo().window(sayfa2Handle);

        String ikinciSayfaTitle=driver.getTitle();
        System.out.println(ikinciSayfaTitle);

        Assert.assertTrue(ikinciSayfaTitle.contains("Elektronik"));


    }
}
