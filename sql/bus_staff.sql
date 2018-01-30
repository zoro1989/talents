/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost
 Source Database       : parkcharge

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : utf-8

 Date: 01/26/2018 13:36:28 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `bus_staff`
-- ----------------------------
DROP TABLE IF EXISTS `bus_staff`;
CREATE TABLE `bus_staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_no` varchar(6) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `name_spell` varchar(50) DEFAULT NULL,
  `name_kana` varchar(10) DEFAULT NULL,
  `name_jp` varchar(10) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `join_day` datetime DEFAULT NULL,
  `practice_start_date` datetime DEFAULT NULL,
  `practice_end_date` datetime DEFAULT NULL,
  `trial_start_date` datetime DEFAULT NULL,
  `trial_end_date` datetime DEFAULT NULL,
  `trial_result` int(1) DEFAULT NULL,
  `formal_date` datetime DEFAULT NULL,
  `job_status` int(1) DEFAULT NULL,
  `befwork_age` int(2) DEFAULT NULL,
  `aftwork_age` int(2) DEFAULT NULL,
  `work_age` int(2) DEFAULT NULL,
  `work_date` datetime DEFAULT NULL,
  `graduate_date` datetime DEFAULT NULL,
  `graduate_school` varchar(50) DEFAULT NULL,
  `education` int(1) DEFAULT NULL,
  `training_mode` int(1) DEFAULT NULL,
  `major` varchar(50) DEFAULT NULL,
  `degree` int(1) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `tel` varchar(12) DEFAULT NULL,
  `urgency_cnt` varchar(10) DEFAULT NULL,
  `urgency_tel` varchar(12) DEFAULT NULL,
  `home_addr` varchar(100) DEFAULT NULL,
  `addr` varchar(100) DEFAULT NULL,
  `register_addr` varchar(100) DEFAULT NULL,
  `register_type` int(1) DEFAULT NULL,
  `jp_level` int(1) DEFAULT NULL,
  `en_level` int(1) DEFAULT NULL,
  `salary_card` varchar(20) DEFAULT NULL,
  `id_card` varchar(20) DEFAULT NULL,
  `professional` varchar(100) DEFAULT NULL,
  `door_no` varchar(50) DEFAULT NULL,
  `check_no` varchar(255) DEFAULT NULL,
  `nation` int(1) DEFAULT NULL,
  `country` int(1) DEFAULT NULL,
  `ismarried` int(1) DEFAULT NULL,
  `hasbaby` int(1) DEFAULT NULL,
  `doc_manage_mode` varchar(50) DEFAULT NULL,
  `doc_no` varchar(50) DEFAULT NULL,
  `doc_fee` decimal(5,2) DEFAULT NULL,
  `doc_remark` varchar(100) DEFAULT NULL,
  `ispartied` int(1) DEFAULT NULL,
  `partied_date` datetime DEFAULT NULL,
  `partied_rls` varchar(100) DEFAULT NULL,
  `partied_rls1` varchar(100) DEFAULT NULL,
  `passport_no` varchar(50) DEFAULT NULL,
  `salary_status` int(1) DEFAULT NULL,
  `doc_box_no` varchar(50) DEFAULT NULL,
  `practice_fee` decimal(5,2) DEFAULT NULL,
  `trial_fee` decimal(5,2) DEFAULT NULL,
  `formal_fee_bottom` decimal(5,2) DEFAULT NULL,
  `formal_fee_top` decimal(5,2) DEFAULT NULL,
  `formal_fee` decimal(5,2) DEFAULT NULL,
  `department` int(1) DEFAULT NULL,
  `leave_date` datetime DEFAULT NULL,
  `duty` int(1) DEFAULT NULL,
  `cmpbefwork_age` int(2) DEFAULT NULL,
  `t_level` varchar(3) DEFAULT NULL,
  `student_line` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
