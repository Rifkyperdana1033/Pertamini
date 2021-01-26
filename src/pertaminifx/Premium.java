/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pertaminifx;

/**
 *
 * @author ACER
 */
public class Premium extends BahanBakar {
    public Premium(int banyak){
        super(banyak);
        super.setnama("Premium");
        super.setHarga(6450);
        super.setIdJenis(3);
    }
    
    @Override
    public void hitungLiter() {
        double Harga = 6450;
        super.setLiter(super.getBanyak()/Harga);
    }
    
}
