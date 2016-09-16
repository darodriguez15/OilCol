package models;

import javax.persistence.*;
import com.avaje.ebean.Model;

@Entity
@Table(name = "SensorTemperaturaEntity")
public class SensorTemperaturaEntity extends Model {

    public static Finder<Long,SensorTemperaturaEntity> FINDER = new Finder<>(SensorTemperaturaEntity.class);

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SensorTemperatura")
    private Long id;

    @Column(name = "temperatura")
    private double temp;



    public SensorTemperaturaEntity (){}

    public SensorTemperaturaEntity (double esta)
    {

        temp = esta;
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
     * @return the temp
     */
    public double getTemperatura() {
        return temp;
    }

    /**
     * @param des the temp to set
     */
    public void setTemperatura (double des) {
        this.temp = des;
    }

}
