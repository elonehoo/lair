/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : lair

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 12/06/2022 21:33:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

CREATE DATABASE `lair`;

-- ----------------------------
-- Table structure for hi
-- ----------------------------
DROP TABLE IF EXISTS `hi`;
CREATE TABLE `hi` (
  `id` varchar(32) NOT NULL COMMENT 'key',
  `name` varchar(255) DEFAULT NULL COMMENT 'user name',
  `view_time` datetime DEFAULT NULL COMMENT 'interview time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;
