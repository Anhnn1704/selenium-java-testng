package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {

    WebDriver driver;

    String fullName = "Selenium Locator";

    @BeforeClass
    public void initialBrowser(){
        //Mở browser lên
        driver = new FirefoxDriver();
        // Mở app lên đến màn hình Login
        driver.get("https://demo.nopcommerce.com/register");
    }

    @Test
    public void TC_01_ID(){
        driver.findElement(By.id("small-searchterms"));

        driver.findElement(By.id("FirstName"));
    }

    @Test
    public void TC_02_Class(){
        //Nó ko lấy hết toàn bộ giá trị (nếu có khoảng trắng)
         driver.findElement(By.className("register-next-step-button"));
    }

    @Test
    public void TC_03_Name(){
        driver.findElement(By.name("DateOfBirthDay"));
        driver.findElement(By.name("DateOfBirthMonth"));
        driver.findElement(By.name("DateOfBirthYear"));
    }

    @Test
    public void TC_04_LinkText(){
        //Chỉ làm việc với element và link và có text
        //Thẻ a và có thuộc tính href
        //Phải lấy hết toàn bộ text ko chứa cái nào hết (tuyệt đối)
        driver.findElement(By.linkText("Register"));

        driver.findElement(By.linkText("Log in"));

        driver.findElement(By.linkText("WishList"));
    }

    @Test
    public void TC_05_Partial_Link_Text(){
        //Chỉ làm việc với element và link
        //Có thể lấy hết toàn bộ hoặc 1 phần (hay dùng)
        driver.findElement(By.partialLinkText("Register"));

        driver.findElement(By.partialLinkText("Digital"));

        driver.findElement(By.partialLinkText("dowloads"));
    }

    @Test
    public void TC_06_Tagname(){
        //Tên thẻ (HTML)
        //Tìm tất cả các element giống nhau (thẻ của component giống nhau)
        //Tất cả textbox/ checkbox/ radioa/ link/ button/ ...
        driver.findElement(By.tagName("button"));

        driver.findElement(By.tagName("input"));

        driver.findElement(By.tagName("lable"));
    }

    @Test
    public void TC_07_Css(){
        driver.findElement(By.cssSelector("input#Company"));
        driver.findElement(By.cssSelector("#Company"));
        driver.findElement(By.cssSelector("input[id='Company']"));

        driver.findElement(By.cssSelector("button.register-next-step-button"));
        driver.findElement(By.cssSelector("button[class='button-1 register-next-step-button']"));

        driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"));
        driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"));
        driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"));

        driver.findElement(By.cssSelector("a[href*='/register?returnUrl=%2F']"));
        driver.findElement(By.cssSelector("a[href*='/login?returnUrl=%2F?']"));

        driver.findElement(By.cssSelector("a[href*='register?']"));
        driver.findElement(By.cssSelector("a[href*='login?']"));

        driver.findElement(By.cssSelector("a"));
        driver.findElement(By.cssSelector("button"));
        driver.findElement(By.cssSelector("input"));
    }

    @Test
    public void TC_08_XPath(){
        driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        driver.findElement(By.xpath("//input[@id='Password'"));
        driver.findElement(By.xpath("//input[@id='Company'"));

        driver.findElement(By.xpath("//button[@class='button-1 register-next-step-button']"));
        driver.findElement(By.xpath("//button[contains(@class, 'register-next-step-button')]"));

        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
        driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));

        driver.findElement(By.xpath("//a[text()='Register']"));
        driver.findElement(By.xpath("//a[text()='Login']"));
        driver.findElement(By.xpath("//a[text()='Shipping & returns']"));

        driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Shipping')]"));
        driver.findElement(By.xpath("//a[contains(text(),'& returns')]"));

        driver.findElement(By.xpath("//a"));
        driver.findElement(By.xpath("//button"));
        driver.findElement(By.xpath("//input"));

    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}
