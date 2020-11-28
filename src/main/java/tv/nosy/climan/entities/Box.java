package tv.nosy.climan.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Box implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = -1162969566150602965L;
    
    @Id
    @Column(name = "REF")
    private String references;

    private Date arrive;

    public Box() {
    }

    public Box(String references, Date arrive) {
        this.references = references;
        this.arrive = arrive;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public Date getArrive() {
        return arrive;
    }

    public void setArrive(Date arrive) {
        this.arrive = arrive;
    }
}
