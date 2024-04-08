package com.ivcevidensia;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SubmitContactTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @Test
    public void submitEmptyContact() {
        driver.get("https://practicetestautomation.com/");
        //click menu item
        WebElement menuButton = driver.findElement(By.id("menu-item-18"));
        menuButton.click();

        //click to Submit empty Contact form
        WebElement submitButton = driver.findElement(By.id("wpforms-submit-161"));
        submitButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        //Verify the error message on First name
        String firstNameErrorMessage = driver.findElement(By.id("wpforms-161-field_0-error")).getText();
        String expectedFirstNameErrorMessage = "This field is required.";
        assertEquals(expectedFirstNameErrorMessage, firstNameErrorMessage);

        //Verify the error message on Last name
        String lastNameErrorMessage = driver.findElement(By.id("wpforms-161-field_0-last-error")).getText();
        String expectedLastNameErrorMessage = "This field is required.";
        assertEquals(expectedLastNameErrorMessage, lastNameErrorMessage);

        //Verify the error message on Email
        String emailErrorMessage = driver.findElement(By.id("wpforms-161-field_1-error")).getText();
        String expectedEmailErrorMessage = "This field is required.";
        assertEquals(expectedEmailErrorMessage, emailErrorMessage);

        //Verify the error message on comment
        String commentErrorMessage = driver.findElement(By.id("wpforms-161-field_2-error")).getText();
        String expectedCommentErrorMessage = "This field is required.";
        assertEquals(expectedCommentErrorMessage, commentErrorMessage);
    }

    @After
    public void tearDown() {
        // Close the browser after test execution
        driver.quit();
    }
}
