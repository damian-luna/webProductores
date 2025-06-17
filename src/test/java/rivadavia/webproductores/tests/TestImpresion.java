package rivadavia.webproductores.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import rivadavia.webproductores.base.DriverManager;
import rivadavia.webproductores.base.LoginPage;
import rivadavia.webproductores.locators.ImpresionLocators;
import rivadavia.webproductores.utils.SeleniumUtils;

public class TestImpresion {

    private static WebDriver driver;
    private static SeleniumUtils utils;
    private static LoginPage login;
    private static ImpresionLocators locators;

    @BeforeClass
    public static void setUp() {
        driver = DriverManager.getDriver();
        utils = new SeleniumUtils(driver);
        utils.esperaImplicita(10);
        login = new LoginPage(driver);
        locators = new ImpresionLocators();

        driver.get("http://php8.productores.testing.sr.intra.net/sistemas/login/login_intra.php?u=P");
        login.escribirUsuario("testing");
        login.escribirCuit("30500050310");
        login.escribirPassword("test28");
        login.clickAceptar();

        utils.esperarVisible(By.xpath("//input[@name='PROD_P']"), 20);
        utils.capturarPantalla("login_ok");
        utils.click(By.xpath("//input[@name='Aceptar']"));

        utils.esperarVisible(By.xpath("//body//div//div//div//input[@value='Aceptar']"), 10);
        utils.click(By.xpath("//body//div//div//div//input[@value='Aceptar']"));
    }

    @Test(groups = {"smoke"})
    public void testCertificadoCooperativa() throws InterruptedException {
        

        utils.hoverSobre(locators.menuImprimir);
        utils.esperarVisible(locators.opcionCertificadoCooperativa, 10);
        utils.capturarPantalla("menu_imprimir");

        utils.click(locators.opcionCertificadoCooperativa);
        utils.escribir(locators.inputPatente, "AA939QW");
        utils.capturarPantalla("busqueda_patente");

        utils.click(locators.btnImprimirCertificado);

        utils.capturarYPdfCerrarVolver("certif_ok");
        //Thread.sleep(10000);

        //utils.capturarPantalla("certif_ok");
        
    }

    @Test(groups = {"smoke"})
    public void testCopiaPoliza() throws InterruptedException {
        driver.get("http://php8.productores.testing.sr.intra.net/menu_prod.php");

        

        utils.hoverSobre(locators.menuImprimir);
        utils.esperarVisible(locators.opcionCertificadoCooperativa, 10);
        utils.capturarPantalla("menu_imprimir_copia");

        utils.click(locators.opcionCopiaPoliza);
        utils.esperarVisible(locators.desplegableRamo, 10);
        utils.seleccionarPorValue(locators.desplegableRamo, "2");

        utils.escribir(locators.inputZona, "47");
        utils.escribir(locators.inputPoliza, "18240");
        utils.capturarPantalla("busqueda_copia_poliza");

        utils.click(locators.btnAceptar);

       

        //Thread.sleep(10000);

       // utils.capturarPantalla("copia_poliza_ok");
        utils.capturarYPdfCerrarVolver("poliza_ok");
    

       
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
