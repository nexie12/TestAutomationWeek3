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

public class BrowseProject {
    private final WebDriver driver = new ChromeDriver();
    Utils utils;

    public BrowseProject() {
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
    @DisplayName("Browse MTP Project")
    public void browseProject() {
        this.utils.login();
        WebElement projectKey = this.fetchProjectKey("https://jira-auto.codecool.metastage.net/projects/MTP/summary");
        Assertions.assertEquals("MTP", projectKey.getAttribute("innerText"));
        this.utils.logout();
    }

    @Test
    @DisplayName("Browse Toucan Project")
    public void toucanProject() {
        this.utils.login();
        WebElement projectKey = this.fetchProjectKey("https://jira-auto.codecool.metastage.net/projects/TOUCAN/summary");
        Assertions.assertEquals("TOUCAN", projectKey.getAttribute("innerText"));
        this.utils.logout();
    }

    @Test
    @DisplayName("Browse Coala Project")
    public void coalaProject() {
        this.utils.login();
        WebElement projectKey = this.fetchProjectKey("https://jira-auto.codecool.metastage.net/projects/COALA/summary");
        Assertions.assertEquals("COALA", projectKey.getAttribute("innerText"));
        this.utils.logout();
    }

    @Test
    @DisplayName("Browse Jeti Project")
    public void jetiProject() {
        this.utils.login();
        WebElement projectKey = this.fetchProjectKey("https://jira-auto.codecool.metastage.net/projects/JETI/summary");
        Assertions.assertEquals("JETI", projectKey.getAttribute("innerText"));
        this.utils.logout();
    }

    private WebElement fetchProjectKey(String url) {
        this.utils.waitUntilElementFound(By.id("header-details-user-fullname"));
        this.driver.get(url);
        return this.utils.waitUntilElementFound(By.cssSelector("#summary-body > div > div.aui-item.project-meta-column > dl > dd:nth-child(4)"));
    }
}
