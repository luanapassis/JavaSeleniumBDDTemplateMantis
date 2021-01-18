package com.javaCucumber.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Browsers {

    private static String downloadPath = "download.defaul.path";
    private static String seleniumHub = "";

    public static WebDriver getLocalChrome(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("no-sandbox");
        chromeOptions.addArguments("--allow-running-insecure-content");
        chromeOptions.addArguments("--lang=pt-BR");
        chromeOptions.addArguments("download.default_directory", downloadPath);
        return new ChromeDriver(chromeOptions);
    }

    public static WebDriver getRemoteChrome(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("no-sandbox");
        chromeOptions.addArguments("--allow-running-insecure-content");
        chromeOptions.addArguments("--lang=pt-BR");
        chromeOptions.addArguments("download.default_directory", downloadPath);

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        URL url = null;
        try {
            url = new URL(seleniumHub);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return new RemoteWebDriver(url, capabilities);
    }

    public static WebDriver getLocalChromeHeadless(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("download.default_directory", downloadPath);
        chromeOptions.addArguments("--headless");

        return new ChromeDriver(chromeOptions);
    }

    public static WebDriver getRemoteChromeHeadless(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("download.default_directory", downloadPath);
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--lang=pt-BR");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("window-size=1280,800");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        URL url = null;
        try {
            url = new URL(seleniumHub);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return new RemoteWebDriver(url, capabilities);
    }

    public static WebDriver getLocalFirefox(){
        return new FirefoxDriver();
    }

    public static WebDriver getRemoteFirefox(){
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();

        URL url = null;
        try {
            url = new URL(seleniumHub);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return new RemoteWebDriver(url, capabilities);
    }

    public static WebDriver getLocalInternetExplorer(){
        return new InternetExplorerDriver();
    }

    public static WebDriver getRemoteInternetExplorer(){
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

        URL url = null;
        try {
            url = new URL(seleniumHub);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return new RemoteWebDriver(url, capabilities);
    }
}

