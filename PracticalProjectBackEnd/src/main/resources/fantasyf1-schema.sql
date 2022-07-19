DROP TABLE IF EXISTS `fantasyf1` CASCADE;
create table `fantasyf1` (
	`id` INTEGER UNIQUE PRIMARY KEY AUTO_INCREMENT,
	`team_principle` VARCHAR(30) NOT NULL, 
	`engine_provider` VARCHAR(30) NOT NULL,
	`team_name` VARCHAR(30) NOT NULL, 
	`driver_one` VARCHAR(30) NOT NULL,
	`driver_two` VARCHAR(30) NOT NULL,
);