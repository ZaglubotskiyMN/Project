package TestsUI;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;


public class AuthorizationPage {

    public static final String pageLogin = "https://demoqa.com/login";
    private static final By inputLogin = By.id("userName");
    private static final By inputpass = By.id("password");
    private static final By loginbut =By.id("login");
    private static final String log = "USER63";
    private static final String pass = "Tz12345!";
    private static final String badpassword= "A45322s!";
    private static final By loginVerification = By.id("userName-value");
    private static final By invalidUsernameorPassword = By.id("name");
    private static final By logout= By.id("submit");



    @Step(value = "Open https://demoqa.com/login")
    public void openPage(){
        Selenide.open(pageLogin);
    }
    @Step(value = "login completed successfully")
    public void successlogin(){
        Selenide.$(inputLogin).sendKeys(log);
        Selenide.$(inputpass).sendKeys(pass);
        Selenide.$(loginbut).click();
    }


    public static boolean loginverification(){
        String userlogintext =Selenide.$(loginVerification).getText();
        return "USER63".equals(userlogintext);
    }

    @Step(value = "invalid password")
    public void invalidpassword(){
        Selenide.$(logout).click();
        Selenide.$(inputLogin).sendKeys(log);
        Selenide.$(inputpass).sendKeys(badpassword);
        Selenide.$(loginbut).click();
    }

    public static boolean invalidauthorization(){
        String userlogintext =Selenide.$(invalidUsernameorPassword).getText();
        return "Invalid username or password!".equals(userlogintext);
    }

    public void logout(){
        Selenide.$(logout).click();
    }







}
