package rivadavia.webproductores.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Set;

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
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(segundos));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("❌ No se pudo encontrar el elemento visible: " + locator);
            capturarPantalla("error_esperarVisible");
            throw e;
        }
    }

    /** Hace clic en el elemento indicado */
    public void click(By locator) {
        try {
            esperarVisible(locator, 10).click();
        } catch (Exception e) {
            System.out.println("❌ Error al hacer click en: " + locator);
            capturarPantalla("error_click");
            throw e;
        }
    }

    /** Hace hover sobre un elemento que contiene cierto texto */
    public void hoverSobre(By locator) {
        try {
            WebElement elemento = esperarVisible(locator, 10);
            new Actions(driver).moveToElement(elemento).perform();
        } catch (Exception e) {
            System.out.println("❌ Error al hacer hover sobre: " + locator);
            capturarPantalla("error_hover");
            throw e;
        }
    }

    /** Selecciona un valor de un desplegable */
    public void seleccionarPorValue(By locator, String value) {
        try {
            WebElement selectElement = esperarVisible(locator, 10);
            Select select = new Select(selectElement);
            select.selectByValue(value);
        } catch (Exception e) {
            System.out.println("❌ Error al seleccionar por value: " + value + " en: " + locator);
            capturarPantalla("error_seleccionarPorValue");
            throw e;
        }
    }

    /** Escribe texto en el elemento indicado */
    public void escribir(By locator, String texto) {
        try {
            WebElement e = esperarVisible(locator, 10);
            e.clear();
            e.sendKeys(texto);
        } catch (Exception e) {
            System.out.println("❌ Error al escribir en: " + locator + " con texto: " + texto);
            capturarPantalla("error_escribir");
            throw e;
        }
    }

    /** Presiona ENTER */
    public void presionarEnter() {
        try {
            new Actions(driver).sendKeys(Keys.ENTER).perform();
        } catch (Exception e) {
            System.out.println("❌ Error al presionar ENTER");
            capturarPantalla("error_enter");
            throw e;
        }
       
    }
    /** Cambia a la nueva pestaña abierta, espera que el PDF cargue, captura pantalla con nombre dado, cierra la pestaña y vuelve a la original */
    public void capturarYPdfCerrarVolver(String nombreArchivo) {
        try {
            String originalHandle = driver.getWindowHandle();  // guardo ventana original

            // Espero que haya 2 ventanas (la original + la nueva)
            Set<String> handles = driver.getWindowHandles();
            int retries = 0;
            while (handles.size() == 1 && retries < 20) {  // esperar hasta 10 segundos (20*500ms)
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                handles = driver.getWindowHandles();
                retries++;
            }

            // Busco la pestaña que no es la original
            for (String handle : handles) {
                if (!handle.equals(originalHandle)) {
                    driver.switchTo().window(handle);
                    System.out.println("Cambiado a pestaña PDF");

                    // Esperar a que el título de la pestaña cambie (si es posible)
                    String initialTitle = driver.getTitle();
                    System.out.println("Titulo inicial: " + initialTitle);

                    int pdfWaitRetries = 0;
                    while (driver.getTitle().equals(initialTitle) && pdfWaitRetries < 20) {  // esperar hasta 10 seg a que cambie el título
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        pdfWaitRetries++;
                    }

                    // Esperar 2 seg extra para asegurar que el PDF terminó de cargar visualmente
                    Thread.sleep(2000);

                    capturarPantalla(nombreArchivo);

                    driver.close();  // cierro la pestaña pdf
                    System.out.println("Pestaña PDF cerrada");
                    break;
                }
            }

            driver.switchTo().window(originalHandle);  // vuelvo a la principal
            System.out.println("Volviendo a la pestaña original");

        } catch (Exception e) {
            System.out.println("❌ Error en capturarYPdfCerrarVolver: " + e.getMessage());
            capturarPantalla("error_capturarPdfCerrarVolver");
            throw new RuntimeException(e);
        }
    }


    
    
    /** Captura de pantalla ante errores o cuando se desee */
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
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /** Obtiene el título de la página */
    public String obtenerTitulo() {
        return driver.getTitle();
    }
}
