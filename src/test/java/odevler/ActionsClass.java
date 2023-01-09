package odevler;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ActionsClass extends TestBase {

    @Test
    public void test01() {


//        1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

      //  2- Hover over Me First" kutusunun ustune gelin

        Actions actions= new Actions(driver);
        WebElement ilk= driver.findElement(By.xpath("//button[@class='dropbtn']"));
        actions.moveToElement(ilk).perform();
        waitFor(3);

//        Link 1" e tiklayin

//
       WebElement ikinci= driver.findElement(By.xpath("//div[@class='dropdown-content']"));
        actions.moveToElement(ikinci).perform();
       ikinci.click();


//        Popup mesajini yazdirin

         String alertmessage =driver .switchTo().alert().getText();
        System.out.println(alertmessage);

//        Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

//         “Click and hold" kutusuna basili tutun
  WebElement clickandhold= driver.findElement(By.xpath("//div[@id='click-box']"));
  actions.clickAndHold(clickandhold).perform();



//        7-“Click and hold" kutusunda cikan yaziyi yazdirin

        String clickHoldText = clickandhold.getText();


//        8- “Double click me" butonunu cift tiklayin

        WebElement doubleclick= driver.findElement(By.xpath("//div[@id='double-click']"));
        actions.doubleClick(doubleclick).perform();
    }
}
