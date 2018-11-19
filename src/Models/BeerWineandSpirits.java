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
public class BeerWineandSpirits extends Item{

    public BeerWineandSpirits() {
    }

    public BeerWineandSpirits(String name, String barcode, String description) {
        super(name, barcode, description);
    }
    
}
