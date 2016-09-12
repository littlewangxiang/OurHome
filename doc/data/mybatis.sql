/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2016-09-12 13:40:19
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
  `user_id` int(11) DEFAULT NULL COMMENT '打扫卫生的用户',
  PRIMARY KEY (`u_id`),
  KEY `user_id` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_health_life
-- ----------------------------
INSERT INTO `t_health_life` VALUES ('1', '2016-08-21 11:28:58', '0', '2016-08-21 11:29:03', '大扫除', '1');
INSERT INTO `t_health_life` VALUES ('2', '2016-08-21 12:49:42', '1', '2016-08-21 12:49:42', '王大扫除', '1');

-- ----------------------------
-- Table structure for `t_insterest_thing`
-- ----------------------------
DROP TABLE IF EXISTS `t_insterest_thing`;
CREATE TABLE `t_insterest_thing` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `add_date` datetime DEFAULT NULL,
  `last_modify_date` datetime DEFAULT NULL,
  `delete_status` int(2) DEFAULT '1',
  `publish_user_id` int(11) DEFAULT NULL,
  `info` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_insterest_thing
-- ----------------------------
INSERT INTO `t_insterest_thing` VALUES ('1', '2016-09-12 09:43:23', '2016-09-12 09:43:23', '1', '1', '第一个奇闻异事');

-- ----------------------------
-- Table structure for `t_insterest_thing_discuss`
-- ----------------------------
DROP TABLE IF EXISTS `t_insterest_thing_discuss`;
CREATE TABLE `t_insterest_thing_discuss` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `add_date` datetime DEFAULT NULL,
  `delete_status` int(2) DEFAULT NULL,
  `last_modify_date` datetime DEFAULT NULL,
  `insterest_thing_id` int(11) DEFAULT NULL COMMENT '奇闻异事id',
  `user_id` int(11) DEFAULT NULL COMMENT '评论用户',
  `parent_discuss_id` int(11) DEFAULT NULL COMMENT '父级评论id',
  `comment_info` varchar(200) DEFAULT NULL COMMENT '评论内容',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='评论表';

-- ----------------------------
-- Records of t_insterest_thing_discuss
-- ----------------------------
INSERT INTO `t_insterest_thing_discuss` VALUES ('1', '2016-09-12 10:29:45', '1', '2016-09-12 10:29:45', '1', '1', null, '我也去过这里');

-- ----------------------------
-- Table structure for `t_living_payment`
-- ----------------------------
DROP TABLE IF EXISTS `t_living_payment`;
CREATE TABLE `t_living_payment` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `add_date` datetime DEFAULT NULL,
  `delete_status` int(2) DEFAULT NULL,
  `last_modify_date` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL COMMENT '发起者',
  `name` varchar(100) DEFAULT NULL COMMENT '缴费主题名',
  `spec_id` int(11) DEFAULT NULL COMMENT '缴费项目id',
  `share_info` varchar(255) DEFAULT NULL COMMENT '缴费分摊用户信息',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_living_payment
-- ----------------------------
INSERT INTO `t_living_payment` VALUES ('1', '2016-09-12 13:28:57', '1', '2016-09-12 13:28:57', '1', '16-9-12卖菜分摊', '1', '[user_id: 1,user_name: \'小明\',share_status: 1,share_time: 2016-8-1512: 34: 12],[user_id: 2,user_name: \'小李子\',share_status: 1,share_time: 2016-8-1512: 34: 12]');

-- ----------------------------
-- Table structure for `t_message`
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `add_date` datetime DEFAULT NULL,
  `delete_status` int(2) DEFAULT NULL,
  `last_modify_date` datetime DEFAULT NULL,
  `message_info` varchar(200) DEFAULT NULL,
  `msg_type` int(3) DEFAULT NULL COMMENT '通知类型',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='通知消息类';

-- ----------------------------
-- Records of t_message
-- ----------------------------
INSERT INTO `t_message` VALUES ('1', '2016-09-12 13:06:42', '1', '2016-09-12 13:06:42', '您参与的购物分摊请及时转账哦', '1');

-- ----------------------------
-- Table structure for `t_specification`
-- ----------------------------
DROP TABLE IF EXISTS `t_specification`;
CREATE TABLE `t_specification` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `add_date` datetime DEFAULT NULL,
  `delete_status` int(2) DEFAULT NULL,
  `last_modify_date` datetime DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='缴费项目表';

-- ----------------------------
-- Records of t_specification
-- ----------------------------
INSERT INTO `t_specification` VALUES ('1', '2016-09-12 13:17:41', '1', '2016-09-12 13:17:41', '买菜');

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
