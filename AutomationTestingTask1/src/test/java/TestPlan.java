import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestPlan {
  private static final WebDriver driver = new ChromeDriver();

  @BeforeSuite
  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
  }

  @Test
  public static void xmAutomationTest() throws InterruptedException {
    driver.get(Utils.BASE_URL);
    driver.manage().window().maximize();

    Assert.assertEquals(driver.getTitle(), Utils.BASE_URL_TITLE);

    MainPage mainPage = new MainPage(driver);
    mainPage.clickAcceptCookiesButton();

    Assert.assertTrue(mainPage.researchAndEducationButtonIsDisplayed());
    mainPage.clickResearchAndEducationButton();

    Assert.assertTrue(mainPage.economicCalendarButtonIsDisplayed());
    mainPage.clickEconomicCalendarButton();

    EconomicCalendarPage economicCalendar = new EconomicCalendarPage(driver);

    economicCalendar.switchToEconomicCalendarIFrame();

    economicCalendar.clickYesterdayButton();
    Assert.assertTrue(economicCalendar.checkIfYesterdayDateIsCorrect());
    economicCalendar.clickTodayButton();
    Assert.assertTrue(economicCalendar.checkIfTodayDateIsCorrect());
    economicCalendar.clickTomorrowButton();
    Assert.assertTrue(economicCalendar.checkIfTomorrowDateIsCorrect());
    economicCalendar.clickThisWeekButton();

    economicCalendar.switchToDefaultContent();

    Assert.assertTrue(economicCalendar.hereButtonIsDisplayed());
    economicCalendar.clickHereButton();

    RiskWarningPage riskWarningPage = new RiskWarningPage(driver);

    Assert.assertTrue(riskWarningPage.hereButtonIsDisplayed());
    riskWarningPage.clickHereButton();

    riskWarningPage.switchToNewTab();
    Assert.assertEquals(driver.getCurrentUrl(), Utils.NEW_TAB_URL);
  }

  @AfterSuite
  public static void cleanUp(){
    driver.manage().deleteAllCookies();
    driver.close();
    driver.quit();
  }
}