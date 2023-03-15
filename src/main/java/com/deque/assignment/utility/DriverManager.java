package com.deque.assignment.utility;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.util.concurrent.TimeUnit;

public class DriverManager {

        private static final long scriptExecTimeout = System.getProperty("scriptExecTimeout") != null ? Long.parseLong(System.getProperty("scriptExecTimeout")) : 3000;
        private static final String browser = System.getProperty("browser") != null ? System.getProperty("browser") : "chrome";
        private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

        public static WebDriver getDesktopDriver() {
                WebDriver driver = null;
                if (drivers.get() == null) {
                        switch (browser) {
                                case "chrome":
                                        WebDriverManager.chromedriver().setup();
                                        driver = new ChromeDriver();
                                        break;
                                case "mozilla":
                                        WebDriverManager.firefoxdriver().setup();
                                        driver = new FirefoxDriver();
                                        break;
                                case "safari":
                                        DriverManagerType safari = DriverManagerType.SAFARI;
                                        WebDriverManager.getInstance(safari).setup();
                                        driver = new SafariDriver();
                                        break;
                        }
                }

                driver.manage().window().maximize();
                driver.manage().timeouts().setScriptTimeout(scriptExecTimeout, TimeUnit.MILLISECONDS);
                drivers.set(driver);
                return drivers.get();
        }

        public static void main(String[] args) {





        }


}
