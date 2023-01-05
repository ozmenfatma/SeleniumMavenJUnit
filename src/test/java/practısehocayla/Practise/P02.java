package practısehocayla.Practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P02 {
   static  String ilkUrunYazisi;
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.saucedemo.com");
    }

    @After
    public void tearnDown() throws InterruptedException {

       driver.close();
    }
@Test
    public void test(){

        //2. Username kutusuna "standard_user" yazdirin
    WebElement userName= driver.findElement(By.id("user-name"));
    userName.sendKeys("standard_user", Keys.ENTER);

//3. Password kutusuna "secret_sauce" yazdirin
    WebElement password=driver.findElement(By.xpath("//*[@id='password']"));
    password.sendKeys("secret_sauce",Keys.ENTER);

//4. Login tusuna basin
  driver.findElement(By.id("login-button")).click();

//5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin

   ilkUrunYazisi= driver.findElement(By.xpath("(//*[@class='inventory_item_name'])[1]")).getText();

    driver.findElement(By.xpath("(//*[@class='inventory_item_name'])[1]")).click();

//6. Add to Cart butonuna basin
    driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

//7. Alisveris sepetine tiklayin
    driver.findElement(By.xpath("//*[@class='shopping_cart_badge']")).click();

//8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
   String actual= driver.findElement(By.xpath("//*[@class='inventory_item_name']")).getText();
    String expected=ilkUrunYazisi;

    //Assert.assertEquals(actual,expected);
    Assert.assertTrue(actual.contains(expected));



//9. Sayfayi kapatin



}

}
