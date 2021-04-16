package TestsUI;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookPageViewing {
    public WebDriver webDriver;

    public static final String pagebook ="https://demoqa.com/books";
    private static final By listbooks = By.className("mr-2");

    @Step(value = "Open https://demoqa.com/book")
    public void openPage() {
        Selenide.open(pagebook);
    }

    @Step(value = "Get books")
    public void getbook(){
        List<WebElement> namebooks = WebDriverRunner.getWebDriver().findElements(listbooks);
        for (int i=0;i< namebooks.size();i++){
            System.out.println(namebooks.get(i).getText());
        }
    }

    public static boolean countBooks(int actualsize){
        List<WebElement> namebooks = WebDriverRunner.getWebDriver().findElements(listbooks);
        for (int i=0;i< namebooks.size();i++){
        }
        int size = namebooks.size();
        return (size==actualsize);
    }


}
