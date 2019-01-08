package Utilities;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    public WebDriver driver;
    protected Actions action;
    public Faker fake;
    public String url="https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table";
    @BeforeClass
    public void setUpClass()
    {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp()
    {
        fake=new Faker();
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        action= new Actions(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }
}

