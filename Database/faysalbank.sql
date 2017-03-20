-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 20, 2017 at 11:06 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `faysalbank`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE IF NOT EXISTS `account` (
`ACCOUNTID` int(11) NOT NULL,
  `ACCOUNTTYPE` int(11) DEFAULT NULL,
  `AMMOUNT` bigint(20) DEFAULT NULL,
  `CURRENCYTYPE` int(11) DEFAULT NULL,
  `PIN` int(11) DEFAULT NULL,
  `BANKBRANCH_BANKBRANCHID` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`ACCOUNTID`, `ACCOUNTTYPE`, `AMMOUNT`, `CURRENCYTYPE`, `PIN`, `BANKBRANCH_BANKBRANCHID`) VALUES
(1, 1, 5000, 3, 2568, 1),
(2, 1, 500, 1, 1256, 1);

-- --------------------------------------------------------

--
-- Table structure for table `bankbranch`
--

CREATE TABLE IF NOT EXISTS `bankbranch` (
`BANKBRANCHID` int(11) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `LOCATION` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bankbranch`
--

INSERT INTO `bankbranch` (`BANKBRANCHID`, `DESCRIPTION`, `LOCATION`, `NAME`) VALUES
(1, 'Pakistan', '3-A2, 1/111, Karachi', 'Faysal Bank');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
`CUSTOMERID` int(11) NOT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `DATEOFBIRTH` date DEFAULT NULL,
  `DATEOFJOIN` date DEFAULT NULL,
  `GENDER` int(11) DEFAULT NULL,
  `GIVENNAME` varchar(255) DEFAULT NULL,
  `NATIONALITY` varchar(255) DEFAULT NULL,
  `NRIC` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CUSTOMERID`, `ADDRESS`, `DATEOFBIRTH`, `DATEOFJOIN`, `GENDER`, `GIVENNAME`, `NATIONALITY`, `NRIC`, `PASSWORD`, `USERNAME`) VALUES
(1, 'B3rd', '1993-06-08', '2017-03-20', 0, 'nabeel.amd93@gmail.com', 'Pakistan', '31202-1336824-5', 'Pakistan zindabad', 'Ali jan'),
(2, 'B-3rd-2', '2017-03-05', '2017-03-25', 0, 'xxxxx', 'Pakistan', '31202-', 'zindabad', 'jan');

-- --------------------------------------------------------

--
-- Table structure for table `customer_account`
--

CREATE TABLE IF NOT EXISTS `customer_account` (
  `Customer_CUSTOMERID` int(11) NOT NULL,
  `accounts_ACCOUNTID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer_account`
--

INSERT INTO `customer_account` (`Customer_CUSTOMERID`, `accounts_ACCOUNTID`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE IF NOT EXISTS `transaction` (
`TRANSACTIONID` int(11) NOT NULL,
  `AMMOUNT` bigint(20) DEFAULT NULL,
  `CUSTNAME` varchar(255) DEFAULT NULL,
  `RECEIVERACOUNT` int(11) DEFAULT NULL,
  `SENDERACCOUNT` int(11) DEFAULT NULL,
  `TRANSECTIONTIMEANDDATE` date DEFAULT NULL,
  `TYPE` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`TRANSACTIONID`, `AMMOUNT`, `CUSTNAME`, `RECEIVERACOUNT`, `SENDERACCOUNT`, `TRANSECTIONTIMEANDDATE`, `TYPE`) VALUES
(1, 5000, 'nabeel.amd93@gmail.com', NULL, NULL, '2017-03-20', 0),
(2, 500, 'nabeel.amd93@gmail.com', NULL, NULL, '2017-03-20', 2),
(3, 500, 'nabeel.amd93@gmail.com', NULL, NULL, '2017-03-20', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
 ADD PRIMARY KEY (`ACCOUNTID`), ADD KEY `FK_Account_BANKBRANCH_BANKBRANCHID` (`BANKBRANCH_BANKBRANCHID`);

--
-- Indexes for table `bankbranch`
--
ALTER TABLE `bankbranch`
 ADD PRIMARY KEY (`BANKBRANCHID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
 ADD PRIMARY KEY (`CUSTOMERID`);

--
-- Indexes for table `customer_account`
--
ALTER TABLE `customer_account`
 ADD PRIMARY KEY (`Customer_CUSTOMERID`,`accounts_ACCOUNTID`), ADD KEY `FK_Customer_Account_accounts_ACCOUNTID` (`accounts_ACCOUNTID`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
 ADD PRIMARY KEY (`TRANSACTIONID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
MODIFY `ACCOUNTID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `bankbranch`
--
ALTER TABLE `bankbranch`
MODIFY `BANKBRANCHID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
MODIFY `CUSTOMERID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
MODIFY `TRANSACTIONID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
ADD CONSTRAINT `FK_Account_BANKBRANCH_BANKBRANCHID` FOREIGN KEY (`BANKBRANCH_BANKBRANCHID`) REFERENCES `bankbranch` (`BANKBRANCHID`);

--
-- Constraints for table `customer_account`
--
ALTER TABLE `customer_account`
ADD CONSTRAINT `FK_Customer_Account_Customer_CUSTOMERID` FOREIGN KEY (`Customer_CUSTOMERID`) REFERENCES `customer` (`CUSTOMERID`),
ADD CONSTRAINT `FK_Customer_Account_accounts_ACCOUNTID` FOREIGN KEY (`accounts_ACCOUNTID`) REFERENCES `account` (`ACCOUNTID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
