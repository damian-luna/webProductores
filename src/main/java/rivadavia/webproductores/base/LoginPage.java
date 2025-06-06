package rivadavia.webproductores.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private SeleniumUtils utils;

    private By btnAceptar = By.xpath("//a[@id='btn_ingresar']");
    private By inputUsuario = By.xpath("//input[@name='usuario']");
    private By inputCuit = By.xpath("//input[@id='cuit']");
    private By inputPassword = By.xpath("//input[@id='password']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new SeleniumUtils(driver);
    }

    public void escribirUsuario(String usuario) {
        try {
            utils.escribir(inputUsuario, usuario);
        } catch (Exception e) {
            utils.capturarPantalla("error_usuario");
            throw new RuntimeException("Falló al escribir el usuario", e);
        }
    }

    public void escribirCuit(String cuit) {
        try {
            utils.escribir(inputCuit, cuit);
        } catch (Exception e) {
            utils.capturarPantalla("error_cuit");
            throw new RuntimeException("Falló al escribir el cuit", e);
        }
    }

    public void escribirPassword(String pass) {
        try {
            utils.escribir(inputPassword, pass);
        } catch (Exception e) {
            utils.capturarPantalla("error_password");
            throw new RuntimeException("Falló al escribir la contraseña", e);
        }
    }

    public void clickAceptar() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(btnAceptar));
            utils.click(btnAceptar);
        } catch (Exception e) {
            utils.capturarPantalla("error_click_ingresar");
            throw new RuntimeException("Falló al hacer clic en Aceptar/Iniciar sesión", e);
        }
    }
}
