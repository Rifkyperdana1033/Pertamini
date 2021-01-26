# Nama Anggota
- RifkyPerdanaPutra 1807051033
- Berdo Nagoya 1807051024

# Final Project PBO

'SI Pertamini' merupakan Sistem Informasi yang dapat digunakan untuk menginput data Penjualan UMKM Pertamini.
### Class Diagram
```mermaid
classDiagram
    transaksi -- BahanBakar
    BahanBakar <|-- pertamax
    BahanBakar <|-- pertalite
    BahanBakar <|-- premium
    BahanBakar <|-- solar

    class transaksi{
        +int id
        +BahanBakar bb
        +getID() int
    }
    class BahanBakar{
        <<abstract>>
        +String nama
        +int harga
        +double Liter
        +int banyak
        +int id_jenis
        +setNama(String nama)
        +setHarga(int harga)
        +setLiter(double liter)
        +setIdjenis(int id)
        +getNama() String
        +getHarga() int
        +getLiter() double
        +getBanyak() int
        +getIdJenis() int
        +hitungLiter()*
    }
    class pertamax{
        +hitungLiter()
    }
    class pertalite{
        +hitungLiter()
    }
    class premium{
        +hitungLiter()
    }
    class solar{
        +hitungLiter()
    }
```

### ER Diagram
```mermaid
erDiagram
          transaksi }|..|{ BahanBakar : to
          BahanBakar ||--|| pertamax : is
          BahanBakar ||--|| pertalite : is
          BahanBakar ||--|| premium : is
          BahanBakar ||--|| solar : is
          
    transaksi{
        int id
        BahanBakar bb
    }
    BahanBakar{
        String nama
        int harga
        double Liter
        int banyak
        int id_jenis
    }
    ```
