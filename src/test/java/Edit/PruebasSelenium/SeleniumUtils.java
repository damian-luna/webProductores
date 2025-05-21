package Edit.PruebasSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class SeleniumUtils {

    private WebDriver driver;

    public SeleniumUtils(WebDriver driver) {
        this.driver = driver;
    }

    /** Espera implícita */
    public void esperaImplicita(int segundos) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(segundos));
    }

    /** Espera a que un elemento sea visible y lo devuelve */
    public WebElement esperarVisible(By locator, int segundos) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(segundos));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /** Hace clic en el elemento indicado */
    public void click(By locator) {
        esperarVisible(locator, 10).click();
    }
 
    /** Hace hover sobre un elemento que contiene cierto texto */
    public void hoverSobre(By locator) {
        WebElement elemento = esperarVisible(locator, 10);
        new Actions(driver).moveToElement(elemento).perform();
    }

    /** Escribe texto en el elemento indicado */
    public void escribir(By locator, String texto) {
        WebElement e = esperarVisible(locator, 10);
        e.clear();
        e.sendKeys(texto);
    }

    /** Presiona ENTER */
    public void presionarEnter() {
        new Actions(driver).sendKeys(Keys.ENTER).perform();
    }

 
    
    public void capturarPantalla(String nombreArchivo) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String carpeta = "evidencias";
        new File(carpeta).mkdirs(); // Crea la carpeta si no existe

        String timestamp = java.time.LocalDateTime.now()
                .toString()
                .replace(":", "-")
                .replace(".", "-");

        String nombreConRuta = carpeta + "/" + nombreArchivo + "_" + timestamp + ".png";

        try {
            Files.copy(src.toPath(), Paths.get(nombreConRuta));
            System.out.println("📸 Captura guardada: " + nombreConRuta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Obtiene el título de la página */
    public String obtenerTitulo() {
        return driver.getTitle();
    }
}
