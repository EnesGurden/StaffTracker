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
                //                 Personel Ahmet = new Personel("Ahmet", LocalDateTime.now(), null);
                //                 DB.insert(Ahmet);

                //                DB.deleteId(4);

                DB.selectAll();
            } catch (SQLException e) {
                System.err.println("❌ SQL hatası: " + e.getMessage());
            }
        }
    }
}