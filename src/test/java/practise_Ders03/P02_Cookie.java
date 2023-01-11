package practise_Ders03;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class P02_Cookie extends TestBase {
    /*
                                    Cookies(Çerezler)
        "Cookie" ler, bir web sitesi tarafından tarayıcıya depolanan küçük veri parçacıklarıdır.
    Tarayıcı, herhangi bir web sayfasına gittiğinde, o sayfanın cookie'lerini saklar ve
    daha sonra o sayfaya geri döndüğünde, o cookie'leri tekrar gönderir. Bu sayede, web sitesi,
    kullanıcının daha önce o sayfada ne yaptığını veya ne seçtiğini hatırlayabilir.
     */

    @Test
    public void test01() {

        //Techproeducation adresine gidiniz

        driver.get("https://techproeducation.com");
        waitFor(5);

        //Sayfadaki cookie lerin sayısını yazdırınız
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("cookie'lerin sayisi :" + cookies.size());


        //Sayfadaki cookie lerin isim ve değerlerini yazdırınız
        for (Cookie c: cookies) {
            System.out.println(c.getName() +":" +c.getValue());

        }

        //Yeni bir cookie ekleyiniz
        Cookie myCookie= new Cookie("myCookie","123456789");
        driver.manage().addCookie(myCookie);


        //Yeni cookie eklendikten sonra cookie sayısını ve isimlerini yazdırınız
        Set<Cookie> cookies1 = driver.manage().getCookies();
        System.out.println("cookie'lerin sayisi :" + cookies1.size());

        for (Cookie w: cookies1) {
            System.out.println(w.getName() +":" +w.getValue());

        }

        //Oluşturduğumuz cookie'i silelim
        driver.manage().deleteCookie(myCookie);

        //Tüm cookieleri silelim
        //Tüm cookieleri silelim
        driver.manage().deleteAllCookies();
        Set<Cookie> cookies3 = driver.manage().getCookies();
        System.out.println(cookies3.size());

    }
}
