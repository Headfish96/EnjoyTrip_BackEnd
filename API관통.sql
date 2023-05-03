-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ssafy_user
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ssafy_user
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ssafy_user` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `ssafy_user` ;

-- -----------------------------------------------------
-- Table `ssafy_user`.`sido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafy_user`.`sido` (
  `sido_code` INT NOT NULL,
  `sido_name` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`sido_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `ssafy_user`.`gugun`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafy_user`.`gugun` (
  `gugun_code` INT NOT NULL,
  `gugun_name` VARCHAR(30) NULL DEFAULT NULL,
  `sido_code` INT NOT NULL,
  PRIMARY KEY (`gugun_code`, `sido_code`),
  INDEX `gugun_to_sido_sido_code_fk_idx` (`sido_code` ASC) VISIBLE,
  CONSTRAINT `gugun_to_sido_sido_code_fk`
    FOREIGN KEY (`sido_code`)
    REFERENCES `ssafy_user`.`sido` (`sido_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `ssafy_user`.`attraction_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafy_user`.`attraction_info` (
  `content_id` INT NOT NULL,
  `content_type_id` INT NULL DEFAULT NULL,
  `title` VARCHAR(100) NULL DEFAULT NULL,
  `addr1` VARCHAR(100) NULL DEFAULT NULL,
  `addr2` VARCHAR(50) NULL DEFAULT NULL,
  `zipcode` VARCHAR(50) NULL DEFAULT NULL,
  `tel` VARCHAR(50) NULL DEFAULT NULL,
  `first_image` VARCHAR(200) NULL DEFAULT NULL,
  `first_image2` VARCHAR(200) NULL DEFAULT NULL,
  `readcount` INT NULL DEFAULT NULL,
  `sido_code` INT NULL DEFAULT NULL,
  `gugun_code` INT NULL DEFAULT NULL,
  `latitude` DECIMAL(20,17) NULL DEFAULT NULL,
  `longitude` DECIMAL(20,17) NULL DEFAULT NULL,
  `mlevel` VARCHAR(2) NULL DEFAULT NULL,
  PRIMARY KEY (`content_id`),
  INDEX `attraction_to_content_type_id_fk_idx` (`content_type_id` ASC) VISIBLE,
  INDEX `attraction_to_sido_code_fk_idx` (`sido_code` ASC) VISIBLE,
  INDEX `attraction_to_gugun_code_fk_idx` (`gugun_code` ASC) VISIBLE,
  CONSTRAINT `attraction_to_content_type_id_fk`
    FOREIGN KEY (`content_type_id`)
    REFERENCES `ssafy_user`.`content_type` (`content_type_id`),
  CONSTRAINT `attraction_to_gugun_code_fk`
    FOREIGN KEY (`gugun_code`)
    REFERENCES `ssafy_user`.`gugun` (`gugun_code`),
  CONSTRAINT `attraction_to_sido_code_fk`
    FOREIGN KEY (`sido_code`)
    REFERENCES `ssafy_user`.`sido` (`sido_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `ssafy_user`.`attraction_description`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafy_user`.`attraction_description` (
  `content_id` INT NOT NULL,
  `homepage` VARCHAR(100) NULL DEFAULT NULL,
  `overview` VARCHAR(10000) NULL DEFAULT NULL,
  `telname` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`content_id`),
  CONSTRAINT `attraction_detail_to_attraciton_id_fk`
    FOREIGN KEY (`content_id`)
    REFERENCES `ssafy_user`.`attraction_info` (`content_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `ssafy_user`.`attraction_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafy_user`.`attraction_detail` (
  `content_id` INT NOT NULL,
  `cat1` VARCHAR(3) NULL DEFAULT NULL,
  `cat2` VARCHAR(5) NULL DEFAULT NULL,
  `cat3` VARCHAR(9) NULL DEFAULT NULL,
  `created_time` VARCHAR(14) NULL DEFAULT NULL,
  `modified_time` VARCHAR(14) NULL DEFAULT NULL,
  `booktour` VARCHAR(5) NULL DEFAULT NULL,
  PRIMARY KEY (`content_id`),
  CONSTRAINT `attraction_detail_to_basic_content_id_fk`
    FOREIGN KEY (`content_id`)
    REFERENCES `ssafy_user`.`attraction_info` (`content_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `ssafy_user`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafy_user`.`user` (
  `id` VARCHAR(40) NOT NULL,
  `password` VARCHAR(40) NOT NULL,
  `name` VARCHAR(40) NOT NULL,
  `email` VARCHAR(40) NOT NULL,
  `user_code` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`user_code`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafy_user`.`board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafy_user`.`board` (
  `num` INT NOT NULL AUTO_INCREMENT,
  `createtime` DATETIME NULL DEFAULT NULL,
  `title` VARCHAR(40) NOT NULL,
  `content` VARCHAR(100) NOT NULL,
  `writername` VARCHAR(40) NOT NULL,
  `writer_code` INT NULL DEFAULT NULL,
  PRIMARY KEY (`num`),
  INDEX `board_to_user_idx` (`writer_code` ASC) VISIBLE,
  CONSTRAINT `board_to_user`
    FOREIGN KEY (`writer_code`)
    REFERENCES `ssafy_user`.`user` (`user_code`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafy_user`.`myplace`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafy_user`.`myplace` (
  `myplace_code` INT NOT NULL AUTO_INCREMENT,
  `attraction_code` INT NULL DEFAULT NULL,
  `user_code` INT NULL DEFAULT NULL,
  PRIMARY KEY (`myplace_code`),
  INDEX `myplace_to_attraction_code_idx` (`attraction_code` ASC) VISIBLE,
  INDEX `myplace_to_user_code_idx` (`user_code` ASC) VISIBLE,
  CONSTRAINT `myplace_to_attraction_code`
    FOREIGN KEY (`attraction_code`)
    REFERENCES `ssafy_user`.`attraction_info` (`content_id`),
  CONSTRAINT `myplace_to_user_code`
    FOREIGN KEY (`user_code`)
    REFERENCES `ssafy_user`.`user` (`user_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafy_user`.`plan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafy_user`.`plan` (
  `plan_code` INT NOT NULL AUTO_INCREMENT,
  `plan_startDate` DATE NOT NULL,
  `plan_endDate` DATE NOT NULL,
  `plan_title` VARCHAR(45) NOT NULL,
  `plan_content` VARCHAR(1000) NULL DEFAULT NULL,
  `like_count` INT NOT NULL,
  `valid` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`plan_code`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafy_user`.`plan_attraction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafy_user`.`plan_attraction` (
  `plan_code` INT NOT NULL,
  `content_id` INT NOT NULL,
  `plan_attraction_code` INT NOT NULL AUTO_INCREMENT,
  `sequence` INT NULL DEFAULT NULL,
  `date` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`plan_attraction_code`),
  INDEX `plan_attraction_to_plan_idx` (`plan_code` ASC) VISIBLE,
  INDEX `plan_attraction_to_attraction_info_idx` (`content_id` ASC) VISIBLE,
  CONSTRAINT `plan_attraction_to_attraction_info`
    FOREIGN KEY (`content_id`)
    REFERENCES `ssafy_user`.`attraction_info` (`content_id`),
  CONSTRAINT `plan_attraction_to_plan`
    FOREIGN KEY (`plan_code`)
    REFERENCES `ssafy_user`.`plan` (`plan_code`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafy_user`.`plan_like`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafy_user`.`plan_like` (
  `plan_pk` INT NULL DEFAULT NULL,
  `user_pk` INT NULL DEFAULT NULL,
  INDEX `plan_pk` (`plan_pk` ASC) VISIBLE,
  INDEX `user_pk` (`user_pk` ASC) VISIBLE,
  CONSTRAINT `plan_like_ibfk_1`
    FOREIGN KEY (`plan_pk`)
    REFERENCES `ssafy_user`.`plan` (`plan_code`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `plan_like_ibfk_2`
    FOREIGN KEY (`user_pk`)
    REFERENCES `ssafy_user`.`user` (`user_code`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafy_user`.`plan_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafy_user`.`plan_user` (
  `plan_code` INT NOT NULL,
  `user_code` INT NOT NULL,
  `plan_user_code` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`plan_user_code`),
  INDEX `plan_user_to_user_idx` (`user_code` ASC) VISIBLE,
  INDEX `plan_user_to_plan` (`plan_code` ASC) VISIBLE,
  CONSTRAINT `plan_user_to_plan`
    FOREIGN KEY (`plan_code`)
    REFERENCES `ssafy_user`.`plan` (`plan_code`),
  CONSTRAINT `plan_user_to_user`
    FOREIGN KEY (`user_code`)
    REFERENCES `ssafy_user`.`user` (`user_code`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafy_user`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafy_user`.`review` (
  `review_code` INT NOT NULL AUTO_INCREMENT,
  `review_score` INT NULL DEFAULT NULL,
  `review_content` VARCHAR(1000) NULL DEFAULT NULL,
  `user_code` INT NULL DEFAULT NULL,
  `attraction_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`review_code`),
  INDEX `review_to_user_idx` (`user_code` ASC) VISIBLE,
  INDEX `review_to_attraction_idx` (`attraction_id` ASC) VISIBLE,
  CONSTRAINT `review_to_attraction`
    FOREIGN KEY (`attraction_id`)
    REFERENCES `ssafy_user`.`attraction_info` (`content_id`),
  CONSTRAINT `review_to_user`
    FOREIGN KEY (`user_code`)
    REFERENCES `ssafy_user`.`user` (`user_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
