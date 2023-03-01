package com.example.testautomation3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateIssue {

    private final WebDriver driver = new ChromeDriver();
    Utils utils = new Utils(driver);

    @BeforeEach
    public void setUp() {
        driver.get("https://jira-auto.codecool.metastage.net/");
        utils.login();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void EmptyRequiredField(){

        driver.findElement(By.xpath("//a[@id='create_link']")).click();
        utils.waitUntilElementFound(By.xpath("//input[@id='create-issue-submit']")).click();

        String expectinfError = "You must specify a summary of the issue.";
        assertEquals(expectinfError,driver.findElement(By.className("error")).getAttribute("innerText"));
    }

    @Test
    public void cancelCreation(){

        driver.findElement(By.xpath("//a[@id='create_link']")).click();

        WebElement projectDropdown = utils.waitUntilElementFound(By.xpath("//div[@id='project-options']"));

    }
}
