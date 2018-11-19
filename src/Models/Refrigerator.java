/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Morrrr
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Refrigerator implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String refrig_id, refrig_name, refrig_band, refrig_color, refrig_size;

//    @ManyToOne

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private User user;

    @OneToMany(mappedBy = "refrig",cascade = CascadeType.ALL, orphanRemoval = false)
    List<addItem> item ;
    
    public Refrigerator() {
        this.item = new ArrayList<>();
 
    } 


    public Refrigerator(User user,String refrig_name, String refrig_band, String refrig_color, String refrig_size) {
        this.refrig_id = "REFRIGERATOR-"+ user.getCout() ;
        this.refrig_name = refrig_name;
        this.refrig_band = refrig_band;
        this.refrig_color = refrig_color;
        this.refrig_size = refrig_size;
        this.item = new ArrayList<>();

    }
    public void addItem( addItem aItem){      
        this.item.add(aItem);
        aItem.setRefrig(this);
    }


    public String getRefrig_id() {
        return refrig_id;
    }

    public void setRefrig_id(String refrig_id) {
        this.refrig_id = refrig_id;
    }

    public String getRefrig_name() {
        return refrig_name;
    }

    public void setRefrig_name(String refrig_name) {
        this.refrig_name = refrig_name;
    }

    public String getRefrig_band() {
        return refrig_band;
    }

    public void setRefrig_band(String refrig_band) {
        this.refrig_band = refrig_band;
    }

    public String getRefrig_color() {
        return refrig_color;
    }

    public void setRefrig_color(String refrig_color) {
        this.refrig_color = refrig_color;
    }

    public String getRefrig_size() {
        return refrig_size;
    }

    public void setRefrig_size(String refrig_size) {
        this.refrig_size = refrig_size;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public List<addItem> getItem() {
        return item;
    }

    public void setItem(List<addItem> item) {
        this.item = item;
    }

    public void setId(long id) {
        this.id = id;
    }

}
