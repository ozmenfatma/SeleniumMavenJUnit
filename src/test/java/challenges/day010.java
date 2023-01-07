package challenges;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class day010 extends TestBase {

    @Test
    public void test() {

//https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");

//Alerts, Frame & Windows Butonuna click yap
driver.findElement(By.xpath("//div[@class='card mt-4 top-card'][3]")).click();

//""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Please select an item from left to start practice.']")).isDisplayed());
//Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("//span[text()='Browser Windows']")).click();

//New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(driver.findElement(By.xpath("//button[@id='tabButton']")).isDisplayed());
  String ilkWindow= driver.getWindowHandle();
//New Tab butonuna click yap
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
//Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        switchToWindow(1);
      String actualText=  driver.findElement(By.xpath("//h1[text()='This is a sample page']")).getText();
      String expectedText="This is a sample page";
      Assert.assertEquals(actualText,expectedText);

//İlk Tab'a geri dön
        waitFor(3);
        driver.switchTo().window(ilkWindow);

////New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(driver.findElement(By.xpath("//button[@id='tabButton']")).isDisplayed());
    }
}
