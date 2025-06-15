package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {

    WebDriver driver;

   // String fullName = "Selenium Locator";

    @BeforeClass
    public void initialBrowser(){
        //Mở browser lên
        driver = new FirefoxDriver();
        // Mở app lên đến màn hình Login
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
    }

//    @Test
//    public void TC_01_ID() throws InterruptedException {
//        driver.findElement(By.name("fullName")).sendKeys("Nguyen Ngoc Anh");
//        driver.findElement(By.name("username")).sendKeys("anhnn1704");
//        driver.findElement(By.name("password")).sendKeys("Anh@1234");
//        driver.findElement(By.name("passwordConfirm")).sendKeys("Anh@1234");
//        driver.findElement(By.name("phone")).sendKeys("0372371927");
//        Thread.sleep(3000);
//    }
//
//    @Test
//    public void TC_02_Class() throws InterruptedException {
//        //Nó ko lấy hết toàn bộ giá trị (nếu có khoảng trắng)
//         driver.findElement(By.className("btn-register-form")).click();
//        Thread.sleep(3000);
//    }
//
//    @Test
//    public void TC_03_Name() throws InterruptedException {
//        driver.findElement(By.name("fullName"));
//        Thread.sleep(3000);
//    }
//
//    @Test
//    public void TC_04_LinkText() throws InterruptedException {
//        //Chỉ làm việc với element và link và có text
//        //Thẻ a và có thuộc tính href
//        //Phải lấy hết toàn bộ text ko chứa cái nào hết (tuyệt đối)
//        driver.findElement(By.linkText("support@vio.edu.vn"));
//        Thread.sleep(3000);
//        driver.findElement(By.linkText("Facebook VioEdu")).click();
//        Thread.sleep(3000);
//    }
//
//    @Test
//    public void TC_05_Partial_Link_Text(){
//        //Chỉ làm việc với element và link
//        //Có thể lấy hết toàn bộ hoặc 1 phần (hay dùng)
//        driver.findElement(By.partialLinkText("Đổi")).click();
//        driver.findElement(By.partialLinkText("quà")).click();
//    }
//
//    @Test
//    public void TC_06_Tagname(){
//        //Tên thẻ (HTML)
//        //Tìm tất cả các element giống nhau (thẻ của component giống nhau)
//        //Tất cả textbox/ checkbox/ radio/ link/ button/ ...
//        driver.findElement(By.tagName("button"));
//        driver.findElement(By.tagName("a"));
//    }
//
//    @Test
//    public void TC_07_Css(){
//        driver.findElement(By.cssSelector("input[name='fullName']"));
//
//        driver.findElement(By.cssSelector("button.btn-register-form"));
//        driver.findElement(By.cssSelector("button[class='btn btn-register-form btn-green-new']"));
//
//        driver.findElement(By.cssSelector("a[href='/skill-list']"));
//        driver.findElement(By.cssSelector("a[href='/arena']"));
//
//        driver.findElement(By.cssSelector("button"));
//        driver.findElement(By.cssSelector("input"));
//    }

    @Test
    public void TC_09_Relative_Locator() throws InterruptedException{
        //Element  By A
        WebElement emailTextbox = driver.findElement(By.cssSelector("input#Email"));
        //By passwordTextboxBy = By.cssSelector("input#Password");
        WebElement passwordTextbox = driver.findElement(By.cssSelector("input#Password"));

        //Element/ By B
        By rememberMeCheckboxBy = By.id("RememberMe");

        //Element/ By C
        By forgotPasswordLinkBy = By.cssSelector("span.forgot-password");


        //Element/ By D
        By loginButtonBy = By.cssSelector("button.login-button");

        //Element/ By E
        WebElement rememberMeLabelText = driver.findElement(RelativeLocator.with(By.tagName("label"))
                .above(loginButtonBy)//Label đang nằm trên login button
                .below(passwordTextbox) //Label nằm dưới Password textbox
                .toRightOf(rememberMeCheckboxBy) //Label nằm bên phải so vs RememberMe checkbox
                .toLeftOf(forgotPasswordLinkBy) //Label nằm bên trái so vs Forgot Password link
        );

        WebElement dangNhap = driver.findElement(By.className("login-button"));
        emailTextbox.sendKeys("anhnn@gmail.com");
        passwordTextbox.sendKeys("Anh@1234");
        dangNhap.click();
        Thread.sleep(3000);

    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}
