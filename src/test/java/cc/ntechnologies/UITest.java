package cc.ntechnologies;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.assertTrue;


public class UITest {

    private static final String BASE_URL = "http://localhost:8080";
    private WebDriver driver = new HtmlUnitDriver();

//    @Test
    public void addAndRemoveUserSucceeds() throws Exception {
        driver.get(BASE_URL);
        deleteAllSpeakers();
        createSpeaker();
        checkSpeakerExists();
        removeSpeaker();
    }

    private void deleteAllSpeakers() {
        listSpeakers();
        driver.findElement(By.id("listSpeakersForm:removeAllButton")).click();
    }


    private void removeSpeaker() {
        listSpeakers();
        driver.findElement(By.id("listSpeakersForm")).click();
    }

    private void createSpeaker() {
        driver.findElement(By.linkText("New speaker")).click();
        assertTrue(driver.getPageSource().contains("New speaker"));
        driver.findElement(By.id("speakerForm:firstname")).sendKeys("John");
        driver.findElement(By.id("speakerForm:lastname")).sendKeys("Smith");
        driver.findElement(By.id("speakerForm:description")).sendKeys("Something described here");
        driver.findElement(By.id("speakerForm:createSpeaker")).click();
    }

    private void checkSpeakerExists() {
        listSpeakers();
        assertTrue(driver.getPageSource().contains("John"));
    }

    private void listSpeakers() {
        driver.findElement(By.linkText("Manage speakers")).click();
    }
}