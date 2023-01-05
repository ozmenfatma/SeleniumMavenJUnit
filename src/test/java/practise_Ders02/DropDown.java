package practise_Ders02;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDown extends TestBase {
    @Test
    public void  test01(){
        //1.yol
        //Dropdown menuyu yazdıralım
        List<WebElement> dropdown = driver.findElements(By.xpath("//*[@id='searchDropdownBox']"));
        dropdown.forEach(t-> System.out.println(t.getText()));


        //2.yol
//        WebElement dropdown = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
//        Select select = new Select(dropdown);
//        for (WebElement w : select.getOptions()) {
//            System.out.println(w.getText());
//        }
        //Dropdown menuden baby secelim
        driver.findElement(By.xpath("//*[@id='searchDropdownBox']")).sendKeys("Baby"
                , Keys.TAB,"Milk",Keys.ENTER);
        //arama bölümünden milk aratalım
    }
}
