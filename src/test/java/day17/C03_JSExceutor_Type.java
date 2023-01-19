package day17;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class C03_JSExceutor_Type extends TestBase {

    @Test
    public void typeTest() {

        //jqvqscriptexecutor ile html kodunu manipule ediyoruz

        //    Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");
        waitFor(3);
        typeWithJS(driver.findElement(By.xpath("//input[@type='search']")),"QA");
    }
    }

