/*
Navicat MySQL Data Transfer

Source Server         : hyh
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : apartment

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-12-17 14:04:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for elewatercharge
-- ----------------------------
DROP TABLE IF EXISTS `elewatercharge`;
CREATE TABLE `elewatercharge` (
  `eleCharge` float(10,5) NOT NULL,
  `waterCharge` float(10,5) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of elewatercharge
-- ----------------------------
INSERT INTO `elewatercharge` VALUES ('0.88000', '2.88000');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `userName` varchar(45) NOT NULL,
  `userPassword` varchar(45) NOT NULL,
  `userNumber` varchar(45) NOT NULL,
  `userWechat` varchar(45) DEFAULT NULL,
  `userBirthday` varchar(45) DEFAULT NULL,
  `userEmail` varchar(45) DEFAULT NULL,
  `userRoom` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('hyh', 'hyh', '13163706938', '610232890', '1998-07-17', '610232890@qq.com', '103');
INSERT INTO `login` VALUES ('admin', 'admin', '18060933786', '610232890', '1888051', '266519898@qq.com', '101');
INSERT INTO `login` VALUES ('admin1', 'admin1', '12345678912', null, null, null, null);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `residentID` varchar(45) NOT NULL,
  `title` varchar(45) NOT NULL,
  `author` varchar(45) NOT NULL,
  `content` varchar(200) NOT NULL,
  PRIMARY KEY (`residentID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '??????????????????????????????', 'hyh', 'dfsdfasdf');
INSERT INTO `message` VALUES ('2', '2', 'hyh', '333');

-- ----------------------------
-- Table structure for renting
-- ----------------------------
DROP TABLE IF EXISTS `renting`;
CREATE TABLE `renting` (
  `residentID` varchar(45) NOT NULL,
  `roomID` int(10) NOT NULL,
  `contractImg` varchar(45) NOT NULL,
  `isCost` varchar(45) NOT NULL,
  `eleDegree` int(10) unsigned zerofill DEFAULT NULL,
  `waterDegree` int(10) unsigned zerofill DEFAULT NULL,
  UNIQUE KEY `roomIDunique` (`roomID`) USING BTREE,
  KEY `fk3` (`residentID`),
  CONSTRAINT `fk2` FOREIGN KEY (`roomID`) REFERENCES `room` (`roomID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk3` FOREIGN KEY (`residentID`) REFERENCES `resident` (`residentID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of renting
-- ----------------------------
INSERT INTO `renting` VALUES ('1', '101', 'images/contract/contract1.jpg', '?????????', '0000000022', '0000000042');
INSERT INTO `renting` VALUES ('2', '102', 'images/contract/contract1.jpg', '?????????', '0000000034', '0000000023');
INSERT INTO `renting` VALUES ('3', '103', 'images/contract/contract1.jpg', '?????????', '0000000022', '0000000004');
INSERT INTO `renting` VALUES ('1', '104', 'images/contract/1576248983738HYH46726.png', '?????????', '0000000000', '0000000000');
INSERT INTO `renting` VALUES ('4', '105', 'images/contract/contract1.jpg', '?????????', '0000000034', '0000000002');
INSERT INTO `renting` VALUES ('5', '201', 'images/contract/contract1.jpg', '?????????', '0000000123', '0000000009');
INSERT INTO `renting` VALUES ('6', '202', 'images/contract/contract1.jpg', '?????????', '0000000324', '0000000066');
INSERT INTO `renting` VALUES ('13', '301', 'images/contract/1575382942204HYH49901.jpg', '?????????', '0000000012', '0000000009');
INSERT INTO `renting` VALUES ('11', '302', 'images/contract/touzi1.png', '?????????', '0000000034', '0000000042');

-- ----------------------------
-- Table structure for resident
-- ----------------------------
DROP TABLE IF EXISTS `resident`;
CREATE TABLE `resident` (
  `residentID` varchar(45) NOT NULL,
  `residentName` varchar(45) NOT NULL,
  `residentAge` varchar(45) NOT NULL,
  `residentNumber` varchar(45) NOT NULL,
  `residentProfession` varchar(45) NOT NULL,
  `residentIDCardNum` varchar(45) NOT NULL DEFAULT '',
  `remarks` varchar(45) DEFAULT NULL,
  `time` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`residentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resident
-- ----------------------------
INSERT INTO `resident` VALUES ('1', '?????????', '18', '1912114119', '??????', '6465132831326543125', '????????????', null);
INSERT INTO `resident` VALUES ('10', '????????????', '22', '1912114116520', '????????????', '2131231231231231233', '1314', null);
INSERT INTO `resident` VALUES ('11', '?????????', '23', '1912114116521', '????????????', '23121212311???232322', '1314', null);
INSERT INTO `resident` VALUES ('12', '???????????????', '2312', '12312312312', '?????????', '?????????', '?????????', null);
INSERT INTO `resident` VALUES ('123755', '?????????', '18', '1912114119', '3234', '6465132831326543125', '????????????', '2019-12-03 17:35:10');
INSERT INTO `resident` VALUES ('13', '?????????2???', '12321', '12312312312', '123123', '123123', '21323', null);
INSERT INTO `resident` VALUES ('14', '???3', '12312', '123', '123123??', '231312', '213132', null);
INSERT INTO `resident` VALUES ('15', '???4', '234234', '2343423', '324342', '234234234234234234234', '2343242', null);
INSERT INTO `resident` VALUES ('16', '?????????', '18', '666', '??????', '6465132831326543125', '????????????', null);
INSERT INTO `resident` VALUES ('17', '????????????', '?????????', 'sfas', 'x\'x', 'qweqw', null, null);
INSERT INTO `resident` VALUES ('18', 'sdafs', 'sdfasd', 'fdsf', 'sdfasd', 'fsdfasdf', null, null);
INSERT INTO `resident` VALUES ('19', 'sfasdfa', 'sdfa', 'sfasdf', 'sdfasd', 'asdfasd', null, null);
INSERT INTO `resident` VALUES ('2', '?????????', '19', '1912114117', '??????', '5665165165132513132', '510??????', null);
INSERT INTO `resident` VALUES ('20', '213123', '123', '23123', '21312', '31231231', null, null);
INSERT INTO `resident` VALUES ('21', '2312312', '3123', '12312', '3123123', '323123123', null, null);
INSERT INTO `resident` VALUES ('22', '12312442', '1231', '23123', '1231231', '23123', null, null);
INSERT INTO `resident` VALUES ('23', '123123', '21312', '312312', '31231', '23123', null, null);
INSERT INTO `resident` VALUES ('24', '2312312', '123123', '123123', '123123', '123123', null, null);
INSERT INTO `resident` VALUES ('25', '23123', '123', '12312', '3123', '123123', null, null);
INSERT INTO `resident` VALUES ('26', '31231', '2312312', '312312', '3123123', '123123', null, null);
INSERT INTO `resident` VALUES ('27', '23123', '123123', '123123', '231312', '1231231', null, null);
INSERT INTO `resident` VALUES ('28', '32423423', '234234', '12', '31231', '23123123', null, null);
INSERT INTO `resident` VALUES ('29', '3123', '1231', '123', '2312', '3123123', null, null);
INSERT INTO `resident` VALUES ('3', '?????????', '20', '1912114118', '??????', '1165165165132132665', '510??????', null);
INSERT INTO `resident` VALUES ('30', '312312', '1231', '2312', '31231', '231231', null, null);
INSERT INTO `resident` VALUES ('4', '?????????', '13', '1912114121', '??????', '2131231231231231232', '510??????', null);
INSERT INTO `resident` VALUES ('5', '?????????', '25', '1912114116', '??????', '2131231231231231232', '510??????', null);
INSERT INTO `resident` VALUES ('6', '??????', '17', '1912114120', '?????????', '2131232342342343242', '510??????', null);
INSERT INTO `resident` VALUES ('7', '??????', '13', '1231231231', '??????', 'l123123123123123123', '??????', null);
INSERT INTO `resident` VALUES ('8', '??????', '19', '2311244131', '?????????', '2131231231231231232', '12580', null);
INSERT INTO `resident` VALUES ('9', '??????', '58', '2123123123', '?????????', '1231231231231231231', '12580', null);

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `roomID` int(10) NOT NULL,
  `roomStyle` int(10) NOT NULL,
  `roomStroey` varchar(45) NOT NULL,
  PRIMARY KEY (`roomID`),
  KEY `fk1` (`roomStyle`),
  CONSTRAINT `fk1` FOREIGN KEY (`roomStyle`) REFERENCES `roomstyle` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('101', '1', '??????');
INSERT INTO `room` VALUES ('102', '2', '??????');
INSERT INTO `room` VALUES ('103', '3', '??????');
INSERT INTO `room` VALUES ('104', '1', '??????');
INSERT INTO `room` VALUES ('105', '3', '??????');
INSERT INTO `room` VALUES ('201', '3', '??????');
INSERT INTO `room` VALUES ('202', '4', '??????');
INSERT INTO `room` VALUES ('203', '4', '??????');
INSERT INTO `room` VALUES ('204', '2', '??????');
INSERT INTO `room` VALUES ('205', '3', '??????');
INSERT INTO `room` VALUES ('301', '5', '??????');
INSERT INTO `room` VALUES ('302', '5', '??????');
INSERT INTO `room` VALUES ('303', '4', '??????');

-- ----------------------------
-- Table structure for roomstyle
-- ----------------------------
DROP TABLE IF EXISTS `roomstyle`;
CREATE TABLE `roomstyle` (
  `id` int(10) NOT NULL,
  `roomstyle` varchar(45) NOT NULL,
  `roomCharge` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roomstyle
-- ----------------------------
INSERT INTO `roomstyle` VALUES ('1', '????????????', '0000000800');
INSERT INTO `roomstyle` VALUES ('2', '????????????', '0000001000');
INSERT INTO `roomstyle` VALUES ('3', '????????????', '0000000900');
INSERT INTO `roomstyle` VALUES ('4', '????????????', '0000001200');
INSERT INTO `roomstyle` VALUES ('5', '????????????', '0000001600');
