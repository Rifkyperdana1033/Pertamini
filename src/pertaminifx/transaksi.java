/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pertaminifx;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ACER
 */
public class transaksi {
    IntegerProperty id;
    BahanBakar bb;
    
    public transaksi(int id,BahanBakar bb){
        this.id = new SimpleIntegerProperty(id);
        this.bb = bb;
        
    }
   
    
    public int getID(){
        return this.id.get();
    }
    
    public StringProperty NamaProperty(){
        return this.bb.NamaProperty();
    }
    
    public IntegerProperty BanyakProperty(){
        return this.bb.BanyakProperty();
    }
    
    public DoubleProperty LiterProperty(){
        return this.bb.LiterProperty();
    }
    
    public IntegerProperty HargaProperty(){
        return this.bb.HargaProperty();
    }
    
    public IntegerProperty IDProperty(){
        return this.id;
    }
}
