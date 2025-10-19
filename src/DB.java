import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
            System.err.println("❌ Database connection fail!");
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
            System.err.println("❌ Insert Fail!");
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteId(int id)
    {
        String sql = "DELETE FROM personel WHERE id = ?";
        try {
            Connection conn = DB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("❌ Delete fail!");
            e.printStackTrace();
        }
        return false;
    }

    public static List<Personel> selectAll() throws SQLException
    {
        String sql = "SELECT * FROM personel";
        try {
            Connection conn = DB.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            List<Personel> personelList = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String adSoyad = rs.getString("ad_soyad");
                LocalDateTime girisTarihi = (rs.getTimestamp("giris_tarihi") != null) ? rs.getTimestamp("giris_tarihi").toLocalDateTime() : null;
                LocalDateTime cikisTarihi = (rs.getTimestamp("cikis_tarihi") != null) ? rs.getTimestamp("cikis_tarihi").toLocalDateTime() : null;
                Personel temp = new Personel(id, adSoyad, girisTarihi, cikisTarihi);
                personelList.add(temp);
            }
            return personelList;
        } catch (SQLException e) {
            System.err.println("❌ Select Fail!");
            e.printStackTrace();
            return null;
        }
    }
}
