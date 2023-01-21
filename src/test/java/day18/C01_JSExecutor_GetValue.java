package day18;

import Utilities.TestBase;
import org.junit.Test;

public class C01_JSExecutor_GetValue extends TestBase {
    /*  Belirli bir WebElement'in id değerini String olarak alır ve value attribute değerini String olarak döndürür

    JavaScriptExecutor ile input elementindeki değerleri almak için aşağıdaki adımları izleyebilirsiniz:
    Web sayfasındaki input elementini locate etmek için WebDriver kullanabilirsiniz. Örneğin, "id" veya "name" attribute'una göre elementi seçebilirsiniz.
    JavaScriptExecutor'u kullanarak, input elementinin "value" attribute'unu alabilirsiniz. Örnek olarak aşağıdaki gibi bir kod kullanabilirsiniz:

    WebElement element = driver.findElement(By.id("inputId")); JavascriptExecutor js = (JavascriptExecutor) driver; String value = (String) js.executeScript("return arguments[0].value", element);
    executeScript metodu ile input elementinin value attribute'unu almış oldunuz.
    Not: Bu kod örneği sadece id attribute'una göre elementi seçer. Eğer elementi başka bir yolla seçmek isterseniz, locate etme kodunu değiştirmeniz gerekebilir.
*/

    @Test
    public void getValueTest() {
//javascrip browserin dili.//

        //      1)getValueTest metotu olustur
//  2)https://www.priceline.com/ a git
//            3)Tarih kısmındaki Yazili metinleri al ve yazdır

            driver.get("https://www.priceline.com/");

            //driver.findElement(By.xpath("//button[text()='Accept All Cookies ']")).click(); cookies icin

            getValueByJS("hotelDates");

        }
}
