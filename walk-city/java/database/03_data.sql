
-- insert users table data
INSERT INTO users (user_id, username,password_hash,role) VALUES (1, 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (user_id, username,password_hash,role) VALUES (2, 'admin', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (user_id, username,password_hash,role) VALUES (3, 'daniel', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (user_id, username,password_hash,role) VALUES (4, 'emma', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (user_id, username,password_hash,role) VALUES (5, 'patricia', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (user_id, username,password_hash,role) VALUES (6, 'hong', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
ALTER SEQUENCE seq_user_id RESTART WITH 7;

INSERT INTO locations(location_name, category, latitude, longitude, address, description, availability, image, social_media)
                VALUES ('Bistro Romano', 'Restaurant', '39.94211562', '-75.14463326', '120 Lombard St Society Hill, Philadelphia, PA 19147-1602', '215-925-8880', '', '', 'https://bistroromano.com'),
                       ('Reading Terminal Market', 'Restaurant', '39.95388019', '-75.15850409', '12th and Arch Sts., Philadelphia, PA 19107', '215-922-2317', '', '', 'https://readingterminalmarket.org'),
                       ('Hershel''s East Side Deli', 'Restaurant', '39.95342564', '-75.15891542', '51 N 12th St, Philadelphia, PA 19107-2902', '215-922-6220', '', '', 'https://facebook.com/HershelsEastSideDeli'),
                       ('The Original Turkey', 'Restaurant', '39.95386374', '-75.1584719', '45 N 12th St, Philadelphia, PA 19107-2902', '215-925-5598', '', '', 'https://theoriginalturkey.com'),
                       ('Dutch Eating Place', 'Restaurant', '39.95391481', '-75.15897608', '1136 Arch St, Philadelphia, PA 19107-2956', '215-922-0425', '', '', 'https://readingterminalmarket.org/merchant/dutch-eating-place'),
                       ('Zahav', 'Restaurant', '39.94638133', '-75.14503766', '237 St. James Place, Philadelphia, PA 19106-3936', '215-625-8800', '', '', 'https://zahavrestaurant.com'),
                       ('Vetri Cucina', 'Restaurant', '39.94687393', '-75.16312356', '1312 Spruce St, Philadelphia, PA 19107-5885', '215-732-3478', '', '', 'https://vetricucina.com'),
                       ('The Franklin Fountain', 'Restaurant', '39.94983155', '-75.142919', '116 Market St, Philadelphia, PA 19106-3099', '215-627-1899', '', '', 'https://franklinfountain.com'),
                       ('Morimoto', 'Restaurant', '39.94980905', '-75.15326427', '723 Chestnut St, Philadelphia, PA 19106-2301', '215-413-9070', '', '', 'https://morimotorestaurant.com'),
                       ('Amada', 'Restaurant', '39.94887705', '-75.14492519', '217-219 Chestnut St, Philadelphia, PA 19106-2812', '215-398-6968', '', '', 'https://amadarestaurant.com'),
                       ('Eastern State Penitentiary', 'Museum', '39.96849261', '-75.17272918', '2027 Fairmount AvenuePhiladelphia, PA 19130', '215-236-3300', '', '', 'https://easternstate.org'),
                       ('Philadelphia Museum of Art', 'Museum', '39.96570947', '-75.18020435', '2600 Benjamin Franklin Parkway, Philadelphia, PA 19130', '215-763-8100', '', '', 'https://philamuseum.org'),
                       ('Barnes Foundation', 'Museum', '39.96074196', '-75.17285042', '2025 Benjamin Franklin Parkway, Philadelphia, PA 19130', '215-278-7000', '', '', 'https://barnesfoundation.org'),
                       ('Rodin Museum', 'Museum', '39.96216166', '-75.1739579', '2151 Benjamin Franklin Parkway, Philadelphia, PA 19130', '215-763-8100', '', '', 'https://rodinmuseum.org'),
                       ('Museum of the American Revolution', 'Museum', '39.94845188', '-75.14543284', '101 South Third Street, Philadelphia, PA 19106', '215-253-6731', '', '', 'https://amrevmuseum.org'),
                       ('Philadelphia''s Magic Gardens', 'Museum', '39.94299385', '-75.15890761', '1020 South Street, Philadelphia, PA 19147', '215-733-0390', '', '', 'https://phillymagicgardens.org'),
                       ('The Franklin Institute', 'Museum', '39.95838358', '-75.17308106', '222 North 20th Street, Philadelphia, PA 19103', '215-448-1200', '', '', 'https://fi.edu'),
                       ('Weitzman National Museum of American Jewish History', 'Museum', '39.95039142', '-75.14838368', '101 S Independence Mall E, Philadelphia, PA 19106-2517', '215-923-3811', '', '', 'https://theweitzman.org'),
                       ('National Constitution Center', 'Museum', '39.95387641', '-75.14883765', '525 Arch Street, Philadelphia, PA 19106', '215-409-6600', '', '', 'https://constitutioncenter.org'),
                       ('Please Touch Museum', 'Museum', '39.97965258', '-75.20841744', '4231 Avenue of the Republic Ave Memorial Hall, Philadelphia, PA 19131-3719', '215-581-3181', '', '', 'https://pleasetouchmuseum.org'),
                       ('Spin Philadelphia', 'Bar', '39.9493597', '-75.16601085', '211 S 15th St Philadelphia, PA 19102', '267-463-4850', '', '', 'https://wearespin.com'),
                       ('Graffiti bar', 'Bar', '39.94963003', '-75.16223866', '124 S 13th St Sampan Restaurant Philadelphia, PA 19107', '215-732-3501', '', '',  'https://sampanphilly.com/graffiti-bar'),
                       ('Oscar''s Tavern', 'Bar', '39.95030233', '-75.16675276', '1524 Sansom St Philadelphia, PA 19102', '215-972-9938', '', '', 'https://oscarstavernphiladelphia.mybistro.online/'),
                       ('Harper''s Garden', 'Bar', '39.95253202', '-75.16994273', '31 S 18th St Philadelphia, PA 19103', '267-886-8552', '', '', 'https://harpersgardenphilly.com'),
                       ('Hop Sing Laundromat', 'Bar', '39.95582246', '-75.1567964', '1029 Race St Philadelphia, PA 19107', '', '', '', 'https://www.yelp.com/biz/hop-sing-laundromat-philadelphia'),
                       ('Attico Rooftop Lounge', 'Bar', '39.94877543', '-75.16369375', '219 S Broad St Rooftop of Cambria Hotel Philadelphia, PA 19107', '267-536-5725', '', '', 'https://atticorooftop.com'),
                       ('Prohibition Taproom', 'Bar', '39.96142108', '-75.15873239', '501 N 13th St Philadelphia, PA 19123', '215-238-1818', '', '', 'https://prohibitiontaproom.com'),
                       ('Charlie was a sinner', 'Bar', '39.94966655', '-75.16129953', '131 S 13th St Philadelphia, PA 19107', '267-758-5372', '', '', 'https://charliewasasinner.com'),
                       ('City Tap House', 'Bar', '39.95684692', '-75.1659993', '100 N18th St Logan Square Philadelphia, PA 19103', '215-587-9040', '', '', 'https://citytap.com'),
                       ('Writer''s Block Rehab', 'Bar', '39.94653188', '-75.16335394', '1342 Cypress St Philadelphia, PA 19107', '267-534-3134', '', '', 'https://writersblockrehabphiladelphia.bestcafes.online'),
                       ('Dilworth Park', 'Park', '39.95323307', '-75.1646092', '1 S 15th St, Philadelphia, PA 19102', '215-440-5500', '', '', 'https://centercityphila.org/parks/dilworth-park'),
                       ('Franklin Square', 'Park', '39.95584431', '-75.15051458', '200 N 6th St, Philadelphia, PA 19106', '215-629-4026', '', '', 'https://historicphiladelphia.org/franklin-square'),
                       ('Independence National Historial Park', 'Park', '39.9495537', '-75.14946364', 'Philadelphia, PA 19106', '215-965-2305', '', '', 'https://nps.gov/inde/index.htm'),
                       ('Rittenshouse Square', 'Park', '39.94961013', '-75.17163401', '1800 Walnut St, Philadelphia, PA 19103', '267-586-5675', '', '', 'https://friendsofrittenhouse.org'),
                       ('Washington Square', 'Park', '39.94713238', '-75.15171426', '210 W Washington Square, Philadelphia, PA 19106', '215-597-8787', '', '', 'https://nps.gov/inde/learn/historyculture/places-washingtonsquare.htm'),
                       ('Race Street Pier & Cherry Street Pier', 'Park', '39.95329592', '-75.1385762', 'N Christopher Columbus Blvd, Philadelphia, PA 19106', '215-922-2386', '', '', 'https://delawareriverwaterfront.com/places/race-street-pier'),
                       ('Bartram''s Garden', 'Park', '39.93291695', '-75.21176517', '5400 Lindbergh Blvd., Philadelphia, PA 19143', '215-729-5281', '', '', 'https://bartramsgarden.org'),
                       ('Schuylkill Banks Boardwalk', 'Park', '39.94726993', '-75.18363428', 'Schuylkill Banks Boardwalk, Philadelphia, PA 19103', '', '', '', 'https://schuylkillbanks.org/projects/boardwalk'),
                       ('Love Park', 'Park', '39.95437767', '-75.16513672', 'Arch St, Philadelphia, PA 19102', '215-686-1776', '', '', 'https://locations.phila.gov/love-park/'),
                       ('Independence Blue Cross RiverRink', 'Park', '39.94806343', '-75.13916897', '101 S Christopher Columbus Blvd, Philadelphia, PA 19106', '215-925-7465', '', '', 'https://riverrink.com');



INSERT INTO badges (badge_name, description)
                VALUES ('Defender of the Land', 'for visiting every location'),
                       ('Bar Hopper', 'for visiting minimum 5 bars and/or restaurants'),
                       ('History Lover', 'for visiting minimum 5 museums'),
                       ('Tree Hugger', 'for visiting minimum 5 parks');
