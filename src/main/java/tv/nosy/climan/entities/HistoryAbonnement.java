package tv.nosy.climan.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class HistoryAbonnement implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = -2660975812830306864L;
    
    @Id
    private Long ref;

    @ManyToMany
    @JoinColumn(name = "BOX_REF", nullable = true)
    private Collection<Box> box;

    @ManyToMany
    @JoinColumn(name = "ABONNEMENT_REF", nullable = true)
    private Collection<Abonnement> abonnement;

    public HistoryAbonnement(Long ref, Collection<Box> box, Collection<Abonnement> abonnement) {
        this.ref = ref;
        this.box = box;
        this.abonnement = abonnement;
    }

    public HistoryAbonnement(){

    }

    public Long getRef() {
        return ref;
    }

    public void setRef(Long ref) {
        this.ref = ref;
    }

    public Collection <Box> getBox() {
        return box;
    }

    public void setBox(Collection <Box> box) {
        this.box = box;
    }

    public Collection <Abonnement> getAbonnement() {
        return abonnement;
    }

    public void setAbonnement(Collection <Abonnement> abonnement) {
        this.abonnement = abonnement;
    }
    
}
