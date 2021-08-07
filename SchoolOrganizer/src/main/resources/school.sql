CREATE SCHEMA IF NOT EXISTS `school_db` DEFAULT CHARACTER SET utf8;
USE `school_db`;



CREATE TABLE IF NOT EXISTS `school_db`.`category`
(
    `id`       BIGINT      NOT NULL,
    `category` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `Category_UNIQUE` (`category` ASC) VISIBLE
)
    ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `school_db`.`activity_type`
(
    `id`          BIGINT      NOT NULL,
    `activity`    VARCHAR(45) NOT NULL,
    `category_id` BIGINT      NOT NULL,
    PRIMARY KEY (`id`, `category_id`),
    UNIQUE INDEX `Activity_UNIQUE` (`activity` ASC) VISIBLE,
    INDEX `fk_Activity_type_Category1_idx` (`category_id` ASC) VISIBLE,
    CONSTRAINT `fk_Activity_type_Category1`
        FOREIGN KEY (`category_id`)
            REFERENCES `school_db`.`category` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `school_db`.`activity`
(
    `id`                   BIGINT    NOT NULL,
    `teacher_id`          BIGINT    NOT NULL,
    `date`                 TIMESTAMP NOT NULL,
    `activity_type_id`     BIGINT    NOT NULL,
    `activity_category_id` BIGINT    NOT NULL,
    PRIMARY KEY (`id`, `teacher_id`, `activity_type_id`, `activity_category_id`),
    INDEX `fk_Activity_Activity_type1_idx` (`activity_type_id` ASC, `activity_category_id` ASC) VISIBLE,
    CONSTRAINT `fk_Activity_Activity_type1`
        FOREIGN KEY (`activity_type_id`, `activity_category_id`)
            REFERENCES `school_db`.`activity_type` (`id`, `category_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `school_db`.`user`
(
    `id`           BIGINT        NOT NULL,
    `email`        VARCHAR(45)   NOT NULL,
    `password`     VARCHAR(45)   NOT NULL,
    `first_name`   VARCHAR(45)   NOT NULL,
    `last_name`    VARCHAR(45)   NOT NULL,
    `class_number` VARCHAR(45)   NOT NULL,
    `phone_number` VARCHAR(45)   NULL,
    `photo_url`    VARCHAR(2083) NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `Login_UNIQUE` (`email` ASC) VISIBLE,
    UNIQUE INDEX `phone_number_UNIQUE` (`phone_number` ASC) VISIBLE
)
    ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `school_db`.`roles`
(
    `id`   BIGINT      NOT NULL,
    `role` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `role_UNIQUE` (`role` ASC) VISIBLE
)
    ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `school_db`.`user_activities`
(
    `user_id`     BIGINT NOT NULL,
    `activity_id` BIGINT NOT NULL,
    PRIMARY KEY (`user_id`, `activity_id`),
    INDEX `fk_User_has_Activity_Activity1_idx` (`activity_id` ASC) VISIBLE,
    INDEX `fk_User_has_Activity_User1_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `fk_User_has_Activity_User1`
        FOREIGN KEY (`user_id`)
            REFERENCES `school_db`.`user` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_User_has_Activity_Activity1`
        FOREIGN KEY (`activity_id`)
            REFERENCES `school_db`.`activity` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `school_db`.`photos`
(
    `id`          BIGINT        NOT NULL,
    `photo_url`   VARCHAR(2083) NOT NULL,
    `date`        TIMESTAMP     NULL,
    `activity_id` BIGINT        NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `photo_url_UNIQUE` (`photo_url` ASC) VISIBLE,
    INDEX `fk_Photos_Activity1_idx` (`activity_id` ASC) VISIBLE,
    CONSTRAINT `fk_Photos_Activity1`
        FOREIGN KEY (`activity_id`)
            REFERENCES `school_db`.`activity` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `school_db`.`comments`
(
    `id`          BIGINT       NOT NULL AUTO_INCREMENT,
    `comment`     VARCHAR(255) NOT NULL,
    `user_id`     BIGINT       NOT NULL,
    `date`        TIMESTAMP    NULL,
    `activity_id` BIGINT       NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_Comments_Activity1_idx` (`activity_id` ASC) VISIBLE,
    CONSTRAINT `fk_Comments_Activity1`
        FOREIGN KEY (`activity_id`)
            REFERENCES `school_db`.`activity` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `school_db`.`user_roles`
(
    `user_id` BIGINT NOT NULL,
    `role_id` BIGINT NOT NULL,
    PRIMARY KEY (`user_id`, `role_id`),
    INDEX `fk_User_has_Roles_Roles1_idx` (`role_id` ASC) VISIBLE,
    INDEX `fk_User_has_Roles_User1_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `fk_User_has_Roles_User1`
        FOREIGN KEY (`user_id`)
            REFERENCES `school_db`.`user` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_User_has_Roles_Roles1`
        FOREIGN KEY (`role_id`)
            REFERENCES `school_db`.`roles` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


INSERT INTO roles(role)
VALUES ('ROLE_USER');
INSERT INTO roles(role)
VALUES ('ROLE_ADMIN');

INSERT INTO user(email, password)
values ('irena.kozlovskaya11@gmail.com', 'irena');
INSERT INTO user(email, password)
values ('irena.kozlovskaya11@mail.ru', 'Girena');


INSERT INTO user_roles (user_id, role_id)
VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id)
VALUES (1, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (2, 1);




