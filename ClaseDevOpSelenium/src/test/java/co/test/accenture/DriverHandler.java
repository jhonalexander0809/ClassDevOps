package co.test.accenture;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 *
 * @author diego.tapia
 */
public class DriverHandler implements WebDriver {

    private String url_Hub;
    private WebDriver driver;
    private Browser browser;
    private BrowserType browserType;
    private DesiredCapabilities desireCapability;

    public void setUPDriverHandler() {
        switch (browserType) {
            case HUB:
                setUpRemote();
                break;
            case LOCAL:
                setUpLocal();
                break;
        }
        this.driver.manage().window().maximize();
    }

    private void setUpRemote() {
        switch (browser) {
            case FIREFOX:
                desireCapability = DesiredCapabilities.firefox();
                break;
            case CHROME:
                desireCapability = DesiredCapabilities.chrome();
                break;
            case IE:
                desireCapability = DesiredCapabilities.internetExplorer();
                break;
            default:
                desireCapability = DesiredCapabilities.firefox();
                break;
        }
        desireCapability.setPlatform(Platform.WINDOWS);
        try {
            this.driver = new RemoteWebDriver(new URL(this.getUrl_Hub()), desireCapability);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void setUpLocal() {
        try {
            switch (browser) {
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", "C:\\drivers\\firefox\\firefoxdriver_win64\\geckodriver.exe");
                    this.driver = new FirefoxDriver();
                    break;
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chrome\\chromedriver_win32\\chromedriver.exe");
                    this.driver = new ChromeDriver();
                    break;
                case IE:
                    System.setProperty("webdriver.ie.driver", "C:\\drivers\\iexplorer\\iexplorerdriver_win64\\IEDriverServer.exe");
                    this.driver = new InternetExplorerDriver();
                    break;
                default:
                    System.setProperty("webdriver.gecko.driver", "C:\\drivers\\firefox\\firefoxdriver_win64\\geckodriver.exe");
                    this.driver = new FirefoxDriver();
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void get(String url) {
        this.driver.get(url);
    }

    @Override
    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return this.driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return this.driver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return this.driver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return this.driver.getPageSource();
    }

    @Override
    public void close() {
        if (this.getDriver() != null) {
            this.getDriver().close();
        }
    }

    @Override
    public void quit() {
        this.getDriver().quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return this.driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return this.driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return this.driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return this.driver.navigate();
    }

    @Override
    public Options manage() {
        return this.driver.manage();
    }

    public String getUrl_Hub() {
        return url_Hub;
    }

    public void setUrl_Hub(String url_Hub) {
        this.url_Hub = url_Hub;
    }

    public Browser getBrowser() {
        return browser;
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }

    public BrowserType getBrowserType() {
        return browserType;
    }

    public void setBrowserType(BrowserType browserType) {
        this.browserType = browserType;
    }

    public WebDriver getDriver() {
        return driver;
    }
}