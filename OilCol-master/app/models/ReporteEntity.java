package models;

import javax.persistence.*;
import com.avaje.ebean.Model;
import java.util.List;

@Entity
@Table(name = "ReporteEntity")
public class ReporteEntity extends Model {

    public static Finder<Long,ReporteEntity> FINDER = new Finder<>(ReporteEntity.class);

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Reporte")
    private Long id;


    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "idSensor")
    private String idSensor;

    @Column(name = "contrasenaSensor")
    private String contrasenaSensor;
    
    @Column(name = "idPozo")
    private Long idPozo;

    @Column(name = "tipoSensor")
    private String tipoSensor;




    public ReporteEntity ( String idS, Long idP, String esta, String tipoS,String contra)
    {
        idSensor = idS;
        idPozo = idP;
        descripcion = esta;
        tipoSensor = tipoS;
        this.setContrasenaSensor(contra);

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
    public String getIdSensor() {
        return idSensor;
    }

    /**
     * @param idSensor the idSensor to set
     */
    public void setIdSensor(String idSensor) {
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


    public String getContrasenaSensor() {
        return contrasenaSensor;
    }

    public void setContrasenaSensor(String contrasenaSensor) {
        this.contrasenaSensor = contrasenaSensor;
    }
}
