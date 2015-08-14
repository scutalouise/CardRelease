/*
SQLyog Ultimate v11.27 (64 bit)
MySQL - 5.6.25-log : Database - vipcard
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`vipcard` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `vipcard`;

/*Table structure for table `t_bankcardtype` */

DROP TABLE IF EXISTS `t_bankcardtype`;

CREATE TABLE `t_bankcardtype` (
  `bankCardTypeId` varchar(2) NOT NULL,
  `name` varchar(30) NOT NULL,
  `operateDate` datetime NOT NULL,
  `operator` varchar(20) NOT NULL,
  PRIMARY KEY (`bankCardTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_cardoper` */

DROP TABLE IF EXISTS `t_cardoper`;

CREATE TABLE `t_cardoper` (
  `operNo` varchar(12) NOT NULL,
  `newCardNo` varchar(6) DEFAULT NULL,
  `oldCardNo` varchar(6) NOT NULL,
  `operDate` datetime NOT NULL,
  `operType` varchar(1) NOT NULL,
  `operateDate` datetime NOT NULL,
  `operator` varchar(20) NOT NULL,
  `remainingPt` varchar(4) NOT NULL,
  `dotId` varchar(20) NOT NULL,
  PRIMARY KEY (`operNo`),
  KEY `FK_fcs299vpa8divdji4wrwp7yeb` (`dotId`),
  CONSTRAINT `FK_fcs299vpa8divdji4wrwp7yeb` FOREIGN KEY (`dotId`) REFERENCES `t_dot` (`dotId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_customer` */

DROP TABLE IF EXISTS `t_customer`;

CREATE TABLE `t_customer` (
  `bankCardNo` varchar(30) NOT NULL,
  `cardNo` varchar(6) NOT NULL,
  `customerName` varchar(24) NOT NULL,
  `customerTel` varchar(20) NOT NULL,
  `hairpinDot` varchar(24) NOT NULL,
  `invalid` date NOT NULL,
  `loss` varchar(1) NOT NULL,
  `operateDate` datetime NOT NULL,
  `operator` varchar(4) NOT NULL,
  `originalPt` varchar(4) NOT NULL,
  `remainingPt` varchar(4) NOT NULL,
  `bankCardTypeId` varchar(2) NOT NULL,
  PRIMARY KEY (`bankCardNo`),
  KEY `FK_fnnleb5w5yapcdr8mf74ft55w` (`bankCardTypeId`),
  CONSTRAINT `FK_fnnleb5w5yapcdr8mf74ft55w` FOREIGN KEY (`bankCardTypeId`) REFERENCES `t_bankcardtype` (`bankCardTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_dot` */

DROP TABLE IF EXISTS `t_dot`;

CREATE TABLE `t_dot` (
  `dotId` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `fax` varchar(50) DEFAULT NULL,
  `ip` varchar(15) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `operateDate` datetime NOT NULL,
  `operator` varchar(20) NOT NULL,
  `phone1` varchar(20) NOT NULL,
  `phone2` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`dotId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_function` */

DROP TABLE IF EXISTS `t_function`;

CREATE TABLE `t_function` (
  `functionId` bigint(20) NOT NULL AUTO_INCREMENT,
  `createDate` datetime NOT NULL,
  `functionName` varchar(50) NOT NULL,
  `operateDate` datetime NOT NULL,
  `operator` varchar(20) NOT NULL,
  `state` varchar(1) NOT NULL,
  `url` varchar(200) NOT NULL,
  `parentId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`functionId`),
  KEY `FK_9kxthsmtq6lfhpao4jkg3w9gn` (`parentId`),
  CONSTRAINT `FK_9kxthsmtq6lfhpao4jkg3w9gn` FOREIGN KEY (`parentId`) REFERENCES `t_function` (`functionId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Table structure for table `t_hairpin` */

DROP TABLE IF EXISTS `t_hairpin`;

CREATE TABLE `t_hairpin` (
  `hairpinNo` varchar(12) NOT NULL,
  `cardNo` varchar(6) NOT NULL,
  `cardPhysicalAdd` varchar(8) NOT NULL,
  `hairpinTime` datetime NOT NULL,
  `operateDate` datetime NOT NULL,
  `operator` varchar(20) NOT NULL,
  PRIMARY KEY (`hairpinNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_kdlimit` */

DROP TABLE IF EXISTS `t_kdlimit`;

CREATE TABLE `t_kdlimit` (
  `limitNo` varchar(10) NOT NULL,
  `limitName` varchar(50) NOT NULL,
  `limitPoint` varchar(2) NOT NULL,
  `operateDate` datetime NOT NULL,
  `operator` varchar(20) NOT NULL,
  `bankCardTypeId` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`limitNo`),
  KEY `FK_97bcwua06ielrhbb2p956ij2c` (`bankCardTypeId`),
  CONSTRAINT `FK_97bcwua06ielrhbb2p956ij2c` FOREIGN KEY (`bankCardTypeId`) REFERENCES `t_bankcardtype` (`bankCardTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `roleId` bigint(20) NOT NULL AUTO_INCREMENT,
  `operateDate` datetime NOT NULL,
  `operator` varchar(20) NOT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `roleName` varchar(50) NOT NULL,
  `setTime` datetime NOT NULL,
  `state` varchar(1) NOT NULL,
  `validTime` datetime DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Table structure for table `t_role_function` */

DROP TABLE IF EXISTS `t_role_function`;

CREATE TABLE `t_role_function` (
  `operateDate` datetime NOT NULL,
  `operator` varchar(20) NOT NULL,
  `roleId` bigint(20) NOT NULL,
  `functionId` bigint(20) NOT NULL,
  PRIMARY KEY (`functionId`,`roleId`),
  KEY `FK_4t4kpd2373y1mahhfc9vv86gt` (`roleId`),
  CONSTRAINT `FK_3pkemujswsf8fdfit9k7gv21t` FOREIGN KEY (`functionId`) REFERENCES `t_function` (`functionId`),
  CONSTRAINT `FK_4t4kpd2373y1mahhfc9vv86gt` FOREIGN KEY (`roleId`) REFERENCES `t_role` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_tradepoint` */

DROP TABLE IF EXISTS `t_tradepoint`;

CREATE TABLE `t_tradepoint` (
  `tradePointNo` varchar(12) NOT NULL,
  `cardNo` varchar(6) NOT NULL,
  `operateDate` datetime NOT NULL,
  `operator` varchar(20) NOT NULL,
  `ptAfter` varchar(4) NOT NULL,
  `ptBefore` varchar(4) NOT NULL,
  `ptTrade` varchar(4) NOT NULL,
  `tradeDate` datetime NOT NULL,
  `tradeType` varchar(1) NOT NULL,
  `bankCardNo` varchar(30) NOT NULL,
  `dotId` varchar(20) NOT NULL,
  PRIMARY KEY (`tradePointNo`),
  KEY `FK_ui3ejlcvflqqqrfg32mtm9yp` (`bankCardNo`),
  KEY `FK_hefujeturmmkm1tcfjxrmrff5` (`dotId`),
  CONSTRAINT `FK_hefujeturmmkm1tcfjxrmrff5` FOREIGN KEY (`dotId`) REFERENCES `t_dot` (`dotId`),
  CONSTRAINT `FK_ui3ejlcvflqqqrfg32mtm9yp` FOREIGN KEY (`bankCardNo`) REFERENCES `t_customer` (`bankCardNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT,
  `loginName` varchar(20) NOT NULL,
  `operateDate` datetime NOT NULL,
  `operator` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `dotId` varchar(20) DEFAULT NULL,
  `roleId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  KEY `FK_l6c0c2yu8mi5safcosiabmiul` (`dotId`),
  KEY `FK_spclh76sfwy8rs8a71cvoapke` (`roleId`),
  CONSTRAINT `FK_l6c0c2yu8mi5safcosiabmiul` FOREIGN KEY (`dotId`) REFERENCES `t_dot` (`dotId`),
  CONSTRAINT `FK_spclh76sfwy8rs8a71cvoapke` FOREIGN KEY (`roleId`) REFERENCES `t_role` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
