CREATE TABLE snowboard_db.users (
	id serial NOT NULL,
	first_name varchar(255) NOT NULL,
	last_name varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	phone varchar(12) NOT NULL,
	user_name varchar(50) NOT NULL,
	password varchar(300) NOT NULL
);
