package day13;

import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class C03_NullPointerException extends TestBase {
    //   Webdriver  , Chromdriver Clasinin parenti olan bir interface 'dir
  WebDriver driver ;
 Faker faker;
    @Test
    public void test01() {
//        NullPointerException
//        Degiskenleri oluşturup instantiate etmediğimizde alırız(new kelimesini kullanmadigimizda)
//        Ornegin WebDriver driver; deyip = new ChromeDriver() demezisek null pointer exception aliriz
//        Solution:
//        Degiskeni instantiate et

        driver.get("https://www.techproeducation.com");
    }

    @Test
    public void test02() {
        System.out.println(faker.name().firstName());  //faker objesi olustu fakat instantiate(degeer atilmadi) edilmedi

       // declared but not instatntiated = nullpointer exc.
       // faker=new Faker();// bu sekilde yapilmali



    }
}
