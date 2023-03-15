package org.wikipedia.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.wikipedia.config.PROP;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;


public class LocalAndroidDriver implements WebDriverProvider {
    static PROP Prop = ConfigFactory.create(PROP.class);
    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName("Android")
                .setPlatformVersion(Prop.getAndroidversion())
                .setDeviceName(Prop.getAndroidDevice())
                .setApp(new File(Prop.getAndroidAppPath()).getAbsolutePath())
                .setAppPackage(Prop.getAndroidAppPackage())
                .setAppActivity(Prop.getAndroidAppActivity());

        try {
            return new AndroidDriver(new URL(Prop.getUrl()), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
