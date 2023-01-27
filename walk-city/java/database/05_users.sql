-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER walk_city_owner
WITH PASSWORD 'walk_city_pass';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO walk_city_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO walk_city_owner;

CREATE USER walk_city_appuser
WITH PASSWORD 'walk_city_pass';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO walk_city_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO walk_city_appuser;
