package co.test.accenture;

import com.relevantcodes.extentreports.ExtentReports;
import java.io.File;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author diego.tapia
 */
public class MainTest {

    protected DriverHandler driver;
    protected ExtentReports report;
    protected File folderReport;
    protected static final String FOLDER_REPORT = "C:\\ReportClassDevOps";
    protected static final String BASE_URL = "http://www.bolivariano.com.co/";

    public MainTest() {
    }

    @Test
    public void hello() {
        
        try {
            // Init TestCase Bolivariano
            TestCaseBolivariano ts = new TestCaseBolivariano(this);

            //LoadURL
            this.driver.get(BASE_URL);

            //1) Cargar MainPage
            ts.cargarMainPage();

            Thread.sleep(3000);

            //2) Llenar Formulario
            ts.llenarFormulario();

            Thread.sleep(3000);

            //3) Seleccion Viaje
            ts.seleccionViaje();

            Thread.sleep(3000);

            //4) Seleccion Silla
            ts.seleccionSilla();
        }  catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }           
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        // Init Driver
        initDriver();
        // Init Report
        initReport();
    }

    private void initDriver() {
        this.driver = new DriverHandler();
        this.driver.setUrl_Hub("http://localhost:4444/wd/hub");
        this.driver.setBrowser(Browser.CHROME);
        this.driver.setBrowserType(BrowserType.LOCAL);
        this.driver.setUPDriverHandler();
    }

    private void initReport() {
        this.folderReport = new File(FOLDER_REPORT + "\\Images\\");

        if (!this.folderReport.exists()) {
            this.folderReport.mkdir();
            this.folderReport.mkdirs();
        }

        report = new ExtentReports(FOLDER_REPORT + "\\Report.html", true);
        report.addSystemInfo("Host", System.getProperty("os.name")).addSystemInfo("Environment", "Development");
        report.loadConfig(new File("src/test/resources/config-report.xml"));
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {

        if (this.driver != null) {
            //this.driver.quit();
            //this.driver.close();
        }
        report.flush();
        report.close();
    }

    public DriverHandler getDriver() {
        return driver;
    }

    public void setDriver(DriverHandler driver) {
        this.driver = driver;
    }

    public ExtentReports getReport() {
        return report;
    }

    public void setReport(ExtentReports report) {
        this.report = report;
    }

    public File getFolderReport() {
        return folderReport;
    }

    public void setFolderReport(File folderReport) {
        this.folderReport = folderReport;
    }
}