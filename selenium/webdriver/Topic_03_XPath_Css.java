package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_03_XPath_Css {

    //1 - Setup: OS/ Browser/ Web/ Page/ Data
    WebDriver driver;

    @BeforeClass
    public void initialBrowser(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }

    @Test
    public void Register_01_Empty_Data() {
        //Action
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Assert
        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
    }

    @Test
    public void Register_02_Invalid_Email(){
        driver.findElement(By.id("txtFirstname")).sendKeys("Ngoc Anh");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("anh@123#");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("anh@123#");
        driver.findElement(By.id("txtPassword")).sendKeys("anh@12345");
        driver.findElement(By.id("txtCPassword")).sendKeys("anh@12345");
        driver.findElement(By.id("txtPhone")).sendKeys("0372371927");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
    }

    @Test
    public void Register_03_Incorrect_Corfirm_Email(){
        driver.findElement(By.id("txtFirstname")).sendKeys("Ngoc Anh");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("anh@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("anh@123#");
        driver.findElement(By.id("txtPassword")).sendKeys("anh@12345");
        driver.findElement(By.id("txtCPassword")).sendKeys("anh@12345");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0372371927");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
    }

    @Test
    public void Register_04_Invalid_Password() {
        driver.findElement(By.id("txtFirstname")).sendKeys("Ngoc Anh");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("anh@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("anh@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("anh12");
        driver.findElement(By.id("txtCPassword")).sendKeys("anh1");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0372371927");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
    }

    @Test
    public void Register_05_Incorrect_Corfirm_Password(){
        driver.findElement(By.id("txtFirstname")).sendKeys("Ngoc Anh");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("anh@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("anh@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("anh123");
        driver.findElement(By.id("txtCPassword")).sendKeys("anh125");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0372371927");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");
    }
    @Test
    public void Register_06_Invalid_Phone_Number(){
        driver.findElement(By.id("txtFirstname")).sendKeys("Ngoc Anh");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("anh@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("anh@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("anh123");
        driver.findElement(By.id("txtCPassword")).sendKeys("anh125");
        WebElement phoneInput = driver.findElement(By.xpath("//input[@id='txtPhone']"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

        //Nhập phone < 10 kí tự
        phoneInput.sendKeys("037237");
        submitButton.click();
        WebElement phoneError = driver.findElement(By.xpath("//label[@id='txtPhone-error']"));
        Assert.assertEquals(phoneError.getText(), "Số điện thoại phải từ 10-11 số.");
        //Nhập phone > 11 kí tự
        phoneInput.clear();

        phoneInput.sendKeys("0372371927887");
        submitButton.click();
        Assert.assertEquals(phoneError.getText(), "Số điện thoại phải từ 10-11 số.");
        //Nhập phone bắt đầu không phải đầu số của các nhà mạng
        phoneInput.clear();
        phoneInput.sendKeys("2365");
        submitButton.click();
        Assert.assertEquals(phoneError.getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");

    }


    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}