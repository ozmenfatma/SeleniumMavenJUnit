import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class cizimmmm extends TestBase {

    @Test
    public void name() {

        driver.get("http://szimek.github.io/signature_pad/");

        // Locate the canvas element
        WebElement canvas = driver.findElement(By.tagName("canvas"));

        // Create a signature
        ((JavascriptExecutor) driver).executeScript("var signaturePad = new SignaturePad(document.querySelector('canvas'));"
                + "signaturePad.begin();"
                + "signaturePad.penColor = 'rgb(0, 0, 0)';"
                + "for (var i = 0; i < 100; i++) {"
                + "  var randomWidth = Math.floor(Math.random() * 40 + 10);"
                + "  var randomHeight = Math.floor(Math.random() * 40 + 10);"
                + "  var randomX = Math.floor(Math.random() *200);"
                + "  var randomY = Math.floor(Math.random() *200);"
                + "  signaturePad.moveTo(randomX, randomY);"
                + "  signaturePad.lineTo(randomX + randomWidth, randomY + randomHeight);"
                + "  signaturePad.stroke();"
                + "}");
    }

    }


