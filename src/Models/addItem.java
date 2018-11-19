/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
/**
 *
 * @author Morrrr
 */
@Entity
public class addItem implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Refrigerator refrig;
    
    private Item item;
    private int Amou;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date exp;
    public Long getId() {
        return id;
    }

    public addItem(Item item, int Amou, Date exp) {
        this.item = item;
        this.Amou = Amou;
        this.exp = exp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Refrigerator getRefrig() {
        return refrig;
    }

    public void setRefrig(Refrigerator refrig) {
        this.refrig = refrig;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getAmou() {
        return Amou;
    }

    public void setAmou(int Amou) {
        this.Amou = Amou;
    }

    public Date getExp() {
        return exp;
    }

    public void setExp(Date exp) {
        this.exp = exp;
    }
    
    
    
}
