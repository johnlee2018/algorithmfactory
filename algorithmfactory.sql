# Host: 192.168.1.163  (Version 5.5.53-0ubuntu0.14.04.1)
# Date: 2017-02-28 19:40:07
# Generator: MySQL-Front 5.4  (Build 1.19)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "algorithm"
#

DROP TABLE IF EXISTS `algorithm`;
CREATE TABLE `algorithm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT 'the name of the algorithm ',
  `function` varchar(255) DEFAULT NULL COMMENT 'the name of the funtion ',
  `level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

#
# Data for table "algorithm"
#

INSERT INTO `algorithm` VALUES (1,'Bubblesort','冒泡排序',2),(2,'Quicksort','快速排序',1),(3,'Heapsort','堆排序',2),(4,'InsertSort','插入排序',2),(5,'MergeSort','å½?å¹¶æ??åº?',2),(6,'MergeSort','å½?å¹¶æ??åº?',2),(31,'MergeSort','归并排序',2),(32,'RadixSort','基数排序',2),(33,'ShellSort','Shell排序',2),(34,'SimpleSelectionSort','简单选择排序',2);

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `level` int(11) DEFAULT NULL COMMENT 'the level of the user,the num 0 is the highest level',
  `username` varchar(255) DEFAULT NULL COMMENT 'the name of the user ',
  `pass` varchar(255) DEFAULT NULL COMMENT 'the pass of the user for loggin in ',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='this is the user table';

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,0,'lee123','3bebc136e0bbbf9bf59fa00734ef15cf'),(2,0,'lee234','d749ed335ad8baed9f652951855d62b6'),(3,1,'lee345','8c3c911cccca03a61068cccb327dfa2d'),(4,2,'lee456','660e29f015e63006d265740b2321eb2e'),(5,2,'lee1234','f0c79af9d7487140603b09ec4624b1d4');
