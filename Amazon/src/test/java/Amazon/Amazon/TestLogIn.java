package Amazon.Amazon;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestLogIn {
    public static WebDriver driver;

    @BeforeClass
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
        Assert.assertEquals("Amazon.com. Spend less. Smile more.", driver.getTitle()); ;
    }

    @Test
    public void Test() throws Exception {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("IPhone X"); 
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep (2000);
        
        driver.findElement(By.className("a-size-medium a-color-base a-text-normal")).click();

        driver.findElement(By.id("add-to-cart-button")).click();

        WebDriverWait wait= new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("attachSiAddCoverage-announce")));

        driver.findElement(By.id("attachSiAddCoverage-announce")).click();

        driver.findElement(By.className("a-button-input")).click();

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

        System.out.println("Congratulation, you will get IPhone a soon is possible");
    }

    
//    
    
    
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}