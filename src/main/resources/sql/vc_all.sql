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

/*Data for the table `t_bankcardtype` */

insert  into `t_bankcardtype`(`bankCardTypeId`,`name`,`operateDate`,`operator`) values ('00','银行卡类型001','2015-07-21 10:54:04','1'),('01','银行卡类型01','2015-07-16 14:56:07','test'),('02','银行卡类型02','2015-07-16 14:56:15','test');

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

/*Data for the table `t_cardoper` */

insert  into `t_cardoper`(`operNo`,`newCardNo`,`oldCardNo`,`operDate`,`operType`,`operateDate`,`operator`,`remainingPt`,`dotId`) values ('201507280001',NULL,'222222','2015-07-28 16:35:21','1','2015-07-28 16:35:21','1','22','0001'),('20150728002',NULL,'222222','2015-07-28 16:44:41','2','2015-07-28 16:44:41','1','22','0001'),('20150728003',NULL,'222222','2015-07-28 16:45:34','1','2015-07-28 16:45:34','1','22','0001'),('20150728004','333333','222222','2015-07-28 18:41:37','3','2015-07-28 18:41:37','1','22','0001');

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

/*Data for the table `t_customer` */

insert  into `t_customer`(`bankCardNo`,`cardNo`,`customerName`,`customerTel`,`hairpinDot`,`invalid`,`loss`,`operateDate`,`operator`,`originalPt`,`remainingPt`,`bankCardTypeId`) values ('1111111111111111111','111111','111111','11111111','开江','2020-07-27','0','2015-07-27 16:26:17','1','11','4','00'),('222222222222222','333333','222222222','22222222222','通川区','2020-07-29','2','2015-07-28 18:41:37','1','22','22','01');

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

insert  into `t_dot`(`dotId`,`address`,`fax`,`ip`,`name`,`operateDate`,`operator`,`phone1`,`phone2`) values ('0000','**市**县(区)**街道(乡镇)**街*号 ','02811111111','1.1.1.1','管理中心','2015-07-29 15:41:21','1','02888888888','02866666666'),('0001','测试网点0001','123456','1.1.1.1','测试网点0001','2015-07-16 14:54:44','test','123456','123456'),('0002','测试网点0002','22222','2.2.2.2','测试网点0002','2015-07-16 14:55:06','test','11111','22222');

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

/*Data for the table `t_function` */

insert  into `t_function`(`functionId`,`createDate`,`functionName`,`operateDate`,`operator`,`state`,`url`,`parentId`) values (1,'2015-07-16 14:39:29','主页内容','2015-07-17 17:12:43','test','1','/index',NULL),(2,'2015-07-16 14:59:09','网点管理','2015-07-20 09:21:06','test','1','/dot',NULL),(3,'2015-07-16 16:03:33','客户管理','2015-07-20 09:19:26','test','1','/customer',NULL),(7,'2015-07-16 16:03:51','用户与授权','2015-07-17 11:50:08','test','1','/authority',NULL),(8,'2015-07-16 16:04:18','新卡初始化','2015-07-17 11:54:45','test','1','/cardRelease',NULL),(9,'2015-07-16 16:04:24','挂失处理','2015-07-29 15:37:54','1','1','/loss',NULL),(10,'2015-07-16 16:04:29','体验卡消费','2015-07-27 15:57:05','1','1','/trade/comsume',NULL),(15,'2015-07-17 13:57:38','体验卡充点','2015-07-27 15:57:23','1','1','/trade/recharge',NULL),(16,'2015-07-20 09:12:23','网点管理报表','2015-07-20 09:12:23','test','1','/dotReport',NULL),(17,'2015-07-20 09:13:10','客户交易查询','2015-07-20 09:13:10','test','1','/customerReport',NULL),(18,'2015-07-27 16:32:17','基础数据','2015-07-29 15:38:18','1','1','/basedata',NULL);

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

insert  into `t_hairpin`(`hairpinNo`,`cardNo`,`cardPhysicalAdd`,`hairpinTime`,`operateDate`,`operator`) values ('201507270001','111111','54D25627','2015-07-27 14:31:44','2015-07-27 14:31:44','1'),('201507280002','222222','54D76397','2015-07-28 16:32:47','2015-07-28 16:32:47','1'),('201507280003','333333','54D74427','2015-07-28 17:21:54','2015-07-28 17:21:54','1');

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

insert  into `t_kdlimit`(`limitNo`,`limitName`,`limitPoint`,`operateDate`,`operator`,`bankCardTypeId`) values ('2015072101','dfsd','11','2015-07-21 09:30:49','1','01');

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

/*Data for the table `t_role` */

insert  into `t_role`(`roleId`,`operateDate`,`operator`,`remark`,`roleName`,`setTime`,`state`,`validTime`) values (1,'2015-07-17 13:59:02','test','对当前系统角色的说明','超级管理员','2015-07-16 14:39:29','0','2015-09-16 00:00:00'),(2,'2015-07-29 15:39:17','1','网点角色只拥有部分系统功能。','网点角色','2015-07-16 14:58:56','0','2020-07-16 00:00:00');

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

