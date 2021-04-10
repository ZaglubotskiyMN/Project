import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class test {
    public WebDriver webDriver;

@Before
public void start() {
    Selenide.open("https://demoqa.com/books");

}

@Test
public void test(){

}


    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(5000);
        if (webDriver != null){
            webDriver.quit();
        }
    }


}
