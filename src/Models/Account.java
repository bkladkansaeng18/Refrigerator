/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Morrrr
 */

@Entity
public class Account implements Serializable{

    @Id @GeneratedValue
    private Long id;    
    private String user_username,user_password;
    private String ImgAcc ;
    public Account( String user_username, String user_password) {
        this.user_username = user_username;
        this.user_password = user_password;
    }

    public Account() {
        
    }

    public String getImgAcc() {
        return ImgAcc;
    }

    public void setImgAcc(String ImgAcc) {
        this.ImgAcc = ImgAcc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_password() {
        return user_password;
    }


     
    
    
    
}

