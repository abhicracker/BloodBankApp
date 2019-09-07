-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Sep 07, 2019 at 05:14 PM
-- Server version: 5.6.41-84.1-log
-- PHP Version: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gcoeacs6_lifeonetouch`
--

-- --------------------------------------------------------

--
-- Table structure for table `blood_banks`
--

CREATE TABLE `blood_banks` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `lat` varchar(200) DEFAULT NULL,
  `lon` varchar(200) DEFAULT NULL,
  `address` text,
  `contact` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `blood_banks`
--

INSERT INTO `blood_banks` (`id`, `name`, `lat`, `lon`, `address`, `contact`) VALUES
(7, 'Samiksha Blood Bank', '20.96460542775062', '77.75721487329372', 'Near Kathora Naka', '9796264565'),
(6, 'Bajali Blood Bank', '20.929836830513484', '77.76681718156738', 'Near Bus Station, Amravati', '7894561235'),
(8, 'Sanjivani blood Bank', '', '', 'Near by sai nagar', '7720962608');

-- --------------------------------------------------------

--
-- Table structure for table `donor`
--

CREATE TABLE `donor` (
  `id` int(11) NOT NULL,
  `name` varchar(300) DEFAULT NULL,
  `bg` varchar(20) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `password` varchar(300) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `age` varchar(10) DEFAULT NULL,
  `weight` varchar(10) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `address` text
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `donor`
--

INSERT INTO `donor` (`id`, `name`, `bg`, `email`, `password`, `gender`, `age`, `weight`, `phone`, `address`) VALUES
(1, 'abhi', 'A+', NULL, NULL, 'male', '23', '74', '9172433994', 'asas'),
(2, 'h', NULL, 'sy', 'ah', 'Male', 'v', 'h', 'ga', 'ya'),
(3, 'Abhishek Sarkate', 'B-', 'aa@a.com', '123', 'Female', 'n', 'j', '12', 'amrt'),
(6, 'Sam Timande', 'A -', 'sam@mail.com', '123', 'Male', '23', '56', '9172433994', 'Badnera'),
(7, 'sushma sarkate', 'O +', 'sushma@mail.com', '123', 'Female', '43', '65', '8421209931', 'Shegaon Naka'),
(8, 'Sipna Donor', 'A +', 'donor@sipna.com', '123', 'Male', '23', '56', '8989121212', 'Dastur Nagar'),
(9, 'Aditya Sarkate', 'AB -', 'adi@mail.com', '123', 'Male', '24', '75', '9172433994', 'Rajapeth'),
(10, 'Samiksha Timande', 'A -', 'samikshatimande02@gmail.com', '2816', 'Female', '21', '44', '9096146291', 'Sai Nagar'),
(11, 'Saloni Ghadwe', 'O +', 'salonighadwe14@gmail.com', 'saloni@1033', 'Female', '22', '60', '8007538505', 'Dastur Nagar'),
(12, 'Diksha Abhiman Bansod', 'A +', 'dikshabansod4010@gmail.com', 'diksha', 'Female', '21', '40', '7720962608', 'Badnera'),
(13, 'Shreyash Gonge', 'A +', 'shreyashgonge11@gmail.com', 'shreyash@11', 'Male', '18', '55', '+91932543369', 'Sai Nagar'),
(14, 'Darshana Bhonde', 'B +', 'darshna01bhonde@gmail.com', 'Princess08', 'Female', '21', '58', '7083736885', 'Shegaon Naka'),
(15, 'mayuri gonge', 'A +', 'mayurigonge25@gmail.com', 'mayuri@25', 'Female', '23', '52', '7066738755', 'Badnera'),
(16, 'mayuri gonge', 'A +', 'mayurigonge25@gmail.com', 'mayuri@25', 'Female', '23', '52', '7066738755', 'Badnera'),
(17, 'Kaustubh Lahane', 'AB +', 'k@mail.com', '123', 'Male', '24', '65', '8645123484', 'Rajapeth'),
(18, 'Shubham', 'AB -', 's@mail.com', '123', 'Male', '21', '69', '895462349', 'Rajapeth'),
(19, 'saurabh talekar', 'AB -', 'talekarsaurabh01@gmail.com', 'madoo', 'Female', '21', '70', '8669023680', 'Dastur Nagar'),
(20, 'saurabh talekar', 'AB -', 'talekarsaurabh01@gmail.com', 'madoo', 'Female', '21', '70', '8669023680', 'Dastur Nagar'),
(21, 'saurabh talekar', 'AB -', 'talekarsaurabh01@gmail.com', 'madoo', 'Female', '21', '70', '8669023680', 'Dastur Nagar'),
(22, 'Shubham t', 'B +', 's@s.com', '123', 'Male', '764', '97', '12345', 'Dastur Nagar'),
(23, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(24, 'chetan', 'A +', 'chetanpohane11.cp@gmail.com', '8888054678', 'Male', '25', '65', '8888054678', 'Sai Nagar'),
(25, 'Prajapati Adhau', 'O +', 'prajapatiadhau@gmail.com', 'password', 'Male', '21', '55', '+17038951022', 'Badnera'),
(26, 'Prajapati Adhau', 'O +', 'prajapatiadhau@gmail.com', 'password', 'Male', '21', '55', '+17038951022', 'Badnera'),
(27, 'Nikhil Gadge', 'AB +', 'nikhilgadge16@gmail.con', 'nikhil', 'Male', '22', '50', '9552451093', 'Shegaon Naka'),
(28, 'K lahane', 'A -', 'k@mail.com', '123', 'Male', '25', '58', '246457976764', 'Sai Nagar'),
(29, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(30, 'Vandana Bansod ', 'B +', 'vandanabansod01@gmail.com', 'vandana', 'Female', '35', '52', '9011948388', 'Rajapeth'),
(31, 'Sanjay Gadge', 'O +', 'sanjaygadge01@gmail.com', 'sanjay', 'Male', '43', '62', '8880808322', 'Badnera'),
(32, 'Piyush Damaani ', 'O -', 'piyushdammani@gmail.com', 'piyush', 'Male', '22', '54', '7020491240', 'Sai Nagar'),
(33, 'Ankit Sontake ', 'B -', 'ankitsontakke517@gmail.com', 'ankit', 'Male', '22', '55', '91950337387', 'Badnera'),
(34, 'Shubham Kawre', 'B +', 'Shubhamkawre999@gmail.com', 'shubham', 'Male', '24', '67', '91823776887', 'Shegaon Naka'),
(35, 'Nilima Gadge ', 'A -', 'nilimagadge@gmail.com', 'nilima', 'Female', '36', '58', '91902140625', 'Dastur Nagar'),
(36, 'Swapnil Bansod', 'B -', 'swapnilbansod16@gmail.com', 'swapnil', 'Male', '20', '50', '9834417832', 'Rajapeth'),
(37, 'rutuja khodke', 'A -', 'rutujakhodke@gmail.com', '1234', 'Female', '21', '50', '+61917972118', 'Sai Nagar'),
(38, 'rutuja khodke', 'A -', 'rutujakhodke@gmail.com', '1234', 'Female', '21', '50', '+61917972118', 'Sai Nagar'),
(39, 'Kishor Narule', 'B +', 'kishornarule7@gmail.com', 'kishornarule7', 'Male', '21', '45', '7775975987', 'Badnera'),
(40, 'Aishwarya Choudhary', 'O +', 'aishchoudhary12@gmail.com', 'aish', 'Female', '22', '48', '7620127336', 'Rajapeth'),
(41, 'Diksha Abhiman Bansod', 'AB +', 'dikdhabansod4@gmail.com', 'diksha', 'Female', '25', '50', '9096966566', 'Rajapeth'),
(42, 'ss', 'A -', 'shadi.sarang512@gmail.com', '123', 'Male', '18', '62', '9096603426', 'Sai Nagar'),
(43, 'Abhishek Sarkate', 'A -', 'a@a.com', '123', 'Male', '23', '65', '9172433994', 'Badnera');

-- --------------------------------------------------------

--
-- Table structure for table `emergency`
--

CREATE TABLE `emergency` (
  `id` int(11) NOT NULL,
  `name` varchar(300) NOT NULL,
  `description` text NOT NULL,
  `phone` varchar(12) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `emergency`
--

INSERT INTO `emergency` (`id`, `name`, `description`, `phone`) VALUES
(1, 'police', 'Maharashtra Police', '8989787845'),
(2, 'Prahar Ambulance', 'Free Of Cost 24/7 Ambulance Service', '9898784562'),
(3, 'Sipna Ambulance Services', '24/7 Available  ,Mini ICU Van available', '7745854122');

-- --------------------------------------------------------

--
-- Table structure for table `helplines`
--

CREATE TABLE `helplines` (
  `id` int(11) NOT NULL,
  `name` varchar(300) NOT NULL,
  `description` text NOT NULL,
  `contact` varchar(15) NOT NULL,
  `city` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `helplines`
--

INSERT INTO `helplines` (`id`, `name`, `description`, `contact`, `city`) VALUES
(1, 'Police', 'Rajapeth Police Station,Amravati.', '100', 'Amravati'),
(2, 'Fire', 'All City Fire Brigade', '101', 'Amravati'),
(4, 'Amravati  General Hospital', 'Irwin Chowk, ', '0721 452458', 'Amravati');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `blood_banks`
--
ALTER TABLE `blood_banks`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `donor`
--
ALTER TABLE `donor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `emergency`
--
ALTER TABLE `emergency`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `helplines`
--
ALTER TABLE `helplines`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `blood_banks`
--
ALTER TABLE `blood_banks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `donor`
--
ALTER TABLE `donor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `emergency`
--
ALTER TABLE `emergency`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `helplines`
--
ALTER TABLE `helplines`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
