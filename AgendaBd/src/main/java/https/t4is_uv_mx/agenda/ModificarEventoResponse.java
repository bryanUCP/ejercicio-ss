//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.04.16 a las 10:47:46 PM CDT 
//


package https.t4is_uv_mx.agenda;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Nombre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="FInicio" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="FLimite" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "nombre",
    "fInicio",
    "fLimite",
    "descripcion"
})
@XmlRootElement(name = "ModificarEventoResponse")
public class ModificarEventoResponse {

    protected int id;
    @XmlElement(name = "Nombre", required = true)
    protected String nombre;
    @XmlElement(name = "FInicio", required = true)
    protected String fInicio;
    @XmlElement(name = "FLimite", required = true)
    protected String fLimite;
    @XmlElement(name = "Descripcion", required = true)
    protected String descripcion;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad fInicio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFInicio() {
        return fInicio;
    }

    /**
     * Define el valor de la propiedad fInicio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFInicio(String value) {
        this.fInicio = value;
    }

    /**
     * Obtiene el valor de la propiedad fLimite.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFLimite() {
        return fLimite;
    }

    /**
     * Define el valor de la propiedad fLimite.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFLimite(String value) {
        this.fLimite = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

}
