-- add database constraints here - such as foreign key constraints
-- very common to add constraints AFTER bulk loading data

--user_location table
ALTER TABLE user_location
ADD CONSTRAINT FK_user_id
FOREIGN KEY (user_id)
REFERENCES users(user_id);

ALTER TABLE user_location
ADD CONSTRAINT FK_location_id
FOREIGN KEY (location_id)
REFERENCES locations(location_id);

--user_badge table
ALTER TABLE user_badge
ADD CONSTRAINT FK_user_id
FOREIGN KEY (user_id)
REFERENCES users(user_id);

ALTER TABLE user_badge
ADD CONSTRAINT FK_badge_id
FOREIGN KEY (badge_id)
REFERENCES badges(badge_id);
