/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javax.persistence.*;

/**
 *
 * @author Morrrr
 */
@Entity
public class Beverages extends Item{

    public Beverages() {
    }

    public Beverages(String name, String barcode, String description) {
        super(name, barcode, description);
    }
    
}
