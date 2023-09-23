-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Počítač: 127.0.0.1
-- Vytvořeno: Sob 23. zář 2023, 17:20
-- Verze serveru: 10.4.27-MariaDB
-- Verze PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databáze: `dogs_shelters`
--

-- --------------------------------------------------------

--
-- Struktura tabulky `dogs`
--

CREATE TABLE `dogs` (
  `did` int(11) NOT NULL COMMENT 'Dog ID',
  `name` varchar(50) NOT NULL COMMENT 'Dog''s name',
  `breed` varchar(50) NOT NULL COMMENT 'Dog''s breed',
  `sex` varchar(30) NOT NULL COMMENT 'Dog''s sex',
  `age` int(11) NOT NULL COMMENT 'Dog''s age',
  `status` varchar(100) NOT NULL COMMENT 'Dog''s status',
  `sid` int(11) NOT NULL COMMENT 'Shelter ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Vypisuji data pro tabulku `dogs`
--

INSERT INTO `dogs` (`did`, `name`, `breed`, `sex`, `age`, `status`, `sid`) VALUES
(1, 'Minnie', 'Kříženec', 'fena', 1, 'k adopci', 1),
(3, 'Rony', 'Německý ovčák', 'pes', 7, 'k adopci', 4),
(5, 'Loki', 'Kříženec', 'pes', 5, 'v převýchově', 3),
(6, 'Mia', 'Jezevčík', 'fena', 2, 'v léčbě', 3),
(8, 'Tinky', 'Čivava', 'fena', 1, 'k adopci', 4),
(10, 'Princess', 'Husky', 'fena', 2, 'k adopci', 1),
(11, 'Brock', 'Kříženec', 'pes', 4, 'v léčbě', 1);

-- --------------------------------------------------------

--
-- Struktura tabulky `shelters`
--

CREATE TABLE `shelters` (
  `sid` int(11) NOT NULL COMMENT 'Shelter ID',
  `name` varchar(50) NOT NULL COMMENT 'Shelter name',
  `city` varchar(50) NOT NULL COMMENT 'Shelter city',
  `contactnum` varchar(50) NOT NULL COMMENT 'Shelter contact phone number'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Vypisuji data pro tabulku `shelters`
--

INSERT INTO `shelters` (`sid`, `name`, `city`, `contactnum`) VALUES
(1, 'Dočasný Domov', 'Praha', '+420777000000'),
(3, 'Pomocná Tlapka', 'Praha', '+420777333333'),
(4, 'Tuláček', 'Chomutov', '+420777555555'),
(11, 'Druhá Šance', 'Brno', '+420777222222');

--
-- Indexy pro exportované tabulky
--

--
-- Indexy pro tabulku `dogs`
--
ALTER TABLE `dogs`
  ADD PRIMARY KEY (`did`),
  ADD KEY `sid` (`sid`);

--
-- Indexy pro tabulku `shelters`
--
ALTER TABLE `shelters`
  ADD PRIMARY KEY (`sid`);

--
-- AUTO_INCREMENT pro tabulky
--

--
-- AUTO_INCREMENT pro tabulku `dogs`
--
ALTER TABLE `dogs`
  MODIFY `did` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Dog ID', AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pro tabulku `shelters`
--
ALTER TABLE `shelters`
  MODIFY `sid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Shelter ID', AUTO_INCREMENT=12;

--
-- Omezení pro exportované tabulky
--

--
-- Omezení pro tabulku `dogs`
--
ALTER TABLE `dogs`
  ADD CONSTRAINT `dogs_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `shelters` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
