select * from stafftracker_db.personel;

delete from personel where id>2;

insert into stafftracker_db.personel values(3,'Arda Turan',NULL,'2025.10.17 12:15:30');

drop table stafftracker_db.personel;

-- AUTO_INCREMENT değerini sıfırla
ALTER TABLE personel AUTO_INCREMENT = 4;



CREATE DATABASE hastane_db;
USE hastane_db;

CREATE TABLE personel (
    id INT PRIMARY KEY AUTO_INCREMENT,
    ad_soyad VARCHAR(100) NOT NULL,
    giris_tarihi DATETIME,
    cikis_tarihi DATETIME
);