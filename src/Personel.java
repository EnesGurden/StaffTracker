import java.time.LocalDateTime;

public class Personel {
    private int id;
    private String adSoyad;
    private String kimlikNo;
    private String dogumTarihi;
    private String anneAdi;
    private String babaAdi;
    private LocalDateTime girisTarihi;
    private LocalDateTime cikisTarihi;

    public Personel(int id, String adSoyad, String kimlikNo, String dogumTarihi, String anneAdi, String babaAdi,
            LocalDateTime girisTarihi, LocalDateTime cikisTarihi) {
        this.id = id;
        this.adSoyad = adSoyad;
        this.kimlikNo = kimlikNo;
        this.dogumTarihi = dogumTarihi;
        this.anneAdi = anneAdi;
        this.babaAdi = babaAdi;
        this.girisTarihi = girisTarihi;
        this.cikisTarihi = cikisTarihi;
    }

    public Personel(String adSoyad, String kimlikNo, String dogumTarihi, String anneAdi, String babaAdi,
            LocalDateTime girisTarihi, LocalDateTime cikisTarihi) {
        this.adSoyad = adSoyad;
        this.kimlikNo = kimlikNo;
        this.dogumTarihi = dogumTarihi;
        this.anneAdi = anneAdi;
        this.babaAdi = babaAdi;
        this.girisTarihi = girisTarihi;
        this.cikisTarihi = cikisTarihi;
    }

    // Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getKimlikNo() {
        return kimlikNo;
    }

    public void setTcKimlikNo(String kimlikNo) {
        this.kimlikNo = kimlikNo;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getAnneAdi() {
        return anneAdi;
    }

    public void setAnneAdi(String anneAdi) {
        this.anneAdi = anneAdi;
    }

    public String getBabaAdi() {
        return babaAdi;
    }

    public void setBabaAdi(String babaAdi) {
        this.babaAdi = babaAdi;
    }

    public LocalDateTime getGirisTarihi() {
        return girisTarihi;
    }

    public void setGirisTarihi(LocalDateTime girisTarihi) {
        this.girisTarihi = girisTarihi;
    }

    public LocalDateTime getCikisTarihi() {
        return cikisTarihi;
    }

    public void setCikisTarihi(LocalDateTime cikisTarihi) {
        this.cikisTarihi = cikisTarihi;
    }

    @Override
    public String toString() {
        return "Personel{"
                + "id=" + id + ", adSoyad='" + adSoyad + '\'' + ", girisTarihi=" + girisTarihi
                + ", cikisTarihi=" + cikisTarihi + '}';
    }
}