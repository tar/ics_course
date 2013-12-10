CREATE TABLE cities (
    id_city SERIAL PRIMARY KEY,
    name text NOT NULL,
	country text NOT NULL,
	UNIQUE(name,country)
);

CREATE TABLE users (
    login text PRIMARY KEY,
	password text NOT NULL,
    name text NOT NULL,
    surname text NOT NULL,
	email text NOT NULL,
	date_reg date NOT NULL,
	id_city integer REFERENCES cities ON DELETE RESTRICT
);

CREATE TABLE paintings(
	id_painting SERIAL PRIMARY KEY,
	user_login text NOT NULL REFERENCES users ON DELETE CASCADE ON UPDATE CASCADE,
	name text NOT NULL,
	date_added date NOT NULL,
	date_painted date,
	price money NOT NULL,
	rating integer NOT NULL
);

CREATE TABLE images(
	id_image SERIAL PRIMARY KEY,
	id_painting integer NOT NULL REFERENCES paintings ON DELETE CASCADE ON UPDATE CASCADE,
	path text NOT NULL
);

CREATE TABLE purchases(
	id_purchase SERIAL PRIMARY KEY,
	login_user text REFERENCES users ON DELETE SET NULL ON UPDATE CASCADE,
	id_painting integer REFERENCES paintings ON DELETE SET NULL ON UPDATE CASCADE,
	date_perchase date NOT NULL 
);

CREATE TABLE genres(
	id_ganre SERIAL PRIMARY KEY,
	name text NOT NULL UNIQUE
);

CREATE TABLE tags(
	id_tag SERIAL PRIMARY KEY,
	name text NOT NULL UNIQUE
);

CREATE TABLE styles(
	id_style SERIAL PRIMARY KEY,
	name text NOT NULL UNIQUE
);

CREATE TABLE painting_ganre(
	id_genre integer NOT NULL REFERENCES genres ON DELETE CASCADE ON UPDATE CASCADE,
	id_painting integer NOT NULL REFERENCES paintings ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT painting_ganre_pkey PRIMARY KEY (id_genre,id_painting)
);

CREATE TABLE painting_tag(
	id_tag integer NOT NULL REFERENCES tags ON DELETE CASCADE ON UPDATE CASCADE,
	id_painting integer NOT NULL REFERENCES paintings ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT painting_tag_pkey PRIMARY KEY (id_tag,id_painting)
);

CREATE TABLE painting_style(
	id_style integer NOT NULL REFERENCES styles ON DELETE CASCADE ON UPDATE CASCADE,
	id_painting integer NOT NULL REFERENCES paintings ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT painting_style_pkey PRIMARY KEY (id_style,id_painting)
);

/*Filling tables*/

insert into styles (name)
values 	('Реализм'),
		('Импрессионизм'),
		('Экспрессионизм'),
		('Сюрреализм'),
		('Абстракционизм'),
		('Символизм'),
		('Наивное искусство'),
		('Примитивизм'),
		('Модернизм'),
		('Постмодернизм'),
		('Авангардизм'),
		('Соцреализм'),
		('Романтизм'),
		('Леттризм'),
		('Фовизм');
		
insert into genres (name)
values 	('Пейзаж'),
		('Городской пейзаж'),
		('Морской пейзаж'),
		('Жанровая картина'),
		('Портрет'),
		('Натюрморт'),
		('Ню, обнаженная натура'),
		('Анималистика'),
		('Архитектура'),
		('Религия'),
		('Историческая живопись'),
		('Батальная живопись'),
		('Фантазия'),
		('Символическая композиция'),
		('Фигуратив');	

insert into cities (name,country)
values 	('Санкт-Петербург','Россия'),
		('Москва','Россия'),
		('Крыжопль','Россия');
		
insert into users (login, name, surname, email, password, date_reg, id_city)
values 	('togorot', 'Абдула', 'Свежадынный', 'kavkaz.sila@aul.kk', 'эээора', 'now', 3),
		('romashka', 'Юлия', 'Милая', 'duna.duna@cipa.ya', 'солнцемирлюбовь', 'now', 1),
		('king', 'Кир', 'Великий', 'azm.esm.car@mycastle.sky', 'силасомной', 'now', 1);
		