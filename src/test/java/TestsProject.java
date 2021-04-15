import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;

public class TestsProject {
    public WebDriver webDriver;
    private AuthorizationPage authorizationPage;
    private BookPageViewing bookPageViewing ;
    private WorkingWithBooks workingWithBooks;

@Before
public void start() {
    //Selenide.open("https://demoqa.com/books");
    authorizationPage = new AuthorizationPage();
    bookPageViewing = new BookPageViewing();
    workingWithBooks = new WorkingWithBooks();

}

@Test
public void TestSuccesslogin(){
authorizationPage.openPage();
authorizationPage.successlogin();
//webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//Assert.assertTrue(AuthorizationPage.loginverification()); /*-- ошибка спросить*/
}

//@Test
public void TestInvalidPassword(){
    authorizationPage.openPage();
    authorizationPage.invalidpassword();
    //webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    //Assert.assertTrue(AuthorizationPage.invalidauthorization()); -- ошибка спросить

}

//@Test
public void TestViewBooks(){
    bookPageViewing.openPage();
    webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    bookPageViewing.getbook();
}

@Test
public void TestAddBook(){
    workingWithBooks.openPage();
    webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    workingWithBooks.addBook("Learning JavaScript Design Patterns");

}



    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(15000);
        if (webDriver != null){
            webDriver.quit();
        }
    }


}
