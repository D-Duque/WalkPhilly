-- The following line terminates any active connections to the database so that it can be dropped
SELECT pg_terminate_backend(pid) 
FROM pg_stat_activity 
WHERE datname = 'walk_city';

DROP DATABASE IF EXISTS walk_city;

DROP USER IF EXISTS walk_city_owner;
DROP USER IF EXISTS walk_city_appuser;

-- then create the database
CREATE DATABASE walk_city;
