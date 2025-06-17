package rivadavia.webproductores.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import rivadavia.webproductores.base.DriverManager;
import rivadavia.webproductores.base.LoginPage;
import rivadavia.webproductores.locators.ImpresionLocators;
import rivadavia.webproductores.locators.SiniestroLocators;
import rivadavia.webproductores.utils.SeleniumUtils;

public class TestSiniestro {

    private static WebDriver driver;
    private static SeleniumUtils utils;
    private static LoginPage login;
    private static SiniestroLocators locators;

    @BeforeClass
    public static void setUp() {
        driver = DriverManager.getDriver();
        utils = new SeleniumUtils(driver);
        utils.esperaImplicita(10);
        login = new LoginPage(driver);
        locators = new SiniestroLocators();

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
    @Test
    public void completarFormularioDenuncia() throws InterruptedException {
    	 utils.hoverSobre(locators.menuAdministradorSiniestros);
         utils.esperarVisible(locators.opcionIngresoDenuncia, 10);
         utils.capturarPantalla("menu_AdministradorSiniestro");

         utils.click(locators.opcionIngresoDenuncia);
        // --- Completar póliza ---
         
        driver.findElement(SiniestroLocators.POLIZA_PRIMER_CAMPO).sendKeys("47");
        driver.findElement(SiniestroLocators.POLIZA_SEGUNDO_CAMPO).sendKeys("774140");

        // --- Completar patente ---
        driver.findElement(SiniestroLocators.PATENTE).clear();
        driver.findElement(SiniestroLocators.PATENTE).sendKeys("AD650OK");

        // --- Fecha del siniestro ---
        driver.findElement(SiniestroLocators.FECHA_SINIESTRO).sendKeys("06/05/2025");

        // --- Hora ---
        driver.findElement(SiniestroLocators.HORA_HH).sendKeys("10");
        driver.findElement(SiniestroLocators.HORA_MM).sendKeys("00");

        // --- Cobertura: solo daños al vehículo (Parcial) ---
        driver.findElement(SiniestroLocators.COB_DANIOS).click();
        driver.findElement(SiniestroLocators.COB_DANIOS).click();
        utils.esperarVisible(SiniestroLocators.COB_DANIOS_PARCIAL, 10);
        driver.findElement(SiniestroLocators.COB_DANIOS_PARCIAL).click();
        driver.findElement(SiniestroLocators.COB_DANIOS_PARCIAL).click();

        // --- Responder todas las preguntas ---
        driver.findElement(SiniestroLocators.PREG_DANIOS_TERCEROS_NO).click();
        driver.findElement(SiniestroLocators.PREG_LESIONADOS_NO).click();
        driver.findElement(SiniestroLocators.PREG_DENUNCIANTE_CONDUCTOR_NO).click();
        driver.findElement(SiniestroLocators.PREG_CONDUCTOR_ASEGURADO_SI).click();
        driver.findElement(SiniestroLocators.PREG_DENUNCIA_POLICIAL_NO).click();
        driver.findElement(SiniestroLocators.PREG_TESTIGOS_NO).click();
        driver.findElement(SiniestroLocators.PREG_DENUNCIA_OFICIO_NO).click();

        // --- Click en "Continuar" ---
        driver.findElement(SiniestroLocators.BTN_CONTINUAR).click();
        
        // Seleccionar daño en parabrisas
        driver.findElement(SiniestroLocators.DANIO_PARABRISAS).click();

        // Hacer clic en botón Aceptar
        driver.findElement(SiniestroLocators.BOTON_ACEPTAR).click();
        
         // Datos del denunciante
        driver.findElement(SiniestroLocators.NOMBRE_DENUNCIANTE).sendKeys("Juan Perez");
        new Select(driver.findElement(SiniestroLocators.SEXO_DENUNCIANTE)).selectByVisibleText("M");
        new Select(driver.findElement(SiniestroLocators.TIPO_DOC_DENUNCIANTE)).selectByVisibleText("D.N.I.");
        driver.findElement(SiniestroLocators.NUM_DOC_DENUNCIANTE).sendKeys("32165498");
        driver.findElement(SiniestroLocators.DOMICILIO_DENUNCIANTE).sendKeys("511");
        driver.findElement(SiniestroLocators.TELEFONO_DENUNCIANTE).sendKeys("2215551234");
        new Select(driver.findElement(SiniestroLocators.PAIS_DENUNCIANTE)).selectByVisibleText("Argentina");
        new Select(driver.findElement(SiniestroLocators.PROVINCIA_DENUNCIANTE)).selectByVisibleText("Bs. As.");
        driver.findElement(By.name("denunciante_cp")).clear();
        driver.findElement(SiniestroLocators.CP_DENUNCIANTE).sendKeys("1900");
        new Select(driver.findElement(SiniestroLocators.LOCALIDAD_DENUNCIANTE)).selectByVisibleText("LA PLATA");
        
        // Datos del conductor
        new Select(driver.findElement(SiniestroLocators.PROVINCIA_CONDUCTOR)).selectByVisibleText("Bs. As.");
        driver.findElement(By.name("conductor_cp")).clear();
        driver.findElement(SiniestroLocators.CP_CONDUCTOR).sendKeys("1900");
        new Select(driver.findElement(SiniestroLocators.LOCALIDAD_CONDUCTOR)).selectByVisibleText("LA PLATA");
        
        // Detalle del siniestro
        driver.findElement(SiniestroLocators.LUGAR_OCURRENCIA).sendKeys("LA PLATA");
        new Select(driver.findElement(SiniestroLocators.PAIS_DETALLE)).selectByVisibleText("Argentina");
        new Select(driver.findElement(SiniestroLocators.PROVINCIA_DETALLE)).selectByVisibleText("Bs. As.");
        driver.findElement(By.name("detalle_cp")).clear();
        driver.findElement(SiniestroLocators.CP_DETALLE).sendKeys("1900");
        new Select(driver.findElement(SiniestroLocators.LOCALIDAD_DETALLE)).selectByVisibleText("LA PLATA");
        
        // Forma de Ocurrencia
        driver.findElement(SiniestroLocators.DESCRIPCION_SINIESTRO).sendKeys("Una piedra golpeó en el parabrisas");
        
        // Ingreso del Siniestro
        driver.findElement(SiniestroLocators.BOTON_INGRESO_SINIESTRO).click();
        
        // Esperar para visualizar el resultado (opcional)
        Thread.sleep(3000);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    
}