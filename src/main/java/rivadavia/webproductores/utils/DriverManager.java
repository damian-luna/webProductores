package rivadavia.webproductores.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            // Especifica la ubicación del driver manualmente
            System.setProperty("webdriver.chrome.driver", "C:/chromeDriver/chromedriver.exe");

            // Opciones para Chrome
            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);
            options.addArguments("--start-maximized"); // Abrir ventana maximizada
            options.addArguments("--remote-allow-origins=*"); // Evitar errores con ChromeDriver nuevo

            // Crear el driver con opciones
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void cerrar() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
