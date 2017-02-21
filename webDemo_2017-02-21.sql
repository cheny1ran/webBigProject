# ************************************************************
# Sequel Pro SQL dump
# Version 4529
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.11)
# Database: webDemo
# Generation Time: 2017-02-21 09:29:49 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table admin
# ------------------------------------------------------------

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` varchar(20) NOT NULL DEFAULT '',
  `pwd` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;

INSERT INTO `admin` (`id`, `pwd`)
VALUES
	('admin','admin');

/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table course
# ------------------------------------------------------------

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL DEFAULT '',
  `time` varchar(20) NOT NULL DEFAULT '',
  `credit` int(11) NOT NULL,
  `belong` varchar(100) NOT NULL DEFAULT '',
  `place` varchar(30) NOT NULL DEFAULT '',
  `amount` int(11) NOT NULL,
  `detail` varchar(200) NOT NULL DEFAULT '',
  `selected` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;

INSERT INTO `course` (`id`, `name`, `time`, `credit`, `belong`, `place`, `amount`, `detail`, `selected`)
VALUES
	(2,'油画','2015/2016(2)',4,'山水画社','广知楼103',21,'书法基础A班：每周六下午15:30~17:00（1.5个周学时），共开设10周；           书法基础B班：每周六晚18:30~20:00（1.5个周学时），共开设10周；           书法提高班：每周日15:00~17:00（2个周学时），共开设10周； ',21),
	(3,'读书交流会','2015/2016(2)',2,'书山有路书社','图书馆二楼',20,'本课程突破传统面试技巧培训讲授式、零散型、非延续、少反馈的缺点，采用体验式培训的方式，重实战，多模拟，发挥人力资源管理专业优势，提供真实案例，给予专业点评，再辅以课程延续性、可及时反馈的优势，为学员在大学生活中常面临的社团面试及求职面试等提供有效指导。本课程将基于面试技巧、礼仪等方面的基本理论，结合大量课堂情境模拟练习及案例分析，帮助学员提高自身面试技能和礼仪修养，从容应对各种面试。',15),
	(6,'test','2013/2014(2)',3,'test','test',20,'11',0);

/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table student
# ------------------------------------------------------------

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` varchar(20) NOT NULL DEFAULT '',
  `pwd` varchar(20) NOT NULL DEFAULT '',
  `name` varchar(20) NOT NULL DEFAULT '',
  `sex` varchar(2) NOT NULL DEFAULT '',
  `year` varchar(4) NOT NULL DEFAULT '',
  `major` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;

INSERT INTO `student` (`id`, `pwd`, `name`, `sex`, `year`, `major`)
VALUES
	('1','2222','陈呵呵','女','2013','软件工程'),
	('201309550104','1234','陈曦曦','女','2013','软件工程');

/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table study
# ------------------------------------------------------------

DROP TABLE IF EXISTS `study`;

CREATE TABLE `study` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `s_id` varchar(20) NOT NULL DEFAULT '',
  `s_name` varchar(20) NOT NULL DEFAULT '',
  `s_major` varchar(100) NOT NULL DEFAULT '',
  `c_id` int(11) NOT NULL,
  `c_name` varchar(100) NOT NULL DEFAULT '',
  `c_belong` varchar(100) NOT NULL DEFAULT '',
  `c_credit` int(11) NOT NULL,
  `c_time` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `study` WRITE;
/*!40000 ALTER TABLE `study` DISABLE KEYS */;

INSERT INTO `study` (`id`, `s_id`, `s_name`, `s_major`, `c_id`, `c_name`, `c_belong`, `c_credit`, `c_time`)
VALUES
	(1,'1','陈呵呵','软件工程',2,'油画','山水画社',4,'2015/2016(2)');

/*!40000 ALTER TABLE `study` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
