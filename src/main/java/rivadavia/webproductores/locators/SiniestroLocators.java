package rivadavia.webproductores.locators;

import org.openqa.selenium.By;

public class SiniestroLocators {
	
    public By menuAdministradorSiniestros = By.xpath("//div[contains(text(),'> Administrador Siniestros')]");
    public By opcionIngresoDenuncia = By.xpath("//div[@class='btn_left'][normalize-space()='Ingreso de Denuncia']");
    
	 // --- Campos de cabecera ---
    public static final By POLIZA_PRIMER_CAMPO = By.id("zona");  // 47
    public static final By POLIZA_SEGUNDO_CAMPO = By.id("poliza"); // 774140

    public static final By PATENTE = By.name("patente"); // "AD650OK", si es editable
    public static final By FECHA_SINIESTRO = By.name("fechaSinFormato"); // 08/06/2025
    public static final By HORA_HH = By.name("hora"); // 10
    public static final By HORA_MM = By.name("minuto"); // 00

    // --- Cobertura Afectada del Vehículo ---
    public static final By COB_ROBO_TOTAL = By.name("checkbox1");
    public static final By COB_ROBO_PARCIAL = By.name("checkbox2");
    public static final By COB_INCENDIO = By.name("checkbox3");

    public static final By COB_DANIOS = By.name("checkbox4"); // checkbox
    public static final By COB_DANIOS_PARCIAL = By.id("danios_parcial");
   // public static final By COB_DANIOS_TOTAL = By.xpath("//input[@name='danios_tipo']");

    // --- Preguntas con Radio Buttons ---
    public static final By PREG_DANIOS_TERCEROS_SI = By.xpath("(//input[@name='terceros'])[1]");
    public static final By PREG_DANIOS_TERCEROS_NO = By.xpath("(//input[@name='terceros'])[2]");

    public static final By PREG_LESIONADOS_SI = By.xpath("(//input[@name='lesionados'])[1]");
    public static final By PREG_LESIONADOS_NO = By.xpath("(//input[@name='lesionados'])[2]");

    public static final By PREG_DENUNCIANTE_CONDUCTOR_SI = By.xpath("(//input[@name='asegurado'])[1]");
    public static final By PREG_DENUNCIANTE_CONDUCTOR_NO = By.xpath("(//input[@name='asegurado'])[2]");

    public static final By PREG_CONDUCTOR_ASEGURADO_SI = By.xpath("(//input[@name='conductor'])[1]");
    public static final By PREG_CONDUCTOR_ASEGURADO_NO = By.xpath("(//input[@name='conductor'])[2]");

    public static final By PREG_DENUNCIA_POLICIAL_SI = By.xpath("(//input[@name='policial'])[1]");
    public static final By PREG_DENUNCIA_POLICIAL_NO = By.xpath("(//input[@name='policial'])[2]");

    public static final By PREG_TESTIGOS_SI = By.xpath("(//input[@name='testigos'])[1]");
    public static final By PREG_TESTIGOS_NO = By.xpath("(//input[@name='testigos'])[2]");

    public static final By PREG_DENUNCIA_OFICIO_SI = By.xpath("(//input[@name='oficio'])[1]");
    public static final By PREG_DENUNCIA_OFICIO_NO = By.xpath("(//input[@name='oficio'])[2]");

    // --- Botones ---
    public static final By BTN_CONTINUAR = By.xpath("//input[@name='Continuar']");
    public static final By BTN_CANCELAR = By.xpath("//input[@name='Cancelar']");
    
    // --- Checkboxes de daños específicos ---
    public static final By DANIO_CERRADURA_ARRANQUE = By.name("checkbox_adic1");
    public static final By DANIO_CERRADURA_EXTERIOR = By.name("checkbox_adic2");
    public static final By DANIO_CRISTALES_LATERALES = By.name("checkbox_adic3");
    public static final By DANIO_PARABRISAS = By.name("checkbox_adic4");
    public static final By DANIO_LUNETAS = By.name("checkbox_adic5");
    public static final By DANIO_CRISTAL_TECHO = By.name("checkbox_adic6");
    public static final By DANIO_ANTENA = By.name("checkbox_adic7");
    public static final By DANIO_GRANIZO = By.name("checkbox_adic8");
    public static final By DANIO_OTROS = By.name("dcheckbox_adic9");
    
 // --- Botones ---
    public static final By BOTON_ACEPTAR = By.xpath("//input[@name='Aceptar']");
    public static final By BOTON_RESTABLECER = By.xpath("//input[@name='Restablecer']");
    
    
 // Sección 1 - Datos del Denunciante
    public static final By NOMBRE_DENUNCIANTE = By.name("denunciante_nombre");
    public static final By SEXO_DENUNCIANTE = By.name("denunciante_sexo");
    public static final By TIPO_DOC_DENUNCIANTE = By.name("denunciante_tipo_documento");
    public static final By NUM_DOC_DENUNCIANTE = By.name("denunciante_numero_documento");
    public static final By DOMICILIO_DENUNCIANTE = By.name("denunciante_domicilio");
    public static final By TELEFONO_DENUNCIANTE = By.name("denunciante_telefono");
    public static final By PAIS_DENUNCIANTE = By.name("denunciante_pais");
    public static final By PROVINCIA_DENUNCIANTE= By.name("denunciante_provincia");
    public static final By CP_DENUNCIANTE = By.name("denunciante_cp");
    public static final By LOCALIDAD_DENUNCIANTE = By.name("denunciante_localidad_combo");

    // Sección 2 - Datos del Asegurado
    public static final By NOMBRE_ASEGURADO = By.name("nombre_asegurado");
    public static final By TIPO_DOC_ASEGURADO = By.name("tipo_doc_asegurado");
    public static final By NUM_DOC_ASEGURADO = By.name("nro_doc_asegurado");

    // Sección 3 - Datos del Conductor
    public static final By NOMBRE_CONDUCTOR = By.name("nombre_conductor");
    public static final By TIPO_DOC_CONDUCTOR = By.name("tipo_doc_conductor");
    public static final By NUM_DOC_CONDUCTOR = By.name("nro_doc_conductor");
    public static final By PAIS_CONDUCTOR = By.name("conductor_pais");
    public static final By PROVINCIA_CONDUCTOR= By.name("conductor_provincia");
    public static final By CP_CONDUCTOR = By.name("conductor_cp");
    public static final By LOCALIDAD_CONDUCTOR = By.name("conductor_localidad_combo");

    // Sección 4 - Detalle del Siniestro
    public static final By FECHA_SINIESTRO2 = By.name("fecha_siniestro");
    public static final By HORA_SINIESTRO = By.name("hora_siniestro");
    public static final By LUGAR_OCURRENCIA = By.name("detalle_lugar");
    public static final By PAIS_DETALLE = By.name("detalle_pais");
    public static final By PROVINCIA_DETALLE= By.name("detalle_provincia");
    public static final By CP_DETALLE = By.name("detalle_cp");
    public static final By LOCALIDAD_DETALLE = By.name("detalle_localidad_combo");

    // Sección 5 - Forma de Ocurrencia
    public static final By DESCRIPCION_SINIESTRO = By.name("ocurrencia_descripcion");

    // Botón Guardar o Continuar
    public static final By BOTON_GUARDAR = By.id("btnGuardar");
    
 // Botón Ingreso Siniestro
    public static final By BOTON_INGRESO_SINIESTRO = By.xpath("//tbody/tr[3]/th[1]/div[1]/ul[1]/li[3]/a[1]");
    
    
}

