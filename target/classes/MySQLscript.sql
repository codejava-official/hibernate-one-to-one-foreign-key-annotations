create database booksdb;
use booksdb;

CREATE TABLE `author` (
  `author_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`author_id`)
);

CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) NOT NULL,
  `description` varchar(512) NOT NULL,
  `published` date NOT NULL,
  `author_id` int(11) NOT NULL,
  PRIMARY KEY (`book_id`),
  KEY `author_fk` (`author_id`),
  CONSTRAINT `author_fk` FOREIGN KEY (`author_id`) REFERENCES `author` (`author_id`)
);