package practise_Ders03;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class P03_Actions extends TestBase {
    /*
                                            Actions
    Action sınıfı, belirli web öğelerinde bir klavyeden veya fareden giriş eylemlerini simüle etmek için kullanılır.
Örneğin, Sol Tıklama, Sağ Tıklama, Çift Tıklama, sürükleyip bırakma, bir webelementin üzerinde bekletme vb.
 */

    @Test
    public void test() {


//    http://uitestpractice.com/Students/Actions adresine gidelim
        driver.get("http://uitestpractice.com/Students/Actions");

//    Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
        Actions actions =new Actions(driver);
        WebElement maviKutu=driver.findElement(By.id("div2"));
        waitFor(3);
        actions.moveToElement(maviKutu).perform();//build koyarsak 3 sn beklemez hemen diger islemlere gecer
        waitFor(2);

//    Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim

        WebElement doubleClicked = driver.findElement(By.xpath("//*[@name='dblClick']"));
        actions.doubleClick(doubleClicked).perform();
        Assert.assertEquals("Double Clicked !!", driver.switchTo().alert().getText());

//    Accept ile alert'ü kapatalım
        driver.switchTo().alert().accept();

//    Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
       WebElement drag= driver.findElement(By.xpath("//*[@id='draggable']"));
       WebElement drop= driver.findElement(By.xpath("//*[@id='droppable']"));
       actions.dragAndDrop(drag,drop).perform();
       // Assert.assertEquals("Dropped!", drop.getText());
        Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());
    }
}

