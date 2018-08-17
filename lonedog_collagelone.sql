# Host: 127.0.0.1  (Version 5.7.17-log)
# Date: 2018-08-17 18:01:52
# Generator: MySQL-Front 5.4  (Build 4.153) - http://www.mysqlfront.de/

/*!40101 SET NAMES utf8 */;

#
# Structure for table "collage_order"
#

CREATE TABLE `collage_order` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户ID',
  `order_address_from` varchar(128) DEFAULT NULL COMMENT '始发地',
  `order_address_to` varchar(128) DEFAULT NULL COMMENT '目的地',
  `order_address_from_code` varchar(32) DEFAULT NULL COMMENT '始发地编码',
  `order_address_to_code` varchar(128) DEFAULT NULL COMMENT '目的地编码',
  `order_type` tinyint(4) DEFAULT '0' COMMENT '发布类型',
  `order_status` tinyint(4) DEFAULT '0' COMMENT '状态',
  `user_phone` varchar(16) DEFAULT NULL COMMENT '发布者手机号',
  `order_price` varchar(8) DEFAULT NULL COMMENT '价格',
  `order_amount` varchar(8) DEFAULT NULL COMMENT '总量(座位数，吨数)',
  `order_amount_fare` varchar(8) DEFAULT NULL COMMENT '剩余(座位数，吨数)',
  `order_begin_time` date NOT NULL COMMENT '开始日期',
  `order_end_time` date NOT NULL COMMENT '结束日期',
  `order_msc` varchar(128) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `del` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0、有效，1、已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发布信息表';

#
# Data for table "collage_order"
#


#
# Structure for table "collage_user"
#

CREATE TABLE `collage_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `nick_name` varchar(128) DEFAULT NULL COMMENT '昵称',
  `show_name` varchar(128) DEFAULT NULL COMMENT '显示名称',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(16) DEFAULT NULL COMMENT '手机号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `del` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0、有效，1、已删除',
  `open_id` varchar(64) NOT NULL DEFAULT '' COMMENT '用户唯一标识',
  `union_id` varchar(64) DEFAULT NULL COMMENT '公众号唯一id',
  `avatar_url` varchar(256) DEFAULT NULL COMMENT '头像链接',
  `gender` tinyint(3) DEFAULT '0' COMMENT '性别1-男性，2-女性',
  `city` varchar(64) DEFAULT NULL COMMENT '市',
  `province` varchar(64) DEFAULT NULL COMMENT '省',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

#
# Data for table "collage_user"
#

INSERT INTO `collage_user` VALUES (1,NULL,NULL,NULL,NULL,'2018-08-13 14:31:43','2018-08-13 14:31:43',0,'omXUE5jAX8wftMnKCoYfXlHU7g-w',NULL,NULL,0,NULL,NULL);

#
# Structure for table "collage_user_car"
#

CREATE TABLE `collage_user_car` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户ID',
  `car_no` varchar(16) DEFAULT NULL COMMENT '车牌号',
  `car_type` smallint(6) DEFAULT '0' COMMENT '车类型',
  `op_status` tinyint(4) DEFAULT '0' COMMENT '状态',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `del` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0、有效，1、已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户车信息表';

#
# Data for table "collage_user_car"
#

