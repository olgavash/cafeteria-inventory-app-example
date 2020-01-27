-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 14, 2020 at 02:07 AM
-- Server version: 5.7.24
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventory`
--

-- --------------------------------------------------------

--
-- Table structure for table `count_sheet`
--

CREATE TABLE `count_sheet` (
  `count_id` int(11) NOT NULL,
  `count` double NOT NULL,
  `inv_date` datetime DEFAULT NULL,
  `product_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `count_sheet`
--

INSERT INTO `count_sheet` (`count_id`, `count`, `inv_date`, `product_id`) VALUES
(311, 3, '2020-01-14 01:34:08', 1),
(312, 5, '2020-01-14 01:34:08', 2),
(313, 6, '2020-01-14 01:34:08', 3),
(314, 2, '2020-01-14 01:34:08', 4),
(315, 4, '2020-01-14 01:34:08', 5),
(316, 5, '2020-01-14 01:34:08', 6),
(317, 2, '2020-01-14 01:34:08', 7);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(318),
(318),
(318);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `cost_per_purchase_uofm` float NOT NULL,
  `name` varchar(255) NOT NULL,
  `purchase_unit_measure` varchar(255) NOT NULL,
  `vendor` varchar(255) NOT NULL,
  `vendor_product_num` varchar(255) NOT NULL,
  `product_class_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `cost_per_purchase_uofm`, `name`, `purchase_unit_measure`, `vendor`, `vendor_product_num`, `product_class_id`) VALUES
(1, 45, 'Mango', 'cs', 'US Food', '67548393', 4),
(2, 56, 'Ham 20oz pkg', 'cs', 'US Food', '67548393', 2),
(3, 23, 'Milk 5gal ', 'cs', 'US Food', '67548393', 3),
(4, 120, 'Beef 3lb pkg', 'cs', 'US Food', '67548393', 2),
(5, 25, 'Grape 5lb', 'cs', 'US Food', '67548393', 4),
(6, 35, 'Chocolate milk 5gal', 'cs', 'US Food', '67548393', 2),
(7, 45, 'Almonds 4 1lb pkg', 'cs', 'US Food', '67548393', 6);

-- --------------------------------------------------------

--
-- Table structure for table `product_class`
--

CREATE TABLE `product_class` (
  `product_class_id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product_class`
--

INSERT INTO `product_class` (`product_class_id`, `description`) VALUES
(4, 'Bakery'),
(3, 'Produce'),
(2, 'Dairy'),
(1, 'Meat'),
(5, 'Grocery'),
(6, 'Beverage'),
(7, 'Paper'),
(8, 'Janitorial');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `count_sheet`
--
ALTER TABLE `count_sheet`
  ADD PRIMARY KEY (`count_id`),
  ADD KEY `FKr7xtkmu7xqfu9ptb6358tj2eh` (`product_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `FK5g7do1yby2n4monwfjw1q79kc` (`product_class_id`);

--
-- Indexes for table `product_class`
--
ALTER TABLE `product_class`
  ADD PRIMARY KEY (`product_class_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
