package day15;
import Utilities.TestBase;
import day18.C02_Log4J;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C02_WebTables extends TestBase{
    private static Logger logger = LogManager.getLogger(C02_WebTables.class.getName());
    @Test
    public void test() {
//        https://the-internet.herokuapp.com/tables
        driver.get(" https://the-internet.herokuapp.com/tables");

//        Task 1 : Table1’i print edin

        String table1 = driver.findElement(By.xpath("//*[@id='table1']")).getText();
       // System.out.println("TABLE 1 VERILERI");
        logger.info("Table 1 Verileri");

        System.out.println(table1);

//        List<WebElement> table01=driver.findElements(By.xpath("//table[@id='table1']"));
//        for (WebElement w:table01){
//            System.out.println(w.getText());
//        }

        //2.YOL TEK TEK VERI AL
        List<WebElement> tumVeriler = driver.findElements(By.xpath("//table[@id='table1']//td"));
        //  we.forEach(t-> System.out.println(t.getText())); -->lambda ile
        for (WebElement veri : tumVeriler) {
            System.out.println(veri.getText());
        }

        //method seklinde
//        public static List<String> getElementsText(List<WebElement> list) {
//            List<String> elementText = new ArrayList<>();
//            for (WebElement w : list) {
//                if (!w.getText()) {
//                    elementText.add(w.getText());
//                }
//            }
//            return elementText;
//        }
    }

//        Task 2 : 3. Row’ datalarını print edin

        @Test
        public void row3Print(){
            //    Task 2 : 3. Row’ datalarını print edin
            driver.get("https://the-internet.herokuapp.com/tables");
            List<WebElement> row3Elements = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[3]//td"));
            row3Elements.forEach(veri-> System.out.println(veri.getText()));
        }

//        Task 3 : Son row daki dataları print edin
         @Test
        public void sonSatirVerileri(){
    driver.get("https://the-internet.herokuapp.com/tables");
    List<WebElement> sonSatir = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[last()]//td"));
    sonSatir.forEach(veri-> System.out.println(veri.getText()));

}

//        Task 4 : 5. Column datalarini print edin
         @Test
         public void sutun5Test(){
    driver.get("https://the-internet.herokuapp.com/tables");
    List<WebElement> sutun5 = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[5]"));
    sutun5.forEach(veri-> System.out.println(veri.getText()));
}

//        Task 5 : Iki parametreli bir Java metot oluşturalım: printData
//        Parameter 1 = row numarasi
//        Parameter 2 = column numarasi
//        printData(2,3);  => 2nd row, 3rd column daki datayı print etsin


    public void printData(int satir, int sutun){
        driver.get("https://the-internet.herokuapp.com/tables");
        String myXpath = "//table[@id='table1']//tbody//tr["+satir+"]//td["+sutun+"]";
        System.out.println(driver.findElement(By.xpath(myXpath)).getText());
    }
    @Test
    public void printDataTest(){
        printData(2,3);
    }


    }

