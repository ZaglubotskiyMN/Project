package TestsUI;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestsProjectUI {
    public WebDriver webDriver;
    private AuthorizationPage authorizationPage;
    private BookPageViewing bookPageViewing;
    private WorkingWithBooks workingWithBooks;

    @Before
    public void start() {
        authorizationPage = new AuthorizationPage();
        bookPageViewing = new BookPageViewing();
        workingWithBooks = new WorkingWithBooks();

        Configuration.browser = "chrome"; // название браузера
        Configuration.browserVersion = "90.0"; // версия браузера
        Configuration.remote = "http://http://188.130.155.80:4444//wd/hub"; // адрес Selenoid
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true); // разрешить удаленный доступ к  рабочему столу контейнера
        capabilities.setCapability("enableVideo", true); // разрешить запись видео
        Configuration.browserCapabilities = capabilities;


    }

    @Test
    @Owner("ZaglubotskiyMN")
    @Description("Просмотр списка книг без регистрации")
    public void aTestViewBooks() {
        bookPageViewing.openPage();
        bookPageViewing.getbook();
        Assert.assertTrue(BookPageViewing.countBooks(8));
    }

    @Test
    @Owner("ZaglubotskiyMN")
    @Description("Авторизация")
    public void bTestSuccessLogin() {
        authorizationPage.openPage();
        authorizationPage.successlogin();
        Assert.assertTrue(AuthorizationPage.loginverification());
    }

    @Test
    @Owner("ZaglubotskiyMN")
    @Description("Добавляем книгу")
    public void cTestAddBook() {
        workingWithBooks.openPage();
        workingWithBooks.addBook("Learning JavaScript Design Patterns");
        Assert.assertTrue(WorkingWithBooks.ConfirmTheAddition());
    }

    @Test
    @Owner("ZaglubotskiyMN")
    @Description("Удаляем книги")
    public void dTestDeleteBooks(){
        workingWithBooks.deletebooks();
        Assert.assertTrue(WorkingWithBooks.ConfirmDeletion());
    }

    @Test
    @Owner("ZaglubotskiyMN")
    @Description("Неверный пароль")
    public void fTestInvalidPassword() {
        authorizationPage.openPage();
        authorizationPage.invalidpassword();
        Assert.assertTrue(AuthorizationPage.invalidauthorization());

    }


    @After

    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        if (webDriver != null) {
            webDriver.quit();
        }
    }


}
