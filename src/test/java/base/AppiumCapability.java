package base;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class AppiumCapability {

    private static AppiumCapability appiumCapability;

        private AppiumDriver appiumDriver;

        public static AppiumCapability getAppiumDriverServiceInstance(){
            if(appiumCapability == null) {
                appiumCapability = new AppiumCapability();
            }
            return appiumCapability;
        }

        public IOSDriver initDriver(){
            String appiumServerPath = "/usr/local/bin/node_modules/appium";
            String appiumServerURLStr = "http://localhost:4723/wd/hub";

            DesiredCapabilities desiredCapabilities = setDesiredCapabilities();
            IOSDriver iosDriver = startDriver(appiumServerURLStr, desiredCapabilities);

            return iosDriver;
        }

        AppiumDriverLocalService appiumDriverLocalService;
        AppiumServiceBuilder appiumServiceBuilder;

        /**
         * Start Appium service first.
         * @param
         */
        public AppiumDriverLocalService startAppiumService(){
            appiumDriverLocalService =
                    new AppiumServiceBuilder()
                            .usingDriverExecutable(new File("/usr/local/bin/node"))
                            .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                            .withIPAddress("127.0.0.1")
                            .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                            .usingPort(4723)
                            .build();
            appiumDriverLocalService.clearOutPutStreams();
            appiumDriverLocalService.start();

            // Print the Appium server URL
            String appiumServerUrl = appiumDriverLocalService.getUrl().toString();
            System.out.println("Appium Server started: " + appiumServerUrl);
            return appiumDriverLocalService;
        }

        private IOSDriver startDriver(String serverUrlStr, DesiredCapabilities desiredCapabilities){
            URL appiumServerURL = null;
            try {
                appiumServerURL = new URL(serverUrlStr);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            assert appiumServerURL != null;
            return new IOSDriver(appiumServerURL, desiredCapabilities);
        }

        /**
         * Stop the driver before stopping Appium Service.
         * @param iosDriver
         */

        /**
         * Stop Appium Service after quiting the driver.
         * @param appiumDriverLocalService
         */
        public void stopAppiumService(AppiumDriverLocalService appiumDriverLocalService){
            if (appiumDriverLocalService.isRunning()) {
                appiumDriverLocalService.stop();
            }
        }

        private DesiredCapabilities setDesiredCapabilities(){
            // Set the desired capabilities
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("deviceName", "iphone 14");
            cap.setCapability("udid", "F55BEF6F-0CCC-4B5A-8DF2-1B6B93D9C108");
            cap.setCapability("platformName", "iOS");
            cap.setCapability("platformVersion", "16.4");
            cap.setCapability("app", "com.discorp.mobile.servicelogistics");

            return cap;
        }
    }

