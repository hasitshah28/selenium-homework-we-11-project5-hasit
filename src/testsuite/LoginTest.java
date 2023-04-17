package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
@Test
    public void userShouldNavigateToLoginPageSuccessfully(){

    //click on the ‘Sign In’ link
    driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();

    //Verify the text ‘Welcome Back!
    String expectedMessage = "Welcome Back!";
    WebElement actualTextElement = driver.findElement(By.xpath("//h2[@class = 'page__heading']"));
    String actualMessage = actualTextElement.getText();
    Assert.assertEquals(expectedMessage, actualMessage);
}
@Test
    public void verifyTheErrorMessage(){

    //click on the ‘Sign In’ link
    driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();

    //Enter invalid username
    driver.findElement(By.id("user[email]")).sendKeys("Admin123@gmail.com");

    //Enter invalid password
    driver.findElement(By.name("user[password]")).sendKeys("abc123");

    //Click on ‘LOGIN’ button
    driver.findElement(By.xpath("//button[@type = 'submit']")).click();

    //Verify the error message ‘Invalid email or password.’
    String expectedMessage = "Invalid email or password.";
    WebElement actualTextElement = driver.findElement(By.xpath("//li[@class = 'form-error__list-item']"));
    String actualMessage = actualTextElement.getText();
    Assert.assertEquals(expectedMessage, actualMessage);

}
    public void closeBrowser(){
        driver.quit();
    }

}
