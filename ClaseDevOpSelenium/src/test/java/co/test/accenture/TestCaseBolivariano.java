package co.test.accenture;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 *
 * @author diego.tapia
 */
public class TestCaseBolivariano {

    private final MainTest mt;
    private final Util u;

    TestCaseBolivariano(MainTest aThis) {
        this.mt = aThis;
        this.u = new Util();
    }

    public void cargarMainPage() {

        String idElement;
        String screen = MainTest.FOLDER_REPORT + "\\Images\\MainPage.png";
        ExtentTest test = this.mt.getReport().startTest("Pagina Principal", "Cerrando el Popup");
        WebElement welcomeVideo;

        try {
            test.log(LogStatus.INFO, "Cargando Pagina Bolivariano");

            idElement = "TB_closeWindowButton";
            Assert.assertTrue(this.mt.getDriver().findElement(By.id(idElement)).isDisplayed());
            test.log(LogStatus.PASS, "se Encontro el WebElement[" + idElement + "]");
            welcomeVideo = this.mt.getDriver().findElement(By.id(idElement));

            u.saveScreenshot(this.mt.getDriver().getDriver(), screen);
            String image = test.addScreenCapture(screen);
            test.log(LogStatus.PASS, "Imagen Verificacion", image);

            Thread.sleep(3000);

            welcomeVideo.click();

            this.mt.getReport().endTest(test);

        } catch (InterruptedException | IOException e) {
            System.out.println(e.getMessage());
            test.log(LogStatus.FAIL, "Fallo al Pagina Principal - Cerrando el Popup" + " \n " + e.getMessage());
            this.mt.getReport().endTest(test);
        }
    }

    public void llenarFormulario() {

        String idElement;
        String screen = MainTest.FOLDER_REPORT + "\\Images\\LlenarForumlario.png";
        ExtentTest test = this.mt.getReport().startTest("Pagina Llenar el Formulario", "Seleccion de Origen y Destino");
        WebElement tipoViaje;
        WebElement fechaInicial;
        WebElement fechaFinal;
        WebElement consultarViaje;
        Select origen;
        Select destino;

        try {
            test.log(LogStatus.INFO, "Llenar el Formulario");

            idElement = "tipo_viaje";
            Assert.assertTrue(this.mt.getDriver().findElement(By.name(idElement)).isDisplayed());
            test.log(LogStatus.PASS, "se Encontro el WebElement[" + idElement + "]");
            tipoViaje = this.mt.getDriver().findElement(By.name(idElement));

            tipoViaje.click();

            idElement = "edit-origen";
            Assert.assertTrue(this.mt.getDriver().findElement(By.id(idElement)).isDisplayed());
            test.log(LogStatus.PASS, "se Encontro el WebElement[" + idElement + "]");
            origen = new Select(this.mt.getDriver().findElement(By.id(idElement)));

            origen.selectByIndex(1);

            idElement = "edit-destino";
            Assert.assertTrue(this.mt.getDriver().findElement(By.id(idElement)).isDisplayed());
            test.log(LogStatus.PASS, "se Encontro el WebElement[" + idElement + "]");
            destino = new Select(this.mt.getDriver().findElement(By.id(idElement)));

            destino.selectByIndex(2);

            idElement = "edit-fecha-salida";
            Assert.assertTrue(this.mt.getDriver().findElement(By.id(idElement)).isDisplayed());
            test.log(LogStatus.PASS, "se Encontro el WebElement[" + idElement + "]");
            fechaInicial = this.mt.getDriver().findElement(By.id(idElement));

            fechaInicial.sendKeys("27/09/2017");

            WebElement dateWidget = this.mt.getDriver().findElement(By.id(idElement));
            List<WebElement> columns = dateWidget.findElements(By.tagName("td"));

            System.out.println("size Columns: " + columns.size());
            
//            for (WebElement cell : columns) {
//                if (cell.getText().equals("27")) {
//                    cell.findElement(By.linkText("27")).click();
//                    break;
//                }
//            }

            idElement = "edit-fecha-regreso";
            Assert.assertTrue(this.mt.getDriver().findElement(By.id(idElement)).isDisplayed());
            test.log(LogStatus.PASS, "se Encontro el WebElement[" + idElement + "]");
            fechaFinal = this.mt.getDriver().findElement(By.id(idElement));

            fechaFinal.sendKeys("30/10/2017");

            idElement = "consultar_viajes";
            Assert.assertTrue(this.mt.getDriver().findElement(By.id(idElement)).isDisplayed());
            test.log(LogStatus.PASS, "se Encontro el WebElement[" + idElement + "]");
            consultarViaje = this.mt.getDriver().findElement(By.id(idElement));

            u.saveScreenshot(this.mt.getDriver().getDriver(), screen);
            String image = test.addScreenCapture(screen);
            test.log(LogStatus.PASS, "Imagen Verificacion", image);

            Thread.sleep(3000);

            consultarViaje.click();

            this.mt.getReport().endTest(test);

        } catch (InterruptedException | IOException e) {
            System.out.println(e.getMessage());
            test.log(LogStatus.FAIL, "Fallo al Llenar el Formulario" + " \n " + e.getMessage());
            this.mt.getReport().endTest(test);
        }
    }

