package ru.beru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

public class FirstTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
    }

    @Test
    public void Test_N1() {
        // Go to home page
        driver.get("https://beru.ru/");
        System.out.println(driver.getTitle());

        // Click to LoginButton
        driver.findElement(By.cssSelector("._3ZGcN3lbEg")).click();

        // If CAPTCHA test:(
        if(driver.getTitle().equals("Ой!")) {
           System.out.println("CAPTCHA test:(");
        } else {
            System.out.println("Page name: "+driver.getTitle());
            // driver.findElement(By.linkText("Другой аккаунт")).click();
            if(driver.findElement(By.id("passp-field-login")).isDisplayed()) {
                System.out.println("First input to account.");
                driver.findElement(By.id("passp-field-login")).sendKeys("nikola.kupin");
                driver.findElement(By.xpath("//button[@type='submit']")).click();
            }
            if(driver.findElement(By.name("passwd")).isEnabled()) {
                driver.findElement(By.id("passp-field-passwd")).sendKeys("Nikola_95");
                driver.findElement(By.xpath("//button[@type='submit']")).click();
                if(driver.findElements(By.cssSelector("._3ZGcN3lbEg")).isEmpty()) {
                    System.out.println("Authorization was successful!!!");
                } else {
                    System.out.println("Authorization is not passed!?!");
                }
            }
        }
    }

    @AfterClass
    public void tearDown() {
        // Close all browser windows and safely end the session
        driver.quit();
    }

}
