import common.LoginForm;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.fail;


/**
 * Created by marina on 12.05.2017.
 */
public class BaseClass {
    static protected WebDriver driver;
    protected String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeSuite
    @Parameters({"configFile"})
    public void setUp(@Optional String configFile) throws Exception {
/*
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        driver = new RemoteWebDriver(new URL("http:/192.168.0.101:4444/wd/hu"), capabilities);
*/
        if (configFile == null) {
            configFile = System.getProperty("configFile");
        }
        if (configFile == null) {
            configFile = System.getenv("configFile");
        }
        if (configFile == null) {
            configFile = "application.properties";
        }
        Properties props = new Properties();
        props.load(new FileInputStream(new File(configFile)));

        baseUrl = props.getProperty("baseUrl", "http://localhost.html");

        String browser = props.getProperty("browser", "firefox");
        if ("firefox".equals(browser)) {
            System.setProperty("webdriver.gecko.driver","D:\\selenium\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if ("ie".equals(browser)) {
            driver = new InternetExplorerDriver();
        } else if ("chrome".equals(browser)) {
            System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            driver = new HtmlUnitDriver();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    protected void getBaseUrl() {
        driver.get(baseUrl);
    }

    protected void fillLoginForm(LoginForm loginForm) {
        driver.findElement(By.name("j_username")).clear();
        driver.findElement(By.name("j_username")).sendKeys(loginForm.getUsername());
        driver.findElement(By.name("j_password")).clear();
        driver.findElement(By.name("j_password")).sendKeys(loginForm.getPassword());
    }

    protected void confirmForm() {
        driver.findElement(By.cssSelector("button.gwt-Button")).click();
    }

    protected void isEqualsElement(String expectedValue) {
        assertEquals(expectedValue, driver.findElement(By.cssSelector("div.list-header-white")).getText());
    }
    protected boolean isOperationSucceeded() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement webElement = new WebDriverWait(driver, 10).until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                try {
                    return webDriver.findElement(By.id("successMessage"));
                }
                catch (NotFoundException ex) {
                }
                try {
                    return webDriver.findElement(By.id("errorMessage"));
                }
                catch (NotFoundException ex) {
                }
                return null;
            }
        });
        if (webElement != null && webElement.getAttribute("id").equals("successMessage")) {
            return true;
        }
        else return false;
    }

}
