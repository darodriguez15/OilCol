package models;

import javax.persistence.*;
import com.avaje.ebean.Model;

@Entity
@Table(name = "caudalEntity")
public class CaudalEntity extends Model{

    public static Finder<Long,CaudalEntity> FINDER = new Finder<>(CaudalEntity.class);

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "Caudal")
    private Long id;
    private double  caudal;



    public CaudalEntity() {
        this.id=null;
        this.caudal =0;


    }

    public CaudalEntity(Long id) {
        this();
        this.id = id;
    }

    public CaudalEntity(Long id, double caudal)
{
    this.id = id;
    this.caudal = caudal;
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
     * @return the caudal
     */
    public double getCaudal() {
        return caudal;
    }

    /**
     * @param nue the caudal to set
     */
    public void setCaudal (double nue) {
        this.caudal = nue;
    }



}