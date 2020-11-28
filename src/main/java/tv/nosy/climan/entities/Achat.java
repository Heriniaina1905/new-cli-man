package tv.nosy.climan.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Achat implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    private String ref;
    @OneToMany
    @JoinColumn(name = "BOX_REF", nullable = true)
    private Collection<Box> box;
    @ManyToMany
    @JoinColumn(name = "CLIENT_ID", nullable = true)
    private Collection<Client> client;
    private Date date;

    public Achat() {
    }

    public Achat(String ref, Collection<Box> box, Collection<Client> client, Date date) {
        this.ref = ref;
        this.box = box;
        this.client = client;
        this.date = date;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Collection<Box> getBox() {
        return box;
    }

    public void setBox(Collection<Box> box) {
        this.box = box;
    }

    public Collection<Client> getClient() {
        return client;
    }

    public void setClient(Collection<Client> client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
