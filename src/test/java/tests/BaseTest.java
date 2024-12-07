package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import utils.webUtils;

import static org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration.milliseconds;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    void setup() {
        driver = webUtils.getWebDriver(); // WebDriver
        System.out.println("WebDriver initialized.");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("WebDriver closed.");
        }
    }

    protected void waitFor() {
        try {
            Thread.sleep(milliseconds);
            System.out.println("Waited for " + milliseconds + " milliseconds.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Interrupted during wait.");
        }
    }


}
