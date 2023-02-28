//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.testautomation3;

import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    private final WebDriver driver = new ChromeDriver();
    Utils utils;

    public Login() {
        this.utils = new Utils(this.driver);
    }

    @BeforeEach
    public void setUp() {
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
        this.driver.get("https://jira-auto.codecool.metastage.net/");
        this.driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    @AfterEach
    public void tearDown() {
        this.driver.quit();
    }

    @Test
    @DisplayName("Happy-path Login Test")
    public void successfulLogin() {
        this.utils.login();
        this.utils.waitUntilElementFound(By.id("header-details-user-fullname")).click();
        this.utils.waitUntilElementFound(By.id("view_profile")).click();
        WebElement username = this.utils.waitUntilElementFound(By.id("up-d-username"));
        Assertions.assertEquals("automation43", username.getAttribute("innerText"));
        this.utils.logout();
    }

    @Test
    @DisplayName("Empty Credentials Test")
    public void emptyLoginField() {
        this.utils.login("", "");
        WebElement loginErrorMessage = this.utils.waitUntilElementFound(By.id("usernameerror"));
        Assertions.assertEquals("Sorry, your username and password are incorrect - please try again.", loginErrorMessage.getAttribute("innerText"));
    }

    @Test
    @DisplayName("Incorrect Username Test")
    public void incorrectUsername() {
        this.utils.login("randomusername", "randompassword");
        WebElement loginErrorMessage = this.utils.waitUntilElementFound(By.id("usernameerror"));
        Assertions.assertEquals("Sorry, your username and password are incorrect - please try again.", loginErrorMessage.getAttribute("innerText"));
    }

    @Test
    @DisplayName("Incorrect Password Test")
    public void incorrectPassword() throws InterruptedException {
        this.utils.login("automation43", "randompassword");
        WebElement loginErrorMessage = this.utils.waitUntilElementFound(By.id("usernameerror"));
        Assertions.assertEquals("Sorry, your username and password are incorrect - please try again.", loginErrorMessage.getAttribute("innerText"));
        this.utils.loginLogout();
    }
}
