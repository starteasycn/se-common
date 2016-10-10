# ************************************************************
# Sequel Pro SQL dump
# Version 4529
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.5.35)
# Database: ds_0
# Generation Time: 2016-10-09 05:49:30 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table mubs_adminuser
# ------------------------------------------------------------

DROP TABLE IF EXISTS `mubs_adminuser`;

CREATE TABLE `mubs_adminuser` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `login` varchar(15) DEFAULT NULL COMMENT '登录名',
  `password` varchar(128) DEFAULT NULL COMMENT '密码',
  `creator` int(11) DEFAULT NULL COMMENT '创建人',
  `createDate` bigint(11) DEFAULT NULL COMMENT '创建时间',
  `lastModifier` int(11) DEFAULT NULL COMMENT '最后修改人',
  `lastModDate` bigint(11) DEFAULT NULL COMMENT '最后修改时间',
  `status` tinyint(11) DEFAULT NULL COMMENT '状态',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(31) DEFAULT NULL COMMENT '联系电邮',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='运营人员|运营人员管理|基础管理|CreateBaseDomain\n管理员/运营人员管理';

LOCK TABLES `mubs_adminuser` WRITE;
/*!40000 ALTER TABLE `mubs_adminuser` DISABLE KEYS */;

INSERT INTO `mubs_adminuser` (`id`, `login`, `password`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`, `phone`, `email`)
VALUES
	(1,'q1q','11',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	(2,'1q','22',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	(3,'a','$2a$10$wRRch8cNGkVCyG9Gp7SziOO0bPsa8I2LizeqzEciHD/1smnAacZrG',NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	(4,'b','11',NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*!40000 ALTER TABLE `mubs_adminuser` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table mubs_adminUserToken
# ------------------------------------------------------------

DROP TABLE IF EXISTS `mubs_adminUserToken`;

CREATE TABLE `mubs_adminUserToken` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `series` varchar(32) DEFAULT NULL COMMENT '序列号',
  `tokenValue` varchar(128) DEFAULT NULL COMMENT 'token',
  `tokenDate` bigint(20) DEFAULT NULL COMMENT '生成时间',
  `ipAddress` varchar(16) DEFAULT NULL COMMENT '访问ip',
  `userAgent` varchar(32) DEFAULT NULL COMMENT '访问浏览器',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `userLogin` varchar(16) DEFAULT NULL COMMENT '用户登录名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='登录token|登录token管理|基础管理|BaseDomain\n登录token管理';



# Dump of table mubs_data_model
# ------------------------------------------------------------

DROP TABLE IF EXISTS `mubs_data_model`;

CREATE TABLE `mubs_data_model` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `creator` int(11) NOT NULL COMMENT '创建人',
  `createDate` bigint(11) NOT NULL COMMENT '创建时间',
  `lastModifier` int(11) NOT NULL COMMENT '修改人',
  `lastModDate` bigint(11) NOT NULL COMMENT '修改时间',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `priority` int(11) NOT NULL DEFAULT '1000' COMMENT '优先级',
  `modelId` int(11) NOT NULL COMMENT '其对应的模型主体id',
  `assignUrl` varchar(32) NOT NULL DEFAULT '' COMMENT '分配的url',
  `whereSql` varchar(512) NOT NULL DEFAULT '' COMMENT '追加数据权限的sql',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '按**维度设置',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据权限模型|数据权限设置|基础管理|CreateBaseDomain\n数据权限model';



# Dump of table mubs_model
# ------------------------------------------------------------

DROP TABLE IF EXISTS `mubs_model`;

CREATE TABLE `mubs_model` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `creator` int(11) NOT NULL COMMENT '创建人',
  `createDate` bigint(11) NOT NULL COMMENT '创建时间',
  `lastModifier` int(11) NOT NULL COMMENT '修改人',
  `lastModDate` bigint(11) NOT NULL COMMENT '修改时间',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `name` varchar(16) NOT NULL DEFAULT '' COMMENT '名称',
  `tblName` varchar(32) DEFAULT NULL COMMENT '对应表名',
  `description` varchar(64) NOT NULL DEFAULT '' COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务模型|业务模型|基础管理|CreateBaseDomain\n业务模型(人员、薪酬等)';



# Dump of table mubs_resource
# ------------------------------------------------------------

DROP TABLE IF EXISTS `mubs_resource`;

CREATE TABLE `mubs_resource` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `url` varchar(256) NOT NULL DEFAULT '' COMMENT '页面url',
  `orderNum` int(11) NOT NULL DEFAULT '0' COMMENT '顺序',
  `parentId` int(11) DEFAULT NULL COMMENT '父页面,null为顶层页面',
  `number` varchar(32) NOT NULL DEFAULT '' COMMENT '编码',
  `longNumber` varchar(128) NOT NULL DEFAULT '' COMMENT '长编码',
  `name` varchar(16) NOT NULL DEFAULT '' COMMENT '资源名称',
  `creator` int(11) NOT NULL COMMENT '创建人',
  `createDate` bigint(11) NOT NULL COMMENT '创建时间',
  `lastModifier` int(11) NOT NULL COMMENT '修改人',
  `lastModDate` bigint(11) NOT NULL COMMENT '修改时间',
  `description` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `modelId` int(11) DEFAULT NULL COMMENT '主模型id  和 数据权限相关',
  `bizModelName` varchar(16) NOT NULL DEFAULT '' COMMENT '业务模型名称|在同一个业务系统里不允许有同名的业务模型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源|资源管理|基础管理|CreateBaseDomain\n资源，一般为页面';

LOCK TABLES `mubs_resource` WRITE;
/*!40000 ALTER TABLE `mubs_resource` DISABLE KEYS */;

INSERT INTO `mubs_resource` (`id`, `url`, `orderNum`, `parentId`, `number`, `longNumber`, `name`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `description`, `modelId`, `bizModelName`)
VALUES
	(1,'/admin/ucm/基础管理',1,0,'a1','a1','基础管理',0,0,0,0,NULL,NULL,''),
	(2,'/admin/ucm/resource',2,1,'b1','a1_b1','资源管理',0,0,0,0,NULL,NULL,'resource');

/*!40000 ALTER TABLE `mubs_resource` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table mubs_resource_action
# ------------------------------------------------------------

DROP TABLE IF EXISTS `mubs_resource_action`;

CREATE TABLE `mubs_resource_action` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `resourceId` int(11) NOT NULL COMMENT '所属资源id',
  `divId` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '页面元素id',
  `actionScript` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '按钮对应的操作脚本',
  `name` varchar(16) NOT NULL DEFAULT '' COMMENT '操作名称',
  `actionAlias` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '操作标识',
  `creator` int(11) NOT NULL COMMENT '创建人',
  `createDate` bigint(11) NOT NULL COMMENT '创建时间',
  `lastModifier` int(11) NOT NULL COMMENT '修改人',
  `lastModDate` bigint(11) NOT NULL COMMENT '修改时间',
  `description` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源操作|资源管理|基础管理|CreateBaseDomain\n页面对应的操作';

LOCK TABLES `mubs_resource_action` WRITE;
/*!40000 ALTER TABLE `mubs_resource_action` DISABLE KEYS */;

INSERT INTO `mubs_resource_action` (`id`, `resourceId`, `divId`, `actionScript`, `name`, `actionAlias`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `description`)
VALUES
	(1,2,X'',X'','新增',X'616464',0,0,0,0,X''),
	(2,2,X'',X'','修改',X'65646974',0,0,0,0,X'');

/*!40000 ALTER TABLE `mubs_resource_action` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table mubs_resource_grid
# ------------------------------------------------------------

DROP TABLE IF EXISTS `mubs_resource_grid`;

CREATE TABLE `mubs_resource_grid` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `creator` int(11) NOT NULL COMMENT '创建人',
  `createDate` bigint(11) NOT NULL COMMENT '创建时间',
  `lastModifier` int(11) NOT NULL COMMENT '修改人',
  `lastModDate` bigint(11) NOT NULL COMMENT '修改时间',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `resId` int(11) NOT NULL COMMENT '资源id',
  `displayName` varchar(32) NOT NULL DEFAULT '' COMMENT ' 显示名称',
  `colId` varchar(16) NOT NULL DEFAULT '' COMMENT 'grid列id',
  `orderNum` int(11) NOT NULL COMMENT '顺序号',
  `width` int(11) NOT NULL COMMENT '显示的宽度',
  `editoptions` varchar(256) NOT NULL DEFAULT '{}' COMMENT 'json',
  `edittype` varchar(16) DEFAULT '' COMMENT '编辑器类型',
  `unformat` varchar(16) DEFAULT NULL COMMENT '扩展编辑器',
  `description` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '描述',
  `moduleName` varchar(45) DEFAULT NULL COMMENT '模块名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源grid|资源grid管理|基础管理|CreateBaseDomain\n页面 grid的元数据描述';

LOCK TABLES `mubs_resource_grid` WRITE;
/*!40000 ALTER TABLE `mubs_resource_grid` DISABLE KEYS */;

INSERT INTO `mubs_resource_grid` (`id`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`, `resId`, `displayName`, `colId`, `orderNum`, `width`, `editoptions`, `edittype`, `unformat`, `description`, `moduleName`)
VALUES
	(1,0,0,0,0,0,2,'ID','id',0,0,'{}','',NULL,X'','resource');

