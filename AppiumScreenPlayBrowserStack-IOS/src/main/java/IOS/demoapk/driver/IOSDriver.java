package IOS.demoapk.driver;

import io.appium.java_client.ios.IOSElement;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSDriver {
    public static io.appium.java_client.ios.IOSDriver<IOSElement> driver;

    public IOSDriver() throws MalformedURLException {
    }

    public static IOSDriver configureDriver() throws MalformedURLException {

        Dotenv dotenv = Dotenv.configure().load();

        String browserstackUser = dotenv.get("BROWSERSTACK_USER");
        String browserstackKey = dotenv.get("BROWSERSTACK_KEY");

        try {
            DesiredCapabilities caps = new DesiredCapabilities();

            // Set your access credentials
            caps.setCapability("browserstack.user", browserstackUser);
            caps.setCapability("browserstack.key", browserstackKey);

            caps.setCapability("app", "bs://c9d984ed7985ff46c77aa0085fa9dcd7397e12d2");

            // Specify device and os_version for testing
            caps.setCapability("device", "iPhone 13");
            caps.setCapability("os_version", "15");

            // Set other BrowserStack capabilities
            caps.setCapability("project", "IOSDemo");
            caps.setCapability("build", "IOS SauceLab build 2");
            caps.setCapability("name", "Login test IOS");

            driver =  new io.appium.java_client.ios.IOSDriver<IOSElement>(new URL("http://hub-cloud.browserstack.com/wd/hub"), caps);

        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        return new IOSDriver();
    }

    public io.appium.java_client.ios.IOSDriver<IOSElement> start(){
        return driver;
    }

}
