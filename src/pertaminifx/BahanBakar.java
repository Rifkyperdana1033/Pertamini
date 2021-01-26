/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pertaminifx;

import java.text.DecimalFormat;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ACER
 */
public abstract class BahanBakar {
    StringProperty nama;
    IntegerProperty harga;
    DoubleProperty Liter;
    IntegerProperty banyak;
    int id_jenis;
    
    public BahanBakar(int Banyak){
        nama = new SimpleStringProperty();
        harga = new SimpleIntegerProperty();
        Liter = new SimpleDoubleProperty();
        banyak = new SimpleIntegerProperty(Banyak);
    }
    
    public void setnama(String nama){
        this.nama.set(nama);
    }
   
    public void setIdJenis(int id){
        this.id_jenis = id;
    }
    
    public int getIdJenis(){
        return id_jenis;
    }
    
    public void setHarga(int harga){
        this.harga.set(harga);
    }
    
    public abstract void hitungLiter();
    
    public void setLiter(double liter){
        this.Liter.set(liter);
    }
    
    public String getNama(){
        return this.nama.get();
    }
    
    public int getHarga(){
        return this.harga.get();
    }
    
    public double getLiter(){
        hitungLiter();
        DecimalFormat df = new DecimalFormat("#.##");
        double x = Double.valueOf(df.format(Liter.get()));
        this.Liter.set(x);
        return this.Liter.get();
    }
    
    public int getBanyak(){
        return this.banyak.get();
    }
    
    public StringProperty NamaProperty(){
        return this.nama;
    }
    
    public IntegerProperty HargaProperty(){
        return this.harga;
    }
    
    public DoubleProperty LiterProperty(){
        hitungLiter();
        DecimalFormat df = new DecimalFormat("#.##");
        double x = Double.valueOf(df.format(Liter.get()));
        this.Liter.set(x);
//        this.Liter.set();
        return this.Liter;
    }
    
    public IntegerProperty BanyakProperty(){
        return this.banyak;
    }
}
