package models;
 
import javax.persistence.*;
import com.avaje.ebean.Model;
 
@Entity
@Table(name = "campoEntity")
public class CampoEntity extends Model{
 
    public static Finder<Long,ProductEntity> FINDER = new Finder<>(ProductEntity.class);
 
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "Campo")
    private Long id;
    private String departamento;
    private double latitud;
    private double longitud;
    
    
    public ProductEntity() {
        this.id=null;
        this.departamento ="NO NAME";
        this.latitud = -1;
        this.longitud = -1;
       
    }
 
    public ProductEntity(Long id) {
        this();
        this.id = id;
    }
 
    public ProductEntity(Long id, String departamento, Double lat, Double longi) {
        this.id = id;
        this.departamento = departamento;
        this.latitud = lat;
        this.longitud = longi;
        this.available = available;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public double getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    /**
     * @return the latitud
     */
    public double getLatitud() {
        return latitud;
    }

    /**
     * @param latitud the latitud to set
     */
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    /**
     * @return the Departamento
     */
    public String getDepartamento() {
        return Departamento;
    }

    /**
     * @param Departamento the Departamento to set
     */
    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    
    
    
    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", available=" + available +
                '}';
    }