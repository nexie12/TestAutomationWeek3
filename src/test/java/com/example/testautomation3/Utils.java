//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.testautomation3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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

    /*public void login() {
        this.login(TestData.USERNAME,TestData.PASSWORD);
    }*/

    public void login() {
        this.login(Utils.readCsv("SuccessfulLoginData.csv").get(0)[0],Utils.readCsv("SuccessfulLoginData.csv").get(0)[1]);
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

    public static List<String[]> readCsv(String csvFilePath) {
        BufferedReader csvReader = null;
        List<String[]> data = new ArrayList<>();

        try {
            var url = Utils.class.getClassLoader().getResource(csvFilePath);
            csvReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String row;

            while ((row = csvReader.readLine()) != null) {
                String[] rowData = row.split(",");

                String username = rowData[0];
                String password = rowData[1];
                System.out.println(username);
                System.out.println(password);

                data.add(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (csvReader != null) {
                try {
                    csvReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }
}