    public void seleccionViaje() {

        int temp;
        String idElement;
        String screen = MainTest.FOLDER_REPORT + "\\Images\\SeleccionViaje.png";
        ExtentTest test = this.mt.getReport().startTest("Pagina Seleccionar Tipo Viaje", "Seleccion de Viaje Origen y Destino");
        WebElement rbIda;
        WebElement rbVuelta;
        WebElement generarSilla;
        List<WebElement> listaViajeIda;
        List<WebElement> listaViajeRegreso;

        try {
            test.log(LogStatus.INFO, "Seleccionar Viaje");

            idElement = "div[contains(@id, 'tabla-ida')]//input[contains(@type, 'radio')]";
            Assert.assertTrue(this.mt.getDriver().findElement(By.xpath(idElement)).isDisplayed());
            test.log(LogStatus.PASS, "se Encontro el WebElement[" + idElement + "]");
            listaViajeIda = this.mt.getDriver().findElements(By.xpath(idElement));

            temp = ((int) (Math.random() * (listaViajeIda.size() - 0))) + 0;
            rbIda = listaViajeIda.get(temp);
            rbIda.click();

            idElement = "div[contains(@id, 'tabla-regreso')]//input[contains(@type, 'radio')]";
            Assert.assertTrue(this.mt.getDriver().findElement(By.xpath(idElement)).isDisplayed());
            test.log(LogStatus.PASS, "se Encontro el WebElement[" + idElement + "]");
            listaViajeRegreso = this.mt.getDriver().findElements(By.xpath(idElement));

            temp = ((int) (Math.random() * (listaViajeRegreso.size() - 0))) + 0;
            rbVuelta = listaViajeRegreso.get(temp);
            rbVuelta.click();

            idElement = "generar_sillas";
            Assert.assertTrue(this.mt.getDriver().findElement(By.id(idElement)).isDisplayed());
            test.log(LogStatus.PASS, "se Encontro el WebElement[" + idElement + "]");
            generarSilla = this.mt.getDriver().findElement(By.id(idElement));

            u.saveScreenshot(this.mt.getDriver().getDriver(), screen);
            String image = test.addScreenCapture(screen);
            test.log(LogStatus.PASS, "Imagen Verificacion", image);

            Thread.sleep(3000);

            generarSilla.click();

            this.mt.getReport().endTest(test);

        } catch (InterruptedException | IOException e) {
            System.out.println(e.getMessage());
            test.log(LogStatus.FAIL, "Fallo al Seleccionar Tipo Viaje" + " \n " + e.getMessage());
            this.mt.getReport().endTest(test);
        }
    }

    public void seleccionSilla() {

        int temp;
        String idElement;
        String screen = MainTest.FOLDER_REPORT + "\\Images\\SeleccionSilla.png";
        ExtentTest test = this.mt.getReport().startTest("Pagina Seleccionar Silla", "Seleccion de Silla para el Viaje Origen y Destino");
        WebElement rbIda;
        WebElement rbVuelta;
        WebElement rbNombreSillaIda;
        WebElement rbNombreSillaRegreso;
        WebElement generarReserva;
        List<WebElement> listaSillaIda;
        List<WebElement> listaSillaRegreso;

        try {
            test.log(LogStatus.INFO, "Seleccionar Silla");

            idElement = "//div[contains(@id, 'bus_ida')]//div[contains(@class, 'silleteria')]//div[contains(@class, 'una_columna Silla')]//div[contains(@class, 'SLibre Elemento')]";
            Assert.assertTrue(this.mt.getDriver().findElement(By.xpath(idElement)).isDisplayed());
            test.log(LogStatus.PASS, "se Encontro el WebElement[" + idElement + "]");
            listaSillaIda = this.mt.getDriver().findElements(By.xpath(idElement));

            temp = ((int) (Math.random() * (listaSillaIda.size() - 0))) + 0;
            rbIda = listaSillaIda.get(temp);
            rbIda.click();

            idElement = "//div[contains(@id, 'bus_ida')]//div[contains(@class, 'silleteria')]//div[contains(@class, 'una_columna Silla')]//div[contains(@class, 'SLibre Elemento')]";
            Assert.assertTrue(this.mt.getDriver().findElement(By.xpath(idElement)).isDisplayed());
            test.log(LogStatus.PASS, "se Encontro el WebElement[" + idElement + "]");
            listaSillaRegreso = this.mt.getDriver().findElements(By.xpath(idElement));

            temp = ((int) (Math.random() * (listaSillaRegreso.size() - 0))) + 0;
            rbVuelta = listaSillaRegreso.get(temp);
            rbVuelta.click();

            idElement = "opcion_pasajero_ida";
            Assert.assertTrue(this.mt.getDriver().findElement(By.name(idElement)).isDisplayed());
            test.log(LogStatus.PASS, "se Encontro el WebElement[" + idElement + "]");
            rbNombreSillaIda = this.mt.getDriver().findElement(By.name(idElement));

            rbNombreSillaIda.click();

            idElement = "opcion_pasajero_regreso";
            Assert.assertTrue(this.mt.getDriver().findElement(By.name(idElement)).isDisplayed());
            test.log(LogStatus.PASS, "se Encontro el WebElement[" + idElement + "]");
            rbNombreSillaRegreso = this.mt.getDriver().findElement(By.name(idElement));

            rbNombreSillaRegreso.click();

            idElement = "generar_reservas";
            Assert.assertTrue(this.mt.getDriver().findElement(By.id(idElement)).isDisplayed());
            test.log(LogStatus.PASS, "se Encontro el WebElement[" + idElement + "]");
            generarReserva = this.mt.getDriver().findElement(By.id(idElement));

            u.saveScreenshot(this.mt.getDriver().getDriver(), screen);
            String image = test.addScreenCapture(screen);
            test.log(LogStatus.PASS, "Imagen Verificacion", image);

            Thread.sleep(3000);

            generarReserva.click();

            this.mt.getReport().endTest(test);

        } catch (InterruptedException | IOException e) {
            System.out.println(e.getMessage());
            test.log(LogStatus.FAIL, "Fallo al Seleccionar Silla" + " \n " + e.getMessage());
            this.mt.getReport().endTest(test);
        }
    }
}