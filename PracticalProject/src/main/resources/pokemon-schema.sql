DROP TABLE IF EXISTS `pokemon` CASCADE;
create table `pokemon` (
	`id` INTEGER UNIQUE PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(30) NOT NULL, 
	`type` VARCHAR(30) NOT NULL,
	`species` VARCHAR(30) NOT NULL, 
	`health` INTEGER NOT NULL,
	`attack` INTEGER NOT NULL,
	`defense` INTEGER NOT NULL
);