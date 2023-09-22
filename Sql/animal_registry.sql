DROP DATABASE IF EXISTS `Друзья человека`;
CREATE DATABASE IF NOT EXISTS `Друзья человека`;
USE `Друзья человека`;

DROP TABLE IF EXISTS `Типы животных`;
CREATE TABLE  `Типы животных`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`type` VARCHAR(45) NOT NULL
);

INSERT INTO `Типы животных` (`type`)
VALUES
("Домашние Животные"),
("Вьючные животные")
;
-- SELECT * FROM `Типы животных`;

DROP TABLE IF EXISTS `Виды животных`;
CREATE TABLE `Виды животных`(
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`type_id` INT NOT NULL, FOREIGN KEY (`type_id`) REFERENCES `Типы животных` (`id`),
`species` VARCHAR(45) NOT NULL UNIQUE
);

INSERT INTO `Виды животных`
(`type_id`, `species`)
VALUES
(1, "Кошка"),
(1, "Собака"),
(1, "Хомяк"),
(2, "Лошадь"),
(2, "Верблюд"),
(2, "Осел")
;
-- SELECT * FROM `Виды животных`;


DROP TABLE IF EXISTS `Зверушки`;
CREATE TABLE `Зверушки`(
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`species_id` INT NOT NULL, FOREIGN KEY (`species_id`) REFERENCES `Виды животных` (`id`),
`name` VARCHAR(45) NOT NULL,
`commands` VARCHAR(120),
`date_of_birth` DATE
);

INSERT INTO `Зверушки`
(`species_id`,`name`,`commands`,`date_of_birth`)
VALUES
(1, "Мурка","урчать, есть", "2020-01-02"),
(1, "Васька","спать, тыгыдык","2022-02-03"),
(2, "Шарик", "сидеть, лежать","2023-03-04"),
(2, "Койра","грызть ногу, голос","2021-04-05"),
(3, "Хома","крутить колесо, строить гнездо","2022-05-06"),
(3, "Чип","пищать","2021-06-07"),
(4, "Ксюша","игого, скакать","2020-07-08"),
(4, "Брего","ржать","2019-08-09"),
(5, "Вера","плевать","2018-09-10"),
(5, "Горбатый","лечь, встать","2022-10-11"),
(6, "Иа","работать","2017-11-12"),
(6, "Бальтазар","терпеть","2018-12-13");

-- SELECT * FROM `Зверушки`;
-- Удаляем верблюдов
DELETE FROM `Зверушки` WHERE `species_id`=5;
-- SELECT * FROM `Зверушки`;

CREATE TABLE `Лошади и Ослы`
AS
SELECT * FROM `Зверушки` WHERE `species_id` IN (4,6);
-- SELECT * FROM `Лошади и Ослы`;

CREATE TABLE `Молодые животные`
AS
SELECT *, timestampdiff(month, `date_of_birth`, curdate()) as `age in months`  FROM `Зверушки` WHERE timestampdiff(year, `date_of_birth`, curdate()) BETWEEN 1 AND 2;

SELECT * FROM `Молодые животные`;










