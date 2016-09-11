/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50139
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50139
File Encoding         : 65001

Date: 2016-09-11 16:10:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_health_life`
-- ----------------------------
DROP TABLE IF EXISTS `t_health_life`;
CREATE TABLE `t_health_life` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `add_date` datetime DEFAULT NULL,
  `delete_status` int(2) DEFAULT NULL,
  `last_modify_date` datetime DEFAULT NULL,
  `life_health_name` varchar(30) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`u_id`),
  KEY `user_id` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_health_life
-- ----------------------------
INSERT INTO `t_health_life` VALUES ('1', '2016-08-21 11:28:58', '1', '2016-08-21 11:29:03', '大扫除', '1');
INSERT INTO `t_health_life` VALUES ('2', '2016-08-21 12:49:42', '1', '2016-08-21 12:49:42', '王大扫除', '1');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `add_date` datetime DEFAULT NULL,
  `last_modify_date` datetime DEFAULT NULL,
  `delete_status` int(2) DEFAULT '1' COMMENT '1：可用  0：已删除',
  `user_name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `person_introduction` varchar(100) DEFAULT '' COMMENT '个人信息说明',
  `feel_word` varchar(30) DEFAULT '' COMMENT '个人心情',
  PRIMARY KEY (`u_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '2016-08-20 17:31:24', '2016-08-20 17:31:27', '0', '小王', '111111', '13661291886', '177dfd4476@qq.com', '我来自河北保定', '好晴天啊好晴天');
INSERT INTO `t_user` VALUES ('2', '2016-08-21 09:39:04', '2016-08-21 09:39:04', '1', '小花', 'aaaaaa', '13672291486', '177rer76@qq.com', '我是一个好人，但不会是雷锋一样的好人', 'it is a goods day');
