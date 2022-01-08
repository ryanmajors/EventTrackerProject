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
  `tournament_date` DATE NOT NULL,
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
INSERT INTO `tournament` (`id`, `name`, `tier`, `location`, `tournament_date`, `multi_day`, `days`, `players`, `entry_fee`, `placement`, `points`, `hidden`) VALUES (1, 'Mile High Classic', 'B', 'Adam\'s Hollow Disc golf course', '2021-09-27', 1, 1, 18, 55.00, 1, 90, 0);

COMMIT;

