package practise_with_buraK;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_FileDowload extends TestBase {

    @Test
    public void test01() {

        //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz

        driver.get("https://the-internet.herokuapp.com/download");

        //2. some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//a[text()='some-file.txt']")).click();


        //3. dosyanin basariyla indirilip indirilmedigini test edelim (dosya downloads'a indirilecektir)

      //  "C:\Users\fatma\Downloads\some-file.txt"

            // String dosyaYolu="C:\\Users\\fatma\\Downloads\\some-file.txt";

        String farklıKısım=System.getProperty("user.home");
        String ortakKısım="\\Downloads\\some-file.txt";

        String dosyaYolu2=farklıKısım+ortakKısım;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu2)));



    }
}
