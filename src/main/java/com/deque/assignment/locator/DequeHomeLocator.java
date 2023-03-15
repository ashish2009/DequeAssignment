package com.deque.assignment.locator;

import org.openqa.selenium.By;

public class DequeHomeLocator {
        public static By MAIN_NAV = By.cssSelector("#main-nav");
        public static By RADIO_IN_ADVENTURE = By.xpath("//div[h3[text()='Let the Adventure Begin!']]//input[@type='radio']");
        public static By ADD_TRAVELLER_LINK = By.xpath("//div[@id='add-traveler']/a");
        public static By TRAVELLER_BOX = By.id("traveler1");
        public static By VIDEO_ICON = By.xpath("//i[@class='vid-next icon-video-right-arrow']");
        public static By VIDEO_TITLE = By.id("video-text");

}
