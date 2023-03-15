package com.deque.assignment.pages;

import com.deque.assignment.locator.DequeHomeLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DequeHomePage extends BasePage{

        public DequeHomePage(WebDriver driver) {
                super(driver);
                waitForPageToLoad();
        }

        public boolean isMainNavLoaded(){
                WebElement element = getElement(DequeHomeLocator.MAIN_NAV);
                return element.isDisplayed();
        }

        public int getRadioButtonInAdventureWidget(){
                List<WebElement> elements = getElements(DequeHomeLocator.RADIO_IN_ADVENTURE);
                return elements.size();
        }

        public void clickOnAddTraveller(){
                WebElement element = getElement(DequeHomeLocator.ADD_TRAVELLER_LINK);
                clickViaJSExecutor(element);
        }

        public boolean isNewTravellerBoxIsVisible(){
                WebElement element = getElement(DequeHomeLocator.TRAVELLER_BOX);
                return isDisplayed(element);
        }

        public void clickOnArrowOnVideo(){
                WebElement element = getElement(DequeHomeLocator.VIDEO_ICON);
                click(element);
        }

        public void scrollToVideo(){
                WebElement element = getElement(DequeHomeLocator.VIDEO_ICON);
                scrollToElement(element);
        }

        public String getVideoTitle(){
                WebElement element = getElement(DequeHomeLocator.VIDEO_TITLE);
                return getText(element);
        }
}
