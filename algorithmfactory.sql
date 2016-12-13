# Host: localhost  (Version 5.7.15-log)
# Date: 2016-12-13 11:15:36
# Generator: MySQL-Front 5.4  (Build 1.19)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "algorithm"
#

DROP TABLE IF EXISTS `algorithm`;
CREATE TABLE `algorithm` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT 'the name of the algorithm ',
  `function` varchar(255) DEFAULT NULL COMMENT 'the name of the funtion ',
  `level` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "algorithm"
#

INSERT INTO `algorithm` VALUES (1,'Bubblesort','它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。',2),(2,'Quicksort','通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。',1);

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='this is the user table';

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,0,'lee123','123456'),(2,0,'lee234','123456'),(3,1,'lee345','123456'),(4,2,'lee456','123456');
