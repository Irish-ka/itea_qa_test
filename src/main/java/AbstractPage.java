import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * An abstract page for Page Objects.
 */
public class AbstractPage {

        protected static WebDriver driver = new FirefoxDriver();


        public AbstractPage() {
        }

        public void implicitWaitForElement(WebElement element) {
            WebDriverWait implicitWaitTime = new WebDriverWait(driver, 20);
            implicitWaitTime.until(ExpectedConditions.elementToBeClickable(element));
        }

    public void implicitWaitForListOfElement(List<WebElement> element) {
        WebDriverWait implicitWaitTime = new WebDriverWait(driver, 20);
        implicitWaitTime.until(ExpectedConditions.elementToBeClickable((WebElement) element));
    }
    }


