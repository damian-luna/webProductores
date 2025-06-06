package rivadavia.webproductores.locators;

import org.openqa.selenium.By;

public class ImpresionLocators {
    public By inputPatente = By.xpath("//input[@id='patente']");
    public By btnImprimirCertificado = By.xpath("//input[@id='impr_cober4']");
    public By menuImprimir = By.xpath("//div[contains(text(),'> Imprimir')]");
    public By opcionCertificadoCooperativa = By.xpath("//div[contains(text(),'Certificado Cooperativa')]");
    public By opcionCopiaPoliza = By.xpath("//div[contains(text(),'Pza./Factura/Condiciones')]");
    public By desplegableRamo = By.xpath("//select[@id='seccion']");
    public By inputZona = By.xpath("//input[@id='zona']");
    public By inputPoliza = By.xpath("//input[@id='poliza']");
    public By btnAceptar = By.xpath("//input[@id='aceptar']");
}
