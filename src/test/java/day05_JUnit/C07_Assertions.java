package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Assertions {
//    assertTrue(True)--->Passed
//    assertTrue(False)--->Failed
//
//    assertFalse(False)--->Passed
//    assertFalse(True)--->Failed

    WebDriver driver ;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //    https://www.amazon.com adresine gidin
        driver.get(" https://www.amazon.com");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

//3)Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleriyapin
//○ title Test  => Sayfa başlığının “YouTube” oldugunu testedin

//○ image Test => YouTube resminin görüntülendiğini (isDisplayed()) testedin

//○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
//○ wrongTitleTest => Sayfa basliginin “youtube” olmadiginidogrulayin


    @Test
    public void test01(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
    @Test
    public void test02(){
        WebElement sayfaResmi = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(sayfaResmi.isDisplayed());
    }
    @Test
    public void test03(){

}


}