# Host: 192.168.1.137  (Version 5.5.53-0ubuntu0.14.04.1)
# Date: 2016-12-14 22:01:57
# Generator: MySQL-Front 5.4  (Build 1.19)

/*!40101 SET NAMES utf8 */;

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

INSERT INTO `user` VALUES (1,0,'lee123','3bebc136e0bbbf9bf59fa00734ef15cf'),(2,0,'lee234','d749ed335ad8baed9f652951855d62b6'),(3,1,'lee345','8c3c911cccca03a61068cccb327dfa2d'),(4,2,'lee456','660e29f015e63006d265740b2321eb2e');
