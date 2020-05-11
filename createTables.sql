create database feedback;

CREATE TABLE `feedback`.`roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) NOT NULL,
  `role_desc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_name_UNIQUE` (`role_name`)
);

CREATE TABLE `feedback`.`users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `password` varchar(500) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `user_name` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIusersQUE` (`email`),
  UNIQUE KEY `username_UNIusersQUE` (`user_name`)
);

CREATE TABLE `feedback`.`user_roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id_idx` (`role_id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);



INSERT INTO `feedback`.`roles`
(`id`,
`role_name`,
`role_desc`)
VALUES
(1,
'ADMIN',
'Administartor');

INSERT INTO `feedback`.`roles`
(`id`,
`role_name`,
`role_desc`)
VALUES
(2,
'EMPL',
'Employee');

INSERT INTO `feedback`.`users` (`id`, `email`, `password`, `last_name`, `user_name`, `first_name`) 
VALUES (1, 'admin@feedback.com', '$2a$10$14NpTBvTMr64Z8iwBibztuiJvyCC6rp98S6EYnglOANK//OIvldde', 'Admin', 'admin', 'Admin');
-- password

INSERT INTO `feedback`.`user_roles`
(`id`,
`role_id`,
`user_id`)
VALUES
(1,
1,
1);