/*!40000 ALTER TABLE `mubs_resource_grid` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table mubs_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `mubs_role`;

CREATE TABLE `mubs_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(32) NOT NULL DEFAULT '' COMMENT '角色名称',
  `creator` int(11) NOT NULL COMMENT '创建人',
  `createDate` bigint(11) NOT NULL COMMENT '创建时间',
  `lastModifier` int(11) NOT NULL COMMENT '修改人',
  `lastModDate` bigint(11) NOT NULL COMMENT '修改时间',
  `description` varchar(256) NOT NULL DEFAULT '' COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色|角色管理|基础管理|CreateBaseDomain\n角色';

LOCK TABLES `mubs_role` WRITE;
/*!40000 ALTER TABLE `mubs_role` DISABLE KEYS */;

INSERT INTO `mubs_role` (`id`, `name`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `description`)
VALUES
	(1,'',0,0,0,0,'');

/*!40000 ALTER TABLE `mubs_role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table mubs_role_resource
# ------------------------------------------------------------

DROP TABLE IF EXISTS `mubs_role_resource`;

CREATE TABLE `mubs_role_resource` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `creator` int(11) NOT NULL COMMENT '创建人',
  `createDate` bigint(11) NOT NULL COMMENT '创建时间',
  `lastModifier` int(11) NOT NULL COMMENT '修改人',
  `lastModDate` bigint(11) NOT NULL COMMENT '修改时间',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `resourceId` int(11) NOT NULL COMMENT '资源id',
  `resourceActionId` int(11) NOT NULL COMMENT '功能按钮id',
  `roleId` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源|角色资源分配|基础管理|CreateBaseDomain\n角色所管辖的页面资源';

LOCK TABLES `mubs_role_resource` WRITE;
/*!40000 ALTER TABLE `mubs_role_resource` DISABLE KEYS */;

