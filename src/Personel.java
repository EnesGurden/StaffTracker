import java.time.LocalDateTime;

public class Personel {
    private int id;
    private String adSoyad;
    private LocalDateTime girisTarihi;
    private LocalDateTime cikisTarihi;

    // Default Constructor
    public Personel(String adSoyad, LocalDateTime girisTarihi, LocalDateTime cikisTarihi)
    {
        this.adSoyad = adSoyad;
        this.girisTarihi = girisTarihi;
        this.cikisTarihi = cikisTarihi;
    }

    public Personel(int id, String adSoyad, LocalDateTime girisTarihi, LocalDateTime cikisTarihi)
    {
        this.id = id;
        this.adSoyad = adSoyad;
        this.girisTarihi = girisTarihi;
        this.cikisTarihi = cikisTarihi;
    }

    // Getter and Setter
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getAdSoyad()
    {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad)
    {
        this.adSoyad = adSoyad;
    }

    public LocalDateTime getGirisTarihi()
    {
        return girisTarihi;
    }

    public void setGirisTarihi(LocalDateTime girisTarihi)
    {
        this.girisTarihi = girisTarihi;
    }

    public LocalDateTime getCikisTarihi()
    {
        return cikisTarihi;
    }

    public void setCikisTarihi(LocalDateTime cikisTarihi)
    {
        this.cikisTarihi = cikisTarihi;
    }

    @Override
    public String toString()
    {
        return "Personel{"
            + "id=" + id + ", adSoyad='" + adSoyad + '\'' + ", girisTarihi=" + girisTarihi
            + ", cikisTarihi=" + cikisTarihi + '}';
    }
}