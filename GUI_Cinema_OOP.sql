-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 07, 2024 at 04:56 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `GUI_Cinema_OOP`
--

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE `movie` (
  `MovieId` int NOT NULL,
  `Title` varchar(255) NOT NULL,
  `Cover` varchar(255) NOT NULL,
  `Banner` varchar(255) NOT NULL,
  `Synopsis` varchar(3000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Genre` varchar(255) NOT NULL,
  `Director` varchar(255) NOT NULL,
  `Duration` varchar(100) NOT NULL,
  `Show Date` date NOT NULL,
  `Show Time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Theater` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`MovieId`, `Title`, `Cover`, `Banner`, `Synopsis`, `Genre`, `Director`, `Duration`, `Show Date`, `Show Time`, `Theater`) VALUES
(1, 'The Garden of  Words', 'https://cdn.discordapp.com/attachments/1025234293976481803/1185306535308578856/The_Garden_of_Words.jpg', 'https://cdn.discordapp.com/attachments/1025234293976481803/1185571561483284540/The_Garden_of_Words_Large.jpg', 'On a rainy morning in Tokyo, Takao Akizuki, an aspiring shoemaker, decides to skip class to sketch designs in a beautiful garden. This is where he meets Yukari Yukino, a beautiful yet mysterious woman, for the very first time. Offering to make her new shoes, Takao continues to meet with Yukari throughout the rainy season, and without even realizing it, the two are able to alleviate the worries hidden in their hearts just by being with each other. However, their personal struggles have not disappeared completely, and as the end of the rainy season approaches, their relationship will be put to the test.', 'Romance', 'CoMix Wave Films', '46 min.', '2023-12-31', '12.00', 'StudioA'),
(2, 'Your Name', 'https://cdn.discordapp.com/attachments/1025234293976481803/1185280983482769529/YourName.jpg', 'https://cdn.discordapp.com/attachments/1025234293976481803/1185571561793654804/YourName_Large.jpg', 'Mitsuha Miyamizu, a high school girl, yearns to live the life of a boy in the bustling city of Tokyo—a dream that stands in stark contrast to her present life in the countryside. Meanwhile in the city, Taki Tachibana lives a busy life as a high school student while juggling his part-time job and hopes for a future in architecture.\n\nOne day, Mitsuha awakens in a room that is not her own and suddenly finds herself living the dream life in Tokyo—but in Taki\'s body! Elsewhere, Taki finds himself living Mitsuha\'s life in the humble countryside. In pursuit of an answer to this strange phenomenon, they begin to search for one another.\n\nKimi no Na wa. revolves around Mitsuha and Taki\'s actions, which begin to have a dramatic impact on each other\'s lives, weaving them into a fabric held together by fate and circumstance.', 'Drama', 'CoMix Wave Films', '1 hr. 46 min.', '2023-12-31', '09.00', 'StudioA'),
(3, 'Suzume no Tojimari', 'https://cdn.discordapp.com/attachments/1025234293976481803/1185299490027086066/Suzume_no_Tojimari.jpg', 'https://cdn.discordapp.com/attachments/1025234293976481803/1185571561084833862/Suzume_no_Tojimari_Large.jpg', 'On her way to school one day, Suzume Iwato stumbles upon Souta Munakata, a young man searching for abandoned areas. The high school girl directs Souta to a nearby ruin, but out of pure curiosity, she herself decides to head to the same destination.\n\nOnce there, Suzume discovers an isolated door with a dreamlike universe lying beyond it—a place that she can see and feel, but not enter. A strange stone rests on the ground nearby, but it turns into a cat-like creature and scurries away when Suzume lifts it. Suddenly afraid, she heads back toward her school, not realizing that her act of leaving the door open will have consequences.\n\nWith the \"keystone\" released, the evil within the other universe can now freely escape and wreak havoc throughout Japan. Intending to correct her dangerous mistake, Suzume joins Souta—whose true goal is to prevent evil from festering—in finding and locking all open doors before the country is destroyed.', 'Romance, Drama', 'CoMix Wave Films', '2 hr. 1 min.', '2023-12-31', '18.00', 'StudioA'),
(14, 'The Garden of  Words', 'https://cdn.discordapp.com/attachments/1025234293976481803/1185306535308578856/The_Garden_of_Words.jpg', 'https://cdn.discordapp.com/attachments/1025234293976481803/1185571561483284540/The_Garden_of_Words_Large.jpg', 'On a rainy morning in Tokyo, Takao Akizuki, an aspiring shoemaker, decides to skip class to sketch designs in a beautiful garden. This is where he meets Yukari Yukino, a beautiful yet mysterious woman, for the very first time. Offering to make her new shoes, Takao continues to meet with Yukari throughout the rainy season, and without even realizing it, the two are able to alleviate the worries hidden in their hearts just by being with each other. However, their personal struggles have not disappeared completely, and as the end of the rainy season approaches, their relationship will be put to the test.', 'Romance', 'CoMix Wave Films', '46 min.', '2024-01-04', '18.00', 'StudioB'),
(15, 'Your NameB', 'https://cdn.discordapp.com/attachments/1025234293976481803/1185280983482769529/YourName.jpg', 'https://cdn.discordapp.com/attachments/1025234293976481803/1185571561793654804/YourName_Large.jpg', 'Mitsuha Miyamizu, a high school girl, yearns to live the life of a boy in the bustling city of Tokyo—a dream that stands in stark contrast to her present life in the countryside. Meanwhile in the city, Taki Tachibana lives a busy life as a high school student while juggling his part-time job and hopes for a future in architecture.\n\nOne day, Mitsuha awakens in a room that is not her own and suddenly finds herself living the dream life in Tokyo—but in Taki\'s body! Elsewhere, Taki finds himself living Mitsuha\'s life in the humble countryside. In pursuit of an answer to this strange phenomenon, they begin to search for one another.\n\nKimi no Na wa. revolves around Mitsuha and Taki\'s actions, which begin to have a dramatic impact on each other\'s lives, weaving them into a fabric held together by fate and circumstance.', 'Drama', 'CoMix Wave Films', '1 hr. 46 min.', '2024-01-06', '12.00', 'StudioA'),
(16, 'Suzume no TojimariA', 'https://cdn.discordapp.com/attachments/1025234293976481803/1185299490027086066/Suzume_no_Tojimari.jpg', 'https://cdn.discordapp.com/attachments/1025234293976481803/1185571561084833862/Suzume_no_Tojimari_Large.jpg', 'On her way to school one day, Suzume Iwato stumbles upon Souta Munakata, a young man searching for abandoned areas. The high school girl directs Souta to a nearby ruin, but out of pure curiosity, she herself decides to head to the same destination.\n\nOnce there, Suzume discovers an isolated door with a dreamlike universe lying beyond it—a place that she can see and feel, but not enter. A strange stone rests on the ground nearby, but it turns into a cat-like creature and scurries away when Suzume lifts it. Suddenly afraid, she heads back toward her school, not realizing that her act of leaving the door open will have consequences.\n\nWith the \"keystone\" released, the evil within the other universe can now freely escape and wreak havoc throughout Japan. Intending to correct her dangerous mistake, Suzume joins Souta—whose true goal is to prevent evil from festering—in finding and locking all open doors before the country is destroyed.', 'Romance, Drama', 'CoMix Wave Films', '2 hr. 1 min.', '2024-01-04', '09.00', 'StudioA'),
(18, 'Suzume no Tojimari', 'https://cdn.discordapp.com/attachments/1025234293976481803/1185299490027086066/Suzume_no_Tojimari.jpg', 'https://cdn.discordapp.com/attachments/1025234293976481803/1185571561084833862/Suzume_no_Tojimari_Large.jpg', 'On her way to school one day, Suzume Iwato stumbles upon Souta Munakata, a young man searching for abandoned areas. The high school girl directs Souta to a nearby ruin, but out of pure curiosity, she herself decides to head to the same destination.\n\nOnce there, Suzume discovers an isolated door with a dreamlike universe lying beyond it—a place that she can see and feel, but not enter. A strange stone rests on the ground nearby, but it turns into a cat-like creature and scurries away when Suzume lifts it. Suddenly afraid, she heads back toward her school, not realizing that her act of leaving the door open will have consequences.\n\nWith the \"keystone\" released, the evil within the other universe can now freely escape and wreak havoc throughout Japan. Intending to correct her dangerous mistake, Suzume joins Souta—whose true goal is to prevent evil from festering—in finding and locking all open doors before the country is destroyed.', 'Romance, Drama', 'CoMix Wave Films', '2 hr. 1 min.', '2024-01-06', '18.00', 'StudioB'),
(19, 'Jujutsu Kaisen 0', 'https://cdn.discordapp.com/attachments/1025234293976481803/1192319948329074688/Jujutsu_Kaisen_0.jpg', 'https://cdn.discordapp.com/attachments/1025234293976481803/1192319948547182632/Jujutsu_Kaisen_0_Large.jpg', 'Violent misfortunes frequently occur around 16-year-old Yuuta Okkotsu, a timid victim of high school bullying. Yuuta is saddled with a monstrous curse, a power that dishes out brutal revenge against his bullies. Rika Orimoto, Yuuta\'s curse, is a shadow from his tragic childhood and a potentially lethal threat to anyone who dares wrong him.\n\nYuuta\'s unique situation catches the attention of Satoru Gojou, a powerful sorcerer who teaches at Tokyo Prefectural Jujutsu High School. Gojou sees immense potential in Yuuta, and he hopes to help the boy channel his deadly burden into a force for good. Yet Yuuta struggles to find his place among his talented classmates: the selectively mute Toge Inumaki, weapons expert Maki Zenin, and Panda.\n\nYuuta clumsily utilizes Rika on missions with the other first-year students, but the grisly aftermath of Rika\'s tremendous displays of power draws the interest of the calculating curse user Suguru Getou. As Getou strives to claim Rika\'s strength and use it to eliminate all non-jujutsu users from the world, Yuuta fights alongside his friends to stop the genocidal plot.', 'Violent', 'MAPPA', '1 hr. 44 min.', '2024-01-12', '12.00', 'StudioA'),
(20, 'Violet Evergarden', 'https://cdn.discordapp.com/attachments/1025234293976481803/1192321934743060512/Violet_Evergarden.jpg', 'https://cdn.discordapp.com/attachments/1025234293976481803/1192321935221207050/Violet_Evergarden_Large.jpg', 'Several years have passed since the end of The Great War. As the radio tower in Leidenschaftlich continues to be built, telephones will soon become more relevant, leading to a decline in demand for \"Auto Memory Dolls.\" Even so, Violet Evergarden continues to rise in fame after her constant success with writing letters. However, sometimes the one thing you long for is the one thing that does not appear.\n\nViolet Evergarden Movie follows Violet as she continues to comprehend the concept of emotion and the meaning of love. At the same time, she pursues a glimmer of hope that the man who once told her, \"I love you,\" may still be alive even after the many years that have passed.', 'Drama', 'Kyoto Animation', '2 hr. 20 min.', '2024-01-11', '09.00', 'StudioB');

-- --------------------------------------------------------

--
-- Table structure for table `seat`
--

CREATE TABLE `seat` (
  `id` int NOT NULL,
  `MovID` varchar(255) NOT NULL,
  `SeatIndex` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Time` varchar(100) NOT NULL,
  `ShowDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `seat`
--

INSERT INTO `seat` (`id`, `MovID`, `SeatIndex`, `Time`, `ShowDate`) VALUES
(1, '3', '6', '18.00', '2023-12-31'),
(2, '3', '10', '18.00', '2023-12-31'),
(3, '3', '6', '18.00', '2023-12-31'),
(4, '3', '10', '18.00', '2023-12-31'),
(5, '3', '15', '18.00', '2023-12-31'),
(6, '3', '16', '18.00', '2023-12-31'),
(7, '3', '14', '18.00', '2023-12-31'),
(8, '2', '14', '09.00', '2023-12-31'),
(9, '2', '10', '09.00', '2023-12-31'),
(10, '2', '3', '09.00', '2023-12-31'),
(11, '15', '14', '09.00', '2024-01-01'),
(12, '16', '17', '18.00', '2024-01-01'),
(13, '15', '1', '09.00', '2024-01-01'),
(14, '15', '2', '09.00', '2024-01-01'),
(15, '15', '3', '09.00', '2024-01-01'),
(16, '14', '2', '12.00', '2024-01-01'),
(17, '16', '16', '18.00', '2024-01-01'),
(18, '16', '10', '18.00', '2024-01-01'),
(19, '16', '6', '18.00', '2024-01-01'),
(20, '15', '17', '09.00', '2024-01-01'),
(21, '15', '13', '09.00', '2024-01-01'),
(22, '16', '2', '09.00', '2024-01-02'),
(23, '16', '6', '09.00', '2024-01-02'),
(24, '16', '2', '09.00', '2024-01-03'),
(25, '16', '15', '09.00', '2024-01-03'),
(26, '16', '1', '09.00', '2024-01-04'),
(27, '16', '5', '09.00', '2024-01-04'),
(28, '16', '6', '09.00', '2024-01-04'),
(29, '15', '1', '12.00', '2024-01-04'),
(30, '15', '2', '12.00', '2024-01-04'),
(31, '15', '3', '12.00', '2024-01-04'),
(32, '18', '19', '18.00', '2024-01-06');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `InvoiceID` int NOT NULL,
  `UserEmail` varchar(255) NOT NULL,
  `MovTitle` varchar(255) NOT NULL,
  `Theather` varchar(100) NOT NULL,
  `ShowTime` varchar(100) NOT NULL,
  `SeatIndex` varchar(255) NOT NULL,
  `Price` int NOT NULL,
  `TransactionDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`InvoiceID`, `UserEmail`, `MovTitle`, `Theather`, `ShowTime`, `SeatIndex`, `Price`, `TransactionDate`) VALUES
(2, 'Email', 'Suzume no Tojimari', 'StudioA', '18.00', '[6, 10]', 24000, '2023-12-31'),
(3, 'Email', 'Suzume no Tojimari', 'StudioA', '18.00', '[6, 10]', 24000, '2023-12-31'),
(4, 'Email', 'Suzume no Tojimari', 'StudioA', '18.00', '[15]', 12000, '2023-12-31'),
(5, 'brindawanyoga@gmail.com', 'Suzume no Tojimari', 'StudioA', '18.00', '[16]', 12000, '2023-12-31'),
(6, 'brindawan@gmail.com', 'Suzume no Tojimari', 'StudioA', '18.00', '[14]', 12000, '2023-12-31'),
(7, 'adriangemok@gmail.com', 'Your Name', 'StudioA', '09.00', '[14, 10, 3]', 36000, '2023-12-31'),
(8, 'Email@gmail.com', 'Your Name', 'StudioA', '09.00', '[14]', 12000, '2024-01-01'),
(9, 'asklasklasd@gmail.com', 'Suzume no Tojimari', 'StudioA', '18.00', '[17]', 12000, '2024-01-01'),
(10, 'Yoga@gmail.com', 'Your Name', 'StudioA', '09.00', '[1, 2, 3]', 36000, '2024-01-01'),
(11, 'test@gmail.com', 'The Garden of  Words', 'StudioA', '12.00', '[2]', 12000, '2024-01-01'),
(12, 'Yoga@gmail.com', 'Suzume no Tojimari', 'StudioA', '18.00', '[16, 10, 6]', 36000, '2024-01-01'),
(13, 'Ramadhan@gmail.com', 'Your Name', 'StudioA', '09.00', '[17, 13]', 24000, '2024-01-01'),
(14, 'arip@gmail.com', 'Suzume no Tojimari', 'StudioA', '09.00', '[2, 6]', 24000, '2024-01-02'),
(15, 'andremanado@gmail.com', 'Suzume no Tojimari', 'StudioA', '09.00', '[15]', 12000, '2024-01-03'),
(16, 'andre@gmail.com', 'Suzume no Tojimari', 'StudioA', '09.00', '[1, 5, 6]', 36000, '2024-01-04'),
(17, 'Yoga@gmail.com', 'Your NameB', 'StudioB', '12.00', '[1, 2, 3]', 96000, '2024-01-04'),
(18, 'brindawan@gmail.com', 'Suzume no Tojimari', 'StudioB', '18.00', '[19]', 24000, '2024-01-06');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`MovieId`);

--
-- Indexes for table `seat`
--
ALTER TABLE `seat`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`InvoiceID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `movie`
--
ALTER TABLE `movie`
  MODIFY `MovieId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `seat`
--
ALTER TABLE `seat`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `InvoiceID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
