package Edit.PruebasSelenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestSelenium {

    private WebDriver driver;
    private SeleniumUtils utils;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver();
        utils = new SeleniumUtils(driver);
        utils.esperaImplicita(10);
    }

    @Test
    public void abrirChromeYBuscar() throws InterruptedException {
        // Abrir web
        //driver.get("https://servertest.sr.intra.net/sistemas/login/login_intra.php?u=P");
    	driver.get("http://php8.productores.testing.sr.intra.net/sistemas/login/login_intra.php?u=P");
        utils.esperarVisible(By.xpath("//input[@name='usuario']"), 10);
        utils.escribir(By.xpath("//input[@name='usuario']"), "testing");  
        utils.escribir(By.xpath("//input[@id='cuit']"), "30500050310");
        utils.escribir(By.xpath("//input[@id='password']"), "test28");
        utils.capturarPantalla("datos_login");
        utils.presionarEnter();
        utils.esperarVisible(By.xpath("//input[@name='PROD_P']"), 20);
        utils.capturarPantalla("login_ok");
        utils.click(By.xpath("//input[@name='Aceptar']"));
     
        utils.esperarVisible(By.xpath("//body//div//div//div//input[@value='Aceptar']"), 10);
        utils.click(By.xpath("//body//div//div//div//input[@value='Aceptar']"));
        
        
        utils.hoverSobre(By.xpath("//div[contains(text(),'> Imprimir')]"));
        utils.esperarVisible(By.xpath("//div[contains(text(),'Certificado Cooperativa')]"), 10);
        
        utils.capturarPantalla("menu_imprimir");

        utils.click(By.xpath("//div[contains(text(),'Certificado Cooperativa')]"));
        
        utils.escribir(By.xpath("//input[@id='patente']"), "AA939QW");  
        utils.capturarPantalla("busqueda_patente");
        utils.click(By.xpath("//input[@id='impr_cober4']"));
       // utils.esperarVisible(By.xpath("//a[normalize-space()='click aquí']"), 10);
        // utils.click(By.xpath("//a[normalize-space()='click aquí']"));
          

        // Esperar 10 segundos para ver el resultado
        Thread.sleep(10000);
        utils.capturarPantalla("certif_ok");
        
        // DriverManager.cerrar();  
    }
}
