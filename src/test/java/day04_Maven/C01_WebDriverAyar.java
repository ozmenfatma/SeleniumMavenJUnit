package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_WebDriverAyar {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1https://www.amazon.com/ sayfasina gidelim
       driver.get("https://www.amazon.com");

       //2arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));

        //3"Samsung headphones" ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones");//KEYS.Enter
        aramaKutusu.submit(); // Enter ' a basti

        //4Bulunan sonuc sayisini yazdiralim
        WebElement aramaSonucu=driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("Arama Sonucu"+aramaSonucu.getText());

        //5Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//*[@class='a-section aok-relative s-image-fixed-height'])[1]")).click();
                  //String sonuc[]=we.getText().split(" ");
                 //System.out.println(sonuc[2]);
                // Arrays.stream(aramaSonucYazisi.get(0).getText().split(" ")).limit(3).skip(2).forEach(System.out::println);

        //6Sayfadaki tum basliklari yazdiralim

        List<WebElement> baslikListesi= driver.findElements(By.xpath("//h1"));
        for (WebElement w : baslikListesi){
            System.out.println(w.getText());
        }
        // => Lambda==> baslikListesi.stream().forEach(t-> System.out.println(t.getText()));

        //Sayfayi kapat

        driver.close();
    }
}
