package day10;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01_ActionClass extends TestBase {
    @Test
    public void rightClick() {


//        https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("  https://the-internet.herokuapp.com/context_menu");



        //1. Actions objesi olustur
        Actions actions=new Actions(driver);

        //2. iletisime gecmek istedigimiz elementi locate et

       WebElement kutu= driver.findElement(By.id("hot-spot"));

        //        Kutuya sag tıklayın
        //TUM ACTIONSLAR actions OBJESI ILE BASLAR PERFORM ILE BITER

        actions.contextClick(kutu).perform();


//        Alert’te cikan yazinin “You selected a context menu” oldugunu test edin

        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());


//        Tamam diyerek alert’i kapatın

        driver.switchTo().alert().accept();
    }
}
