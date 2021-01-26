/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pertaminifx;

/**
 *
 * @author ACER
 */
public class Pertamax extends BahanBakar {

    public Pertamax(int banyak){
        super(banyak);
        super.setnama("Pertamax");
        super.setHarga(9200);
        super.setIdJenis(1);
    }
    
    @Override
    public void hitungLiter() {
        double Harga = 9200;
        super.setLiter(super.getBanyak() / Harga);
    }
    
}
