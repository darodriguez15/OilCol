package models;

import javax.persistence.*;
import com.avaje.ebean.Model;

@Entity
@Table(name = "SensoresSeguros")
public class SensoresSegurosEntity extends Model{

    public static Finder<Long,SensoresSegurosEntity> FINDER = new Finder<>(SensoresSegurosEntity.class);

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "SensorSeguro")
    private Long id;
    private String idPozo;
    private String contraseña;




    public SensoresSegurosEntity(String idP, String contra) {
        this.setId(null);
        this.setIdPozo(idP);
        this.setContraseña(contra);


    }


    public static Finder<Long, SensoresSegurosEntity> getFINDER() {
        return FINDER;
    }

    public static void setFINDER(Finder<Long, SensoresSegurosEntity> FINDER) {
        SensoresSegurosEntity.FINDER = FINDER;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdPozo() {
        return idPozo;
    }

    public void setIdPozo(String idPozo) {
        this.idPozo = idPozo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}