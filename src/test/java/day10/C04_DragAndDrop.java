package day10;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C04_DragAndDrop extends TestBase {
    @Test
    public void dragAndDropTest(){

        //en cok kullanilan method

//        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
//        KAYNAK VE HEDEF ELEMENTLERI IFRAMEIN ICINDE
        driver.switchTo().frame(0);
//        And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));
//        dragAndDrop() surukleme islemini gerceklestirir
        Actions actions = new Actions(driver);
        actions.dragAndDrop(kaynak,hedef).perform();
        waitFor(5);
    }
    @Test
    public void clickAndHoldTest(){
//        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
//        KAYNAK VE HEDEF ELEMENTLERI IFRAMEIN ICINDE
        driver.switchTo().frame(0);
//        And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));
//        dragAndDrop() surukleme islemini gerceklestirir
        Actions actions = new Actions(driver);
        actions
                .clickAndHold(kaynak)//kaynagi tut
                .moveToElement(hedef)//hedefe koy
                .release()// kaynagi birak
                .build()// onceki methodlarin iliskisini kur/ guclendir. KULLANILMASI TERCIH EDILIR
                .perform();//islemi gerceklestir
    }

    @Test
    public void moveByOffSetTest(){
        //        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
//        KAYNAK VE HEDEF ELEMENTLERI IFRAMEIN ICINDE
        driver.switchTo().frame(0);
//        And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));
//        dragAndDrop() surukleme islemini gerceklestirir
        Actions actions = new Actions(driver);
        actions.
                clickAndHold(kaynak).// kaynagi tut
                moveByOffset(430,30)
                .release() // kaynagi birak
                .build()
                .perform();
        waitFor(5);
    }

    }

