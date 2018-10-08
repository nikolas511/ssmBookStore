/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50534
Source Host           : 127.0.0.1:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50534
File Encoding         : 65001

Date: 2018-08-25 11:05:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` varchar(50) NOT NULL,
  `bookname` varchar(30) DEFAULT NULL,
  `price` decimal(8,2) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `category_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `books_category_id_fk` (`category_id`),
  CONSTRAINT `books_category_id_fk` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('1', '数学', '66.00', 'aaa', null, '好好好', 'cda2443e-e6df-462a-b5df-78a230e6e793');
INSERT INTO `books` VALUES ('2', '英语', '33.00', 'aaa', '666', '英语好书', '2');
INSERT INTO `books` VALUES ('3', '物理', '78.00', 'aa啊', '好', '好', '2');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` varchar(50) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '科学', '科学类');
INSERT INTO `category` VALUES ('2', '语言', '语言类');
INSERT INTO `category` VALUES ('3', '物理类', '非常非常好');
INSERT INTO `category` VALUES ('cda2443e-e6df-462a-b5df-78a230e6e793', '我的分类', '豪华书');

-- ----------------------------
-- Table structure for orderitems
-- ----------------------------
DROP TABLE IF EXISTS `orderitems`;
CREATE TABLE `orderitems` (
  `id` varchar(50) NOT NULL,
  `ordertime` datetime DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price` decimal(8,2) DEFAULT NULL,
  `book_id` varchar(50) DEFAULT NULL,
  `order_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `orderitems_book_id_fk` (`book_id`),
  KEY `orderitems_order_id_fk` (`order_id`),
  CONSTRAINT `orderitems_book_id_fk` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`),
  CONSTRAINT `orderitems_order_id_fk` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitems
-- ----------------------------
INSERT INTO `orderitems` VALUES ('0b856314-a9d4-4867-bb4f-dcbda64fa822', '2017-06-25 10:52:27', '1', '78.00', '3', '1e8da64b-f6fc-4608-ad70-81756b5080ea');
INSERT INTO `orderitems` VALUES ('7b2cf318-26d4-4fc4-a042-827b57d37202', '2017-06-25 10:51:23', '1', '66.00', '1', '46714390-7be8-4008-bc50-d5c11ac68387');
INSERT INTO `orderitems` VALUES ('824ada24-2e39-4c6e-890c-ce74ae701fb1', '2017-12-31 15:49:41', '2', '66.00', '1', '87f55794-1931-4e83-a8b4-2e3ffd699ed1');
INSERT INTO `orderitems` VALUES ('a4efaf6e-30bf-454e-a4cb-3b01a7ffee38', '2017-06-25 10:54:49', '1', '66.00', '1', '252a355a-dcf2-461d-829e-ea8311b699c9');
INSERT INTO `orderitems` VALUES ('b082673e-102c-4eb0-8e0d-9898b7fac547', '2017-06-25 10:52:27', '1', '66.00', '1', '1e8da64b-f6fc-4608-ad70-81756b5080ea');
INSERT INTO `orderitems` VALUES ('e1640428-f50f-44c7-99fc-661c0a8a37ae', '2017-12-31 15:49:41', '1', '33.00', '2', '87f55794-1931-4e83-a8b4-2e3ffd699ed1');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` varchar(50) NOT NULL,
  `ordertime` datetime DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  `totalprice` decimal(8,2) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `orders_user_id_fk` (`user_id`),
  CONSTRAINT `orders_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1e8da64b-f6fc-4608-ad70-81756b5080ea', '2017-06-25 10:52:27', '1', '144.00', '4');
INSERT INTO `orders` VALUES ('252a355a-dcf2-461d-829e-ea8311b699c9', '2017-06-25 10:54:49', '0', '66.00', '4');
INSERT INTO `orders` VALUES ('46714390-7be8-4008-bc50-d5c11ac68387', '2017-06-25 10:51:23', '1', '66.00', '1');
INSERT INTO `orders` VALUES ('87f55794-1931-4e83-a8b4-2e3ffd699ed1', '2017-12-31 15:49:41', '0', '165.00', '4');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` varchar(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('0', 'admin', 'admin', null, null, null, null);
INSERT INTO `users` VALUES ('1', 'lotty', '666666', '2017-06-01', '113*****@qq.com', '177*****', '王***号');
INSERT INTO `users` VALUES ('2', 'n**as', '123', '2017-06-01', '1*****4851@qq.com', '177*****', '***');
INSERT INTO `users` VALUES ('3', '***', '123456', '1996-10-01', '5*****61@qq,com', '17*****85', '桂苑2-404');
INSERT INTO `users` VALUES ('4', 'aaa', '123', '2017-06-09', 'aaa@aa.com', 'asdf', 'aaaaaa');
