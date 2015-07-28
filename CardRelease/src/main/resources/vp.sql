/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.19 : Database - vipcard
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
USE `vipcard`;

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

/*Data for the table `t_dot` */

insert  into `t_dot`(`dotId`,`address`,`fax`,`ip`,`name`,`operateDate`,`operator`,`phone1`,`phone2`) values ('0001','网点名0000','11111','1.1.11','网点名001','2015-07-16 22:35:58','test','1111','1111'),('0002','222222222222','2222222222','2.2.2.2','网点名002','2015-07-16 22:36:17','test','222222222','22222222'),('0003','333333333','3333333','3.3.3.3','网点名003','2015-07-16 22:36:37','test','33333333','333333'),('0004','44444444444','44444444444','4.4.4.4','网点名004','2015-07-16 22:36:54','test','4444444444444','444444444'),('0005','12345','55555555','5.5.5.5','网点名005','2015-07-27 00:20:52','1','55555555555','555555'),('1234','11111111','','','11111111','2015-07-27 00:17:19','1','11111111','');

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `t_function` */

insert  into `t_function`(`functionId`,`createDate`,`functionName`,`operateDate`,`operator`,`state`,`url`,`parentId`) values (1,'2015-07-16 22:41:26','主页内容','2015-07-17 19:39:10','test','1','/index',NULL),(2,'2015-07-16 22:41:32','网点管理','2015-07-17 23:02:25','test','1','/dot',NULL),(3,'2015-07-16 22:41:38','客户管理','2015-07-17 23:02:38','test','1','/customer',NULL),(4,'2015-07-17 19:41:54','基础数据','2015-07-17 19:41:54','test','1','/basedata',NULL),(5,'2015-07-17 19:42:16','用户与授权','2015-07-17 19:42:16','test','1','/authority',NULL),(6,'2015-07-17 19:42:46','卡初始化','2015-07-17 19:42:46','test','1','/cardRelease',NULL),(7,'2015-07-17 19:43:03','VIP卡消费扣点','2015-07-17 19:43:03','test','1','/trade/comsume',NULL),(8,'2015-07-17 19:43:19','VIP卡充点','2015-07-17 19:43:19','test','1','/trade/recharge',NULL),(9,'2015-07-18 00:57:25','网点管理报表','2015-07-18 00:57:25','test','1','/dotReport',NULL),(10,'2015-07-18 00:57:53','客户交易报表','2015-07-18 00:57:53','test','1','/customerReport',NULL),(11,'2015-07-26 18:14:11','系统功能名字XX','2015-07-26 18:17:15','1','1','/basedfsdfsdfsfsDDD',NULL);

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

/*Data for the table `t_hairpin` */

insert  into `t_hairpin`(`hairpinNo`,`cardNo`,`cardPhysicalAdd`,`hairpinTime`,`operateDate`,`operator`) values ('11','111111','11111111','2015-07-19 23:47:20','2015-07-19 23:47:22','111');

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

/*Data for the table `t_kdlimit` */

insert  into `t_kdlimit`(`limitNo`,`limitName`,`limitPoint`,`operateDate`,`operator`,`bankCardTypeId`) values ('2015072601','fsdf','1','2015-07-26 19:00:44','1',NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_role` */

insert  into `t_role`(`roleId`,`operateDate`,`operator`,`remark`,`roleName`,`setTime`,`state`,`validTime`) values (1,'2015-07-17 19:43:56','test','对当前系统角色的说明..','超级管理员','2015-07-16 22:40:42','0','2020-07-16 00:00:00'),(2,'2015-07-17 19:44:34','test','对当前系统角色的说明..','部分功能1','2015-07-16 22:40:48','0','2020-07-16 00:00:00'),(3,'2015-07-17 19:45:03','test','对当前系统角色的说明..sfs','部分功能','2015-07-16 22:41:02','0','2020-07-16 00:00:00'),(4,'2015-07-16 22:41:09','test','ddsdad','角色名04','2015-07-16 22:41:09','0','2020-07-16 00:00:00'),(5,'2015-07-26 18:10:24','1','gdg ','角色名XX','2015-07-26 18:07:32','0','2020-07-31 00:00:00');

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

/*Data for the table `t_role_function` */

insert  into `t_role_function`(`operateDate`,`operator`,`roleId`,`functionId`) values ('2015-07-18 00:58:30','test',1,1),('2015-07-17 19:44:48','test',2,1),('2015-07-18 00:58:30','test',1,2),('2015-07-17 19:44:48','test',2,2),('2015-07-18 00:58:30','test',1,3),('2015-07-17 19:44:48','test',2,3),('2015-07-18 00:58:30','test',1,4),('2015-07-17 19:44:48','test',2,4),('2015-07-18 00:58:30','test',1,5),('2015-07-17 19:45:17','test',3,5),('2015-07-18 00:58:30','test',1,6),('2015-07-17 19:45:17','test',3,6),('2015-07-18 00:58:30','test',1,7),('2015-07-17 19:45:17','test',3,7),('2015-07-18 00:58:30','test',1,8),('2015-07-17 19:45:17','test',3,8),('2015-07-18 00:58:30','test',1,9),('2015-07-18 00:58:30','test',1,10);

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

/*Data for the table `t_tradepoint` */

insert  into `t_tradepoint`(`tradePointNo`,`cardNo`,`operateDate`,`operator`,`ptAfter`,`ptBefore`,`ptTrade`,`tradeDate`,`tradeType`,`bankCardNo`,`dotId`) values ('201507260001','222222','2015-07-26 22:24:10','1','11','0','11','2015-07-26 22:24:10','1','1111111111111111','0001');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`userId`,`loginName`,`operateDate`,`operator`,`password`,`phone`,`sex`,`userName`,`dotId`,`roleId`) values (1,'admin','2015-07-27 01:32:02','1','a66abb5684c45962d887564f08346e8d','111111','0','用户真实姓名','0001',1),(2,'test','2015-07-17 23:36:55','test','96e79218965eb72c92a549dd5a330112','111111','0','用户真实姓名02','0002',2),(4,'1111','2015-07-26 17:44:31','1','96e79218965eb72c92a549dd5a330112','','0','louise','0001',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
