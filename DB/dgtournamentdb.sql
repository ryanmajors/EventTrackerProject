-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema dgtournamentdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `dgtournamentdb` ;

-- -----------------------------------------------------
-- Schema dgtournamentdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dgtournamentdb` DEFAULT CHARACTER SET utf8 ;
USE `dgtournamentdb` ;

-- -----------------------------------------------------
-- Table `tournament`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tournament` ;

CREATE TABLE IF NOT EXISTS `tournament` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(150) NOT NULL,
  `tier` VARCHAR(45) NOT NULL,
  `location` VARCHAR(45) NOT NULL,
  `month` INT NOT NULL,
  `year` INT NULL,
  `multi_day` TINYINT NOT NULL,
  `days` INT NULL,
  `players` INT NULL,
  `entry_fee` DECIMAL(4,2) NULL,
  `placement` INT NULL,
  `points` INT NULL,
  `hidden` TINYINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS dguser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'dguser'@'localhost' IDENTIFIED BY 'dguser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'dguser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `tournament`
-- -----------------------------------------------------
START TRANSACTION;
USE `dgtournamentdb`;
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (1, 'Winter Fling Presented by Mile High Disc Golf Club', 'C', 'Arvada', 03, 2018, 0, 1, 31, 55.00, 24, 40, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (2, 'Aviary Fools - 2018', 'C', 'Colorado Springs', 04, 2018, 0, 1, 18, 55.00, 7, 60, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (3, '2018 Stake Your Claim', 'C', 'Sterling', 04, 2018, 1, 2, 15, 65.00, 9, 35, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (4, '2018 Cottonwood Classic', 'C', 'Fort Morgan', 04, 2018, 0, 1, 21, 65.00, 13, 45, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (5, 'Cinco! Cinco!', 'B', 'Woodland Park', 05, 2018, 1, 2, 31, 99.00, 5, 202.5, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (6, 'NGT Qualifier R5 - Adam\'s Hollow', 'C', 'Brighton', 05, 2018, 0, 1, 7, 35.00, 2, 30, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (7, 'Gazebo at the Hollow', 'C', 'Brighton', 06, 2018, 0, 1, 23, 45.00, 11, 65, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (8, 'High Plains Challenge', 'A', 'Fort Morgan', 06, 2018, 1, 3, 34, 99.00, 24, 110, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (9, 'Colorado State Championships - 25th PDGA Anniversary - AMS', 'B', 'Woodland Park', 07, 2018, 1, 2, 44, 95.00, 20, 187.5, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (10, '2018 Mile High Classic - Ams', 'C', 'Henderson', 09, 2018, 0, 1, 22, 55.00, 7, 80, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (11, '2018 Next Generation Tour National Championships', 'A', 'Fountain Hills', 11, 2018, 1, 3, 80, 9.00, 54, 270, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (12, 'St. Patty\'s Day Meltdown 2019', 'B', 'Fort Collins', 03, 2019, 1, 2, 32, 85.00, 30, 22.5, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (13, 'The 303 Open-Amateur Edition', 'B', 'Federal Heights', 04, 2019, 1, 2, 67, 85.00, 49, 142.5, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (14, '2019 Dynamic Discs Glass Blown Open A-Tier (Age-Protected Pros and All Amateurs)', 'A', 'Emporia', 04, 2019, 1, 3, 315, 99.00, 134, 1820, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (15, 'How the West Was Won', 'C', 'West Creek', 05, 2019, 0, 1, 18, 55.00, 9, 50, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (16, 'NG Exclusive - Adam\'s Hollow', 'C', 'Brighton', 06, 2019, 0, 1, 10, 35.00, 2, 45, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (17, 'Muscles for Romito', 'C', 'Elizabeth', 07, 2019, 0, 1, 17, 65.00, 1, 85, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (18, 'NG eXclusive @ Bear Mountain', 'C', 'Bailey', 08, 2019, 0, 1, 10, 45.00, 7, 20, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (19, 'Little Windmill Amateur Championships Presented by Elevated Disc Golf', 'C', 'Aurora', 08, 2019, 0, 1, 15, 45.00, 12, 20, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (20, 'Colorado State Disc Golf Championships 2019', 'A', 'Colorado Springs', 08, 2019, 1, 3, 45, 99.00, 44, 0, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (21, 'Next Generation Tour Mountain Premier Presented by DiscMania', 'A', 'Denver', 09, 2019, 1, 2, 15, 99.00, 11, 50, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (22, 'Mile High Classic 2019 - Ams', 'C', 'Brighton', 09, 2019, 0, 1, 18, 55.00, 1, 90, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (23, 'NADGT- Exclusive - Adams Hollow', 'B', 'Brighton', 03, 2020, 0, 1, 35, 45.00, 10, 195, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (24, 'NADGT Exclusive - Frisco Peak One', 'B', 'Frisco', 07, 2020, 0, 1, 40, 45.00, 18, 172.5, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (25, 'NADGT Exclusive - Pueblo City Park', 'B', 'Pueblo', 07, 2020, 0, 1, 18, 45.00, 14, 37.5, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (26, 'Rocky Mountain Soda Company Presents: Rocky Mountain Amateur Championship- MA1, FA1, & MA40', 'A', 'Arvad', 10, 2020, 1, 2, 69, 95.00, 57, 130, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (27, 'NADGT Exclusive @ Ponderosa Pines: Presidents Day Bash', 'B', 'Ponderosa', 02, 2021, 0, 1, 16, 65.00, 12, 37.5, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (28, 'Colorado DG Hall of Fame Championships - Ams @ Anheuser Busch', 'B', 'Fort Collins', 03, 2021, 0, 1, 26, 65.00, 3, 180, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (29, 'NADGT-Exclusive @ Adam\'s Hollow', 'B', 'Brighton', 03, 2021, 0, 1, 22, 65.00, 2, 157.5, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (30, 'NADGT Exclusive @ Anheuser Busch', 'B', 'Fort Collins', 03, 2021, 0, 1, 24, 65.00, 8, 127.5, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (31, 'NADGT Cee-Time @ Valmont presented by Boulder Disc Golf Club', 'C', 'Boulder', 04, 2021, 0, 1, 34, 45.00, 2, 165, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (32, 'Rocky Mountain Amateur Championships - MA1, FA1 & MA40 Only', 'A', 'Denver', 04, 2021, 1, 3, 81, 95.00, 2, 800, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (33, 'The 303 Warm-Up at Michelob Ultra DiscGolfPark', 'C', 'Fort Collins', 05, 2021, 0, 1, 36, 45.00, 11, 130, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (34, 'NADGT Exclusive @ Casper DGC', 'B', 'Casper', 05, 2021, 0, 1, 20, 65.00, 4, 127.5, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (35, 'NADGT Exclusive @ Romero', 'B', 'Romero', 05, 2021, 0, 1, 25, 65.00, 9, 127.5, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (36, 'NADGT Exclusive @ Frisco Peak One DGC - MA1, FA1 and MA40', 'B', 'Frisco', 06, 2021, 0, 1, 61, 65.00, 19, 322.5, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (37, 'NADGT Exclusive @ CMC Leadville - MA1/FA1/MA40', 'B', 'Leadville', 06, 2021, 0, 1, 51, 65.00, 38, 105, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (38, 'NADGT Exclusive @ Woodmen Hills', 'B', 'Woodmen Hills', 06, 2021, 0, 1, 22, 65.00, 3, 150, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (39, 'NADGT Exclusive @ Pueblo City Park', 'B', 'Pueblo', 07, 2021, 0, 1, 26, 65.00, 4, 173.5, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (40, 'Cee-Time @ Royal Gorge AmPowered by NADGT', 'C', 'Canon City', 07, 2021, 0, 1, 8, 45.00, 1, 40, 0);
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `month`, `year`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (41, '2021 Muscles for Romito', 'C', 'Fort Collins', 08, 2021, 0, 1, 37, 45.00, 30, 40, 0);

COMMIT;

