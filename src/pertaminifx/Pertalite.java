/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pertaminifx;

/**
 *
 * @author ACER
 */
public class Pertalite extends BahanBakar {
    public Pertalite(int banyak){
        super(banyak);
        super.setnama("Pertalite");
        super.setHarga(7650);
        super.setIdJenis(2);

    }
    
    @Override
    public void hitungLiter() {
        double Harga = 7650;
        super.setLiter(super.getBanyak() / Harga);
    }
}
