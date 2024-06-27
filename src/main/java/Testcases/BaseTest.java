package Testcases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static AndroidDriver driver;
    public static AppiumDriverLocalService service;
    @BeforeClass
    public static void configureAppium() throws MalformedURLException {
        service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\shara\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).withArgument(GeneralServerFlag.BASEPATH,"/wd/hub").build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setCapability("app","C:\\Users\\shara\\IdeaProjects\\untitled2\\src\\main\\APP\\General-Store.apk");
        options.setCapability("platformName","Android");
        options.setCapability("deviceName","Sharath");
        //options.setCapability("appPackage","APPL????");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),options);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
        service.stop();
    }
}
