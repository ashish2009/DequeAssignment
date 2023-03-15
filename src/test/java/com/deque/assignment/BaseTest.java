package com.deque.assignment;

import com.deque.assignment.pages.DequeHomePage;
import com.deque.assignment.utility.DriverManager;
import com.deque.assignment.utility.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Map;

public class BaseTest {

        protected DequeHomePage dequeHomePage;
        protected WebDriver driver;


        @BeforeClass
        public void setup() throws IOException {
                PropertyReader propertyReader = PropertyReader.getInstance();
                Map<String, String> propertyMap = propertyReader.getProperties();
                driver = DriverManager.getDesktopDriver();
                driver.get(propertyMap.get("url"));
                dequeHomePage = new DequeHomePage(driver);
        }

        @AfterClass
        public void cleanUp(){
                driver.quit();
        }
}
