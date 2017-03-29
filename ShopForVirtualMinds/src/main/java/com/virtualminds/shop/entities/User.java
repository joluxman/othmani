package com.virtualminds.shop.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by jocopernicus on 3/14/2017.
 */
@Entity
@Table(name="USERS")
public class User implements Serializable {
    @Id
    @SequenceGenerator(
            name="USERS_SEQUENCE_GENERATOR",
            sequenceName="USERS_SEQ"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="USERS_SEQUENCE_GENERATOR")
    private Long idUser;
    private String username;
    private String password;
    private boolean activated;
    @OneToMany
    @JoinColumn(name="idUser")
    private Collection<Role> roles;

    public User(String username, String password, boolean activated) {
        this.username = username;
        this.password = password;
        this.activated = activated;
    }

    public User() {
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