INSERT INTO `mubs_role_resource` (`id`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`, `resourceId`, `resourceActionId`, `roleId`)
VALUES
	(1,0,0,0,0,0,1,0,1),
	(2,0,0,0,0,0,2,1,1);

/*!40000 ALTER TABLE `mubs_role_resource` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table mubs_role_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `mubs_role_user`;

CREATE TABLE `mubs_role_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `creator` int(11) NOT NULL COMMENT '创建人',
  `createDate` bigint(11) NOT NULL COMMENT '创建时间',
  `lastModifier` int(11) NOT NULL COMMENT '修改人',
  `lastModDate` bigint(11) NOT NULL COMMENT '修改时间',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `userId` int(11) NOT NULL COMMENT '用户id',
  `roleId` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色|用户角色分配|基础管理|CreateBaseDomain\n用户对应的角色';

LOCK TABLES `mubs_role_user` WRITE;
/*!40000 ALTER TABLE `mubs_role_user` DISABLE KEYS */;

INSERT INTO `mubs_role_user` (`id`, `creator`, `createDate`, `lastModifier`, `lastModDate`, `status`, `userId`, `roleId`)
VALUES
	(1,0,0,0,0,0,3,1);

/*!40000 ALTER TABLE `mubs_role_user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table mubs_user_data
# ------------------------------------------------------------

DROP TABLE IF EXISTS `mubs_user_data`;

CREATE TABLE `mubs_user_data` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `creator` int(11) NOT NULL COMMENT '创建人',
  `createDate` bigint(11) NOT NULL COMMENT '创建时间',
  `lastModifier` int(11) NOT NULL COMMENT '修改人',
  `lastModDate` bigint(11) NOT NULL COMMENT '修改时间',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `dataModelId` int(11) NOT NULL COMMENT '数据权限model id',
  `dataId` int(11) NOT NULL COMMENT '对应id',
  `userId` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户数据权限|用户数据权限分配|基础管理|CreateBaseDomain\n用户管理数据权限';




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
