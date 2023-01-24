package practise_Ders05;

import Utilities.Utilities;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead extends Utilities {



    /*
      <!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
      <!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
      1- Öncelikli olarak dependency leri pom.xml'e yüklüyoruz
      2- Dosya yolumuzu string bir değişkene atıyoruz
      3- Ve bu dosyayı sistemde akışa alıyoruz
      */
    @Test
    public void name() throws IOException {
        /*
        1-once dosya yolu alinir
        2-Dosyayi stream ile akisa aliyoruz
        3-excel dosyasini create ediyirz. workbook clasindan workbok obj olusturup akisa alidgimiz objeyi yaziyoruz create diyoruz
        4- once sheet al(getsheet)
        5-getRow satir
        6-getCell hucre
         */
        String dosyaYolu = "C:\\Users\\fatma\\OneDrive\\Masaüstü\\data.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        //Bilgisayarınızdaki data isimli excel dosyasından kullanıcı bilgilerini alıp
        String email = workbook.getSheet("Sayfa1").getRow(1).getCell(1).toString();
        System.out.println("Email : "+email);
        String password = workbook.getSheet("Sayfa1").getRow(2).getCell(1).toString();
        System.out.println("Şifre : "+password);
        //https://www.bluerentalcars.com/ adresine gidip
        driver.get("https://www.bluerentalcars.com/");
        //Excel dosyasından aldığımız kullanıcı bilgileri ile login olalım
        driver.findElement(By.xpath("//*[@class='btn btn-primary btn-sm']")).click();
        WebElement emailAddress = driver.findElement(By.xpath("//*[@id='formBasicEmail']"));
        emailAddress.sendKeys(email, Keys.TAB,password,Keys.ENTER);
        //Login olduğumuzu doğrulayalım
        WebElement login = driver.findElement(By.xpath("//*[@id='dropdown-basic-button']"));
        assert login.getText().equals("Erol Evren");
    }

}

