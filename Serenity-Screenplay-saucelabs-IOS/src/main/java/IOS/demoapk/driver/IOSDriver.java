package IOS.demoapk.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSDriver {
    public static io.appium.java_client.ios.IOSDriver<IOSElement> driver;

    public IOSDriver() {

    }

    public static IOSDriver configureDriver() throws MalformedURLException {

        try {
            MutableCapabilities caps = new MutableCapabilities();
            caps.setCapability("platformName","iOS");
            caps.setCapability("appium:deviceName","iPhone.*");
            caps.setCapability("appium:deviceOrientation", "portrait");
            caps.setCapability("appium:automationName", "XCUITest");
            caps.setCapability("appium:app", "storage:filename=sauceDemo.ipa");
            MutableCapabilities sauceOptions = new MutableCapabilities();
            sauceOptions.setCapability("build", "appium-build-OP7YL");
            sauceOptions.setCapability("name", "your test name");
            caps.setCapability("sauce:options", sauceOptions);

            URL url = new URL("https://oauth-efsolora-240a4:cf284a50-2259-4fde-8bee-92dde8eb9ee0@ondemand.us-west-1.saucelabs.com:443/wd/hub");
            driver =  new io.appium.java_client.ios.IOSDriver<IOSElement>(url, caps);

        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        return new IOSDriver();
    }

    public io.appium.java_client.ios.IOSDriver<IOSElement> start(){
        return driver;
    }

}
