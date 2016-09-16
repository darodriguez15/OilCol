package models;

import javax.persistence.*;
import com.avaje.ebean.Model;

@Entity
@Table(name = "pozoEntity")
public class PozoEntity extends Model {

    public static Finder<Long,PozoEntity > FINDER = new Finder<>(PozoEntity.class);

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Pozo")
    private Long id;


    @Column(name = "Longitud")
    private double longitud;

    @Column(name = "Latitud")
    private double latitud;

    private String Estado;

    public PozoEntity (){}

    public PozoEntity (double lat, double lon, String esta)
    {
        longitud = lon;
        latitud = lat;
        Estado = esta;
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
     * @return the longitud
     */
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
     * @return the Estado
     */
    public String getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

}
