CREATE DATABASE Idea_Manager;
USE Idea_Manager;

/******************************
	    --- Tables ---
******************************/
CREATE TABLE `user` (
	`id` VARCHAR(64) NOT NULL,
    `username` VARCHAR(40) NOT NULL,
    `email` VARCHAR(60) NOT NULL,
    `passwordHash` VARCHAR(255) NOT NULL,
    `passwordSalt` BLOB NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `idea` (
	`id` VARCHAR(64) NOT NULL,
    `name` VARCHAR(40) NOT NULL,
    `description` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `message` (
	`id` VARCHAR(64) NOT NULL,
    `userId` VARCHAR(64) NOT NULL,
    `content` VARCHAR(2000) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `theme` (
    `id` VARCHAR(64) NOT NULL,
    `userId` VARCHAR(64) NOT NULL,
    PRIMARY KEY (`id`)
);