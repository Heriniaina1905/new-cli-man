package tv.nosy.climan.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Abonnement implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 930238079388975958L;
    
    @Id
    private String nom;
    private long prix;


    public Abonnement() {
    }

    public Abonnement(String nom, long prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getPrix() {
        return prix;
    }

    public void setPrix(long prix) {
        this.prix = prix;
    }

    
}
