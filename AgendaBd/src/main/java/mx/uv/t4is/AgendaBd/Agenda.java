package mx.uv.t4is.AgendaBd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//DTO
@Entity
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private String Nombre;
    private String FInicio;
    private String FLimite;    
    private String Descripcion;


    public Agenda() {
    }
    

    public Agenda(int id, String Nombre, String FInicio, String FLimite, String Descripcion) {
        this.id = id;
        this.Nombre = Nombre;
        this.FInicio = FInicio;
        this.FLimite = FLimite;
        this.Descripcion = Descripcion;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getFInicio() {
        return this.FInicio;
    }

    public void setFInicio(String FInicio) {
        this.FInicio = FInicio;
    }

    public String getFLimite() {
        return this.FLimite;
    }

    public void setFLimite(String FLimite ) {
        this.FLimite = FLimite;
    }

    public String getDescripcion() {
        return this.Descripcion;
    }

    public void setDescripcion(String Descripcion ) {
        this.Descripcion = Descripcion;
    }



    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            "}";
    }

}

