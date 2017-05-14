/**
 * Created by marina on 09.05.2017.
 */
//Нужно запускать отдельно сервер!!! (импорт в мавене второго селениума, с 3 не работает, ошибки компиляции)
/*
import com.thoughtworks.selenium.Selenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;
*/

public class SeleniumSearch {
/*
    private Selenium selenium;

    @Before
    public void setUp() throws Exception {
*/
/* Для переноса старого кода с селениум 1 на селениум 2
        WebDriver driver = new FirefoxDriver();
        selenium = new WebDriverBackedSelenium(driver, "https://www.google.ru/");
*//*

        //selenium = new DefaultSelenium("localhost", 4444, "*firefox", "https://www.google.ru/");
        //selenium.start();
    }

    @Test
    public void testFindSeleniumInGoogle() throws Exception {
        selenium.open("https://www.google.ru/?gws_rd=ssl");
        selenium.type("username=lst-ib", "Selenium");
        selenium.click("password=btnK");
        assertTrue(selenium.isElementPresent("link=Selenium - Web Browser Automation"));
    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }
*/

}
