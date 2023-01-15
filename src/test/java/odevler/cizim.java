package odevler;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class cizim extends TestBase {

    @Test
    public void test() {
        driver.get("http://szimek.github.io/signature_pad/");
        Actions actions = new Actions(driver);
        WebElement canvas =driver.findElement(By.xpath("//div[@class='signature-pad--body']"));
       canvas.click();

//      actions.moveToElement(canvas, 100, 50).clickAndHold().moveByOffset(100,75).release().perform();
//        actions.moveToElement(canvas, 300, 50).clickAndHold().moveByOffset(-50, +50).release().perform();
        actions.moveToElement(canvas,150,80) //start points x axis and y axis.
                .click()
                .clickAndHold()
                .moveByOffset(25, 200) // 2nd points (x1,y1)
                .release()
                .build()
                .perform();
//         String canvas_dimensions = canvas.getSize();
//        var canvas_center_x = canvas_dimensions.getWidth() / 2;
//        var canvas_center_y = canvas_dimensions.getHeight() / 2;
//        int button_x = (canvas_center_x / 3) * 2;
//        int button_y = (canvas_center_y / 3) * 2;
//
//        //Click button on the canvas
//        new Actions(driver)
//                .moveToElement(canvas, button_x, button_y)
//                .click()
//                .perform();
    }
}
