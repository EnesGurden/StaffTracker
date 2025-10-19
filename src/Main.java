import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        List<Personel> personelList = new ArrayList<>();

        try {
            personelList = DB.selectAll();
            for (Personel p : personelList) {
                System.out.println("ID: " + p.getId() + ", Ad Soyad: " + p.getAdSoyad() + ", Giriş: " + p.getGirisTarihi() + ", Çıkış: " + p.getCikisTarihi());
            }
        } catch (SQLException e) {
            System.err.println("❌ SQL hatası: " + e.getMessage());
        }
    }
}