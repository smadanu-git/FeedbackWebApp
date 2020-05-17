CREATE TABLE `feedback`.`reviews` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `reviewer_id` INT NOT NULL,
  `reviewee_id` INT NOT NULL,
  `comments` VARCHAR(300) NULL,
  `rating` VARCHAR(45) NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT 'Pending',
  `submitted_date` DATE NULL,
  `status_uq` VARCHAR(45) AS(if(status <> 'Completed', status, null)) stored null,
  PRIMARY KEY (`id`),
  INDEX `reviewer_fk_idx` (`reviewer_id` ASC) VISIBLE,
  INDEX `reviewee_fk_idx` (`reviewee_id` ASC) VISIBLE,
  CONSTRAINT `reviewer_fk`
    FOREIGN KEY (`reviewer_id`)
    REFERENCES `feedback`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  constraint unique (`reviewer_id`, `reviewee_id`, `status_uq`),
  CONSTRAINT `reviewee_fk`
    FOREIGN KEY (`reviewee_id`)
    REFERENCES `feedback`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	
	DROP TRIGGER IF EXISTS `feedback`.`reviews_BEFORE_UPDATE`;

	DELIMITER $$
	USE `feedback`$$
	CREATE DEFINER = CURRENT_USER TRIGGER `feedback`.`reviews_BEFORE_INSERT` BEFORE INSERT ON `reviews` FOR EACH ROW
	BEGIN
		DECLARE msg VARCHAR(32) DEFAULT "";
	IF NEW.reviewer_id = NEW.reviewee_id THEN
		set msg = 'Error: Reviewer and Reviewee are Same';
        signal sqlstate '45000' set message_text = msg;
	END IF;
	END$$
	DELIMITER ;
