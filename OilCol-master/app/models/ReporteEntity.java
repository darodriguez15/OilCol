package models;

import javax.persistence.*;
import com.avaje.ebean.Model;

@Entity
@Table(name = "ReporteEntity")
public class ReporteEntity extends Model {

    public static Finder<Long,ReporteEntity> FINDER = new Finder<>(ReporteEntity.class);

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Reporte")
    private Long id;


    @Column(name = "descripcion")
    private String descripcion;

    private Long idSensor;

    private Long idPozo;

    private String tipoSensor;




    public ReporteEntity ( Long idS, Long idP, String esta, String tipoS)
    {
        idSensor = idS;
        idPozo = idP;
        descripcion = esta;
        tipoSensor = tipoS;

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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param des the descripcion to set
     */
    public void setDescripcion (String des) {
        this.descripcion = des;
    }

    /**
     * @return the idSensor
     */
    public Long getIdSensor() {
        return idSensor;
    }

    /**
     * @param idSensor the idSensor to set
     */
    public void setIdSensor(Long idSensor) {
        this.idSensor = idSensor;
    }

    /**
     * @return the idPozo
     */
    public Long getIdPozo() {
        return idPozo;
    }

    /**
     * @param idPozo the idPozo to set
     */
    public void setIdPozo(Long idPozo) {
        this.idPozo = idPozo;
    }

    /**
     * @return the tipoSensor
     */
    public String getTipoSensor() {
        return tipoSensor;
    }

    /**
     * @param tipoSensor the tipoSensor to set
     */
    public void setTipoSensor(String tipoSensor) {
        this.tipoSensor = tipoSensor;
    }



}
