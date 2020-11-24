package tv.nosy.climan.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 9075304736144514894L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    private String nom;
    private String tel;
    private String mail;
    private String CIN;

    public Client() {
    }

    public Client(String nom, String tel, String mail, String cIN) {
        this.nom = nom;
        this.tel = tel;
        this.mail = mail;
        CIN = cIN;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String cIN) {
        CIN = cIN;
    }
}
