package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator_Part_2 {

    WebDriver driver;

   // String fullName = "Selenium Locator";

    @BeforeClass
    public void initialBrowser(){
        //Mở browser lên
        driver = new FirefoxDriver();
        // Mở app lên đến màn hình Login
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
    }

    @Test
    public void TC_08_Relative_Locator() throws InterruptedException{
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
