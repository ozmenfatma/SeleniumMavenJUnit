package day13;

public class interwiew {
    // Interview Questions
/*

Tell me 5 exception that you get.-5 adet selenium da aldigin exceptions dan bahset.
What type of exceptions do you get in selenium? - Seleniumda ki align exceptions tiplerinden bahset
What is your solution?-Cozum ne?
What type of waits do you use?- Hangi resit wait kullanirsin?
Which wait do you prefer?- Hangi wait tercih edersin?
Why do you prefer that wait?- Neden onu tercih edersin?
How to you resolve synronization issue?-Senkronizasyon problemini nasil cozersin?


NoSuchElementException
TimeOutException
NullPointerException
InvalidSelectorException
StaleElementReferenceException
InvalidElementStateException
WebDriverException
ElementNotInteractableException
ElementClickInterceptedException
InvalidArgumentException
JavascriptException
RemoteDriverServerException
 */

    //  NoSuchElementException:
    /*
Yanlis locator
Popup, yeni pencere, iframe,…
Sayfa dolmada problemler ve yavaslamalar
Sakli olan elementler
Solution:
Locatorin dogrulugunu tekrar kontrol et
Manual test ile iframe, yeni pencere, alert,… gibi elementlerin varligini kontrol et.
Bekleme problemi olabilir. Implicit wait bekleme suresini cozmuyor. Bu durumda explicit wait yada fluent wait kullaniriz


Seleniumda aldigin 5 exception
Null pointer, no such element, time out, slale element reference, web driver
Genel olarak exception aldiginda bozum yolun nedir?
Hata mesajini oku
Genel olarak zamanlama, yanlis locator, iframe hataları olabiliyor
Hata mesajina gore exception I cozdukden sonra tekrar kodumu calistirim
Selniumda kullandigin waitler nelerdir>
Implicit yada explicit yada fluent
Hangi waiti tercih edersin?
Test Base (Driver sinifinda) implicit wait kullanıyorum. Cogu problemi bozuyor Cozemedigi durumlarda explicit wait kullanıyorum.
Neden Explicit wait?
Explicit wait element e ouzel yazilabilir. Yerel cozum gerektiğinde explicit wait I kullanmak zorundayiz.
Senkronize(bekleme) problemlerini nasıl çözersin
Selenium waitlerini kullanarak. Implicit wait driver im da var, ama yetmedigi durumlarda explicit wait kullanirim. Bu yüzden ReusableMethod sinifimda tekrar tekrar kullanabileceğimiz explicit wait method lari var. Kolaylıkla explicit wait ile bekleme problemlerini cozebuliyoruz.


 */
}
