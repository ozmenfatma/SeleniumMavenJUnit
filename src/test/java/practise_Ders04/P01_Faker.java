package practise_Ders04;

import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class P01_Faker extends TestBase {

    @Test
    public void test01() throws InterruptedException {


            //"https://demoqa.com/automation-practice-form"  Adresine gidin
            driver.get("https://demoqa.com/automation-practice-form");
            // Formu doldurunuz
            Faker faker = new Faker();
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys(faker.name().firstName(), Keys.TAB,faker.name().lastName(),Keys.TAB,
                faker.internet().emailAddress(),Keys.TAB,Keys.SPACE,Keys.TAB,faker.phoneNumber().cellPhone(),Keys.TAB
                ,"20 Jul 1980",Keys.ENTER,Keys.TAB,faker.shakespeare().romeoAndJulietQuote(),Keys.TAB,Keys.SPACE);
        WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='uploadPicture']"));
       // String path="C:/Users/fatma/OneDrive/Masaüstü/logo.jpeg";
        //shift sag clik dosya uzerindeyken ayrintili ozellikler gosteriyor
       // dosyaSec.sendKeys(path);
        String anayol=System.getProperty("user.home");
        String ortakYol="/OneDrive/Masaüstü/logo.jpeg";
        String dosyaYolu= anayol+ortakYol;
        dosyaSec.sendKeys(dosyaYolu);

        WebElement adress = driver.findElement(By.xpath("//*[@id='currentAddress']"));
        adress.sendKeys(faker.address().fullAddress(),Keys.TAB,"NCR");
        Thread.sleep(2000);





        // Sayfayi kapatin

    }
}
