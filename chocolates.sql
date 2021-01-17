CREATE database if not exists chocolates;
USE chocolates;
DROP table if exists chocolate_profiles;

CREATE table chocolate_profiles (
	id INT(3) not null auto_increment,
	type VARCHAR(25) not null,
	cacao_solids_percent INT(3) not null,
	sugar_percent INT(3) not null,
	dairy VARCHAR(3) not null,
	vanilla VARCHAR(3) not null,
	primary key(id)
);

INSERT INTO chocolate_profiles values
	(1, "unsweetened chocolate", 100, 0, "N", "N"),
	(2, "dark chocolate", 71, 29, "N", "N"),
	(3, "bittersweet chocolate", 70, 30, "N", "N"),
	(4, "semi-sweet chocolate", 60, 40, "N", "N"),
	(5, "milk chocolate", 40, 60, "Y", "Y"),
	(6, "white chocolate", 0, 20, "Y", "Y");