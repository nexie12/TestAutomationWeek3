//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.testautomation3;

import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClassTemplate {
    private WebDriver driver = new ChromeDriver();
    Utils utils;

    public TestClassTemplate() {
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
}
