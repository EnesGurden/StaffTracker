import java.sql.*;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args)
    {
        Connection conn = DB.getConnection();

        if (conn != null) {
            try {
                //                Personel Ali = new Personel("Ali", null, LocalDateTime.now());
                //                DB.insert(Ali);
                // Personel Ahmet = new Personel("Ahmet", LocalDateTime.now(), null);
                // DB.insert(Ahmet);

                DB.deleteId(23);

                DB.getConnection();
                String sql = "SELECT * FROM personel";
                PreparedStatement statement = conn.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String adSoyad = rs.getString("ad_soyad");
                    Timestamp girisTarihi = rs.getTimestamp("giris_tarihi");
                    Timestamp cikisTarihi = rs.getTimestamp("cikis_tarihi");
                    System.out.println("ID: " + id + ", Ad: " + adSoyad + ", Giriş: " + girisTarihi + ", Çıkış: " + cikisTarihi);
                }
            } catch (SQLException e) {
                System.err.println("❌ SQL hatası: " + e.getMessage());
            }
        }
    }
}