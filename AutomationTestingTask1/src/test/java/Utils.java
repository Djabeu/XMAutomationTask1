import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {
  final static String BASE_URL = "https://xm.com";

  final static String BASE_URL_TITLE = "Forex & CFD Trading on Stocks, Indices, Oil, Gold by XM™";

  final static String NEW_TAB_URL = "https://www.xm.com/assets/pdf/new/docs/XM-Risk-Disclosures-for-Financial-Instruments.pdf?v5";

  final static String CHROME_DRIVER_LOCATION = "chromedriver";

  public static void scrollToElement(WebDriver driver, WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
  }
}
