#!/bin/bash
export PGPASSWORD='postgres1'

DATABASE=walk_city

psql -U postgres -f "./01_createdb.sql" &&
psql -U postgres -d $DATABASE -f "./02_schema.sql"  &&
psql -U postgres -d $DATABASE -f "./03_data.sql"  &&
psql -U postgres -d $DATABASE -f "./04_constraints.sql"  &&
psql -U postgres -d $DATABASE -f "./05_users.sql"
