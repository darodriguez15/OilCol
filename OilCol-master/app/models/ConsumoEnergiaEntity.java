package models;

import javax.persistence.*;
import com.avaje.ebean.Model;

@Entity
@Table(name = "consumoEnergiaEntity")
public class ConsumoEnergiaEntity extends Model {

    public static Finder<Long, ConsumoEnergiaEntity> FINDER = new Finder<>(ConsumoEnergiaEntity.class);

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ConsumoEnergia")
    private Long id;

    private double consumo;


    public ConsumoEnergiaEntity() {
        this.id = null;

        this.consumo = 0;

    }

    public ConsumoEnergiaEntity(Long id) {
        this();
        this.id = id;
    }

    public ConsumoEnergiaEntity(Long id, Double consu) {
        this.id = id;
        this.consumo = consu;

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
     * @return the consumo
     */
    public double getConsumoEnergia() {
        return consumo;
    }

    /**
     * @param consumo the consumo to set
     */
    public void setConsumoEnergia(double consumo) {
        this.consumo = consumo;
    }


}