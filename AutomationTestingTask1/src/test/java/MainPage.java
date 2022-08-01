import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends PageObject{
  @FindBy(xpath = "//*[@id=\"cookieModal\"]/div/div/div[1]/div[3]/div[2]/div[3]/button")
  private WebElement accept_cookies;
  @FindBy(xpath = "//*[@id=\"main-nav\"]/li[4]")
  private WebElement research_and_education;

  @FindBy(xpath = "//*[@id=\"main-nav\"]/li[4]/div/div/div[3]/div[1]/ul/li[6]/a")
  private WebElement economic_calendar;


  public MainPage(WebDriver driver) {
    super(driver);
  }

  public void clickAcceptCookiesButton(){
    accept_cookies.click();
  }

  public void clickResearchAndEducationButton(){
    research_and_education.click();
  }

    public void clickEconomicCalendarButton(){
    economic_calendar.click();
  }

  public boolean researchAndEducationButtonIsDisplayed(){
    return research_and_education.isDisplayed();
  }

  public boolean economicCalendarButtonIsDisplayed(){
    return economic_calendar.isDisplayed();
  }

}
