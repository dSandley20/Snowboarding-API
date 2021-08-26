CREATE TABLE public.location_comments (
	id serial NOT NULL,
	location_id int NOT NULL,
	"content" varchar(255) NULL,
	CONSTRAINT location_comments_pk PRIMARY KEY (id),
	CONSTRAINT location_comments_fk FOREIGN KEY (location_id) REFERENCES public.locations(id) ON DELETE CASCADE
);
