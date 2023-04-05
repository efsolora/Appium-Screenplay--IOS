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
            sauceOptions.setCapability("build", "appium-build-GY757");
            sauceOptions.setCapability("name", "<your test name>");
            caps.setCapability("sauce:options", sauceOptions);
            URL url = new URL("https://oauth-crigaviria12345-ce0db:3bd1b3d8-f424-4dd3-a834-49aaa236dfe2@ondemand.us-west-1.saucelabs.com:443/wd/hub");
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
