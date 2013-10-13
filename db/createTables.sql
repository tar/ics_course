CREATE TABLE cities (
    id_city SERIAL PRIMARY KEY,
    name text NOT NULL,
	country text NOT NULL
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
	image text NOT NULL,
	date_added date NOT NULL,
	date_painted date,
	price money NOT NULL,
	rating integer NOT NULL
);

CREATE TABLE purchases(
	id_purchase SERIAL PRIMARY KEY,
	login_user text REFERENCES users ON DELETE SET NULL ON UPDATE CASCADE,
	id_painting integer REFERENCES paintings ON DELETE SET NULL ON UPDATE CASCADE,
	date_perchase date NOT NULL 
);

CREATE TABLE genres(
	id_ganre SERIAL PRIMARY KEY,
	name text NOT NULL
);

CREATE TABLE tags(
	id_tag SERIAL PRIMARY KEY,
	name text NOT NULL
);

CREATE TABLE styles(
	id_style SERIAL PRIMARY KEY,
	name text NOT NULL
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