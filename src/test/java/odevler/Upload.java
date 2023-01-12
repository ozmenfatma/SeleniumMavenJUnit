package odevler;

import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Upload extends TestBase {


    @Test
    public void test01() {


//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
       WebElement home= driver.findElement(By.xpath("//a[@style='color: orange;']"));
        Assert.assertTrue(home.isDisplayed());

//        4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//i[@class='fa fa-envelope']")).click();

//        5. Verify 'GET IN TOUCH' is visible
      WebElement yazi=  driver.findElement(By.xpath("//h2[text()='Get In Touch']"));
     Assert.assertTrue( yazi.isDisplayed());

//        6. Enter name, email, subject and message
        Faker faker=new Faker();
        String name= faker.name().firstName();
        String email=faker.internet().emailAddress();
        String subject= faker.name().title();

        driver.findElement(By.xpath("//input[@class='form-control']"))
                .sendKeys(name, Keys.TAB,email,Keys.TAB,subject,Keys.TAB,"Hello");

//        7. Upload file
        WebElement upload= driver.findElement(By.xpath("//input[@name='upload_file']"));

        String path=System.getProperty("user.home")+"/OneDrive/Masaüstü/logo.jpeg";
        upload.sendKeys(path);
         Actions actions= new Actions(driver);
         actions.sendKeys(Keys.PAGE_DOWN).perform();


//        8. Click 'Submit' button
       WebElement submit= driver.findElement(By.xpath("//input[@value='Submit']"));
      submit.click();

//        9. Click OK button
        driver.switchTo().alert().accept();
        Actions actions1= new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).perform();


//        10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement yazi1= driver.findElement(By.xpath("//div[text()='Success! Your details have been submitted successfully.']"));
        Assert.assertTrue(yazi1.isDisplayed());

//        11. Click 'Home' button and verify that landed to home page successfully

        driver.findElement(By.xpath("//i[@class='fa fa-angle-double-left']")).click();





    }
}
