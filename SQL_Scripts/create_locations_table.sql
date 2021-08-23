CREATE TABLE snowboard_db.locations (
	id serial NOT NULL,
	"name" varchar(255) NOT NULL,
	country varchar(255) NOT NULL,
	state varchar(255) NULL,
	city varchar(255) NULL,
	zipcode varchar(11) NULL
);
