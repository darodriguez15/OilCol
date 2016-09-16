package models;

import javax.persistence.*;
import com.avaje.ebean.Model;

@Entity
@Table(name = "SensorEmergenciaEntity")
public class SensorEmergenciaEntity extends Model {

    public static Finder<Long,SensorEmergenciaEntity> FINDER = new Finder<>(SensorEmergenciaEntity.class);

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SensorEmergencia")
    private Long id;
    private String emergencia;


    public SensorEmergenciaEntity(String emergencia)
    {
        emergencia = emergencia;
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
     * @return the emergencia
     */
    public String getEmergencia() {
        return emergencia;
    }

    /**
     * @param emergencia the emergencia to set
     */
    public void setEmergencia(String emergencia) {
        this.emergencia = emergencia;
    }


}