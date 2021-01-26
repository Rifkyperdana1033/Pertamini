/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pertaminifx;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * *
 *
 * @author ACER
 **
 */
public class Main extends Application {

    TableView tabel = new TableView();
    ObservableList<transaksi> Data = FXCollections.observableArrayList();
    TextField Harga;
    ComboBox Jenis = new ComboBox();
    ArrayList id_jenis = new ArrayList();
    Label judul;
    transaksi trs;
    PertaminiDataModel PDM;
    int id = 0;

    @Override
    public void start(Stage primaryStage) {
        try {
            PDM = new PertaminiDataModel ("MYSQL");
                Data = PDM.getData();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        judul = new Label();
        judul.setText("Pertamini");
        judul.setMinHeight(5);
        judul.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Harga = new TextField();
        Harga.setPromptText("Input Banyak");

        Jenis.setPromptText("Jenis");
        id_jenis.add(" ");
        Jenis.getItems().add("Pertamax");
        id_jenis.add("Pertamax");
        Jenis.getItems().add("Pertalite");
        id_jenis.add("Pertalite");
        Jenis.getItems().add("Premium");
        id_jenis.add("Premium");
        Jenis.getItems().add("Bio Solar");
        id_jenis.add("Bio Solar");

        Button btn = new Button();
//        keluar = Double.parseDouble(Liter.getText()) /9200;

        btn.setText("input");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    id = PDM.ID();
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                int jns = id_jenis.indexOf(Jenis.getValue().toString());
                switch (jns) {
                    case 1: {
                        trs = new transaksi(id, new Pertamax(Integer.parseInt(Harga.getText())));
                        break;
                    }
                    case 2: {
                        trs = new transaksi(id, new Pertalite(Integer.parseInt(Harga.getText())));
                        break;
                    }
                    case 3: {
                        trs = new transaksi(id, new Premium(Integer.parseInt(Harga.getText())));
                        break;
                    }
                    case 4: {
                        trs = new transaksi(id, new Solar(Integer.parseInt(Harga.getText())));
                        break;
                    }
                    default : {
                        break;
                    } 
                }
                
                Data.add(trs);
                try {
                    PDM.inputData(trs);
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                Harga.clear();
                Jenis.setValue(null);
            }
        });

        TableColumn colID = new TableColumn("ID");
        colID.setCellValueFactory(new PropertyValueFactory<transaksi, String>("ID"));
        colID.setMinWidth(100);

        TableColumn colJenis = new TableColumn("Jenis");
        colJenis.setCellValueFactory(new PropertyValueFactory<transaksi, String>("Nama"));
        colJenis.setMinWidth(100);

        TableColumn colLiter = new TableColumn("Liter");
        colLiter.setCellValueFactory(new PropertyValueFactory<transaksi, String>("Liter"));
        colLiter.setMinWidth(100);

        TableColumn colHarga = new TableColumn("Harga per Liter");
        colHarga.setCellValueFactory(new PropertyValueFactory<transaksi, String>("Harga"));
        colHarga.setMinWidth(100);
        
        TableColumn colBanyak = new TableColumn("Jumlah");
        colBanyak.setCellValueFactory(new PropertyValueFactory<transaksi, String>("Banyak"));
        colBanyak.setMinWidth(100);

        tabel.setItems(Data);
        tabel.getColumns().setAll(colID,colJenis,colLiter,colBanyak,colHarga);
        VBox tab = new VBox(1);
        VBox form = new VBox(10);
        HBox root = new HBox(5);
        root.getChildren().addAll(tab, form);
        tab.getChildren().addAll(tabel);
        form.getChildren().addAll(judul, Jenis, Harga, btn);

        Scene scene = new Scene(root);

        primaryStage.setTitle("Pertamini");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
