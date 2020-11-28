package tv.nosy.climan.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 5782011532293726750L;
    
    @Id
    private String username;
    private String password;
    private boolean actived;
    @ManyToMany
    @JoinTable(name = "USERS_ROLES")
    private Collection<Role> roles;

    public User() {
    }

    public User(String username, String password, boolean actived, Collection<Role> roles) {
        this.username = username;
        this.password = password;
        this.actived = actived;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public boolean isActived() {
        return actived;
    }

    public void setActived(boolean actived) {
        this.actived = actived;
    }
}
