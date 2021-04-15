import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WorkingWithBooks {
    public WebDriver webDriver;
    public static final String pagebook ="https://demoqa.com/books";
    private static final By logout= By.id("submit");
    private static final By buttonAddBook = By.id("addNewRecordButton");
    private static final By goToStore= By.id("gotoStore");


    @Step(value = "Open https://demoqa.com/books ")
    public void openPage(){
        Selenide.open(pagebook);
    }


    @Step(value = "add book")
    public void addBook(String book){
       //SelenideElement input= Selenide.$(By.xpath(".//a[text()='"+book+"']"));
        SelenideElement input= Selenide.$(By.linkText(book));
       input.click();
       Selenide.$(buttonAddBook).click();


    }

    //@Step(value = "view profil")




}
