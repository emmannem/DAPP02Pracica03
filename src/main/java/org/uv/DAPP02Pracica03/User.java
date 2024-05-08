/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.DAPP02Pracica03;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author JMRes
 */
@Entity
@Table(name = "usuarios")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "usuario_id_usuarios_seq")
    @SequenceGenerator(name = "usuario_id_usuarios_seq",
            sequenceName = "usuario_id_usuarios_seq",
            initialValue = 1, allocationSize = 1)
    @Column(name = "id_usuarios")
    private Long clave;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "rol")
    private String rol;
    @Column(name = "enabled")
    private boolean enabled;

    /**
     * @return the clave
     */
    public Long getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(Long clave) {
        this.clave = clave;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * @return the enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param enabled the enabled to set
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
