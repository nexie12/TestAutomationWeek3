//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.testautomation3;

public final class TestData {
    public static final String USERNAME = Utils.readCsv("SuccessfulLoginData.csv").get(0)[0];
    public static final String FALSE_USERNAME = Utils.readCsv("FalseLoginData.csv").get(0)[0];
    public static final String PASSWORD = Utils.readCsv("SuccessfulLoginData.csv").get(0)[1];
    public static final String FALSE_PASSWORD = Utils.readCsv("FalseLoginData.csv").get(0)[1];
    public static final String EXPECTED_LOGIN_ERROR_MESSAGE = "Sorry, your username and password are incorrect - please try again.";
    public static final String MTP_KEY = "MTP";
    public static final String TOUCAN_KEY = "TOUCAN";
    public static final String COALA_KEY = "COALA";
    public static final String JETI_KEY = "JETI";

    public TestData() {
    }
}
