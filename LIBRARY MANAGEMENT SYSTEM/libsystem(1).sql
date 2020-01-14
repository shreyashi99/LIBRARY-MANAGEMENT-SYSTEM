-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 20, 2019 at 10:14 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `libsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `book_category`
--

CREATE TABLE IF NOT EXISTS `book_category` (
  `Sl_no` int(10) DEFAULT NULL,
  `Sem` varchar(30) DEFAULT NULL,
  `Category` varchar(20) NOT NULL,
  `Sub_category` int(30) DEFAULT NULL,
  PRIMARY KEY (`Category`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book_category`
--

INSERT INTO `book_category` (`Sl_no`, `Sem`, `Category`, `Sub_category`) VALUES
(1, '5th', 'CSE', 2),
(2, '5th', 'ECE', 2);

-- --------------------------------------------------------

--
-- Table structure for table `fine`
--

CREATE TABLE IF NOT EXISTS `fine` (
  `Member_id` varchar(30) DEFAULT NULL,
  `Book_id` int(10) DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `return_date` date DEFAULT NULL,
  `days_late` int(10) DEFAULT NULL,
  `fine` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fine`
--

INSERT INTO `fine` (`Member_id`, `Book_id`, `due_date`, `return_date`, `days_late`, `fine`) VALUES
('SRC123', 602, '2019-07-25', '2019-08-04', 10, 500);

-- --------------------------------------------------------

--
-- Table structure for table `lending`
--

CREATE TABLE IF NOT EXISTS `lending` (
  `trans_id` int(5) NOT NULL AUTO_INCREMENT,
  `Member_name` varchar(30) NOT NULL,
  `Member_id` varchar(30) NOT NULL,
  `book_id` int(10) NOT NULL,
  `Sub_category` varchar(30) NOT NULL,
  `Book_name` varchar(30) NOT NULL,
  `Category` varchar(30) NOT NULL,
  `units` int(5) NOT NULL,
  `Issue_date` date NOT NULL,
  `due_date` date NOT NULL,
  PRIMARY KEY (`trans_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=52 ;

--
-- Dumping data for table `lending`
--

INSERT INTO `lending` (`trans_id`, `Member_name`, `Member_id`, `book_id`, `Sub_category`, `Book_name`, `Category`, `units`, `Issue_date`, `due_date`) VALUES
(49, 'Shreyashi', 'SRC123', 501, 'java', 'Effective java', 'CSE', 1, '2019-07-19', '2019-07-26'),
(50, 'Shreyashi', 'SRC123', 505, 'C++', 'Jumping into C++', 'CSE', 1, '2019-07-19', '2019-07-26'),
(51, 'Shreyashi', 'SRC123', 603, 'Digital Electronics', 'Digital Electronics', 'ECE', 1, '2019-07-19', '2019-07-26');

-- --------------------------------------------------------

--
-- Table structure for table `member_login`
--

CREATE TABLE IF NOT EXISTS `member_login` (
  `User_id` varchar(30) NOT NULL,
  `Password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`User_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member_login`
--

INSERT INTO `member_login` (`User_id`, `Password`) VALUES
('SRC123', 'SRC');

-- --------------------------------------------------------

--
-- Table structure for table `registration_details`
--

CREATE TABLE IF NOT EXISTS `registration_details` (
  `First_name` varchar(30) DEFAULT NULL,
  `Last_name` varchar(30) DEFAULT NULL,
  `Contact` int(20) DEFAULT NULL,
  `Member_id` varchar(30) DEFAULT NULL,
  KEY `User_id` (`Member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registration_details`
--

INSERT INTO `registration_details` (`First_name`, `Last_name`, `Contact`, `Member_id`) VALUES
('Shreyashi', 'Chowdhury', 2147483647, 'SRC123');

-- --------------------------------------------------------

--
-- Table structure for table `return_book`
--

CREATE TABLE IF NOT EXISTS `return_book` (
  `trans_id` int(5) NOT NULL,
  `Member_name` varchar(30) DEFAULT NULL,
  `Member_id` varchar(30) DEFAULT NULL,
  `book_id` int(10) DEFAULT NULL,
  `Subcategory` varchar(30) DEFAULT NULL,
  `Book_name` varchar(30) DEFAULT NULL,
  `Category` varchar(30) DEFAULT NULL,
  `Unit` int(5) DEFAULT NULL,
  `Issue_date` date DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `return_date` date DEFAULT NULL,
  PRIMARY KEY (`trans_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `return_book`
--

INSERT INTO `return_book` (`trans_id`, `Member_name`, `Member_id`, `book_id`, `Subcategory`, `Book_name`, `Category`, `Unit`, `Issue_date`, `due_date`, `return_date`) VALUES
(48, 'Shreyashi', 'SRC123', 602, 'Microelectric Circuit', 'Microelectric Circuit 5th edit', 'ECE', 1, '2019-07-18', '2019-07-25', '2019-08-04');

-- --------------------------------------------------------

--
-- Table structure for table `subcategory`
--

CREATE TABLE IF NOT EXISTS `subcategory` (
  `book_id` int(10) DEFAULT NULL,
  `Sub_category` varchar(30) DEFAULT NULL,
  `Book_name` varchar(30) DEFAULT NULL,
  `Category` varchar(20) DEFAULT NULL,
  KEY `Category` (`Category`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subcategory`
--

INSERT INTO `subcategory` (`book_id`, `Sub_category`, `Book_name`, `Category`) VALUES
(501, 'java', 'Effective java', 'CSE'),
(502, 'java', 'Clean Code', 'CSE'),
(503, 'java', 'Spring in action', 'CSE'),
(504, 'C++', 'C++ primer', 'CSE'),
(505, 'C++', 'Jumping into C++', 'CSE'),
(601, 'Microelectric Circuit', 'Microelectric Circuit analysis', 'ECE'),
(602, 'Microelectric Circuit', 'Microelectric Circuit 5th edit', 'ECE'),
(603, 'Digital Electronics', 'Digital Electronics', 'ECE'),
(604, 'Digital Electronics', 'Modern Digital Electronics', 'ECE');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `registration_details`
--
ALTER TABLE `registration_details`
  ADD CONSTRAINT `registration_details_ibfk_1` FOREIGN KEY (`Member_id`) REFERENCES `member_login` (`User_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `subcategory`
--
ALTER TABLE `subcategory`
  ADD CONSTRAINT `subcategory_ibfk_1` FOREIGN KEY (`Category`) REFERENCES `book_category` (`Category`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
