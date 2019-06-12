/*
Navicat MySQL Data Transfer

Source Server         : 10.255.242.168
Source Server Version : 50723
Source Host           : 10.255.242.168:3306
Source Database       : book_mall_db

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-05-14 18:07:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(64) CHARACTER SET utf8mb4 NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '用户密码，MD5加密',
  `email` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户电子邮件',
  `phone` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户电话',
  `question` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '密码找回问题',
  `answer` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '密码找回答案',
  `role` int(11) NOT NULL DEFAULT '1' COMMENT '用户角色，0-管理员、1-普通用户',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_unique_index` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=295328 DEFAULT CHARSET=utf8;
