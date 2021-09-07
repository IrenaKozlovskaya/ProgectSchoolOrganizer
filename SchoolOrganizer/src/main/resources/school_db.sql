CREATE SCHEMA IF NOT EXISTS `school_db` DEFAULT CHARACTER SET utf8;
USE `school_db`;



CREATE TABLE IF NOT EXISTS `school_db`.`category`
(
    `id`       BIGINT      NOT NULL  AUTO_INCREMENT,
    `category` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `Category_UNIQUE` (`category` ASC) VISIBLE
    )
    ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `school_db`.`activity_type` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `category_id` BIGINT NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `Activity_UNIQUE` (`name` ASC) VISIBLE,
    INDEX `fk_activity_type_category1_idx` (`category_id` ASC) VISIBLE,
    CONSTRAINT `fk_activity_type_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `school_db`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `school_db`.`activity`
(
    `id`                   BIGINT    NOT NULL   AUTO_INCREMENT,
    `name`                 VARCHAR(255)   NOT NULL,
    `date`                 TIMESTAMP NOT NULL,
    `activity_type_id`     BIGINT    NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_Activity_Activity_type1_idx` (`activity_type_id` ASC) VISIBLE,
    CONSTRAINT `fk_Activity_Activity_type1`
    FOREIGN KEY (`activity_type_id`)
    REFERENCES `school_db`.`activity_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    )
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `school_db`.`users`
(
    `id`           BIGINT        NOT NULL  AUTO_INCREMENT,
    `email`        VARCHAR(255)   NOT NULL,
    `password`     VARCHAR(255)   NOT NULL,
    `first_name`   VARCHAR(255)  NULL,
    `last_name`    VARCHAR(255)  NULL,
    `phone_number` VARCHAR(45)   NULL,
    `photo_url`    VARCHAR(2083) NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `Email_UNIQUE` (`email` ASC) VISIBLE,
    UNIQUE INDEX `phone_number_UNIQUE` (`phone_number` ASC) VISIBLE
    )
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `school_db`.`roles`
(
    `id`   BIGINT      NOT NULL  AUTO_INCREMENT,
    `role` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `role_UNIQUE` (`role` ASC) VISIBLE
    )
    ENGINE = InnoDB;




CREATE TABLE IF NOT EXISTS `school_db`.`activity_users`
(
    `user_id`     BIGINT NOT NULL,
    `activity_id` BIGINT NOT NULL,
    PRIMARY KEY (`user_id`, `activity_id`),
    INDEX `fk_User_has_Activity_Activity1_idx` (`activity_id` ASC) VISIBLE,
    INDEX `fk_User_has_Activity_User1_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `fk_User_has_Activity_User1`
    FOREIGN KEY (`user_id`)
    REFERENCES `school_db`.`users` (`id`)
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
    REFERENCES `school_db`.`users` (`id`)
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

INSERT INTO users(email, password)
values ('irena.kozlovskaya11@gmail.com', 'irena');
INSERT INTO users(email, password)
values ('irena.kozlovskaya11@mail.ru', 'Girena');


INSERT INTO user_roles (user_id, role_id)
VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id)
VALUES (1, 2);
INSERT INTO user_roles (user_id, role_id)
VALUES (2, 1);


INSERT INTO category (category)
VALUES ('Спортивные');
INSERT INTO category (category)
VALUES ('Образовательные');
INSERT INTO category (category)
VALUES ('Научные');
INSERT INTO category (category)
VALUES ('Развлекательные');
INSERT INTO category (category)
VALUES ('Торжественные');
INSERT INTO category (category)
VALUES ('Благотоворительные');
INSERT INTO category (category)
VALUES ('Выездные');

INSERT INTO activity_type (name, category_id)
VALUES ('Футбол', 1);
INSERT INTO activity_type (name, category_id)
VALUES ('Баскетбол', 1);
INSERT INTO activity_type (name, category_id)
VALUES ('Соревнования', 2);
INSERT INTO activity_type (name, category_id)
VALUES ('Факультативы', 2);
INSERT INTO activity_type (name, category_id)
VALUES ('Лабораторные исследования', 3);
INSERT INTO activity_type (name, category_id)
VALUES ('Кино', 4);
INSERT INTO activity_type (name, category_id)
VALUES ('Музей', 4);
INSERT INTO activity_type (name, category_id)
VALUES ('Линейка', 5);
INSERT INTO activity_type (name, category_id)
VALUES ('Выступления в городе', 5);
INSERT INTO activity_type (name, category_id)
VALUES ('Красный крест', 6);
INSERT INTO activity_type (name, category_id)
VALUES ('Туры по Беларусии', 7);
INSERT INTO activity_type (name, category_id)
VALUES ('Туры за рубеж', 7);








