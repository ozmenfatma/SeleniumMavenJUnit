package odevler;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.nio.file.FileStore;

public class KeyboardActions2 extends TestBase {

    @Test
    public void test01() {

//        https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

//        video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        waitFor(3);
        actions
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(3);
//        videoyu izlemek icin Play tusuna basin
        driver.switchTo().frame(0);
     //   driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

//        videoyu calistirdiginizi test edin

        WebElement video = driver.findElement(By.xpath("//*[@id='player']//div"));
        String beforeClassValue = video.getAttribute("class");
        video.click();
        // videoyu calistirdiginizi test edin
        waitFor(5);
        String afterClassValue = video.getAttribute("class");
        System.out.println("beforeClassText = " + beforeClassValue);
        System.out.println("afterClassText = " + afterClassValue);
        Assert.assertNotEquals(beforeClassValue,afterClassValue);
        waitFor(5);


    }
}
