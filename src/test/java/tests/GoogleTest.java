package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.DrbgParameters;
import java.util.ArrayList;
import java.util.HashMap;

import static com.codeborne.selenide.Selenide.open;
import static javax.swing.UIManager.put;

public class GoogleTest {
    @BeforeAll
    static void beForeAll() throws MalformedURLException {
//        Configuration.holdBrowserOpen = true;
//        Configuration.browserSize = "1920x1080";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "100.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test badge...");

            /* How to set session timeout */
            put("sessionTimeout", "15m");

            /* How to set timezone */
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});

            /* How to add "trash" button */
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});

            /* How to enable video recording */
            put("enableVideo", true);
        }});
        RemoteWebDriver driver = new RemoteWebDriver(new URL("https://selenoid.autotests.cloud/wd/hub"), options);

    }

    @Test
    void openGoogle(){
        open("https://www.google.ru/?hl=ru");
        System.out.println("ПРив");
    }
}
