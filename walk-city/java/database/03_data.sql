
-- insert users table data
INSERT INTO users (user_id, username,password_hash,role) VALUES (1, 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (user_id, username,password_hash,role) VALUES (2, 'admin', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
ALTER SEQUENCE seq_user_id RESTART WITH 3;

-- insert ??? table data

INSERT INTO locations(location_name, category, latitude, longitude, address, description, availability, image, social_media)
                VALUES ('Bistro Romano', 'Restaurant', '39.94211562', '-75.14463326', '120 Lombard St Society Hill, Philadelphia, PA 19147-1602', '215-925-8880', 'bistroromano.com'),
                       ('Reading Terminal Market', 'Restaurant', '39.95388019', '-75.15850409', '12th and Arch Sts., Philadelphia, PA 19107', '215-922-2317', 'predeterminations.org'),
                       ('Eastern State Penitentiary', 'Museum', '39.96849261', '-75.17272918', '2027 Fairmount AvenuePhiladelphia, PA 19130', '215-236-3300', 'easternstate.org'),
                       ('Philadelphia Museum of Art', 'Museum', '39.96570947', '-75.18020435', '2600 Benjamin Franklin Parkway, Philadelphia, PA 19130', '215-763-8100', 'philamuseum.org'),
                       ('Spin Philadelphia', 'Bar', '39.9493597', '-75.16601085', '211 S 15th St Philadelphia, PA 19102', '267-463-4850', 'wearespin.com'),
                       ('Graffiti bar', 'Bar', '39.94963003', '-75.16223866', '124 S 13th St Sampan Restaurant Philadelphia, PA 19107', '215-732-3501', 'sampanphilly.com/graffiti-bar'),
                       ('Dilworth Park', 'Park', '39.95323307', '-75.1646092', '1 S 15th St, Philadelphia, PA 19102', '215-440-5500', 'dilworthpark.org'),
                       ('Franklin Square', 'Park', '39.95584431', '-75.15051458', '200 N 6th St, Philadelphia, PA 19106', '215-629-4026', 'historicphiladelphia.org/franklin-square');