insert  into `t_role_function`(`operateDate`,`operator`,`roleId`,`functionId`) values ('2015-07-27 16:32:30','1',1,1),('2015-07-27 16:32:30','1',1,2),('2015-07-27 16:32:30','1',1,3),('2015-07-27 16:32:30','1',1,7),('2015-07-27 16:32:30','1',1,8),('2015-07-27 16:32:30','1',1,9),('2015-07-29 15:49:52','1',2,9),('2015-07-27 16:32:30','1',1,10),('2015-07-29 15:49:52','1',2,10),('2015-07-27 16:32:30','1',1,15),('2015-07-27 16:32:30','1',1,16),('2015-07-29 15:49:52','1',2,16),('2015-07-27 16:32:30','1',1,17),('2015-07-27 16:32:30','1',1,18);

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

insert  into `t_tradepoint`(`tradePointNo`,`cardNo`,`operateDate`,`operator`,`ptAfter`,`ptBefore`,`ptTrade`,`tradeDate`,`tradeType`,`bankCardNo`,`dotId`) values ('201507200001','222222','2015-07-20 17:37:47','1','33','0','33','2015-07-20 17:37:49','1','6228481552887309119 ','0001'),('20150720002','222222','2015-07-20 18:15:19','1','43','33','10','2015-07-20 18:15:19','1','6228481552887309119 ','0001'),('20150720003','222222','2015-07-20 18:18:22','1','55','43','12','2015-07-20 18:18:22','1','6228481552887309119 ','0001'),('20150720004','222222','2015-07-20 18:22:35','1','66','55','11','2015-07-20 18:22:35','1','6228481552887309119 ','0001'),('20150720005','222222','2015-07-20 18:24:27','1','86','66','20','2015-07-20 18:24:27','1','6228481552887309119 ','0001'),('20150720006','222222','2015-07-20 18:45:00','test','85','86','-1','2015-07-20 18:45:00','2','6228481552887309119 ','0001'),('20150720007','222222','2015-07-20 18:47:49','test','84','85','-1','2015-07-20 18:47:49','2','6228481552887309119 ','0001'),('20150720008','222222','2015-07-20 18:50:16','test','83','84','-1','2015-07-20 18:50:16','2','6228481552887309119 ','0001'),('20150720009','222222','2015-07-20 18:52:57','test','82','83','-1','2015-07-20 18:52:57','2','6228481552887309119 ','0001'),('20150720010','222222','2015-07-20 18:54:27','test','81','82','-1','2015-07-20 18:54:27','2','6228481552887309119 ','0001'),('20150720011','222222','2015-07-20 18:56:45','test','80','81','-1','2015-07-20 18:56:45','2','6228481552887309119 ','0001'),('20150720012','222222','2015-07-20 18:57:03','test','78','80','-2','2015-07-20 18:57:03','2','6228481552887309119 ','0001'),('20150721013','222222','2015-07-21 09:11:12','1','77','78','-1','2015-07-21 09:11:12','2','6228481552887309119 ','0001'),('20150721014','222222','2015-07-21 09:11:14','1','76','77','-1','2015-07-21 09:11:14','2','6228481552887309119 ','0001'),('20150721015','222222','2015-07-21 09:11:30','1','75','76','-1','2015-07-21 09:11:30','2','6228481552887309119 ','0001'),('20150721016','222222','2015-07-21 09:12:23','1','85','75','10','2015-07-21 09:12:23','1','6228481552887309119 ','0001'),('20150727017','111111','2015-07-27 14:50:43','1','11','0','11','2015-07-27 14:50:43','1','1111111111111111111','0001'),('20150728018','222222','2015-07-28 16:34:40','1','22','0','22','2015-07-28 16:34:40','1','222222222222222','0001'),('20150728019','333333','2015-07-28 18:41:45','1','22','0','22','2015-07-28 18:41:45','1','222222222222222','0001'),('20150729020','111111','2015-07-29 09:26:02','1','10','11','-1','2015-07-29 09:26:02','2','1111111111111111111','0001'),('20150729021','111111','2015-07-29 14:52:26','1','9','10','-1','2015-07-29 14:52:26','2','1111111111111111111','0001'),('20150729022','111111','2015-07-29 14:57:48','1','8','9','-1','2015-07-29 14:57:48','2','1111111111111111111','0001'),('20150729023','111111','2015-07-29 14:59:10','1','7','8','-1','2015-07-29 14:59:10','2','1111111111111111111','0001'),('20150729024','111111','2015-07-29 15:05:10','1','6','7','-1','2015-07-29 15:05:10','2','1111111111111111111','0001'),('20150729025','111111','2015-07-29 15:13:57','1','5','6','-1','2015-07-29 15:13:57','2','1111111111111111111','0001'),('20150729026','111111','2015-07-29 15:17:30','1','4','5','-1','2015-07-29 15:17:30','2','1111111111111111111','0001');

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

/*Data for the table `t_user` */

insert  into `t_user`(`userId`,`loginName`,`operateDate`,`operator`,`password`,`phone`,`sex`,`userName`,`dotId`,`roleId`) values (1,'admin','2015-07-29 15:40:13','1','a66abb5684c45962d887564f08346e8d','111111','0','超级管理员','0001',1),(3,'scuta','2015-07-29 15:41:52','1','96e79218965eb72c92a549dd5a330112','111111','0','网点用户','0001',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
