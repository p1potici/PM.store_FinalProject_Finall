package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }



    protected void clickElement(By selector) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selector));
        element.click();
    }

    protected void enterText(By selector, String text) {
        WebElement element = wait.<WebElement>until(ExpectedConditions.visibilityOfElementLocated(selector));
        element.clear();
        element.sendKeys(text);
    }

    protected void selectDropdownByVisibleText(By selector, String visibleText) {
        WebElement element = driver.findElement(selector);
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(visibleText);
    }

    public void waitFor(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Interrupted during wait.");
        }
    }
    public void goTo() {
        driver.get("https://www.pmstore.ro/");
    }
}
