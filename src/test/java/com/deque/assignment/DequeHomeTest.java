package com.deque.assignment;


import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DequeHomeTest extends BaseTest{

        @Test
        public void testMyWebPage() {
                AxeBuilder axeBuilder = new AxeBuilder();
                Results axeResults = null;

                try {
                        axeResults = axeBuilder.analyze(driver);
                        List<Rule> rules = axeResults.getViolations();
                        System.out.println("Size of violations: "+rules.size());
                        rules.forEach(r-> System.out.println(r.getDescription()));
                        Assert.assertTrue(rules.size()==13);
                } catch (RuntimeException e) {
                }


        }


        @Test
        public void verifyHomePageContent(){
                Assert.assertTrue(dequeHomePage.isMainNavLoaded(),"Main nav is not loaded properly");
                Assert.assertEquals(dequeHomePage.getRadioButtonInAdventureWidget(),5,"Number of radio button not matched");
        }

        @Test
        public void verifyTravellerGetAdded(){
                dequeHomePage.clickOnAddTraveller();
                Assert.assertTrue(dequeHomePage.isNewTravellerBoxIsVisible(),"New traveller select not added");
        }

        @Test
        public void verifyTitleOnVideo(){
                dequeHomePage.scrollToVideo();
                Assert.assertTrue(dequeHomePage.getVideoTitle().contains("Life was possible on Mars"),"Initial text not shown on video");
                dequeHomePage.clickOnArrowOnVideo();
                Assert.assertTrue(dequeHomePage.getVideoTitle().contains("Why Mars died"),"New text not shown on video");
        }
}
