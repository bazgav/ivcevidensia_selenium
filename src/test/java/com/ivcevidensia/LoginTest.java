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

public class LoginTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage()
                .window()
                .maximize();
    }

    @Test
    public void testSuccessfulLogin() {
        // Navigate to the login page
        driver.get("https://practicetestautomation.com/");
        String expectedTitle = "Practice Test Automation | Learn Selenium WebDriver";
        assertEquals(expectedTitle, driver.getTitle());

        // enter the menu link
        WebElement menuButton = driver.findElement(By.id("menu-item-20"));
        menuButton.click();

        // find Test Login Page link
        WebElement linkElement = driver.findElement(By.linkText("Test Login Page"));
        linkElement.click();

        // Enter username
        WebElement usernameElement = driver.findElement(By.id("username"));
        usernameElement.sendKeys("student");

        // Enter password
        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("Password123");

        // Click on the login button
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Wait for the page to load
        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofMillis(500));

        // Verify successful login by checking if a welcome message is displayed
        String loginMessage = driver.findElement(By.className("post-title"))
                .getText();
        String expectedLoginMessage = "Logged In Successfully";
        assertEquals(expectedLoginMessage, loginMessage);
    }

    @After
    public void tearDown() {
        // Close the browser after test execution
        driver.quit();
    }
}