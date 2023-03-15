package com.deque.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.function.Function;

public class BasePage {

        WebDriver driver = null;
        final int explicitWaitTimeout = 40;

        public BasePage(WebDriver driver) {
                this.driver = driver;
        }

        public void waitForPageToLoad(){
                new WebDriverWait(driver, 120).until(
                        webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        }

        public void waitForAnElementToBeVisible(WebElement element)
        {
                WebDriverWait wait=new WebDriverWait(driver, explicitWaitTimeout);
                wait.until((Function<? super WebDriver, WebElement>) ExpectedConditions.visibilityOf(element));
        }

        public void click(WebElement element){
                waitForAnElementToBeVisible(element);
                element.click();
        }

        public void clickViaJSExecutor(WebElement element) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].click()",element);
        }

        public String getText(WebElement element){
                waitForAnElementToBeVisible(element);
                return element.getText();
        }

        public boolean isDisplayed(WebElement element){
                waitForAnElementToBeVisible(element);
                return element.isDisplayed();
        }

        public WebElement getElement(By by){
                return driver.findElement(by);
        }

        public List<WebElement> getElements(By by){
                return driver.findElements(by);
        }

        public void scrollToElement(WebElement element)
        {
                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].scrollIntoView(true);", element);

        }

        public void executeJs(String script)
        {
                ((JavascriptExecutor) driver)
                        .executeScript(script);

        }
}
