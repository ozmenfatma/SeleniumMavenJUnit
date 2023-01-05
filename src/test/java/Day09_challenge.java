import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Day09_challenge extends TestBase {
    @Test
    public void test01() throws InterruptedException {

     driver.get("http://demo.guru99.com/popup.php");
     Thread.sleep(3000);
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gdpr-consent-notice']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//span[text()='Tümünü Kabul Et']")).click();


//       ilk pencereyi al

       String ilkPencere= driver.getWindowHandle();
//
////       "Click Here" butonuna tıklayın


       driver.findElement(By.xpath("//a[.='Click Here']")).click();


//      setteki tüm pencereyi al

       List<String> windowHandle= new ArrayList<>(driver.getWindowHandles());
       System.out.println("window handle degerleri " + windowHandle);




//       diğer pencereye geç

       driver.switchTo().window(windowHandle.get(1));



////       e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
 driver.findElement(By.xpath("//input[@type='text']")).sendKeys("abcde@gmail.com", Keys.ENTER);

////       Gönder düğmesine tıklayarak


////       ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
     String actualmessage=  driver.findElement(By.xpath("//h3")).getText();
      String expectedmessage="This access is valid only for 20 days.";
        Assert.assertEquals(actualmessage,expectedmessage);

////       Tekrar ilk pencereye geç
        driver.switchTo().window(windowHandle.get(0));

////       İlk pencerede olduğunu doğrula
        Assert.assertTrue(driver.findElement(By.xpath("//a[.='Click Here']")).isDisplayed());
}
}