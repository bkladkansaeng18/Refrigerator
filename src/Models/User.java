package Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.*;



/**
 *
 * @author Morrrr
 */
@Entity
public class User extends Account{
    private String name;
    private String email;
    private Date brithday;
    private int status;
    private int cout;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = false)
    List<Refrigerator> refrigerator ;


    
     
    public User() {
      this.cout =0;
      refrigerator = new ArrayList<Refrigerator>();
        
    }

    public List<Refrigerator> getRefrigerator() {
        return refrigerator;
    }

 
    public void addRefrig(Refrigerator refrig){
        this.cout++;
        refrig.setUser(this);
        this.refrigerator.add(refrig);
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCout() {
        return cout;
    }

   
     
}


