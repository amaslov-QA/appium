package ru.netology.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.netology.pages.MainActivityPage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ActivityTest {
    private AppiumDriver driver;

    @BeforeAll
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appium:deviceName", "Pixel 4a API 30");
        desiredCapabilities.setCapability("appium:app", "C:\\Studies\\QAmid\\Mobil_testing\\mqa-homeworks-main\\mqa-homeworks-main\\2.2 UI Automator\\sample\\app\\build\\outputs\\apk\\release\\app-release-unsigned.apk");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AppiumDriver(remoteUrl, desiredCapabilities);
    }


    @Test
    public void dontSetEmptyString() {
        MainActivityPage page = new MainActivityPage(driver);
        page.userInput.sendKeys(" ");
        page.buttonChange.click();
        Assertions.assertEquals("Hello UiAutomator!", page.textToBeChanged.getText());

    }

    @Test
    public void activityTest() {
        MainActivityPage page = new MainActivityPage(driver);
        page.userInput.sendKeys("test");
        page.buttonActivity.click();
        Assertions.assertEquals("test", page.activityText.getText());

    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}




