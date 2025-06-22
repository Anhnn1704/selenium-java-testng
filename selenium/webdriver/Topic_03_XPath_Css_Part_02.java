package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_03_XPath_Css_Part_02 {

    //1 - Setup: OS/ Browser/ Web/ Page/ Data
    WebDriver driver;

    @BeforeClass
    public void initialBrowser(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void xPath(){
        driver.get("https://tanvietbooks.vn/account/register");
         //Tiêu chí chọn: duy nhất - id/class/name - giá trị của attribute phải có nghĩa (liên quan tới element đó)
        //Relative Xpath Format: //tagname[@attribute='value']

        //1. Đối với các element che mất/bị ẩn/không nằm trong viewport (nằm phía dưới hoặc phía trên màn hình đang chạy)
        // không tìm được thuộc tính trong thẻ là duy nhất => Tìm thuộc tính trong element cha của nó
        driver.findElement(By.xpath("//li[@class='li_menu']//a[@title='Sách công nghệ Tân Việt']")).click();
        driver.navigate().back();

        //2. Hàm text()
        driver.findElement(By.xpath("//a[text()='Bách khoa cho bé']"));

        //3. Hàm contains()
        driver.findElement(By.xpath("//a[contains(text(), 'sách công nghệ')]"));
        driver.findElement(By.xpath("//a[contains(@title,'nhà sách')]"));
        driver.findElement(By.xpath("//ul[@class='list-menu toggle-mn']//a[contains(@href,'nuoi')]"));
        driver.findElement(By.xpath("//a[contains(.,'Wonderland')]"));
        driver.findElement(By.xpath("//a[contains(string(),'Wonderland')]"));

        //4. Hàm concat()

        //5. Hàm starts-with: dùng khi thuộc tính của 1 element với mỗi lần lấy xpath nó thay đổi liên tục nhưng text ở đâu luôn cố định

        //6. Hàm AND OR NOT
        driver.findElement(By.xpath("//input[@id='lastName' and @placeholder='Họ']"));
        driver.findElement(By.xpath("//input[@id='lastName' or @name='firstName']"));

        //7. Xpath Axes
        driver.findElement(By.id("query")).sendKeys("Kí họa");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//button[@title='Thêm vào giỏ hàng']/parent::*/preceding-sibling::a[@title='Kí Họa Venice']")).click();

    }

        @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}