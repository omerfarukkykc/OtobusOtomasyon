use otobusotomasyon;
DELIMITER //
CREATE PROCEDURE GetMusteriler()
BEGIN 
	SELECT *  FROM musteriler;
END //
CREATE PROCEDURE GetMusteri(IN id INT)
BEGIN 
	SELECT *  FROM musteriler WHERE musteri_ID = id;
END //
CREATE PROCEDURE GetIller()
BEGIN 
	SELECT *  FROM iller;
END //
CREATE PROCEDURE GetIlceler(IN ilid INT)
BEGIN 
	SELECT *  FROM ilceler where il_ID = ilid;
END //
CREATE PROCEDURE GetSeferler(IN basla DATETIME,IN bitir DATETIME,IN kid INT,IN vid INT)
BEGIN 
	SELECT *  FROM seferler WHERE kalkisTarih BETWEEN basla and bitir AND kalkisYer_ID = kid AND varisYer_ID = vid;
END //
CREATE PROCEDURE GetYolcular(IN id INT)
BEGIN 
	SELECT *  FROM biletler WHERE seferID = id;
END //
CREATE PROCEDURE GetBilet(IN id INT)
BEGIN 
	SELECT *  FROM biletler WHERE bilet_ID = id;
END //

CREATE PROCEDURE GetKoltuklar(IN id INT)
BEGIN 
	SELECT * FROM koltuklar LEFT JOIN biletler ON koltuklar.koltuk_ID = biletler.koltuk_ID WHERE (SELECT otobus_ID  FROM seferler WHERE sefer_ID = id);
END //


CREATE PROCEDURE AddBilet(IN SEFER_ID INT,IN fiyat INT,IN koltuk_ID INT,IN musteri_ID INT)
BEGIN 
	INSERT INTO biletler (seferID, fiyat, koltuk_ID,musteri_ID) VALUES(SEFER_ID,fiyat,koltuk_ID,musteri_ID);
END //
CREATE PROCEDURE DelBilet(IN id INT)
BEGIN 
	DELETE FROM biletler WHERE bilet_ID = id;
END //



CREATE PROCEDURE AddMusteri(IN ADI VARCHAR(50),IN SOYADI VARCHAR(50),IN TC VARCHAR(50),IN HESKODU VARCHAR(50), IN CINSIYET enum('KADIN', 'ERKEK'))
BEGIN 
	INSERT INTO musteriler (adi,soyadi,tc,hesKodu,cinsiyeti) VALUES(ADI,SOYADI,TC,HESKODU,CINSIYET);
END //
CREATE PROCEDURE DelMusteri(IN id INT)
BEGIN 
	DELETE FROM musteriler WHERE musteri_ID = id;
END //

CREATE PROCEDURE AddOtobus(IN PLAKA VARCHAR(50),IN KOLTUK_SAYISI INT)
BEGIN 
	declare a INT default 0;
	INSERT INTO otobusler (plaka,koltukSayisi) VALUES(PLAKA,KOLTUK_SAYISI);
	loop_label: LOOP
		 IF a >= KOLTUK_SAYISI THEN
            LEAVE loop_label;
         END IF;
         SET a=a+1;
         INSERT INTO koltuklar (arac_ID,koltukNumarası) VALUES((SELECT MAX(otobus_ID) FROM otobusler),a);
		ITERATE loop_label;
	END LOOP;
END //
CREATE PROCEDURE DelOtobus(IN id INT)
BEGIN 
	DELETE FROM otobusler WHERE otobus_ID = id;
	DELETE FROM koltuklar WHERE arac_ID = id;
END //
CREATE PROCEDURE GetOtobusler()
BEGIN 
	SELECT * FROM otobusler;
END //

CREATE PROCEDURE AddVoyage(IN bs DATETIME,IN bt DATETIME,IN bid INT,IN bsid INT,IN oid INT)
BEGIN 
	INSERT INTO seferler (kalkisTarih,varisTarih,kalkisYer_ID,varisYer_ID,otobus_ID) values (bs,bt,bid,bsid,oid);
END //
CREATE PROCEDURE UpBiletbiletler(IN id INT,IN sid INT,IN fiyat INT,IN koltuk_ID INT,IN musteri_ID INT)
BEGIN 
	UPDATE biletler SET seferID = sid, fiyat = fiyat, koltuk_ID = koltuk_ID,musteri_ID = musteri_ID WHERE bilet_ID = id;
END //

CREATE PROCEDURE DelVoyage(IN id INT)
BEGIN 
	DELETE FROM seferler WHERE sefer_ID = id;
    DELETE FROM biletler WHERE seferID = id;
END //



DELIMITER ;