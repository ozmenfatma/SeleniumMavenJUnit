package day13;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class C01_NoSuchElementException extends TestBase {

    @Test
    public void test01() {
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//input[@type='searchh']")).sendKeys("QA"+ Keys.ENTER);


    }
}
