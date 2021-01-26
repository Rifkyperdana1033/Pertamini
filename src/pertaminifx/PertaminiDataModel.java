/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pertaminifx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ACER
 */
public class PertaminiDataModel {

    public final Connection CONN;

    public PertaminiDataModel(String driver) throws SQLException {
        this.CONN = koneksi.koneksi(driver);
    }

    public void inputData(transaksi transaksi) throws SQLException {
        String insertTransaksi = "INSERT INTO transaksi (id,id_bahanbakar,Jumlah,Liter)"
                + " VALUES (?,?,?,?)";
        String insertBahanBakar = "INSERT INTO bahanbakar (id,id_jenis,nama_jenis,"
                + "harga)"
                + " VALUES (?,?,?,?)";

        PreparedStatement stmtTransaksi = CONN.prepareStatement(insertTransaksi);
        stmtTransaksi.setInt(1, transaksi.getID());
        stmtTransaksi.setInt(2, transaksi.getID());
        stmtTransaksi.setInt(3, transaksi.bb.getBanyak());
        stmtTransaksi.setDouble(4, transaksi.bb.getLiter());
        stmtTransaksi.execute();
        
        PreparedStatement stmtBB = CONN.prepareStatement(insertBahanBakar);
        stmtBB.setInt(1, transaksi.getID());
        stmtBB.setInt(2, transaksi.bb.getIdJenis());
        stmtBB.setString(3, transaksi.bb.getNama());
        stmtBB.setInt(4, transaksi.bb.getHarga());
        stmtBB.execute();
        
    }

    

    public ObservableList getData() throws SQLException {
        ObservableList<transaksi> data = FXCollections.observableArrayList();
        Pertamax pmax;
        Pertalite plite;
        Premium pre;
        Solar bisol;
        
        String sqlTransaksi = "SELECT * FROM `transaksi`";
        String sqlBahanbakar = "SELECT * FROM `bahanbakar`";
        String sqlPertamax = "SELECT * FROM `pertamax`";
        String sqlPertalite = "SELECT * FROM `pertalite`";
        String sqlPremium = "SELECT * FROM `premium`";
        String sqlSolar = "SELECT * FROM `solar`";


        try {
            ResultSet rsTransaksi = CONN.createStatement().executeQuery(sqlTransaksi);
            ResultSet rsBahanBakar = CONN.createStatement().executeQuery(sqlBahanbakar);
            ResultSet rsPertamax = CONN.createStatement().executeQuery(sqlPertamax);
            ResultSet rsPertalite = CONN.createStatement().executeQuery(sqlPertalite);
            ResultSet rsPremium = CONN.createStatement().executeQuery(sqlPremium);
            ResultSet rsSolar = CONN.createStatement().executeQuery(sqlSolar);
            
            while (rsTransaksi.next() && rsBahanBakar.next()) {
                switch (rsBahanBakar.getInt("id_jenis")) {
                    case 1 :
                    {
                        rsPertamax.absolute(1);
                        pmax = new Pertamax(rsTransaksi.getInt("Jumlah"));
                        data.add(new transaksi(rsTransaksi.getInt("id"),pmax));
                        break;
                    }
                    case 2 :{
                        rsPertalite.absolute(1);
                        plite = new Pertalite(rsTransaksi.getInt("Jumlah"));
                        data.add(new transaksi(rsTransaksi.getInt("id"),plite));
                        break;
                    }
                    case 3 :{
                        rsPremium.absolute(1);
                        pre = new Premium(rsTransaksi.getInt("Jumlah"));
                        data.add(new transaksi(rsTransaksi.getInt("id"),pre));
                        break;
                    }
                    case 4 :{
                        rsSolar.absolute(1);
                        bisol = new Solar(rsTransaksi.getInt("Jumlah"));
                        data.add(new transaksi(rsTransaksi.getInt("id"),bisol));
                        break;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PertaminiDataModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public int ID() throws SQLException {
        String sql = "SELECT MAX(id) from transaksi";
        ResultSet rs = CONN.createStatement().executeQuery(sql);
        while (rs.next()) {
            return rs.getInt(1) == 0 ? 1018001 : rs.getInt(1) + 1;
        }
        return 1018001;
    }
}
