DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

-- Add seed data in the 03_data.sql script file
CREATE TABLE locations (
    location_id SERIAL NOT NULL PRIMARY KEY,
    location_name varchar(150) NOT NULL,
    category varchar(50) NOT NULL,
    latitude varchar(50) NOT NULL,
    longitude varchar(50) NOT NUll,
    address varchar(250) NOT NULL,
    description varchar(500) NOT NULL,
    availability varchar(500),
    image varchar(100),
    social_media varchar(100) NOT NULL
)
-- Add Foreign key constraints in the 04_constraints.sql script file
