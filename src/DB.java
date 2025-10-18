import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB {
    private static String URL = "jdbc:mysql://localhost:3306/stafftracker_db";
    private static String USER = "root";
    private static String PASSWORD = "root123";

    private static Connection connection = null;

    public static Connection getConnection()
    {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            System.err.println("❌ Fail database connection!");
            e.printStackTrace();
        }
        return connection;
    }

    public static boolean insert(Personel personel)
    {
        String sql = "INSERT INTO personel (ad_soyad, giris_tarihi, cikis_tarihi) VALUES (?, ?, ?)";

        try {
            Connection conn = DB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, personel.getAdSoyad());

            if (personel.getGirisTarihi() != null) {
                pstmt.setTimestamp(2, java.sql.Timestamp.valueOf(personel.getGirisTarihi()));
            } else {
                pstmt.setDate(2, null);
            }

            if (personel.getCikisTarihi() != null) {
                pstmt.setTimestamp(3, java.sql.Timestamp.valueOf(personel.getCikisTarihi()));
            } else {
                pstmt.setDate(3, null);
            }
            
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            System.err.println("❌ Failed insert personel!");
            e.printStackTrace();
        }
        return false;
    }
}
