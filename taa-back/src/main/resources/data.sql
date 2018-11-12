TRUNCATE place;
TRUNCATE sport;

LOAD DATA LOCAL INFILE '/home/mj/taa-workspace/taa/taa-back/src/main/resources/cities.csv'
INTO TABLE place
FIELDS TERMINATED BY ','
    ENCLOSED BY '"'
LINES TERMINATED BY '\n'
(id, item_name);

LOAD DATA LOCAL INFILE '/home/mj/taa-workspace/taa/taa-back/src/main/resources/sports.csv'
INTO TABLE sport
FIELDS TERMINATED BY ','
    ENCLOSED BY '"'
LINES TERMINATED BY '\n'
(id, item_name, covered);