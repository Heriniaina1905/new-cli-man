package tv.nosy.climan.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = -1203154469898444494L;

    @Id
    private String nom;
    private String description;

    public Role() {
    }

    public Role(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}