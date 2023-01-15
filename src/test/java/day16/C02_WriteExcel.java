package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    @Test
    public void writeExcel() throws IOException {

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

//      ILK SATIR 3.SUTUN CREATE ET

      Cell cell3=  row1.createCell(2);

//      O SATIRA  NUFUS YAZDIR

        cell3.setCellValue("NUFUS");



        //        2. satir 3. sutuna 450000
        sheet1.getRow(1).createCell(2).setCellValue("450000");

//        3. satir 3. sutuna 350000
        sheet1.getRow(2).createCell(2).setCellValue("350000");

        //      KAYDET

        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);

    }
}
