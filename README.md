# StaffTracker

#  StaffTracker - Personel Giriş-Çıkış Takip Sistemi

Personel giriş ve çıkış saatlerini takip eden Java Swing uygulaması.

##  Özellikler
- ✅ Personel giriş kaydı
- ✅ Personel çıkış kaydı  
- ✅ Giriş-çıkış loglarını görüntüleme
- ✅ MySQL veritabanı entegrasyonu

##  Teknolojiler
- Java
- Swing (GUI)
- MySQL
- JDBC

## Kurulum

### Gereksinimler
- JDK 8+
- MySQL 8.0+
- MySQL Connector/J

### Veritabanı Kurulumu
```sql
CREATE DATABASE stafftracker_db;
USE stafftracker_db;

CREATE TABLE personel (
    id INT PRIMARY KEY AUTO_INCREMENT,
    ad_soyad VARCHAR(100) NOT NULL,
    giris_tarihi DATETIME,
    cikis_tarihi DATETIME
);
```

### Projeyi Çalıştırma
1. Projeyi klonlayın:
```bash
   git clone https://github.com/EnesGurden/StaffTracker.git
```
2. Eclipse'de açın
3. MySQL Connector JAR'ı ekleyin
4. `DB.java`'da veritabanı bilgilerini güncelleyin
5. `gui.java`'yı çalıştırın


## Geliştirici
Enes Gürden