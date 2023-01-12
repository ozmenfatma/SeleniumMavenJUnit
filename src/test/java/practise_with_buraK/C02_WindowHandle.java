package practise_with_buraK;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class C02_WindowHandle extends TestBase {
    @Test
    public void test01() {


        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        String sayfa1Handle=driver.getWindowHandle();


        // 2- url'in 'amazon' icerdigini test edelim
        String amazonUrl=driver.getCurrentUrl();
        Assert.assertTrue(amazonUrl.contains("amazon"));


        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String sayfa2= driver.getWindowHandle();



        // 4- title'in 'Best Buy' icerdigini test edelim
        String bestBuyTitle=driver.getTitle();
        Assert.assertTrue(bestBuyTitle.contains("Best Buy"));


        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(sayfa1Handle);
        WebElement amazonAramaMot=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        amazonAramaMot.sendKeys("Java" + Keys.ENTER);



        // 6- arama sonuclarının 'Java' icerdigini test edelim
        WebElement result = driver.findElement(By.xpath("(//*[@class='a-size-base-plus a-color-base a-text-normal'])[2]"));
        String resultText = result.getText();
        Assert.assertTrue(resultText.contains("Java"));

        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(sayfa2);

        // 8- logonun gorundugunu test edelim
        WebElement logo = driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());


    }
}
