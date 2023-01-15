package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class C01_ExcelRead {

    @Test
    public void readExcelTest() throws IOException {

  // WORKBOOK(Excell Dosyasi) > WORKSHEET/SHEET > ROW (Satir)> CELL(Veri Hucresi)

        String path= "./src/test/java/resources/Capitals.xlsx";

        //        String path =".\\src\\test\\java\\resources\\Capitals.xlsx";//WINDOWS
//        DOSYAYI AC
        FileInputStream fileInputStream = new FileInputStream(path);

//        EXCEL DOSYASINI AC /WORKBOOK AC
        Workbook workbook= WorkbookFactory.create(fileInputStream);

//        SAYFAYI AC / Sheet1
        Sheet sheet1=workbook.getSheet("Sheet1");

       // Sheet sheet1=workbook.getSheetAt(0); --> index 0 dan baslar. ilk sayfayi ac


//        ILK SATIRA GIT / Row
        Row row1= sheet1.getRow(0);// ilk satira git


//        INK SATIRDAKI ILK VERIYI AL
        Cell cell1 = row1.getCell(0);//ILK HUCREDEKI DATAYI VER

//        O VERIYI YAZDIR
        System.out.println(cell1);

        //        1. SATIR 2. SUTUN
        Cell cell12 = sheet1.getRow(0).getCell(1);
        System.out.println(cell12);

        Cell cellfransa = sheet1.getRow(2).getCell(0);
        System.out.println(cellfransa);

        //        3.Satir 1.Sutun yazdir ve O verinin France oldugunu test et
        String cell31 = sheet1.getRow(2).getCell(0).toString();
        System.out.println(cell31);
        Assert.assertEquals("France",cell31);

        // Excelidekı toplam satır sayısını bul

       int toplamSatirSayisi= sheet1.getLastRowNum(); // son satir numarasi. index sayisi 0 dan basladigi icin toplamsatirsayisindan 1 eksik veriir
        System.out.println(toplamSatirSayisi + 1);// o yuzden +1 ekleriz



        //        Kullanilan toplam satir sayisini bul
        int kullanilanToplamSatirSayisi = sheet1.getPhysicalNumberOfRows();
        System.out.println(kullanilanToplamSatirSayisi);//1 den basliyor



      // COUNTRY,CAPITALS key ve valuelari map a alip print et

        //        COUNTRY, CAPITALS key ve value lari map a alip print et
//        {{USA, D.C},{FRANCE, PARIS},...}

///        Variable olusturalim. Bu variable exceldeki country,capital verilerini tutacak
        Map<String,String> ulkeBaskentleri = new HashMap<>();
        for (int satirSayisi=1;satirSayisi<kullanilanToplamSatirSayisi;satirSayisi++){
            String country = sheet1.getRow(satirSayisi).getCell(0).toString();
            String capital = sheet1.getRow(satirSayisi).getCell(1).toString();
            ulkeBaskentleri.put(country,capital);
        }
        System.out.println(ulkeBaskentleri);

        TreeMap a = new TreeMap<>(ulkeBaskentleri);  // natural order a gore veriyor
        System.out.println(a);

    }
}
