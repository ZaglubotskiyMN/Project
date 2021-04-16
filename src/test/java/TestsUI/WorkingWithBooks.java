package TestsUI;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WorkingWithBooks {
    public static WebDriver webDriver;
    public static final String pagebook ="https://demoqa.com/books";
    public static final String pageprofile = "https://demoqa.com/profile";
    private static final By deletebooks= By.xpath("//button[text()='Delete All Books']");
    private static final By buttonAddBook = By.xpath("//button[text()='Add To Your Collection']");
    private static final By confirmDeleteOk = By.xpath("//button[text()='OK']");
    //private static final By goToStore= By.id("gotoStore");


    @Step(value = "Open https://demoqa.com/books ")
    public void openPage(){

        Selenide.open(pagebook);
    }


    @Step(value = "add book")
    public void addBook(String book){
       SelenideElement input= Selenide.$(By.xpath(".//a[text()='"+book+"']"));
       input.click();
       Selenide.$(buttonAddBook).scrollTo();
       Selenide.$(buttonAddBook).click();
    }

    public static boolean ConfirmTheAddition(){
        Alert alert= WebDriverRunner.driver().switchTo().alert();
        String alertGetText =alert.getText();
        alert.accept();
        //System.out.println(alertGetText);
        return "Book added to your collection.".equals(alertGetText);

    }

    @Step(value = "delete books")
    public void deletebooks(){
        Selenide.open(pageprofile);
        Selenide.$(deletebooks).scrollTo();
        Selenide.$(deletebooks).click();
        Selenide.$(confirmDeleteOk).click();
    }

    public static boolean ConfirmDeletion(){
        Alert alert =WebDriverRunner.driver().switchTo().alert();
        String alertGetText = alert.getText();
        alert.accept();
        return "All Books deleted.".equals(alertGetText);

    }




}
