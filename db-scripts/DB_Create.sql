CREATE DATABASE Idea_Sharer;
USE Idea_Sharer;

/******************************
	    --- Tables ---
******************************/
CREATE TABLE `user` (
	`id` VARCHAR(64) NOT NULL,
    `username` VARCHAR(40) NOT NULL UNIQUE,
    `email` VARCHAR(60) NOT NULL UNIQUE,
    `passwordHash` VARCHAR(255) NOT NULL,
    `passwordSalt` BLOB NOT NULL,
    `creationDate` DATE NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `idea` (
	`id` VARCHAR(64) NOT NULL,
    `userId` VARCHAR(64) NOT NULL,
    `name` VARCHAR(40) NOT NULL,
    `description` VARCHAR(255) NOT NULL,
    `likes` INT NOT NULL,
    `creationDate` DATE NOT NULL,
    CHECK (`likes` >= 0),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE
);

CREATE TABLE `message` (
	`id` VARCHAR(64) NOT NULL,
    `userId` VARCHAR(64) NOT NULL,
    `ideaId` VARCHAR(64) NOT NULL,
    `content` VARCHAR(2000) NOT NULL,
    `creationDate` DATE NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE,
    FOREIGN KEY (`ideaId`) REFERENCES `idea` (`id`) ON DELETE CASCADE
);

CREATE TABLE `theme` (
    `id` VARCHAR(64) NOT NULL,
    `userId` VARCHAR(64) NOT NULL,
    `primaryColor` CHAR(7) NOT NULL,
    `secondaryColor` CHAR(7) NOT NULL,
    `tertiaryColor` CHAR(7) NOT NULL,
    `textColor` CHAR(7) NOT NULL,
    `hoverColor` CHAR(7) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE
);

CREATE TABLE `favorite` (
	`id` VARCHAR(64) NOT NULL,
    `userId` VARCHAR(64) NOT NULL,
    `ideaId` VARCHAR(64) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE,
    FOREIGN KEY (`ideaId`) REFERENCES `idea` (`id`) ON DELETE CASCADE
);