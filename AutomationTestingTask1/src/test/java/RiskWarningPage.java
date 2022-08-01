import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RiskWarningPage extends PageObject{

  @FindBy(xpath = "//*[@id=\"research-app\"]/div[3]/p[11]/a")
  private WebElement here;

  public RiskWarningPage(WebDriver driver) {
    super(driver);
  }

  public void scrollToHereElement() {
    Utils.scrollToElement(driver, here);
  }

  public boolean hereButtonIsDisplayed(){
    return here.isDisplayed();
  }
  public void clickHereButton() {
    scrollToHereElement();
    here.click();
  }

  public void switchToNewTab(){
      List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
      driver.switchTo().window(browserTabs.get(1));
    }

}