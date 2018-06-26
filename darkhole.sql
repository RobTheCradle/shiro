/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.17-log : Database - darkhole
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`darkhole` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `darkhole`;

/*Table structure for table `perms` */

DROP TABLE IF EXISTS `perms`;

CREATE TABLE `perms` (
  `p_id` varchar(50) NOT NULL COMMENT '权限id',
  `p_name` varchar(50) DEFAULT NULL COMMENT '权限名称',
  `p_status` int(11) DEFAULT NULL COMMENT '权限状态 1 --> 正常  0 --> 删除',
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `perms` */

insert  into `perms`(`p_id`,`p_name`,`p_status`) values ('1','增加',1),('2','删除',1),('3','修改',1),('4','查看',1);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `r_id` varchar(50) NOT NULL COMMENT '角色id',
  `r_name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `r_status` int(11) DEFAULT NULL COMMENT '角色状态：1 --> 正常 0 --> 删除',
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`r_id`,`r_name`,`r_status`) values ('1','医生',1),('2','护士',1),('3','导医',1);

/*Table structure for table `role_perms` */

DROP TABLE IF EXISTS `role_perms`;

CREATE TABLE `role_perms` (
  `r_p_id` varchar(50) DEFAULT NULL COMMENT '主键',
  `r_id` varchar(50) DEFAULT NULL COMMENT '角色id',
  `p_id` varchar(50) DEFAULT NULL COMMENT '权限id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_perms` */

insert  into `role_perms`(`r_p_id`,`r_id`,`p_id`) values ('1','1','1'),('2','1','2'),('3','1','3'),('4','1','4'),('5','2','4');

/*Table structure for table `url` */

DROP TABLE IF EXISTS `url`;

CREATE TABLE `url` (
  `url_id` varchar(50) NOT NULL COMMENT '链接id',
  `url_href` varchar(50) DEFAULT NULL COMMENT '链接地址',
  `url_perms` varchar(200) DEFAULT NULL COMMENT '链接所需权限',
  `url_prems_type` int(11) DEFAULT NULL COMMENT '链接访问权限类型：0 --> anon 1 --> authc 2 --> role 3 --> perms',
  PRIMARY KEY (`url_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `url` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `u_id` varchar(50) NOT NULL COMMENT '用户id',
  `u_account` varchar(50) DEFAULT NULL COMMENT '用户账号',
  `u_password` varchar(50) DEFAULT NULL COMMENT '用户密码',
  `u_salt` varchar(50) DEFAULT NULL COMMENT '盐',
  `u_status` int(11) DEFAULT NULL COMMENT '用户状态：1 --> 正常 0 --> 删除',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`u_id`,`u_account`,`u_password`,`u_salt`,`u_status`) values ('1','辜勇胜','123456','1',1),('2','李明','123456','12',1);

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `u_r_id` varchar(50) NOT NULL COMMENT '主键',
  `u_id` varchar(50) DEFAULT NULL COMMENT '用户id',
  `r_id` varchar(50) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`u_r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`u_r_id`,`u_id`,`r_id`) values ('1','1','1'),('2','2','2');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
