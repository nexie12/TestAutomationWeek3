//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.testautomation3;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
    private WebDriver driver;

    public Utils(WebDriver Driver) {
        this.driver = Driver;
    }

    public void loginLogout() throws InterruptedException {
        this.login();
        this.waitUntilElementFound(By.id("header-details-user-fullname"));
        this.logout();
    }

    public void login() {
        this.login("automation43", "CCAutoTest19.");
    }

    public void login(String username, String password) {
        this.driver.findElement(By.id("login-form-username")).sendKeys(new CharSequence[]{username});
        this.driver.findElement(By.id("login-form-password")).sendKeys(new CharSequence[]{password});
        this.driver.findElement(By.id("login")).click();
    }

    public void logout() {
        this.driver.findElement(By.id("header-details-user-fullname")).click();
        this.driver.findElement(By.id("log_out")).click();
    }

    public WebElement waitUntilElementFound(By identifier) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofMillis(2000L));
        return (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(identifier));
    }
}
