import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EconomicCalendarPage extends PageObject{

  @FindBy(id = "timeFrame_yesterday")
  private WebElement yesterday;

  @FindBy(id = "timeFrame_today")
  private WebElement today;

  @FindBy(id = "timeFrame_tomorrow")
  private WebElement tomorrow;

  @FindBy(id = "timeFrame_thisWeek")
  private WebElement thisWeek;

  @FindBy(id = "widgetFieldDateRange")
  private WebElement widgetFieldDateRange;

  @FindBy(xpath = "//*[@id=\"research-app\"]/div[4]/div/p[3]/a")
  private WebElement here;

  @FindBy(xpath = "//*[@id=\"top\"]/div[1]/div/div[3]/i")
  private WebElement closeTopBanner;

  @FindBy(xpath = "//*[@id=\"research-app\"]/div[3]/div/div[1]/div/div[2]/div/iframe")
  private WebElement economicCalendarIFrame;

  public EconomicCalendarPage(WebDriver driver) {
    super(driver);
  }

    private Date day(int dayDiff) {
      final Calendar cal = Calendar.getInstance();
      cal.add(Calendar.DATE, dayDiff);
      return cal.getTime();
    }

    public boolean checkIfDateIsCorrect(Date date){
      DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      String yesterdayDate = dateFormat.format(date);

      return widgetFieldDateRange.getText().contains(yesterdayDate);
    }

    public boolean checkIfYesterdayDateIsCorrect(){
      return checkIfDateIsCorrect(day(-1));
    }

    public boolean checkIfTodayDateIsCorrect(){
      return checkIfDateIsCorrect(day(0));
    }

    public boolean checkIfTomorrowDateIsCorrect(){
      return checkIfDateIsCorrect(day(1));
    }

  public void clickYesterdayButton() throws InterruptedException {
    yesterday.click();
    Thread.sleep(1000);
  }

  public void clickTodayButton() throws InterruptedException {
      today.click();
    Thread.sleep(1000);
    }

    public void clickTomorrowButton() throws InterruptedException {
      tomorrow.click();
      Thread.sleep(1000);
    }

    public void clickThisWeekButton(){
      thisWeek.click();
    }

    public void clickCloseTopBannerButton(){
      closeTopBanner.click();
    }

  public void scrollToHereElement() {
    Utils.scrollToElement(driver, here);
  }

  public boolean hereButtonIsDisplayed(){
    return here.isDisplayed();
  }

  public void clickHereButton(){
    scrollToHereElement();
    clickCloseTopBannerButton();
    here.click();
  }

  public void switchToEconomicCalendarIFrame(){
    driver.switchTo().frame(economicCalendarIFrame);
  }

  public void switchToDefaultContent(){
    driver.switchTo().defaultContent();
  }

}
