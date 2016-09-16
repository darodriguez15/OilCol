package models;

import javax.persistence.*;
import com.avaje.ebean.Model;

@Entity
@Table(name = "JefeDeCampoEntity")
public class JefeDeCampoEntity extends Model {

    public static Finder<Long, JefeDeCampoEntity> FINDER = new Finder<>(JefeDeCampoEntity.class);

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JefeDeCampo")
    private Long id;

    private String nombre;

    private int edad;

    private String telefono;

    private String direccion;

    private String nacionalidad;

    private String cedula;







    public JefeDeCampoEntity(String name, int age, String tel, String addres, String nat, String ced)
    {
        nombre = name;
        edad = age;
        telefono = tel;
        direccion = addres;
        nacionalidad = nat;
        cedula = ced;

    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * @param nacionalidad the nacionalidad to set
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
