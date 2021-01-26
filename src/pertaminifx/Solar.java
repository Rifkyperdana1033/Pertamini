/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pertaminifx;

/**
 *
 * @author ACER
 */
public class Solar extends BahanBakar {
    public Solar(int banyak){
        super(banyak);
        super.setnama("Bio Solar");
        super.setHarga(9400);
        super.setIdJenis(4);
    }
    
    @Override
    public void hitungLiter() {
        double Harga = 9400;
        super.setLiter(super.getBanyak() / Harga);
    }
}
